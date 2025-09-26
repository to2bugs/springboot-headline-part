package com.otto;

import com.otto.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    public void test() {
        // 生成
        String token = jwtHelper.createToken(1L);
        System.out.println("token = " + token);

        // 解析
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);

        // 检测有效期: false是未到期，true是到期
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + (!expiration ? "有效" : "无效"));
    }
}
