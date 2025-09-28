package com.otto.controller;

import com.otto.pojo.Headline;
import com.otto.pojo.vo.req.HeadlinePublishVo;
import com.otto.pojo.vo.resp.HeadlineVo;
import com.otto.service.HeadlineService;
import com.otto.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "头条消息管理")
@CrossOrigin
@RestController
@RequestMapping("/headline")
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;

    /**
     * 发布头条消息
     */
    @Operation(summary = "发布头条消息")
    @PostMapping("/publish")
    public Result publishHeadline(
            @RequestBody HeadlinePublishVo headlinePublishVo,
            @RequestHeader("token") String token
    ) {
        Result restul = headlineService.publishHeadline(headlinePublishVo, token);
        return restul;
    }


    /**
     * 根据id回显头条数据
     * @return
     */
    @Operation(summary = "根据id回显头条数据")
    @PostMapping("/findHeadlineByHid")
    public Result<Map<String, Object>> findHeadlineByHid(@RequestParam("hid") Integer hid) {
        Result<Map<String, Object>> result = headlineService.findHeadlineByHid(hid);
        return result;
    }


    /**
     * 修改头条数据
     * @param headlineVo
     * @return
     */
    @Operation(summary = "修改头条数据")
    @PostMapping("/update")
    public Result updateHeadline(@RequestBody HeadlineVo headlineVo) {
        Result result = headlineService.updateHeadline(headlineVo);
        return result;
    }


    /**
     * 根据id移除头条
     * 逻辑删除
     */
    @Operation(summary = "根据id移除头条")
    @PostMapping("/removeByHid")
    public Result removeByHid(@RequestParam("hid") Integer hid) {
        headlineService.removeById(hid);
        return Result.ok(null);
    }

}
