package com.cp.dd.web.controller.member;

import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.member.AreaVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.service.member.IAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 登录接口
 *
 * @author chengp
 * @date 2019-09-23
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/area")
@Api(value = "/area", tags = "园区接口")
public class AreaController {

    private IAreaService areaService;

    @AddOperLog(name = "新增园区")
    @GetMapping("/save")
    @ApiOperation(value = "保存", notes = "保存")
    public Result save(@RequestParam @ApiParam(value = "name", required = true) String name,
                       @RequestParam @ApiParam(value = "区域", required = true) String areaCode,
                       @RequestParam @ApiParam(value = "幼儿园/场馆", required = true) String type
                       ) {
        areaService.save(name,areaCode,type);
        return Result.success();
    }
    @AddOperLog(name = "删除园区")
    @GetMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除")
    public Result delete(@RequestParam @ApiParam(value = "name", required = true) Long id) {
        areaService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation(value = "列表", notes = "列表")
    public Result<List<Area>> list() {
        return Result.success(areaService.findList());
    }


    @GetMapping("/regionList")
    @ApiOperation(value = "获取区域列表", notes = "获取区域列表 ")
    public Result<List<Area>> regionList() {
        return Result.success(areaService.findRegionList());
    }

    @GetMapping("/getPage")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<AreaVO>> getPage(@Valid PageQuery pageQuery,
                                             @RequestParam ( required =false) @ApiParam(value = "name", required = false) String name) {
        return Result.success(areaService.getPage(pageQuery,name));
    }




    

}
