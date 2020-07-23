package com.cp.dd.web.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.constant.sys.SysDictCodeConstant;
import com.cp.dd.common.entity.sys.SysDict;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2019-09-30
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 获取字典列表
     *
     * @param code      字典码
     * @return 字典列表
     */
    List<SysDict> listByCode(String code);



    /**
     * 排序
     *
     * @param id       字典id
     * @param upOrDown 向上或向下
     */
    void sort(Long id, String upOrDown);

    /**
     * 删除
     *
     * @param id 字典
     */
    void delete(Long id);
}
