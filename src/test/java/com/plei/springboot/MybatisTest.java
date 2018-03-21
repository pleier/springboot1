package com.plei.springboot;

import com.plei.springboot.mybatis.dao.UserDao;
import com.plei.springboot.mysql.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author : pleier
 * @date : 2018/3/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void save(){
        User user = new User();
        user.setCreateDate(new Date());
        user.setName("hehe");
        userDao.save(user);
    }
}
