package com.wansui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.mapper.UserMapper;
import com.wansui.util.JwtHelper;
import com.wansui.util.MD5Util;
import com.wansui.util.Result;
import com.wansui.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2023-10-13 15:36:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * @description 用户登录
     * @param user
     * @return Result object
     */
    @Override
    public Result login(User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(wrapper);
//        判断用户是否为空
        if(loginUser ==null){
            return Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }

        if(StringUtils.isEmpty(user.getUserPwd())){
            return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }

        String encrypt = MD5Util.encrypt(user.getUserPwd());
        System.out.println(encrypt+"----"+user.getUserPwd());
        if(encrypt.equals(loginUser.getUserPwd())){
            String token =jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            HashMap<Object, Object> data = new HashMap<>();
            data.put("token", token);
            return Result.ok(data);
        }else{
            return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }

    }

    /**
     * @description 获取用户信息
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        if(jwtHelper.isExpiration(token)){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }

        int userId = jwtHelper.getUserId(token).intValue();

        User loginUser = userMapper.selectById(userId);

        if(loginUser != null){
            loginUser.setUserPwd("");
            HashMap<String,Object> data = new HashMap<>();
            data.put("loginUser", loginUser);
            return Result.ok(data);
        }else{
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }




    }
}




