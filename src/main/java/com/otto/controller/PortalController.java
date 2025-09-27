package com.otto.controller;

import com.otto.pojo.vo.req.PortalNewsVo;
import com.otto.pojo.vo.resp.TypeVo;
import com.otto.service.HeadlineService;
import com.otto.service.TypeService;
import com.otto.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "首页管理")
@CrossOrigin
@RestController
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;

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


    /**
     * 分页查询首页头条信息
     */
    @Operation(summary = "分页查询首页头条信息")
    @PostMapping("/findNewsPage")
    public Result<Map<String, Object>> findNewsPage(@RequestBody PortalNewsVo portalNewsVo) {
        Result<Map<String, Object>>  result = headlineService.findNewsPage(portalNewsVo);
        return result;
    }


    /**
     * 查询头条详情
     */
    @Operation(summary = "查询头条详情")
    @PostMapping("/showHeadlineDetail")
    public Result<Map<String, Object>> showHeadlineDetail(@RequestParam("hid") Integer hid) {
        Result<Map<String, Object>> result = headlineService.showHeadlineDetail(hid);
        return result;
    }
}
