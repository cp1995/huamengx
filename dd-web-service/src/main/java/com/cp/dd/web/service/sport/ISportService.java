package com.cp.dd.web.service.sport;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.web.form.member.sport.SportForm;

import java.util.List;


/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
public interface ISportService extends IService<Sport> {

    void save(SportForm sportForm);

    void delete(Long id);

    void saveIds(Long id,String ids);

    List<Sport> getList();

    List<Sport> getWechatList();

    IPage getPage(PageQuery pageQuery, String name);

}


