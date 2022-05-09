package com.wugui.datax.admin.http.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.wugui.datax.admin.http")
public class DataXAdminHttpSampleApplication {

	public static void main(String[] args) {
        SpringApplication.run(DataXAdminHttpSampleApplication.class, args);
	}

}