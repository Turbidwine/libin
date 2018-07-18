package com.example.service;


import com.example.entity.Condition;

import java.util.List;

public interface RedisService {

    public List<String> getResultByCondition(List<Condition> conditionList);

}
