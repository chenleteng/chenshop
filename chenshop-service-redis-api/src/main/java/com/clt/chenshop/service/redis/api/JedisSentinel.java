package com.clt.chenshop.service.redis.api;

public interface JedisSentinel {
    public Object get(String key);
    public void set(String key, Object value);
}
