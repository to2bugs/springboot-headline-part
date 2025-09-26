package com.otto.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName news_type 可以不用标注，因为已经在application.yml全局定义了表的前缀了
 * @TableId 必须标注
 */
@Schema(description = "首页类型")
@Data
public class Type implements Serializable {
    @Schema(description = "类型id")
    @TableId
    private Integer tid;

    @Schema(description = "类型的名字")
    private String tname;

    @Version
    private Integer version;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}