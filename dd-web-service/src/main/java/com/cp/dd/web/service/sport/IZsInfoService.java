package com.cp.dd.web.service.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.sport.ZsInfoAreaCountVO;
import com.cp.dd.common.vo.sport.ZsInfoCountVO;
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

    void audit(List<Long> ids,Integer auditStatus);

    IPage<ZsInfo> getPage(PageQuery query,String name,String deptName,String code,String areaId,
                          String categoryType);

    IPage<ZsInfo> getAuditPage(PageQuery query,String name,String deptName,String code,
                          String categoryType,Integer auditStatus);

    List<ZsInfo> getAppList(String name,String deptName,String code);

    ZsInfoCountVO countInfo();

    ZsInfoAreaCountVO countArea();

}
