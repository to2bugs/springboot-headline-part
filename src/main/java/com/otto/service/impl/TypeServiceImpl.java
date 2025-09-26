package com.otto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.pojo.Type;
import com.otto.pojo.vo.resp.TypeVo;
import com.otto.service.TypeService;
import com.otto.mapper.TypeMapper;
import com.otto.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author to2bagezero
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2025-09-25 14:06:27
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result<List<TypeVo>> findAllTypes() {
        List<Type> types = typeMapper.selectList(null);
        List<TypeVo> typeVos = new ArrayList<>();

        types.forEach(type -> {
            TypeVo typeVo = new TypeVo();
            BeanUtils.copyProperties(type, typeVo);
            typeVos.add(typeVo);
        });


        return Result.ok(typeVos);
    }
}




