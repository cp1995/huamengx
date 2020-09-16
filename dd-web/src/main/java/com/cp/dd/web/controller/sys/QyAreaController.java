package com.cp.dd.web.controller.sys;

import com.cp.dd.common.entity.sys.QyArea;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.service.sys.IQyAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 区域设置 前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-16
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/qyArea")
@Api(value = "/qyArea", tags = "区域设置")
public class QyAreaController {

    private IQyAreaService qyAreaService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增区域")
    @ApiOperation(value = "新增区域", notes = "新增区域")
    public Result save(@RequestParam() @ApiParam(value = "区域名称",required = true) String name,
                       @RequestParam() @ApiParam(value = "省名称,多个用逗号隔开",required = true) String province
                        ) {
        qyAreaService.save(name,province);
        return Result.success();
    }

    @GetMapping("/getPage")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<QyArea>> getPage(@Valid PageQuery pageQuery

    ) {

        return Result.success(qyAreaService.getPage(pageQuery));
    }



}
