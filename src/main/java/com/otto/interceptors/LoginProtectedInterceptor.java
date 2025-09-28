package com.otto.interceptors;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.otto.utils.JwtHelper;
import com.otto.utils.Result;
import com.otto.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登陆保护拦截器
 *  检查请求头中是否包含有效的token
 *  有效，放行
 *  无效，返回504
 */
@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null || jwtHelper.isExpiration(token)) {
            Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
            // 使用jackson提供的ObjectMapper类，将Java对象转换为Json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String resultStr = objectMapper.writeValueAsString(result);
            // 写回给客户端
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print(resultStr);
            // 拦截
            return false;
        }
        // 放行
        return true;
    }
}
