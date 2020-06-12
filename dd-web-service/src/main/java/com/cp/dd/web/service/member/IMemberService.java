package com.cp.dd.web.service.member;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.form.member.MemberForm;
import com.cp.dd.web.form.member.MemberLoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
public interface IMemberService extends IService<Member> {

    /**
     * 账号密码登录
     *
     * @param memberForm 登录信息
     * @return MemberVO
     */
    MemberVO login(MemberLoginForm memberForm);


    void save(MemberForm memberForm);

    void update(MemberForm memberForm);

    void delete(Long id);

    void updatePassWord(Long id,String password);

    IPage getPage(PageQuery pageQuery, String name);

    void  export(String name, HttpServletResponse response, HttpServletRequest request);


}


