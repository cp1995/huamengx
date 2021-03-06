package com.cp.dd.web.controller.sport;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.ZsInfoAreaCountVO;
import com.cp.dd.common.vo.sport.ZsInfoCountVO;
import com.cp.dd.common.vo.sport.ZsInfoLsCountVO;
import com.cp.dd.common.vo.sport.ZsInfoVO;
import com.cp.dd.common.vo.sys.SysUserVO;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.sport.WechatZsInfoForm;
import com.cp.dd.web.form.sport.ZsInfoForm;
import com.cp.dd.web.service.member.IZsCategoryService;
import com.cp.dd.web.service.sport.IZsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-19
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/zsInfo")
@Api(value = "/zsInfo", tags = "证书信息")
public class ZsInfoController {

    private IZsInfoService zsInfoService;
    private IZsCategoryService zsCategoryService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增证书信息")
    @ApiOperation(value = "新增证书信息", notes = "新增证书信息")
    public Result save(ZsInfoForm zsInfoForm) {
        zsInfoService.save(zsInfoForm);
        return Result.success();
    }

    @IgnoreLogin
    @PostMapping(value = "/wechatSave")
    @AddOperLog(name = "公众号新增证书信息")
    @ApiOperation(value = "公众号新增证书信息", notes = "公众号新增证书信息")
    public Result wechatSave(WechatZsInfoForm zsInfoForm) {
        zsInfoService.weChatSave(zsInfoForm);
        return Result.success();
    }

    @PostMapping(value = "/update")
    @AddOperLog(name = "修改证书信息")
    @ApiOperation(value = "修改证书信息", notes = "修改证书信息")
    public Result update(ZsInfoForm zsInfoForm) {
        zsInfoService.update(zsInfoForm);
        return Result.success();
    }

    @GetMapping(value = "/detail")
    @ApiOperation(value = "详情", notes = "详情")
    public Result<ZsInfoVO> detail(@RequestParam @ApiParam(value = "Id", required = true)
                              Long id) {
        ZsInfo zsInfo =zsInfoService.getById(id);
        ZsInfoVO vo = new ZsInfoVO();
        BeanUtils.copyProperties(zsInfo,vo);
        vo.setCategoryName(zsCategoryService.getById(zsInfo.getCategoryId()).getName());
        return Result.success(vo);
    }

    @GetMapping(value = "/del")
    @AddOperLog(name = "删除证书信息")
    @ApiOperation(value = "删除证书信息", notes = "删除证书信息")
    public Result del(@RequestParam @ApiParam(value = "Id", required = true)
                              List<Long> ids) {
        zsInfoService.del(ids);
        return Result.success();
    }

    @GetMapping(value = "/audit")
    @ApiOperation(value = "证书审核", notes = "证书审核")
    public Result audit(@RequestParam @ApiParam(value = "Id", required = true)
                              List<Long> ids,
                        @RequestParam @ApiParam(value = "审核状态  0审核 1审核通过 2不通过" ,required = true) Integer auditStatus
                        ) {
        zsInfoService.audit(ids,auditStatus);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<ZsInfo>> page(@Valid PageQuery pageQuery,
                                          @RequestParam(required = false) @ApiParam("姓名") String name,
                                          @RequestParam(required = false) @ApiParam("机构名") String deptName,
                                          @RequestParam(required = false) @ApiParam("证书编号") String code,
                                          @RequestParam(required = false) @ApiParam("区域") String areaId,
                                          @RequestParam(required = false) @ApiParam("机构证书、个人证书") String categoryType,
                                          @RequestParam(required = false) @ApiParam("证书类别") Long categoryId
    ) {
        return Result.success(zsInfoService.getPage(pageQuery,name,deptName,code,areaId,categoryType,categoryId));
    }


    @GetMapping("/getAuditPage")
    @ApiOperation(value = "审核分页列表", notes = "审核分页列表")
    public Result<PageModel<ZsPersonalVO>> getAuditPage(@Valid PageQuery pageQuery,
                                                        @RequestParam(required = false) @ApiParam("姓名") String name,
                                                        @RequestParam(required = false) @ApiParam("机构名") String deptName,
                                                        @RequestParam(required = false) @ApiParam("证书编号") String code,
                                                        @RequestParam(required = false) @ApiParam("机构证书、个人证书") String categoryType,
                                                        @RequestParam(required = false) @ApiParam("审核状态  0审核 1审核通过 2不通过") Integer auditStatus,
                                                        @RequestParam(required = false) @ApiParam("区域code") String areaCode
    ) {
        return Result.success(zsInfoService.getAuditPage(pageQuery,name,deptName,code,categoryType,auditStatus,areaCode));
    }


    @IgnoreLogin
    @GetMapping("/pageApp")
    @ApiOperation(value = "公众号证书查询", notes = "公众号个人证书查询")
    public Result<List<ZsInfo>> pageApp(
                                          @RequestParam(required = false) @ApiParam("姓名") String name,
                                             @RequestParam(required = false) @ApiParam("机构名") String deptName,
                                          @RequestParam(required = false) @ApiParam("证书编号") String code
    ) {
        if(StringUtils.isBlank(name) && StringUtils.isBlank(deptName) && StringUtils.isBlank(code)){
            throw new ApiException("请输入查询条件");
        }
        return Result.success(zsInfoService.getAppList(name,deptName,code));
    }

    @GetMapping("/countInfo")
    @ApiOperation(value = "各类证书总数量统计", notes = "各类证书总数量统计")
    public Result<List<ZsInfoCountVO>> countInfo(
    ) {
        return Result.success(zsInfoService.countInfo());
    }

    @GetMapping("/countArea")
    @ApiOperation(value = "证书区域统计", notes = "证书区域统计")
    public Result<List<ZsInfoAreaCountVO> > countArea(
    ) {
        return Result.success(zsInfoService.countArea());
    }

    @GetMapping("/countSex")
    @ApiOperation(value = "统计男女比例", notes = "统计男女比例")
    public Result countSex() {
        MemberVO memberVO = SessionCache.get();
        String areaId = null;
        if (memberVO.getRole() == 4){
            areaId = memberVO.getAreaId()+"";
        }
       Integer countNan = zsInfoService.count(Wrappers.<ZsInfo>lambdaQuery()
            .eq(ZsInfo::getSex,1)
            .eq(StringUtils.isNotBlank(areaId),ZsInfo::getAreaId,areaId)
            .eq(ZsInfo::getCategoryType,"个人证书")
        );

        Integer countNv = zsInfoService.count(Wrappers.<ZsInfo>lambdaQuery()
                .eq(ZsInfo::getSex,2)
                .eq(StringUtils.isNotBlank(areaId),ZsInfo::getAreaId,areaId)
                .eq(ZsInfo::getCategoryType,"个人证书")
        );
        Map<String,Integer> map = new HashMap<>();
        map.put("男",countNan);
        map.put("女",countNv);
        return Result.success(map);
    }

    @GetMapping("/countLx")
    @ApiOperation(value = "证书流失人数", notes = "证书流失人数")
    public Result<ZsInfoLsCountVO> countLx(@RequestParam(required = false) @ApiParam("年份") String year
    ) {
        return Result.success(zsInfoService.countLx(year));
    }


}
