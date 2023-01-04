docker build \
--build-arg OUT_DIR_DATAX_EXECUTOR='.' \
-t dockerhub.dap.local/datax-executor:2.1.3 \
-f Dockerfile .
