package com.cp.dd.web.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sys.QyArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;

/**
 * <p>
 * 区域设置 服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-16
 */
public interface IQyAreaService extends IService<QyArea> {

    void save(String name,String province);

    IPage<QyArea> getPage(PageQuery query);



}
