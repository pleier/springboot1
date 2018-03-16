package com.plei.springboot.mysql.entity;


import javax.persistence.*;

/**
 * @author : pleier
 * @date : 2018/3/15
 */
@Entity
@Table(name="deparment")
public class Deparment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
