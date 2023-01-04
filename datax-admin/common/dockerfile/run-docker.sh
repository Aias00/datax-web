docker run -itd \
-v /etc/localtime:/etc/localtime \
-v /data/datax-web/datax-admin/conf:/opt/datax-web/datax-admin/conf \
-v /data/datax3:/opt/datax3  \
-v /data/datax-web/temp/datax/executor/json:/opt/datax-web/temp/datax/executor/json  \
-v /data/datax-web/logs/applogs/admin:/opt/datax-web/logs/applogs/admin \
-p 9201:9201 \
--name datax-admin-2.1.3 dockerhub.dap.local/datax-admin:2.1.3
