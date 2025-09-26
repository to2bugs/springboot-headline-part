package com.otto.pojo.vo.resp;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "用户信息")
@Data
public class UserInfoVo implements Serializable {
    @Schema(description = "用户id，主键")
    @TableId
    private Integer uid;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "用户昵称")
    private String nickName;

    private static final long serialVersionUID = 1L;
}
