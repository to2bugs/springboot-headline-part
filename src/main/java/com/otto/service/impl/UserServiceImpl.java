package com.otto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.pojo.User;
import com.otto.pojo.vo.req.UserRegisterVo;
import com.otto.pojo.vo.resp.UserInfoVo;
import com.otto.service.UserService;
import com.otto.mapper.UserMapper;
import com.otto.utils.JwtHelper;
import com.otto.utils.MD5Util;
import com.otto.utils.Result;
import com.otto.utils.ResultCodeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author to2bagezero
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2025-09-25 14:06:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 登陆
     * 1. 根据参数，查询用户
     * 2. 查询结果为null，账号错误501
     * 3. 密码对比，返回错误503
     * 4. 根据用户id，生成token，并返回
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(wrapper);

        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        if (!StringUtils.hasText(user.getUserPwd()) || !MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())) {
            return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }

        // 根据用户id，生成token
        String token = jwtHelper.createToken(loginUser.getUid().longValue());

        Map data = new HashMap();
        data.put("token", token);
        // System.out.println("data:"+data);

        return Result.ok(data);
    }

    /*
        根据token获取用户信息
        1. 校验token是否在有效期
        2. 通过token解析出userId
        3. 根据id查询用户信息
        4. 去掉密码，返回用户信息
     */
    @Override
    public Result<Map<String, Object> > getUserInfo(String token) {
        // 校验token是否在有效期
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            // 过期
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        // 解析出userId
        Long userId = jwtHelper.getUserId(token);

        // 根据id查询用户信息
        User user = userMapper.selectById(userId);
        if(user == null){
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        UserInfoVo userInfo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfo);

        Map<String, Object> map = new HashMap<>();
        map.put("loginUser", userInfo);

        return Result.ok(map);
    }

    /**
     * 判断注册的用户名是否可以使用
     * @param username
     * @return
     */
    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);

        User user = userMapper.selectOne(wrapper);
        if (user == null){
            return Result.ok(null);
        }
        return Result.build(null, ResultCodeEnum.USERNAME_USED);
    }


    /**
     * 用户注册
     * @param userRegisterVo
     * @return
     */
    @Override
    public Result regist(UserRegisterVo userRegisterVo) {
        // 判断用户名是否已经注册过了
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, userRegisterVo.getUsername());
        Long cnt = userMapper.selectCount(wrapper);
        if(cnt > 0){
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        String userPwdMD5 = MD5Util.encrypt(userRegisterVo.getUserPwd());
        userRegisterVo.setUserPwd(userPwdMD5);

        User user = new User();
        BeanUtils.copyProperties(userRegisterVo, user);
        userMapper.insert(user);

        return Result.ok(null);
    }
}




