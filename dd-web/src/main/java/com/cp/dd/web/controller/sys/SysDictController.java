package com.cp.dd.web.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.sys.SysDict;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.service.sys.ISysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author chengp
 * @date 2020-07-05
 */
@Validated
@AllArgsConstructor
@RestController
@IgnoreLogin
@RequestMapping("/api/sysDict")
@Api(value = "/sysDict", tags = "字典管理")
public class SysDictController {

    private ISysDictService sysDictService;


    @GetMapping
    @ApiOperation(value = "列表", notes = "字典树状列表")
    public Result<List<SysDict>> listByCode(@RequestParam @ApiParam(value = "字典码", required = true) String code) {
        List<SysDict> list = sysDictService.listByCode(code);
        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "字典树状列表")
    public Result<PageModel<SysDict>> page(@Valid PageQuery pageQuery,
                                           @RequestParam(required = false) @ApiParam("字典编码") String code,
                                           @RequestParam(required = false) @ApiParam("字典名称") String remark) {
        IPage<SysDict> page = sysDictService.page(pageQuery.loadPage(), Wrappers.<SysDict>lambdaQuery()
                .eq(StringUtils.isNotBlank(code),SysDict::getCode, code)
                .like(StringUtils.isNotBlank(remark),SysDict::getRemark, remark)
                .eq(SysDict::getIsDeleted, false)
                // 默认按sort排序
                .orderByAsc(SysDict::getSort));
        return Result.success(page);
    }

    @PostMapping
    @ApiOperation(value = "保存", notes = "保存字典")
    public Result save(SysDict sysDict) {
        sysDictService.saveOrUpdate(sysDict);
        return Result.success();
    }

    @PostMapping("/sort")
    @ApiOperation(value = "排序", notes = "排序")
    public Result sort(@RequestParam @ApiParam(value = "字典Id", required = true) Long id,
                       @RequestParam @ApiParam(value = "up-向上替换，down-向下替换") String upOrDown) {
        sysDictService.sort(id, upOrDown);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除", notes = "删除字典")
    public Result save(@PathVariable @ApiParam(value = "字典ID", required = true) Long id) {
        sysDictService.delete(id);
        return Result.success();
    }
}
