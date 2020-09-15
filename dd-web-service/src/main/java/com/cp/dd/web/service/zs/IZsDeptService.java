package com.cp.dd.web.service.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.zs.ZsDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import com.cp.dd.web.form.zs.ZsDeptForm;

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

    void update(ZsDeptForm zsDeptForm);

    IPage<ZsDeptVO> getPage(PageQuery query, Long categoryId, String status);

}
