package com.wugui.datax.admin.http.sample.controller;

import com.wugui.datax.admin.http.api.DataxAdminHttpApi;
import com.wugui.datax.admin.http.dto.JobInfoDto;
import com.wugui.datax.admin.http.model.ReturnT;
import com.wugui.datax.admin.http.sample.service.DataxHttpService;
import com.wugui.datax.admin.http.sample.service.impl.DataxHttpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: huangjj
 * Date: 2022/5/9 6:49 PM
 * Describe:
 */
@RestController
@RequestMapping(value = "/test/job")
public class TestController {

    @Autowired
    private DataxAdminHttpApi dataxAdminHttpApi;

    @Autowired
    private DataxHttpService dataxHttpService;

    @PostMapping("start")
    public ReturnT<String> start(){
        return dataxAdminHttpApi.start(14);
    }

    @GetMapping("get")
    public ReturnT<JobInfoDto> get(){
        return dataxAdminHttpApi.get(14);
    }

}
