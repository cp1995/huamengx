package com.cp.dd.web.controller.member;

import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.sys.CaptchaUtil;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.member.MemberForm;
import com.cp.dd.web.form.member.MemberLoginForm;
import com.cp.dd.web.service.member.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * 登录接口
 *
 * @author chengp
 * @date 2019-09-23
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/member")
@Api(value = "/member", tags = "登录接口")
public class LoginController {

    private IMemberService memberService;

/*
    @IgnoreLogin
    @GetMapping("/captcha")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void captcha(@RequestParam @NotBlank(message = "标识不能为空") @ApiParam(value = "唯一标识", required = true) String sign,
                        HttpServletResponse response) {
        //获取图片验证码
        CaptchaUtil.outCaptcha(sign, response);
    }
*/

    @IgnoreLogin
    @AddOperLog(name = "登录")
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "通过账号密码登录")
    public Result<MemberVO> login(@Valid MemberLoginForm memberLoginForm) {
        MemberVO memberVO = memberService.login(memberLoginForm);
        return Result.success(memberVO);
    }

    @AddOperLog(name = "新增用户")
    @PostMapping("/save")
    @ApiOperation(value = "新增用户", notes = "通过账号密码登录")
    public Result save(@Valid MemberForm memberForm) {
        memberService.save(memberForm);
        return Result.success("新增用户成功");
    }

    @AddOperLog(name = "修改资料")
    @PostMapping("/update")
    @ApiOperation(value = "修改资料", notes = "通过账号密码登录")
    public Result update(@Valid MemberForm memberForm) {
        memberService.update(memberForm);
        return Result.success("修改资料成功");
    }
    @AddOperLog(name = "删除用户")
    @GetMapping("/delete")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public Result delete(@RequestParam @ApiParam(value = "name", required = true) Long id) {
        memberService.delete(id);
        return Result.success();
    }

    @AddOperLog(name = "修改密码")
    @GetMapping("/updatePassWord")
    @ApiOperation(value = "修改密码", notes = "通过账号密码登录")
    public Result updatePassWord(@RequestParam @ApiParam(value = "id", required = true) Long id,
                         @RequestParam  @ApiParam(value = "password", required = true) String password) {
        memberService.updatePassWord(id,password);
        return Result.success("修改密码成功");
    }

    @GetMapping("/getPage")
    @ApiOperation(value = "用户分页列表", notes = "用户分页列表")
    public Result<PageModel<MemberVO>> getPage(@Valid PageQuery pageQuery,
                                           @RequestParam ( required =false) @ApiParam(value = "name", required = false) String name) {

        return Result.success(memberService.getPage(pageQuery,name));
    }

    @AddOperLog(name = "用户导出")
    @GetMapping("/export")
    @ApiOperation(value = "用户导出", notes = "用户导出")
    public void export( HttpServletResponse response, HttpServletRequest request,
                        @RequestParam ( required =false) @ApiParam(value = "name", required = false) String name)  {
        memberService.export(name,response,request);
    }

    

}
