package com.cp.dd.web.service.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.zs.ZsDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import com.cp.dd.web.form.zs.ZsDeptForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
public interface IZsDeptService extends IService<ZsDept> {

    void save(ZsDeptForm zsDeptForm);

    void wechatSave(ZsDeptForm zsDeptForm);

    void update(ZsDeptForm zsDeptForm);

    void wechatUpdate(ZsDeptForm zsDeptForm);

    ZsDeptVO detail(Long id);

    IPage<ZsDeptVO> getPage(PageQuery query, Long categoryId, String status,String areaCode);

    IPage<ZsDeptVO> auditPage(PageQuery query, Long categoryId, String status,Integer auditStatus,String areaCode);

    void audit(List<Long> ids, Integer auditStatus);

    void del(List<Long> ids);

}
