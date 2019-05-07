package com.xbc.flower.xbcflowerboot.controller;

import com.xbc.flower.xbcflowerboot.dto.ApiResult;
import com.xbc.flower.xbcflowerboot.entity.User;
import com.xbc.flower.xbcflowerboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author weizeng
 * @date 2019/4/30 16:36
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findAll")
    public ApiResult<List<User>> findAll() {
        List<User> userList = userService.findAll();
        return new ApiResult<>(userList);
    }
}
