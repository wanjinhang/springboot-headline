package com.wansui.controller;

import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author wansui
 * @date 2023/10/14
 */

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        System.out.println(user.getUsername());
        return userService.login(user);
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){

        return userService.getUserInfo(token);
    }

    /**
     * 检查用户名
     *
     * @param username 用户名
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @PostMapping("checkUserName")
    public Result checkUserName(String username){
        return userService.checkUser(username);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        return userService.regist(user);
    }

    /**
     * 检查登录
     *
     * @param token 令 牌
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/16
     */
    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){

        return userService.checkLogin(token);
    }
}
