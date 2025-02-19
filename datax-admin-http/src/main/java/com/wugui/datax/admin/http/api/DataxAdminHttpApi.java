package com.wugui.datax.admin.http.api;

import com.baomidou.mybatisplus.extension.api.R;
import com.wugui.datax.admin.http.config.FeignConfiguration;
import com.wugui.datax.admin.http.dto.DataXJsonBuildDto;
import com.wugui.datax.admin.http.dto.DataXJobInfoDto;
import com.wugui.datax.admin.http.dto.DataXTriggerJobDto;
import com.wugui.datax.admin.http.model.ReturnT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: huangjj
 * Date: 2022/5/9 5:12 PM
 * Describe:
 */
@FeignClient(url = "${datax.job.admin.address}",name = "datax-admin-http", configuration = FeignConfiguration.class)
public interface DataxAdminHttpApi {

    /**
     * 添加任务
     * @param dataxJobInfoDto
     * @return
     */
    @PostMapping("api/job/add")
    ReturnT<String> add(@RequestBody DataXJobInfoDto dataxJobInfoDto);

    /**
     * 启动任务
     * @param id
     * @return
     */
    @PostMapping("api/job/start")
    ReturnT<String> start(@RequestParam("id") int id);

    /**
     * 更新任务
     * @param dataxJobInfoDto
     * @return
     */
    @PostMapping("api/job/update")
    ReturnT<String> update(@RequestBody DataXJobInfoDto dataxJobInfoDto);

    /**
     * 移除任务
     * @param id
     * @return
     */
    @PostMapping("api/job/remove/{id}")
    ReturnT<String> remove(@PathVariable(value = "id") int id);

    /**
     * 停止任务
     * @param id
     * @return
     */
    @PostMapping("api/job/stop")
    ReturnT<String> pause(@RequestParam("id") int id);

    /**
     * 手动触发任务
     * @param dto
     * @return
     */
    @PostMapping("api/job/trigger")
    ReturnT<String> triggerJob(@RequestBody DataXTriggerJobDto dto);

    /**
     * 获取近5次触发时间
     * @param cron
     * @return
     */
    @GetMapping("api/job/nextTriggerTime")
    ReturnT<List<String>> nextTriggerTime(@RequestParam("cron") String cron);

    /**
     * 通过Id获取任务信息
     * @param id
     * @return
     */
    @GetMapping("api/job/getById")
    ReturnT<DataXJobInfoDto> get(@RequestParam("id") int id);

    /**
     * 查询执行器,可通过appName来查找执行器id
     */
    @GetMapping("api/jobGroup/findGroupId")
    ReturnT<String> findGroupId(@RequestParam("appName") String appName);

    /**
     * JSON构建
     * @param dto
     * @return
     */
    @PostMapping("api/dataxJson/buildJson")
    R<String> buildJobJson(@RequestBody DataXJsonBuildDto dto);

}

