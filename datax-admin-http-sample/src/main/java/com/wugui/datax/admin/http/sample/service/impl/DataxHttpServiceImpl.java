package com.wugui.datax.admin.http.sample.service.impl;

import com.wugui.datax.admin.http.api.DataxAdminHttpApi;
import com.wugui.datax.admin.http.model.LoginUser;
import com.wugui.datax.admin.http.sample.service.DataxHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Author: huangjj
 * Date: 2022/5/9 9:11 PM
 * Describe:
 */
@Service
@Slf4j
public class DataxHttpServiceImpl implements DataxHttpService {

    @Value("${datax.job.admin.user}")
    private String user;

    @Value("${datax.job.admin.password}")
    private String password;

    @Autowired
    private DataxAdminHttpApi dataxAdminHttpApi;
//
//    @Override
//    public void login(){
//        Map<String, Object> login = dataxAdminHttpApi.login(new LoginUser(user, password));
//        System.setProperty("datax.admin.auth.token",String.valueOf(login.get("data") ));
//        log.info("=====》datax-web登录，获取token成功");
//    }

}
