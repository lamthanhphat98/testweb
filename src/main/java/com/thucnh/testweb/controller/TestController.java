package com.thucnh.testweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String returnString() {
        return "index.html";
    }

    @GetMapping("/test2")
    public String returnString2() {
        return "index2.html";
    }
}
