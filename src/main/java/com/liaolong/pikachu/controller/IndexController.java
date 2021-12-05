package com.liaolong.pikachu.controller;

import com.liaolong.pikachu.exceptions.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiaoLong
 * @date 2021-12-05 13:29
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @GetMapping("/a")
    public String a() throws NotFoundException {
        System.out.println("进入a()方法了...");

        System.out.println("即将返回值了...");
        return "index";
    }
    @GetMapping("/b")
    public String b() throws NotFoundException {
        System.out.println("进入a()方法了...");

        System.out.println("即将返回值了...");
        return "blog";
    }
    @GetMapping("/c")
    public String c() throws NotFoundException {
        System.out.println("进入a()方法了...");

        System.out.println("即将返回值了...");
        return "blog";
    }
    @GetMapping("/d")
    public String d() throws NotFoundException {
        System.out.println("进入a()方法了...");

        System.out.println("即将返回值了...");
        return "blog";
    }
    @GetMapping("/e")
    public String e() throws NotFoundException {
        System.out.println("进入a()方法了...");

        System.out.println("即将返回值了...");
        return "blog";
    }
}
