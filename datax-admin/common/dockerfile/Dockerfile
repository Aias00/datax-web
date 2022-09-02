FROM openjdk:8-jre-alpine

#时区
RUN echo "Asia/Shanghai" > /etc/timezone

#参数
ARG OUT_DIR_DATAX_ADMIN

# 将上传到对应目录下
COPY ${OUT_DIR_DATAX_ADMIN}/bin /opt/datax-web/datax-admin/bin/
COPY ${OUT_DIR_DATAX_ADMIN}/conf /opt/datax-web/datax-admin/conf/
COPY ${OUT_DIR_DATAX_ADMIN}/datax-admin-2.1.3*.jar /opt/datax-web/datax-admin

#使用ENTRYPOINT启动脚本
RUN chmod +x /opt/datax-web/datax-admin/bin/entrypoint.sh
WORKDIR /opt/datax-web/datax-admin/bin
EXPOSE 9201
ENTRYPOINT ["/bin/sh", "entrypoint.sh"]