FROM harbor.dap.local/library/metrics-datax-base

#时区
RUN echo "Asia/Shanghai" > /etc/timezone

#参数
ARG OUT_DIR_DATAX_EXECUTOR

# 将上传到对应目录下
COPY ${OUT_DIR_DATAX_EXECUTOR}/bin /opt/datax-web/datax-executor/bin/
COPY ${OUT_DIR_DATAX_EXECUTOR}/conf /opt/datax-web/datax-executor/conf/
COPY ${OUT_DIR_DATAX_EXECUTOR}/datax-executor-2.1.3*.jar /opt/datax-web/datax-executor

#使用ENTRYPOINT启动脚本
RUN chmod +x /opt/datax-web/datax-executor/bin/entrypoint.sh
WORKDIR /opt/datax-web/datax-executor/bin
EXPOSE 8201 9999
ENTRYPOINT ["/bin/sh", "entrypoint.sh"]