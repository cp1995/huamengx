package com.cp.dd.web.controller.sport;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.ZsCategory;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.member.ZsCategoryForm;
import com.cp.dd.web.form.sport.ZsInfoForm;
import com.cp.dd.web.service.member.IZsCategoryService;
import com.cp.dd.web.service.sport.IZsInfoService;
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
@RequestMapping("/api/zsInfo")
@Api(value = "/zsInfo", tags = "证书信息")
public class ZsInfoController {

    private IZsInfoService zsInfoService;

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增证书信息")
    @ApiOperation(value = "新增证书信息", notes = "新增证书信息")
    public Result save(ZsInfoForm zsInfoForm) {
        zsInfoService.save(zsInfoForm);
        return Result.success();
    }

    @PostMapping(value = "/update")
    @AddOperLog(name = "修改证书信息")
    @ApiOperation(value = "修改证书信息", notes = "修改证书信息")
    public Result update(ZsInfoForm zsInfoForm) {
        zsInfoService.update(zsInfoForm);
        return Result.success();
    }

    @GetMapping(value = "/del")
    @AddOperLog(name = "删除证书信息")
    @ApiOperation(value = "删除证书信息", notes = "删除证书信息")
    public Result del(@RequestParam @ApiParam(value = "Id", required = true)
                              List<Long> ids) {
        zsInfoService.del(ids);
        return Result.success();
    }




}
