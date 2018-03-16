package com.plei.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : pleier
 * @date : 2018/3/15
 */
@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String hello(){
        return "hello springBoot";
    }
}
