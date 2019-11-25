package com.ldy.common.config.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

public class CustomCache<T> {
    private String cacheName;
    private StringRedisTemplate stringRedisTemplate;
    private T t;

    public CustomCache(String cacheName, T value, StringRedisTemplate stringRedisTemplate) {
        this.cacheName = cacheName;
        this.stringRedisTemplate = stringRedisTemplate;
        this.t = value;
    }

    public void setValue (String key, T value, long expiredTime) {


    }



}
