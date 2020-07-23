package com.cp.dd.web.controller.member;

import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.sport.ItemVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.sport.SportForm;
import com.cp.dd.web.service.sport.ISportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 登录接口
 *
 * @author chengp
 * @date 2020-06-01
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/sport")
@Api(value = "/sport", tags = "场次接口")
public class SportController {

    private ISportService sportService;

    @AddOperLog(name = "新增场次")
    @PostMapping("/save")
    @ApiOperation(value = "保存", notes = "保存")
    public Result save(@Valid SportForm sportForm) {
        sportService.save(sportForm);
        return Result.success();
    }
    @AddOperLog(name = "删除场次")
    @GetMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除")
    public Result delete(@RequestParam @ApiParam(value = "name", required = true) Long id) {
        sportService.delete(id);
        return Result.success();
    }

    @GetMapping("/getList")
    @ApiOperation(value = "场次选择下拉列表", notes = "场次选择下拉列表")
    public Result<List<Sport>> getList() {
        return Result.success(sportService.getList());
    }
    @GetMapping("/getDataPage")
    @ApiOperation(value = "数据报告分页列表", notes = "数据报告分页列表")
    public Result<PageModel<Sport>> getDataPage(@Valid PageQuery pageQuery,
                                                 @ApiParam("name") @RequestParam(required = false) String name
    ) {
        return Result.success(sportService.getPage(pageQuery,name));
    }


    

}
