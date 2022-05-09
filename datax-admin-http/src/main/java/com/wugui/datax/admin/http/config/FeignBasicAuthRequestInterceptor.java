package com.wugui.datax.admin.http.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * Author: huangjj
 * Date: 2022/5/9 5:58 PM
 * Describe:feign拦截器配置，调用前先鉴权.
 */
//@Component
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor{


  public FeignBasicAuthRequestInterceptor(){}

  @Override
  public void apply(RequestTemplate requestTemplate) {
    requestTemplate.header("Authorization", System.getProperty("datax.admin.auth.token"));
  }
}
