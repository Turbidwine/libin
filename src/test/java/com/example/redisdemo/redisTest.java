package com.example.redisdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.mapper.TagMapper;
import com.example.service.RedisService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void testSet(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        redisTemplate.opsForValue().set("1",list);
    }

    @Test
    public void testGet(){
        System.out.println(redisTemplate.opsForValue().get("1"));
    }

    @Test
    public void testSw(){
        //redisService.testTransactional("1","3");
        //redisTemplate.opsForValue().set("1","2");
        System.out.println(redisTemplate.opsForValue().get("1"));
    }

    @Test
    public void selectTagValueGroupBy(){
        List<String> list  = tagMapper.selectTagValueGroupBy("RegisterBrand");
        HashOperations<String,String,List<String>> hashOperations = redisTemplate.opsForHash();
        for (String s : list) {
            if(s!=null)
                hashOperations.put("RegisterBrand",s,tagMapper.selectIdByTagValue("RegisterBrand",s));
        }
    }

    @Test
    public void Test(){
        //Age=28        RegisterBrand=Gap
        long start = new Date().getTime();
        HashOperations<String,String,List<String>> hashOperations = redisTemplate.opsForHash();
        List<String> age =  hashOperations.get("Age","28");
        List<String> registerBrand =  hashOperations.get("RegisterBrand","Gap");
        List<String> a = (List<String>)CollectionUtils.intersection(age, registerBrand);
        System.out.println(age.size()+"------"+registerBrand.size()+"-----"+a.size());
        long end = new Date().getTime();
        System.out.println("------------------"+(end-start)/1000);
    }
}
