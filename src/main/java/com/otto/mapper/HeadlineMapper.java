package com.otto.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.otto.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.otto.pojo.vo.req.PortalNewsVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author to2bagezero
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2025-09-25 14:06:27
* @Entity com.otto.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    /**
     * 注意这个写法，返回值是IPage<T>
     *     获取到的数据在参数page中
     * @param page
     * @param portalNewsVo
     * @return
     */
    IPage<Map<String, Object>> selectMyPage(
            IPage<Map<String, Object>> page,
            @Param("portalNewsVo") PortalNewsVo portalNewsVo);


    /**
     * 查询头条详情
     * @param hid
     * @return
     */
    Map<String, Object> selectHeadlineDetail(@Param("hid") Integer hid);
}




