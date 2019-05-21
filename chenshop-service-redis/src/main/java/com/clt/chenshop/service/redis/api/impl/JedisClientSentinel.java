package com.clt.chenshop.service.redis.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.service.redis.api.JedisSentinel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-24 15:29
 **/

@Service(version = DubboVersionConstant.DUBBO_JEDIS_CLIENT_SENTINEL_VERSION)
public class JedisClientSentinel implements JedisSentinel {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }
}
