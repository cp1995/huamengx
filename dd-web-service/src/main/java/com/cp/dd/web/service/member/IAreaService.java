package com.cp.dd.web.service.member;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.form.member.MemberForm;
import com.cp.dd.web.form.member.MemberLoginForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
public interface IAreaService extends IService<Area> {

    List<Area> findList();

    void delete(Long id);

    void save(String name,String areaCode,String type);

    IPage getPage(PageQuery pageQuery, String name);


}


