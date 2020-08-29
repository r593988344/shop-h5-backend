package com.shop.web.controller;

import com.shop.web.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shop.web.dto.BaseResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    @GetMapping("page")
    public BaseResponse getHomePage(@RequestParam(value = "module",required = false) String module) {
        return homePageService.queryList(module);
    }
}
