package com.wansui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.mapper.UserMapper;
import com.wansui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Result login(User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> eq = wrapper.eq(User::getUsername, user.getUsername());
        User user1 = userMapper.selectOne(eq);


        return null;
    }

}




