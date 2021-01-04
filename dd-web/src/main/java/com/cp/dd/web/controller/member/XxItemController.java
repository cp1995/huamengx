package com.cp.dd.web.controller.member;

import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.SignUtil;
import com.cp.dd.common.vo.sport.AccessTokenFactory;
import com.cp.dd.common.vo.sport.XxItemVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.sport.XxItemForm;
import com.cp.dd.web.form.sport.XxItemUpdateForm;
import com.cp.dd.web.service.sport.ISportService;
import com.cp.dd.web.service.sport.IXxItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录接口
 *
 * @author chengp
 * @date 2020-06-01
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/xxItem")
@Api(value = "/item", tags = "小学信息录入接口")
@Slf4j
public class XxItemController {

    private IXxItemService xxItemService;

    private ISportService sportService;

    @AddOperLog(name = "新增小学生报告信息")
    @PostMapping("/save")
    @ApiOperation(value = "新增小学生报告信息", notes = "新增小学生报告信息")
    public Result save(@Valid XxItemForm xxItemForm) {
        xxItemService.save(xxItemForm);
        return Result.success();
    }


    @AddOperLog(name = "修改小学生报告信息")
    @PostMapping("/update")
    @ApiOperation(value = "修改小学生报告信息", notes = "修改小学生报告信息")
    public Result update(@Valid XxItemUpdateForm xxItemUpdateForm) {
        xxItemService.update(xxItemUpdateForm);
        return Result.success();
    }
    @GetMapping("/getPage")
    @ApiOperation(value = "报告分页列表", notes = "用户分页列表")
    public Result<PageModel<XxItemVO>> getPage(@Valid PageQuery pageQuery,
                                             @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                             @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                             @ApiParam("场次名称") @RequestParam(required = false) String name,
                                             @ApiParam("创建人") @RequestParam(required = false) String createBy,
                                             @ApiParam("家长姓名") @RequestParam(required = false) String parentName,
                                             @ApiParam("所属区域") @RequestParam(required = false) Long areaId
    ) {


        return Result.success(xxItemService.getPage(pageQuery,childName,phone,name,createBy,parentName,areaId));
    }

    @GetMapping("/getDataPage")
    @ApiOperation(value = "数据报告分页列表", notes = "数据报告分页列表")
    public Result<PageModel<XxItemVO>> getDataPage(@Valid PageQuery pageQuery,
                                             @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                             @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                             @ApiParam("场次名称") @RequestParam(required = false) String name,
                                             @ApiParam("创建人") @RequestParam(required = false) String createBy,
                                             @ApiParam("所属区域") @RequestParam(required = false) Long areaId,
                                             @ApiParam("排序(1、身高得分 2、bmi 3、下肢 4、上肢 5、协调性 6、平衡性 7、柔韧性 8、灵敏性 9、拍球 10 、传球 11、上篮)  ") @RequestParam(required = false) Integer sort,
                                             @ApiParam("asc 或者 desc") @RequestParam(required = false) String ascOrDesc
    ) {
        return Result.success(xxItemService.getDataPage(pageQuery,childName,phone,name,createBy,areaId,sort,ascOrDesc));
    }
    @AddOperLog(name = "数据报告导出")
    @GetMapping("/export")
    @ApiOperation(value = "数据报告列表导出", notes = "数据报告列表导出")
    public void export(HttpServletResponse response, HttpServletRequest request,
                       @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                       @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                       @ApiParam("场次名称") @RequestParam(required = false) String name,
                       @ApiParam("创建人") @RequestParam(required = false) String createBy,
                       @ApiParam("所属区域") @RequestParam(required = false) Long areaId,
                       @ApiParam("排序(1、身高得分 2、bmi 3、下肢 4、上肢 5、协调性 6、平衡性 7、柔韧性 8、灵敏性 9、拍球 10 、传球 11、上篮) ") @RequestParam(required = false) Integer sort,
                       @ApiParam("asc 或者 desc") @RequestParam(required = false) String ascOrDesc
                                                                                            ) {
        xxItemService.export(response,request,childName,phone,name,createBy,areaId,sort,ascOrDesc);
    }

    @PostMapping("/import")
    @AddOperLog(name = "数据报告导入")
    @ApiOperation(value = "导入", notes = "数据报告导入")
    public Result<?> importWord(@RequestParam("file") MultipartFile file) {
        xxItemService.importItem(file);
        return Result.success();
    }
    @AddOperLog(name = "公众号获取报告")
    @GetMapping("/getData")
    @ApiOperation(value = "公众号获取报告", notes = "公众号获取报告")
    public Result<List<XxItemVO> > getData(
                                                 @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                                 @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                                 @ApiParam("场次名称") @RequestParam(required = true) Long sportId

    ) {
        return Result.success(xxItemService.getData(null,childName,phone,sportId));
    }


    @IgnoreLogin
    @GetMapping("/getWxData")
    @ApiOperation(value = "公众号游客获取报告", notes = "公众号游客获取报告")
    public Result<List<XxItemVO> > getWxData(
            @ApiParam(value = "父母姓名" ,required = true) @RequestParam() String parentName,
            @ApiParam(value = "小朋友姓名" ,required = true) @RequestParam() String childName,
            @ApiParam(value = "家长手机号" ,required = true) @RequestParam() String phone

    ) {
        return Result.success(xxItemService.getData(parentName,childName,phone,null));
    }


    @IgnoreLogin
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "详情")
    public Result<XxItemVO> detail(
            @ApiParam("id") @RequestParam(required = true) Long id

    ) {
        return Result.success(xxItemService.detail(id));
    }

    @GetMapping("/del")
    @AddOperLog(name = "删除报告")
    @ApiOperation(value = "删除报告", notes = "删除报告")
    public Result del(
            @ApiParam("id") @RequestParam(required = true) Long id) {
        xxItemService.del(id);
        return Result.success();
    }

    @IgnoreLogin
    @GetMapping(value = "/downloadFile")
    @ApiOperation(value = "模板下载", notes = "模板下载")
    public HttpServletResponse  download(HttpServletResponse response) throws IOException {
          try {
              HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                  String path = request.getSession().getServletContext().getRealPath("/");
                   path = path + File.separator + "小学体测数据模板-格式统一为文本格式.xlsx";
                   // path是指欲下载的文件的路径。
                   File file = new File(path);
                   // 取得文件名。
                   String filename = file.getName();
                   // 取得文件的后缀名。
                   String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

                   // 以流的形式下载文件。
                   InputStream fis = new BufferedInputStream(new FileInputStream(path));
                   byte[] buffer = new byte[fis.available()];
                   fis.read(buffer);
                   fis.close();
                   // 清空response
                   response.reset();
                   // 设置response的Header
                  // response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
                   response.addHeader("Content-Length", "" + file.length());
                   OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                   response.setContentType("application/octet-stream");
                   response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
                   toClient.write(buffer);
                   toClient.flush();
                   toClient.close();
                 } catch (IOException ex) {
                   ex.printStackTrace();
                 }
             return response;
     }
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    @IgnoreLogin
    @ApiOperation(value = "微信分享", notes = "url(当前连接url,用于签名验证)")
    public Result share(String url) {
        String appId ="wx59e0048bc8e7000d";
        String secret ="1813ffee71693b567b981c502de0e20c";
        Map<String, String> map = new HashMap<String, String>();
        String jsapi_ticket = AccessTokenFactory.getJsapiTicket(appId,secret).getTicket();
        System.out.println("jsapi_ticket="+jsapi_ticket);
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String nonceStr = UUID.randomUUID().toString();//生成签名的随机串
        System.out.println("nonceStr="+nonceStr);
        String signature = "";
        try {
            signature = SignUtil.getSignature(
                    jsapi_ticket, nonceStr, timestamp,
                    url);
        } catch (Exception e) {
            log.error("获取签名失败", e);
            log.error(e.getMessage());
        }
        System.out.println("signature="+signature);
        map.put("url", url);
        map.put("jsapi_ticket", jsapi_ticket);
        map.put("nonceStr", nonceStr);
        map.put("timestamp", timestamp);
        map.put("signature", signature);
        map.put("appid", appId);
        return Result.success(map);
    }
}
