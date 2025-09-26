package com.otto.pojo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "首页头条信息查询对象")
@Data
public class PortalNewsVo implements Serializable {
    @Schema(description = "搜索标题关键字", required = false)
    private String keyWords;

    @Schema(description = "新闻的类型：1新闻 2体育 3娱乐 4科技 5其他", required =false)
    private Integer type;

    @Schema(description = "当前页数")
    private Integer pageNum = 1;

    @Schema(description = "每页数据条数")
    private Integer pageSize = 10;

    private static final long serialVersionUID = 1L;
}
