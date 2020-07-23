package com.cp.dd.web.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.service.sys.IMinIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/upload")
@Api(tags = "文件上传接口")
@Slf4j
@IgnoreLogin
public class UploadController {

    private IMinIOService minIOService;

    private static final int ppSaveAsPDF = 32;



    @ApiOperation(value = "文件上传", notes = "文件上传  multipartFile")
    @PostMapping(value = "uploadFile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public Result uploadFile(@ApiParam(value = "uploadFile", required = false) MultipartFile multipartFile, HttpServletRequest req, HttpServletResponse response) {
        JSONArray fileList = new JSONArray();
        try {
            String contextPath = req.getContextPath();
            String ip = req.getServerName();
            int port = req.getServerPort();
            String extName = "";
            String name = "";
            String oldName="";
            if (multipartFile.getOriginalFilename() != null && !("").equals(multipartFile.getOriginalFilename())) {
                extName = getFileExt(multipartFile.getOriginalFilename()).substring(1);
                oldName =(multipartFile.getOriginalFilename()).substring(0,
                        (multipartFile.getOriginalFilename()).lastIndexOf("."));
            }
            name = multipartFile.getOriginalFilename();
            /*String uuid = UUID.randomUUID().toString() + "_" +
                    new SimpleDateFormat("yyyyMMddhhmmssms").format(new Date());*/
            String uuid = oldName + "_" +
                    new SimpleDateFormat("yyyyMMddhhmmssms").format(new Date());
            byte[] changeByte = multipartFile.getBytes();
            InputStream is = new ByteArrayInputStream(changeByte);

            String origFile = uuid + "." + extName;
            minIOService.uploadFile(origFile, is);
            String url = "http://" + ip + ":" + port + contextPath +
                    "/upload/loadImgDataByFileName?fileName=" + origFile;

            JSONObject image = new JSONObject();
            image.put("name", name);
            image.put("fileUrl", url);
            image.put("fileName", origFile);
            if (multipartFile.getOriginalFilename() != null && !("").equals(multipartFile.getOriginalFilename())) {
                image.put("oriFileName", (multipartFile.getOriginalFilename()).substring(0,
                        (multipartFile.getOriginalFilename()).lastIndexOf(".")));
            }
            fileList.add(image);
            return  Result.success(fileList);

        } catch (Exception e) {
            log.error(e.getMessage());
            return  Result.fail(e.getMessage());
        }

    }

    @GetMapping(value = "/loadImgDataByFileName")
    @ApiOperation(value = "文件预览", notes = "文件预览")
    public void loadImgData(String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (StringUtils.isEmpty(fileName)) {
            return;
        }
        if (fileName.length() < 3) {
            return;
        }
        String suffix = fileName.substring(fileName.length() - 3);
        //MongoDBFileVo mongoDBFileVo = mongoDBFileService.findByFilename(fileName.trim());
        byte[] buffer = minIOService.loadFile(fileName.trim());
        if (buffer != null) {
            //byte[] buffer = mongoDBFileVo.getBytes();
            if (suffix.toLowerCase(Locale.ENGLISH).endsWith("jpg")) {
                response.setContentType("JPG");
            } else if (suffix.toLowerCase(Locale.ENGLISH).endsWith("gif")) {
                response.setContentType("GIF");
            } else if (suffix.toLowerCase(Locale.ENGLISH).endsWith("png")) {
                response.setContentType("PNG");
            } else {
                response.setContentType("application/octet-stream");
                // 1设置响应头
                String userAgent = request.getHeader("USER-AGENT");
                String oldFileName = fileName;
                String  extName = getFileExt(oldFileName.substring(1));
                oldFileName = oldFileName.substring(0, oldFileName.lastIndexOf("_"))+extName;
                try {
                    if (null != userAgent) {
                        if (-1 != userAgent.indexOf("MSIE")) { // IE
                            oldFileName = URLEncoder.encode(oldFileName, "UTF-8");
                        } else if (-1 != userAgent.indexOf("Firefox") && !userAgent.contains("AppleWebKit")) { // Firefox
                            oldFileName = new String(oldFileName.getBytes("UTF-8"), "ISO8859-1");
                        } else if (userAgent.contains("AppleWebKit")) { // Google
                            // Chrome
                            oldFileName = new String(oldFileName.getBytes("GBK"), "ISO-8859-1");
                        } else {
                            oldFileName = URLEncoder.encode(oldFileName, "UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    try {
                        oldFileName = new String(oldFileName.getBytes("UTF-8"), "ISO-8859-1");
                    } catch (UnsupportedEncodingException e1) {
                    }
                }
                response.addHeader("Content-Disposition", "attachment;filename=" + oldFileName);
                response.addHeader("Content-Length", "" + buffer.length);
            }
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }
    }

    @GetMapping (value = "/presignedPutObj")
    @ApiOperation(value = "minio文件presign上传", notes = "调用此api获取minio的上传链接，这样可以不必暴露minio的accesskye")
    public Result presignedPutObj(String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (StringUtils.isEmpty(fileName)) {
           throw new ApiException( "文件名不能为空");
        }

        String url = minIOService.presignedPutUrl(fileName);
        return Result.success(url);
    }

    @GetMapping("/download")
    @ApiOperation(value = "文件下载", notes = "文件下载")
    public void loadImg(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] buffer = minIOService.loadFile(fileName);
        if (buffer == null) return;
        response.reset();
        if (fileName.contains("jpg") || fileName.contains("png") || fileName.contains("bmp")) {
            response.setContentType("image/jpg");
        }
        if (fileName.contains("pdf")) {
            response.setContentType("application/pdf");
        } else {
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Content-Length", "" + buffer.length);
        }
        /* response.setContentType(mongoDBFileVo.getContentType());*/
        response.setHeader("Cache-Control", "public"); // HTTP/1.1
        response.setHeader("Pragma", "Pragma");
        response.setDateHeader("Expires", System.currentTimeMillis() + 30000000);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        toClient.write(buffer);
        toClient.flush();
        toClient.close();

    }

    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    @GetMapping(value = "/presignedGetObj")
    @ApiOperation(value = "获取minio文件presigned", notes = "调用此api获取minio文件的获取链接，这样可以不必暴露minio的accesskye")
    public Result presignedGetObj(String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (StringUtils.isEmpty(fileName)) {
            throw new ApiException( "文件名不能为空");
        }
        String url = minIOService.presignGetUrl(fileName);
        return Result.success(url);
    }



}
