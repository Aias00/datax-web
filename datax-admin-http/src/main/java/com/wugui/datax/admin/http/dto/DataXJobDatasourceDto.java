package com.wugui.datax.admin.http.dto;

import lombok.Data;

/**
 * jdbc数据源配置实体类(job_jdbc_datasource)
 *
 * @author zhouhongfa@gz-yibo.com
 * @version v1.0
 * @since 2019-07-30
 */

@Data
public class DataXJobDatasourceDto {

    private Long id;

    /**
     * 数据源名称
     */
    private String datasourceName;

    /**
     * 数据源
     */
    private String datasource;

    /**
     * 数据源分组
     */
    private String datasourceGroup;

    /**
     * 用户名
     * AESEncryptHandler 加密类
     * MyBatis Plus 3.0.7.1之前版本没有typeHandler属性，需要升级到最低3.1.2
     */
    private String jdbcUsername;

    /**
     * 密码
     */
    private String jdbcPassword;

    /**
     * jdbc url
     */
    private String jdbcUrl;

    /**
     * jdbc驱动类
     */
    private String jdbcDriverClass;

    /**
     * 状态：0删除 1启用 2禁用
     */
    private Integer status = 1;

    /**
     * zookeeper地址
     */
    private String zkAdress;

    /**
     * 数据库名
     */
    private String databaseName;

}