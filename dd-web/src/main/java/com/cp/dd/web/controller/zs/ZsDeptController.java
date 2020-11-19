package com.cp.dd.web.controller.zs;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.zs.ZsDept;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.zs.ZsDeptForm;
import com.cp.dd.web.service.zs.IZsDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/zsDept")
@Api(value = "/zsDept", tags = "加盟商管理")
public class ZsDeptController {

    private IZsDeptService zsDeptService;

    @IgnoreLogin
    @PostMapping(value = "/wechatSave")
    @AddOperLog(name = "公众号新增加盟商")
    @ApiOperation(value = "公众号新增加盟商", notes = "公众号新增加盟商")
    public Result wechatSave(@Valid ZsDeptForm zsDeptForm) {
        zsDeptService.wechatSave(zsDeptForm);
        return Result.success();
    }


    @PostMapping(value = "/save")
    @AddOperLog(name = "新增加盟商")
    @ApiOperation(value = "新增加盟商", notes = "新增加盟商")
    public Result save(@Valid ZsDeptForm zsDeptForm) {
        zsDeptService.save(zsDeptForm);
        return Result.success();
    }

    @IgnoreLogin
    @PostMapping(value = "/wechatUpdate")
    @AddOperLog(name = "公众号修改加盟商")
    @ApiOperation(value = "公众号修改加盟商", notes = "公众号修改加盟商")
    public Result wechatUpdate(@Valid ZsDeptForm zsDeptForm) {
        zsDeptService.wechatUpdate(zsDeptForm);
        return Result.success();
    }

    @PostMapping(value = "/update")
    @AddOperLog(name = "修改加盟商")
    @ApiOperation(value = "修改加盟商", notes = "修改加盟商")
    public Result update(@Valid ZsDeptForm zsDeptForm) {
        zsDeptService.update(zsDeptForm);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<ZsDeptVO>> page(@Valid PageQuery pageQuery,
                                            @RequestParam(required = false) @ApiParam("加盟类型") Long categoryId,
                                            @RequestParam(required = false) @ApiParam("加盟状态 待加盟 加盟中 已过期 已终止") String status,
                                            @RequestParam(required = false) @ApiParam("区域code") String areaCode

    ) {

        return Result.success(zsDeptService.getPage(pageQuery,categoryId,status,areaCode));
    }

    @GetMapping("/auditPage")
    @ApiOperation(value = "审核分页列表", notes = "审核分页列表")
    public Result<PageModel<ZsDeptVO>> auditPage(@Valid PageQuery pageQuery,
                                            @RequestParam(required = false) @ApiParam("加盟类型") Long categoryId,
                                            @RequestParam(required = false) @ApiParam("加盟状态 待加盟 加盟中 已过期 已终止") String status,
                                                 @RequestParam(required = false) @ApiParam("审核状态  0待审核 1审核通过 2不通过") Integer auditStatus,
                                                 @RequestParam(required = false) @ApiParam("区域code") String areaCode

    ) {

        return Result.success(zsDeptService.auditPage(pageQuery,categoryId,status,auditStatus,areaCode));
    }

    @IgnoreLogin
    @GetMapping(value = "/getName")
    @ApiOperation(value = "公众号证书查询", notes = "公众号证书查询")
    public Result<List<ZsDept>> getName(@RequestParam @ApiParam(value = "加盟商名称", required = true)
                                              String  name

    ) {
        List<ZsDept> zsDept = zsDeptService.list(Wrappers.<ZsDept>lambdaQuery()
                .eq(ZsDept::getName,name)
        );
        return Result.success(zsDept);
    }

    @IgnoreLogin
    @GetMapping(value = "/getAuditName")
    @ApiOperation(value = "公众号证书审核查询", notes = "公众号证书审核查询")
    public Result<List<ZsDept>> getAuditName(@RequestParam @ApiParam(value = "加盟商名称", required = true)
                                          String  name,
                                  @RequestParam @ApiParam(value = "身份证", required = true)
                                          String  idCard
    ) {
        List<ZsDept> zsDept = zsDeptService.list(Wrappers.<ZsDept>lambdaQuery()
                .eq(ZsDept::getName,name)
                .eq(ZsDept::getIdCard,idCard)
                .eq(ZsDept::getAuditStatus,2)
        );
        return Result.success(zsDept);
    }


    @GetMapping(value = "/audit")
    @ApiOperation(value = "加盟商审核", notes = "加盟商审核")
    public Result audit(@RequestParam @ApiParam(value = "Id", required = true)
                                List<Long> ids,
                        @RequestParam @ApiParam(value = "审核状态  0审核 1审核通过 2不通过" ,required = true) Integer auditStatus
    ) {
        zsDeptService.audit(ids,auditStatus);
        return Result.success();
    }

    @GetMapping(value = "/detail")
    @ApiOperation(value = "加盟商详情", notes = "加盟商详情")
    public Result detail(@RequestParam @ApiParam(value = "Id", required = true)
                               Long id
    ) {
        return Result.success(zsDeptService.detail(id));
    }

    @IgnoreLogin
    @GetMapping(value = "/wxDetail")
    @ApiOperation(value = "公众号加盟商详情", notes = "加盟商详情")
    public Result wxDetail(@RequestParam @ApiParam(value = "Id", required = true)
                                 Long id
    ) {
        return Result.success(zsDeptService.detail(id));
    }


}
