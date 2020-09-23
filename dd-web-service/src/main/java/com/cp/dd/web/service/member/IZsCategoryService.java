package com.cp.dd.web.service.member;

import com.cp.dd.common.entity.member.ZsCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.vo.zs.ZsCategoryVO;
import com.cp.dd.web.form.member.ZsCategoryForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
public interface IZsCategoryService extends IService<ZsCategory> {

    void save(ZsCategoryForm zsCategoryForm);

    void update(ZsCategoryForm zsCategoryForm);

    void del(List<Long> ids);

    ZsCategoryVO getId(Long id);

}
