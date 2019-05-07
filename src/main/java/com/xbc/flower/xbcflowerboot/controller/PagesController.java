package com.xbc.flower.xbcflowerboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：
 *
 * @author weizeng
 * @date 2019/5/5 16:56
 */
@Controller
@RequestMapping("/home")
public class PagesController {

    @RequestMapping("/userList")
    public String homePage() {
        return "userList";
    }
}
