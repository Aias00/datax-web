package com.wugui.datax.admin.http.dto;


import java.io.Serializable;

/**
 * 用于启动任务接收的实体
 *
 * @author jingwk
 * @ClassName TriggerJobDto
 * @Version 1.0
 * @since 2019/12/01 16:12
 */
public class DataXTriggerJobDto implements Serializable {

    private String executorParam;

    private int jobId;

    public String getExecutorParam() {
        return executorParam;
    }

    public void setExecutorParam(String executorParam) {
        this.executorParam = executorParam;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
