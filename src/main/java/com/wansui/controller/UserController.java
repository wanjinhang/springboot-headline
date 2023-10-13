package com.wansui.controller;

import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wansui
 * @date 2023/10/13
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        System.out.println(user.getUsername());
        Result result =userService.login(user);
        return  result;
    }
}
