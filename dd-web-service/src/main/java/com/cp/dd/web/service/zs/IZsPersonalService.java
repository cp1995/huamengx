package com.cp.dd.web.service.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import com.cp.dd.web.form.zs.ZsPersonalForm;

import java.util.List;

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

    IPage<ZsPersonalVO> getPage(PageQuery query, String name, Integer status);

    void update(ZsPersonalForm zsPersonalForm);

    void del(List<Long> ids);

    void audit(List<Long> ids,Integer auditStatus);

    ZsPersonalVO detail(Long id);


}
