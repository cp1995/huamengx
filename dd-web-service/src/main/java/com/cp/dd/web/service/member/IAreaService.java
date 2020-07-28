package com.cp.dd.web.service.member;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.member.AreaVO;

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

    IPage<AreaVO> getPage(PageQuery pageQuery, String name);


}


