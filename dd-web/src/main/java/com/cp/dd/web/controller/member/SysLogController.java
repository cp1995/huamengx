package com.cp.dd.web.controller.member;

import com.cp.dd.common.entity.sys.SysLog;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.service.member.ISysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;


/**
 * 登录接口
 *
 * @author chengp
 * @date 2019-09-23
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/sysLog")
@Api(value = "/sysLog", tags = "系统日志")
public class SysLogController {

    private ISysLogService sysLogService;



    @GetMapping("/getPage")
    @ApiOperation(value = "用户分页列表", notes = "用户分页列表")
    public Result<PageModel<SysLog>> getPage(@Valid PageQuery pageQuery,
                                             @ApiParam("操作人") @RequestParam(required = false) String createBy,
                                             @ApiParam("用户id") @RequestParam(required = false) Long memberId,
                                             @ApiParam("操作结果 0 成功  -1失败") @RequestParam(required = false) Integer resultCode,
                                             @ApiParam("开始时间yyyy-MM-dd") @RequestParam(required = false)
                                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime,
                                             @ApiParam("结束时间yyyy-MM-dd") @RequestParam(required = false)
                                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime) {

        return Result.success(sysLogService.getPage(pageQuery,createBy,memberId,resultCode,startTime,endTime));
    }

    @GetMapping("/getId")
    @ApiOperation(value = "详情", notes = "详情")
    public Result<SysLog> getPage(@ApiParam("用户id") @RequestParam(required = true) Long id) {
        return Result.success(sysLogService.getById(id));
    }

    @AddOperLog(name = "用户导出")
    @GetMapping("/export")
    @ApiOperation(value = "用户导出", notes = "用户导出")
    public void export(HttpServletResponse response, HttpServletRequest request,
                       @ApiParam("操作人") @RequestParam(required = false) String createBy,
                       @ApiParam("用户id") @RequestParam(required = false) Long memberId,
                       @ApiParam("操作结果 0 成功  -1失败") @RequestParam(required = false) Integer resultCode,
                       @ApiParam("开始时间yyyy-MM-dd") @RequestParam(required = false)
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime,
                       @ApiParam("结束时间yyyy-MM-dd") @RequestParam(required = false)
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime)  {
        sysLogService.export(response,request,createBy,memberId,resultCode,startTime,endTime);
    }




    

}
