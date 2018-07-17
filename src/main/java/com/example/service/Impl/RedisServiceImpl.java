package com.example.service.Impl;

import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    @Transactional
    public void testTransactional(String key,String value) {
        redisTemplate.opsForValue().set(key,value);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
