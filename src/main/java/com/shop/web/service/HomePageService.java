package com.shop.web.service;

import com.shop.web.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomePageService {

    public BaseResponse queryList(String module) {
        int pages = 10;
        return new BaseResponse(pages);
    }
}
