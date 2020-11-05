package com.cp.dd.web.controller.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.zs.ZsPersonalForm;
import com.cp.dd.web.service.zs.IZsPersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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
@RequestMapping("/api/zsPersonal")
@Api(value = "/zsPersonal", tags = "认证证书管理")
public class ZsPersonalController {

    private IZsPersonalService zsPersonalService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增认证证书")
    @ApiOperation(value = "新增认证证书", notes = "新增认证证书")
    public Result  save(ZsPersonalForm zsDeptForm) {
        zsPersonalService.save(zsDeptForm);
        return Result.success();
    }

    @PostMapping(value = "/update")
    @AddOperLog(name = "修改认证证书")
    @ApiOperation(value = "修改认证证书", notes = "修改认证证书")
    public Result  update(ZsPersonalForm zsDeptForm) {
        zsPersonalService.update(zsDeptForm);
        return Result.success();
    }

    @IgnoreLogin
    @PostMapping(value = "/wechatSave")
    @AddOperLog(name = "公众号新增认证证书")
    @ApiOperation(value = "公众号新增认证证书", notes = "公众号新增认证证书")
    public Result  wechatSave(ZsPersonalForm zsDeptForm) {
        zsPersonalService.wechatSave(zsDeptForm);
        return Result.success();
    }

    @IgnoreLogin
    @PostMapping(value = "/wechatUpdate")
    @AddOperLog(name = "公众号修改认证证书")
    @ApiOperation(value = "公众号修改认证证书", notes = "修改认证证书")
    public Result  wechatUpdate(ZsPersonalForm zsDeptForm) {
        zsPersonalService.wechatUpdate(zsDeptForm);
        return Result.success();
    }
    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "字典树状列表")
    public Result<PageModel<ZsPersonalVO>> page(@Valid PageQuery pageQuery,
                                              @RequestParam(required = false) @ApiParam("证书名称") String zsName,
                                              @RequestParam(required = false) @ApiParam("证书状态 0待失效 1生效 2失效") Integer status,
                                                @RequestParam(required = false) @ApiParam("证书类别") Long categoryId,
                                                @RequestParam(required = false) @ApiParam("区域code") String areaCode
    ) {

        return Result.success(zsPersonalService.getPage(pageQuery,zsName,status,categoryId,areaCode));
    }
    @IgnoreLogin
    @GetMapping(value = "/getName")
    @ApiOperation(value = "公众号证书查询", notes = "公众号证书查询")
    public Result<ZsPersonal> getName(@RequestParam @ApiParam(value = "name", required = true)
                                               String  name
    ) {
        ZsPersonal zsPersonal = zsPersonalService.getOne(Wrappers.<ZsPersonal>lambdaQuery()
            .eq(ZsPersonal::getName,name)
        );
        return Result.success(zsPersonal);
    }

    @IgnoreLogin
    @GetMapping(value = "/getAuditName")
    @ApiOperation(value = "公众号证书审核查询", notes = "公众号证书审核查询")
    public Result<ZsPersonal> getAuditName(@RequestParam @ApiParam(value = "name", required = true)
                                              String  name,
                                           @RequestParam @ApiParam(value = "身份证", required = true)
                                                   String  idCard
    ) {
        ZsPersonal zsPersonal = zsPersonalService.getOne(Wrappers.<ZsPersonal>lambdaQuery()
                .eq(ZsPersonal::getName,name)
                .eq(ZsPersonal::getIdCard,idCard)
        );
        return Result.success(zsPersonal);
    }

    @GetMapping(value = "/del")
    @AddOperLog(name = "删除证书信息")
    @ApiOperation(value = "删除证书信息", notes = "删除证书信息")
    public Result del(@RequestParam @ApiParam(value = "Id", required = true)
                              List<Long> ids) {
        zsPersonalService.del(ids);
        return Result.success();
    }

    @GetMapping(value = "/audit")
    @ApiOperation(value = "证书失效/审核", notes = "证书失效/审核")
    public Result audit(@RequestParam @ApiParam(value = "Id", required = true)
                                List<Long> ids,
                        @RequestParam @ApiParam(value = "审核状态  0待生效 1生效 2失效" ,required = true) Integer auditStatus
    ) {
        zsPersonalService.audit(ids,auditStatus);
        return Result.success();
    }

    @GetMapping(value = "/detail")
    @ApiOperation(value = "证书详情", notes = "证书详情")
    public Result<ZsPersonalVO> detail(@RequestParam @ApiParam(value = "Id", required = true)
                                 Long id
    ) {
        return Result.success(zsPersonalService.detail(id));
    }

    @IgnoreLogin
    @GetMapping(value = "/wxDetail")
    @ApiOperation(value = "公众号证书详情", notes = "证书详情")
    public Result<ZsPersonalVO> wxDetail(@RequestParam @ApiParam(value = "Id", required = true)
                                               Long id
    ) {
        return Result.success(zsPersonalService.detail(id));
    }

}
