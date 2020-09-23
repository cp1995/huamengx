package com.cp.dd.web.controller.sport;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.ZsCategory;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.zs.ZsCategoryVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.member.ZsCategoryForm;
import com.cp.dd.web.service.member.IZsCategoryService;
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
 *  前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-19
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/zsCategory")
@Api(value = "/zsCategory", tags = "证书类型")
public class ZsCategoryController {

    private IZsCategoryService zsCategoryService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增证书类型")
    @ApiOperation(value = "新增证书类型", notes = "新增证书类型")
    public Result save(ZsCategoryForm zsCategoryForm) {
        zsCategoryService.save(zsCategoryForm);
        return Result.success();
    }

    @PostMapping(value = "/update")
    @AddOperLog(name = "新增证书类型")
    @ApiOperation(value = "修改证书类型", notes = "修改证书类型")
    public Result update(ZsCategoryForm zsCategoryForm) {
        zsCategoryService.update(zsCategoryForm);
        return Result.success();
    }

    @GetMapping(value = "/del")
    @AddOperLog(name = "删除证书类型")
    @ApiOperation(value = "删除证书类型", notes = "删除证书类型")
    public Result del(@RequestParam @ApiParam(value = "Id", required = true)
                              List<Long> ids) {
        zsCategoryService.del(ids);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<ZsCategory>> page(@Valid PageQuery pageQuery,
                                              @RequestParam(required = false) @ApiParam("分类名称") String name,
                                              @RequestParam(required = false) @ApiParam("机构证书、个人证书") String type
                                              ) {
        return Result.success(zsCategoryService.page(pageQuery.loadPage(), Wrappers.<ZsCategory>lambdaQuery()
                .eq(StringUtils.isNotBlank(name), ZsCategory::getName, name)
                .eq(StringUtils.isNotBlank(type), ZsCategory::getType, type)
                .ne(ZsCategory::getStatus, Constants.Status.delete)
                .orderByAsc(ZsCategory::getCreateTime)));
    }

    @IgnoreLogin
    @GetMapping("/appPage")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<ZsCategory>> appPage(@Valid PageQuery pageQuery,
                                              @RequestParam(required = false) @ApiParam("分类名称") String name,
                                              @RequestParam(required = false) @ApiParam("机构证书、个人证书") String type
    ) {
        return Result.success(zsCategoryService.page(pageQuery.loadPage(), Wrappers.<ZsCategory>lambdaQuery()
                .eq(StringUtils.isNotBlank(name), ZsCategory::getName, name)
                .eq(StringUtils.isNotBlank(type), ZsCategory::getType, type)
                .ne(ZsCategory::getStatus, Constants.Status.delete)
                .orderByAsc(ZsCategory::getCreateTime)));
    }
    @GetMapping("/list")
    @ApiOperation(value = "列表", notes = "列表")
    public Result<List<ZsCategory>> list() {
        return Result.success(zsCategoryService.list(Wrappers.<ZsCategory>lambdaQuery()
                .eq(ZsCategory::getStatus, Constants.Status.enable)
                .orderByAsc(ZsCategory::getCreateTime)));
    }

    @GetMapping("/getAcCode")
    @ApiOperation(value = "通过分类id过去证书编号 名称", notes = "通过分类id过去证书编号")
    public Result<ZsCategoryVO> getAcCode(@RequestParam @ApiParam(value = "Id", required = true)
                                                    Long id) {
        return Result.success(zsCategoryService.getId(id));
    }




}
