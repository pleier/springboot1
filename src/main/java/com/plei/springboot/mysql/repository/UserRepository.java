package com.plei.springboot.mysql.repository;

import com.plei.springboot.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : pleier
 * @date : 2018/3/15
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
