package com.otto.pojo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "发布头条实体类")
@Data
public class HeadlinePublishVo {
    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "文章内容")
    private String article;

    @Schema(description = "文章类别")
    private Integer type;
}
