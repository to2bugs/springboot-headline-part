package com.otto.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "头条数据回显的实体类")
@Data
public class HeadlineVo implements Serializable {
    @Schema(description = "头条的id")
    private Integer hid;

    @Schema(description = "头条的标题")
    private String title;

    @Schema(description = "头条的正文")
    private String article;

    @Schema(description = "头条的类型")
    private Integer type;

    private static final long serialVersionUID = 1L;
}
