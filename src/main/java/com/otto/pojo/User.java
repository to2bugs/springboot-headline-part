package com.otto.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName news_user 可以不用标注，因为已经在application.yml全局定义了表的前缀了
 * @TableId 必须标注
 */
@Schema(description = "用户")
@Data
public class User implements Serializable {
    @Schema(description = "用户id，主键")
    @TableId
    private Integer uid;

    @Schema(description = "用户名", required = true)
    private String username;

    @Schema(description = "用户密码", required = true)
    private String userPwd;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "乐观锁-版本号")
    @Version
    private Integer version;

    @Schema(description = "逻辑删除：1表示删除，0表示未删除")
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}