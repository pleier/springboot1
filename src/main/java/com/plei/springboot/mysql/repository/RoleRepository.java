package com.plei.springboot.mysql.repository;

import com.plei.springboot.mysql.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : pleier
 * @date : 2018/3/15
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
}
