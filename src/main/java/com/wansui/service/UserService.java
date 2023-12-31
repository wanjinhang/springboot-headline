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



    /**
     * 获取用户信息
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 用户登录
     * @param user
     * @return
     */

    Result login(User user) ;

    /**
     * 检查用户名
     * @param username
     * @return
     */
    Result checkUser(String username);

    /**
     * 雷吉斯特
     *
     * @param user 用户
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/16
     */
    Result regist(User user);

    /**
     * 检查登录
     *
     * @param token 令牌
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/16
     */
    Result checkLogin(String token);
}
