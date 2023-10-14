package com.wansui.controller;

import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wansui
 * @date 2023/10/13
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        System.out.println(user.getUsername());
        Result result =userService.login(user);
        return  result;
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);

        return result;
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username){
       Result result =userService.checkUser(username);
       return result;
    }
}
