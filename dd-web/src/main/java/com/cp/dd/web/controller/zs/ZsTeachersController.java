package com.cp.dd.web.controller.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.zs.ZsTeachers;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.zs.ZsTeachersForm;
import com.cp.dd.web.service.zs.IZsTeachersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-14
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/zsTeachers")
@Api(value = "/zsTeachers", tags = "认证师资管理")
public class ZsTeachersController {

    private IZsTeachersService zsTeachersService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增认证师资")
    @ApiOperation(value = "新增认证师资", notes = "新增认证师资")
    public Result save(ZsTeachersForm zsTeachersForm) {
        zsTeachersService.save(zsTeachersForm);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "字典树状列表")
    public Result<PageModel<ZsTeachers>> page(@Valid PageQuery pageQuery,
                                              @RequestParam(required = false) @ApiParam("姓名") String name) {
        IPage<ZsTeachers> page = zsTeachersService.page(pageQuery.loadPage(), Wrappers.<ZsTeachers>lambdaQuery()
                .like(StringUtils.isNotBlank(name),ZsTeachers::getName, name)
                // 默认按sort排序
                .orderByAsc(ZsTeachers::getRzTime));
        return Result.success(page);
    }

    @PostMapping("/import")
    @AddOperLog(name = "认证师资数据导入")
    @ApiOperation(value = "导入", notes = "认证师资数据导入")
    public Result<?> importWord(@RequestParam("file") MultipartFile file) {
        zsTeachersService.importItem(file);
        return Result.success();
    }

}
