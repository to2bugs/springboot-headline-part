package com.otto.controller;

import com.otto.pojo.vo.resp.TypeVo;
import com.otto.service.TypeService;
import com.otto.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "首页管理")
@CrossOrigin
@RestController
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private TypeService typeService;

    /**
     * 查询首页分类
     * @return
     */
    @Operation(summary = "查询首页分类")
    @GetMapping("/findAllTypes")
    public Result findAllTypes() {
        Result<List<TypeVo>> result = typeService.findAllTypes();
        return result;
    }
}
