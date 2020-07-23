package com.cp.dd.common.constant.cache;

/**
 * 缓存 键 常量/前缀
 * <p>
 * 注意，可以是用 spel 表达式，
 *
 * @author chengp
 * @date 2020/4/13
 */
public interface CacheKey {

    /**
     * 积分等级
     */
    String INTEGRAL_LEVEL = "'integral_level'";

    /**
     * 积分项 前缀
     */
    String INTEGRAL_ITEMS_PREFIX = "'integral_items:' + ";

    /**
     * 区域列表
     */
    String SYS_REGION_LIST = "'sys_region_list'";

    /**
     * 积分项 前缀
     */
    String DEPT_NAME_PREFIX = "'dept_name:' + ";

    /**
     * 字典 前缀
     */
    String SYS_DICT_MAP_PREFIX = "'sys_dict_map:' +";

    /**
     * 区域 前缀
     */
    String SYS_AREA_PREFIX = "'sys_area:' +";

    /**
     * 区域 前缀
     */
    String SYS_AREA_LIST = "'sys_area_list'";

    /**
     * 大数据缓存 前缀
     */
    String BS_PREFIX = "'bs:' +";

}
