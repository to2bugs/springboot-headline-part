package com.otto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.pojo.Headline;
import com.otto.pojo.vo.req.PortalNewsVo;
import com.otto.service.HeadlineService;
import com.otto.mapper.HeadlineMapper;
import com.otto.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author to2bagezero
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2025-09-25 14:06:27
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    /*
        分页查询首页头条信息
        1. 进行分页数据的查询
        2. 将分页数据拼接到result

        注意事项：
            1. 自定义语句和自定义mapper，并携带分页
            2. 返回的数据类型List<Map<String, Object>>
     */
    @Override
    public Result<Map<String, Object>> findNewsPage(PortalNewsVo portalNewsVo) {
        Integer currentPage = portalNewsVo.getPageNum();
        Integer size = portalNewsVo.getPageSize();

        IPage<Map<String, Object>> page = new Page<>(currentPage, size);
        headlineMapper.selectMyPage(page, portalNewsVo); // 查询后的数据都在page中

        // 封装数据
        HashMap<String, Object> dataMap = new HashMap<>();  // 最外层
        HashMap<String, Object> pageInfoMap = new HashMap<>(); // pageInfo对应的Map

        // 当前页面的数据集合
        List<Map<String, Object>> records = page.getRecords();
        pageInfoMap.put("pageData", records);
        dataMap.put("pageInfo", pageInfoMap);

        long pageNumber = page.getCurrent();
        dataMap.put("pageNum", pageNumber); // 当前页数

        long pageSize = page.getSize();
        dataMap.put("pageSize", pageSize); // 每一页的条数

        long totalPage = page.getPages();
        dataMap.put("totalPage", totalPage); // 总的页数

        long totalSize = page.getTotal();
        dataMap.put("totalSize", totalSize); // 总的数据的条数

        return Result.ok(dataMap);
    }
}




