package com.plei.springboot;

import com.plei.springboot.mysql.entity.Deparment;
import com.plei.springboot.mysql.entity.Role;
import com.plei.springboot.mysql.entity.User;
import com.plei.springboot.redis.UserRedis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest{

    @Autowired
    UserRedis userRedis;

    @Before
    public void setup(){
        Deparment deparment = new Deparment();
        deparment.setName("开发不");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        userRedis.delete(this.getClass().getName()+":userByname:"+user.getName());

        userRedis.add(this.getClass().getName()+":userByname:"+user.getName(),10L,user);
    }

    @Test
    public void get(){
        User  user = userRedis.get(this.getClass().getName()+":userByname:user");
        Assert.assertNotNull(user);
        System.out.print(user);
    }
}
