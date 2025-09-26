package com.otto.service;

import com.otto.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.otto.pojo.vo.req.UserRegisterVo;
import com.otto.utils.Result;

import java.util.Map;

/**
* @author to2bagezero
* @description 针对表【news_user】的数据库操作Service
* @createDate 2025-09-25 14:06:27
*/
public interface UserService extends IService<User> {

    /**
     * 登陆
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    Result<Map<String, Object>> getUserInfo(String token);


    /**
     * 判断注册的用户名是否可以使用
     * @param username
     * @return
     */
    Result checkUserName(String username);


    /**
     * 用户注册
     * @param userRegisterVo
     * @return
     */
    Result regist(UserRegisterVo userRegisterVo);
}
