package com.otto.service;

import com.otto.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.otto.pojo.vo.req.PortalNewsVo;
import com.otto.utils.Result;

import java.util.Map;

/**
* @author to2bagezero
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2025-09-25 14:06:27
*/
public interface HeadlineService extends IService<Headline> {

    /**
     * 分页查询首页头条信息
     * @param portalNewsVo
     * @return
     */
    Result<Map<String, Object>> findNewsPage(PortalNewsVo portalNewsVo);

    Result<Map<String, Object>> showHeadlineDetail(Integer hid);
}
