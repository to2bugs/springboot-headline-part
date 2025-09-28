package com.otto.controller;

import com.otto.pojo.User;
import com.otto.pojo.vo.req.UserRegisterVo;
import com.otto.service.UserService;
import com.otto.utils.JwtHelper;
import com.otto.utils.Result;
import com.otto.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @Operation(summary = "用户登陆")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println("user = " + user);
        Result result = userService.login(user);
        return result;
    }


    /**
     * 根据token获取用户数据
     */
    @Operation(summary = "根据token获取用户数据")
    @GetMapping("/getUserInfo")
    public Result<Map<String, Object>> getUserInfo(@RequestHeader("token") String token) {
        Result<Map<String, Object>> result = userService.getUserInfo(token);
        return result;
    }

    /**
     * 判断注册的用户名是否可以使用
     */
    @Operation(summary = "判断注册的用户名是否可以使用")
    @PostMapping("/checkUserName")
    public Result checkUserName(
            @Parameter(name = "username", description = "注册的用户名", required = true) @RequestParam("username") String username
    ) {
        Result result = userService.checkUserName(username);
        return result;
    }


    /**
     * 用户注册
     */
    @Operation(summary = "用户注册")
    @PostMapping("/regist")
    public Result regist(@RequestBody UserRegisterVo userRegisterVo) {
        Result result = userService.regist(userRegisterVo);
        return result;
    }


    /**
     * 检查携带的token是否有效
     */
    @Operation(summary = "检查携带的token是否有效")
    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestHeader("token") String token) {
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(null);
    }

}
