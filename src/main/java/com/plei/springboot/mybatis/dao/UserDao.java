package com.plei.springboot.mybatis.dao;

import com.plei.springboot.mysql.entity.User;

/**
 * @author : pleier
 * @date : 2018/3/21
 */
public interface UserDao {
    void save(User user);
}
