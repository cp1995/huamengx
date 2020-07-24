package com.cp.dd.web.service.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.web.form.sport.ZsInfoForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
public interface IZsInfoService extends IService<ZsInfo> {

    void save (ZsInfoForm zsInfoForm);

    void update (ZsInfoForm zsInfoForm);

    void del(List<Long> ids);

    IPage<ZsInfo> getPage(PageQuery query,String name,String code,String address,String areaCode,
                          String categoryType,String mobile);


}
