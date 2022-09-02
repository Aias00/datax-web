指标平台docker部署

1 打包
首先在打镜像之前，先本地打包，在target下生成对应的distribution目录(包括bin目录、conf目录)
以及datax-admin-2.1.3.zip包(包括bin目录、conf目录)
目录说明：
./bin: 存放启动脚本
./conf:存放配置文件

2 打镜像

2.1 先将 Dockerfile 放在与项目bin目录、conf目录同级目录下；
将entrypoint.sh放到项目bin目录下。
最终形成的结构：
./bin: 存放项目启动脚本以及docker的entrypoint.sh脚本
./conf:存放配置文件
./Dockerfile:打镜像使用的脚本

方式一：通过镜像命令来生成镜像
在Dockerfile所在目录，执行命令，例如：

```
docker build \
--build-arg OUT_DIR_DATAX_ADMIN='.' \
-t dockerhub.dap.local/datax-admin:2.1.3 \
-f Dockerfile .
```
参数解释：
[1] --build-arg：dockerfile入参，例 OUT_DIR_DATAX_ADMIN='.'，表示dockerfile所在目录
[2] -t dockerhub.dap.local/datax-admin:2.1.3 镜像名
[3] -f 在当前目录去查找dockerfile文件，如果存在多个dockerfile文件时，则只需要使用"-f"指定dockerfile文件

方式二：目前可支持使用maven-docker插件，执行写好的Dockerfile来生成镜像
在pom文件中已配置启动dockerfile配置信息，点击Plugins中docker插件的build

2.2 生成镜像如果需要推送私服，在docker的daemon.json配置文件中配置上可访问的私服地址：
```
"registry-mirrors": [
    "https://xxxxxx.mirror.aliyuncs.com",
    "http://hub-mirror.c.163.com"
  ],
  "insecure-registries": [
    "https://dockerhub.dap.local"
  ],
```
然后对生成的镜像推送到私服，命令如下：
```
# 先使用本地的镜像生成远程推送镜像名和标签
docker tag [ImageId] dockerhub.dap.local/[ImagesName]:[ImageTag]
# 推送到远程私服
docker push dockerhub.dap.local/[ImagesName]:[ImageTag]
```
参数解释：
[1] ImageId ：你本地需要推送的镜像ID号
[2] dockerhub.dap.local/[ImagesName]:[ImageTag] ：往远程推送镜像，定义镜像的名称和标签名

3 运行镜像，启动容器

执行命令，例如：
```
docker run -itd \
-v /etc/localtime:/etc/localtime \
-v /app/datax-web/datax-admin/conf:/opt/datax-web/datax-admin/conf \
-v /app/datax-web/logs/applogs/executor/jobhandler:/opt/datax-web/logs/applogs/admin  \
-p 9201:9201 \
--name datax-admin-2.1.3 dockerhub.dap.local/datax-admin:2.1.3 
```
参数解释：
[1] -d 后台运行
    -itd 后台运行，交互操作
[2] -v /etc/localtime:/etc/localtime 挂载宿主机的时区到容器
[3] -v /app/datax-web/datax-admin/conf:/opt/datax-web/datax-admin/conf 挂载宿主机的配置文件目录到容器, 冒号前是宿主机目录（按实际情况配置），冒号后是容器内目录
[4] -p 9201:9201 端口映射，注意是小写 p ；前一个 9201 是对外浏览器上访问的端口，后一个 9201 是容器内工程本身的端口
[5] --name datax-admin-2.1.3 给容器取名为 datax-admin-2.1.3
[6] 最后 dockerhub.dap.local/datax-admin:2.1.3  表示引用的镜像的名字

