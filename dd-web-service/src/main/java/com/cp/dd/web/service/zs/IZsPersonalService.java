package com.cp.dd.web.service.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.web.form.zs.ZsPersonalForm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
public interface IZsPersonalService extends IService<ZsPersonal> {

    void save(ZsPersonalForm zsPersonalForm);

    void update(ZsPersonalForm zsPersonalForm);



}
