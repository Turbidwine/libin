package com.example.service.Impl;

import com.example.entity.Condition;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public List<String> getResultByCondition(List<Condition> conditionList) {

        for (int i = 0; i < conditionList.size(); i++) {

        }
        return null;
    }
}
