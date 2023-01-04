docker run -itd \
-v /etc/localtime:/etc/localtime \
-v /data/datax-web/datax-executor/conf:/opt/datax-web/datax-executor/conf \
-v /data/datax3:/opt/datax3  \
-v /data/datax-web/temp/datax/executor/json:/opt/datax-web/temp/datax/executor/json  \
-v /data/datax-web/logs/applogs/executor:/opt/datax-web/logs/applogs/executor \
-p 8201:8201 \
-p 9999:9999 \
--name datax-executor-2.1.3 dockerhub.dap.local/datax-executor:2.1.3
