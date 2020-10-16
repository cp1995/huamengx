package com.cp.dd.web.controller.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "字典树状列表")
    public Result<PageModel<ZsPersonal>> page(@Valid PageQuery pageQuery,
                                              @RequestParam(required = false) @ApiParam("证书名称") String zsName,
                                              @RequestParam(required = false) @ApiParam("证书状态 0待失效 1生效 2失效") Integer status
    ) {
        IPage<ZsPersonal> page = zsPersonalService.page(pageQuery.loadPage(), Wrappers.<ZsPersonal>lambdaQuery()
                .like(StringUtils.isNotBlank(zsName),ZsPersonal::getZsName, zsName)
                .eq(Objects.nonNull(status), ZsPersonal::getStatus,status)
                // 默认按sort排序
                .orderByAsc(ZsPersonal::getCreateTime));
        return Result.success(page);
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

}
