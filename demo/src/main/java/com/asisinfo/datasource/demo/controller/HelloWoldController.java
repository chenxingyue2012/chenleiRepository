package com.asisinfo.datasource.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWoldController {

    @RequestMapping(value = "/hello/v1")
    public String hello() {
        return "welcome";  //thymeleaf -> templates/index.html
    }

}
