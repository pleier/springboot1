package com.plei.springboot.mysql.repository;

import com.plei.springboot.mysql.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : pleier
 * @date : 2018/3/15
 */
public interface DeparmentRepository extends JpaRepository<Deparment,Long> {
}
