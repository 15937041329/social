package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈
 * 〈〉
 *
 * @author
 * @create 2019/8/20
 */



@RestController
public class SpringBootTest {

    @RequestMapping("/hello")
    public String helloSpringBoot() {
        return "Hello SpringBoot Project.";
    }
}


