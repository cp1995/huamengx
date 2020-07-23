package com.cp.dd.common.constant.cache;

/**
 * 缓存管理器名称
 *
 * @author chengp
 * @date 2020/4/13
 */
public interface CacheName {

    /**
     * 不过期、一分钟、十分钟、半小时、一小时、一天、一周、一月
     */
    String NEVER_EXPIRE = "neverExpire";
    String ONE_MINUTE = "oneMinute";
    String TEN_MINUTE = "tenMinute";
    String HALF_HOUR = "halfHour";
    String ONE_HOUR = "oneHour";
    String ONE_DAY = "oneDay";
    String ONE_WEEK = "oneWeek";
    String ONE_MONTH = "oneMonth";
}
