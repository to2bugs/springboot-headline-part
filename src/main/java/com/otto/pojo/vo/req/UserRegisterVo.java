package com.otto.pojo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "用户注册对象")
@Data
public class UserRegisterVo implements Serializable {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String userPwd;

    @Schema(description = "昵称")
    private String nickName;

    private static final long serialVersionUID = 1L;
}
