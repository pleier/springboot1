package com.plei.springboot.redis;

import com.alibaba.fastjson.JSON;
import com.plei.springboot.mysql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void add(String key, Long time, User user){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(user),time, TimeUnit.MINUTES);
    }

    public void add(String key, Long time, List<User> users){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(users),time, TimeUnit.MINUTES);
    }

    public User get(String key){
        User user = null;
        String json = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(json)){
            user = JSON.parseObject(json,User.class);
        }
        return user;
    }

    public List<User> getList(String key){
        List<User> users = null;
        String json = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(json)){
            users = JSON.parseArray(json,User.class);
        }
        return users;
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
