package com.otto.service;

import com.otto.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.otto.pojo.vo.resp.TypeVo;
import com.otto.utils.Result;

import java.util.List;

/**
* @author to2bagezero
* @description 针对表【news_type】的数据库操作Service
* @createDate 2025-09-25 14:06:27
*/
public interface TypeService extends IService<Type> {

    /**
     * 查询首页分类数据
     * @return
     */
    Result<List<TypeVo>> findAllTypes();
}
