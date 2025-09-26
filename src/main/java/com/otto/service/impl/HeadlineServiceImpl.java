package com.otto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.pojo.Headline;
import com.otto.service.HeadlineService;
import com.otto.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author to2bagezero
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2025-09-25 14:06:27
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




