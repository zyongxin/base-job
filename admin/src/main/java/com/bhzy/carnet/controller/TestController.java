package com.bhzy.carnet.controller;

import com.bhzy.carnet.core.annotation.Auth;
import com.bhzy.carnet.resutl.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "广告图控制器Api", description = "广告图控制器api，包括提供基础的增删改查")
@RestController
@RequestMapping("admin/ads")
public class TestController {

    @Auth
    @ApiOperation(value = "测试权限", notes = "")
    @GetMapping("/testAuth")
    public Message testAuth(){
        return Message.success();
    }

    @GetMapping("/test")
    public Message test(){
        return Message.success();
    }
}
