package com.cp.dd.web.service.sport;

import com.cp.dd.common.entity.sport.ZsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
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


}
