package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈
 * 〈\〉
 *
 * @author
 * @create 2019/8/20
 */
@Controller
@RequestMapping("/test")
public class text {
    @RequestMapping("/helloWorld")
    @ResponseBody

    public String helloWorld() {

        return "Hello World";

}
}

