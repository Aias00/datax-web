package com.wugui.datax.admin.http.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONConverter;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.wugui.datax.admin.http.model.LoginUser;
import com.wugui.datax.admin.http.properties.DataxHttpProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * Author: huangjj
 * Date: 2022/5/9 5:58 PM
 * Describe:feign拦截器配置，调用前先鉴权.
 */
//@Component
@NoArgsConstructor
@AllArgsConstructor
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    @Resource
    private DataxHttpProperties dataxHttpProperties;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = requestTemplate.headers();
        String url = requestTemplate.url();
        if (url.contains("/api/auth/login")) {
            return;
        }
        if (CollectionUtils.isEmpty(headers) || !headers.containsKey("Authorization")) {
            // do login
            LoginUser loginUser = new LoginUser(dataxHttpProperties.getUsername(), dataxHttpProperties.getPassword());
            RestTemplate restTemplate = new RestTemplate();
            String token = restTemplate.postForObject(dataxHttpProperties.getAddress() + "/api/auth/login", loginUser,
                String.class);
            System.out.println("token:" + token);
            JSONObject json = JSONUtil.parseObj(token);
            Object content = json.get("content");
            JSONObject object = JSONUtil.parseObj(content);
            String tokenStr = object.getStr("data");
            // TODO 获取到的信息添加到内存缓存，设置过期时间，避免重复获取。
            // add header
            requestTemplate.header("Authorization", tokenStr);
        }
        //    requestTemplate.header("Authorization", System.getProperty("datax.admin.auth.token"));
    }
}
