package com.wansui.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wansui.util.JwtHelper;
import com.wansui.util.Result;
import com.wansui.util.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录保护拦截器
 *
 * @author wansui
 * @date 2023/10/16
 * @see HandlerInterceptor
 */

@Component
public class LoginProtectInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        boolean expiration = jwtHelper.isExpiration(token);
        if (!expiration) {
            return true;
        }

        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        String json = new ObjectMapper().writeValueAsString(result);
        response.getWriter().print(json);
        return false;

    }
}
