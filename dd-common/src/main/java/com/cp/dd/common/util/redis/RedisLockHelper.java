package com.cp.dd.common.util.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.UUID;

/**
 * redis 实现分布式锁
 *
 * @author chengp
 * @date 2020/4/1
 */
public class RedisLockHelper {

    /**
     * 默认加锁过期时间
     */
    private static final long LOCK_EXPIRE = 5 * 60 * 1000;

    private RedisTemplate<String, Object> redisTemplate;

    public RedisLockHelper(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 分布式锁
     *
     * @param key key值
     * @return 是否获取到
     */
    public boolean lock(String key) {
        return lock(key, LOCK_EXPIRE);
    }

    /**
     * 分布式锁
     *
     * @param key    key值
     * @param expire 过期时间（毫秒）
     * @return 是否获取到
     */
    public boolean lock(String key, long expire) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            String uuid = UUID.randomUUID().toString();
            String result = commands.set(key, uuid, "NX", "PX", expire);
            return StringUtils.isNotEmpty(result);
        });
    }

    /**
     * 删除锁
     *
     * @param key key值
     */
    public void unLock(String key) {
        redisTemplate.delete(key);
    }

}