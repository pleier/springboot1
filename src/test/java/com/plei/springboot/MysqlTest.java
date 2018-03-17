package com.plei.springboot;

import com.plei.springboot.mysql.entity.Deparment;
import com.plei.springboot.mysql.entity.Role;
import com.plei.springboot.mysql.entity.User;
import com.plei.springboot.mysql.repository.DeparmentRepository;
import com.plei.springboot.mysql.repository.RoleRepository;
import com.plei.springboot.mysql.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeparmentRepository deparmentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        deparmentRepository.deleteAll();
        roleRepository.deleteAll();

        Deparment deparment = new Deparment();
        deparment.setName("开发部");

        deparmentRepository.save(deparment);

        Assert.assertNotNull(deparment.getId());

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepository.findAll();
        Assert.assertNotNull(roles);
        user.setRoles(roles);
        userRepository.save(user);
        Assert.assertNotNull(user.getId());

    }

    @Test
    public void fadePage() {
        try {
            Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
            Page<User> page = userRepository.findAll(pageable);
            Assert.assertNotNull(page);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
