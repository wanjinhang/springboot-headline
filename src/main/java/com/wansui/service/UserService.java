package com.wansui.service;

import com.wansui.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wansui.util.Result;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-10-13 15:36:58
*/
public interface UserService extends IService<User> {

    public Result login(User user) ;
}
