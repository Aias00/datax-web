package com.wugui.datax.test;

import com.wugui.datax.admin.http.api.DataxAdminHttpApi;
import com.wugui.datax.admin.http.dto.DataXJobInfoDto;
import com.wugui.datax.admin.http.model.ReturnT;
import com.wugui.datax.admin.http.sample.DataXAdminHttpSampleApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author liuhy
 * @since 2022/5/10
 */
@SpringBootTest(classes = DataXAdminHttpSampleApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DataxTest {

    @Resource
    private DataxAdminHttpApi dataxAdminHttpApi;

    @Test
    public void testLogin() {
        ReturnT<DataXJobInfoDto> dtoReturnT = dataxAdminHttpApi.get(1);
        System.out.println(dtoReturnT);
    }
}
