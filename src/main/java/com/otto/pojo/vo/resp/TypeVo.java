package com.otto.pojo.vo.resp;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "首页类型")
@Data
public class TypeVo implements Serializable {
    @Schema(description = "类型id")
    @TableId
    private Integer tid;

    @Schema(description = "类型的名字")
    private String tname;

    private static final long serialVersionUID = 1L;
}
