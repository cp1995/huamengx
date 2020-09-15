package com.cp.dd.web.controller.zs;

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

    @PostMapping(value = "/save")
    @AddOperLog(name = "新增加盟商")
    @ApiOperation(value = "新增加盟商", notes = "新增加盟商")
    public Result save(ZsDeptForm zsDeptForm) {
        zsDeptService.save(zsDeptForm);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "分页列表")
    public Result<PageModel<ZsDeptVO>> page(@Valid PageQuery pageQuery,
                                            @RequestParam(required = false) @ApiParam("加盟类型") Long categoryId,
                                            @RequestParam(required = false) @ApiParam("加盟状态 待加盟 加盟中 已过期 已终止") String status

    ) {

        return Result.success(zsDeptService.getPage(pageQuery,categoryId,status));
    }


}
