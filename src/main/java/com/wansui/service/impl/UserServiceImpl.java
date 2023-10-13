package com.wansui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.User;
import com.wansui.service.UserService;
import com.wansui.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2023-10-13 15:36:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




