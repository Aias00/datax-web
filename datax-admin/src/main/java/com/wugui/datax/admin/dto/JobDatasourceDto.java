package com.wugui.datax.admin.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wugui.datax.admin.core.handler.AESEncryptHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * jdbc数据源配置实体类(job_jdbc_datasource)
 *
 * @author zhouhongfa@gz-yibo.com
 * @version v1.0
 * @since 2019-07-30
 */

@Data
@ApiModel
public class JobDatasourceDto{

    @ApiModelProperty(value = "自增主键")
    private Long id;

    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称")
    private String datasourceName;

    /**
     * 数据源
     */
    @ApiModelProperty(value = "数据源")
    private String datasource;

    /**
     * 数据源分组
     */
    @ApiModelProperty(value = "数据源分组")
    private String datasourceGroup;

    /**
     * 用户名
     * AESEncryptHandler 加密类
     * MyBatis Plus 3.0.7.1之前版本没有typeHandler属性，需要升级到最低3.1.2
     */
    @ApiModelProperty(value = "用户名")
    private String jdbcUsername;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String jdbcPassword;

    /**
     * jdbc url
     */
    @ApiModelProperty(value = "jdbc url")
    private String jdbcUrl;

    /**
     * jdbc驱动类
     */
    @ApiModelProperty(value = "jdbc驱动类")
    private String jdbcDriverClass;

    /**
     * 状态：0删除 1启用 2禁用
     */
    @ApiModelProperty(value = "状态：0删除 1启用 2禁用")
    private Integer status = 1;

    /**
     * zookeeper地址
     */
    @ApiModelProperty(value = "zookeeper地址", hidden = true)
    private String zkAdress;

    /**
     * 数据库名
     */
    @ApiModelProperty(value = "数据库名", hidden = true)
    private String databaseName;

}