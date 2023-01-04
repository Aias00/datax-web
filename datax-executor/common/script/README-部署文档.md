指标平台部署

1 部署流程说明

1.1 打包

打包命令：mvn clean -s 【maven settings 文件路径】 package  -P【打包哪个环境】 -DskipTests
例如：打包test环境 mvn clean -s /opt/homebrew/Cellar/maven/3.8.4/libexec/conf/settings-unicom.xml package  -Ptest -DskipTests

在target下生成对应的datax-executor-2.1.3.zip包(包括bin目录、conf目录)
以及/distribution目录(conf目录、datax-executor-2.1.3-xxx.jar)
1.2 上传

- 首次部署
  上传对应的datax-executor-2.1.3.zip包，解压后，可看到以下目录
  目录说明：
  ./bin: 存放启动脚本
  ./conf:存放配置文件
  ./datax-executor-2.1.3-xxx.jar: jar包
- 二次部署
  只需要将更新的datax-executor-2.1.3-xxx.jar包上传到目录下
  保证有且只有一个前缀为datax-executor-2.1.3-xxx.jar的jar包即可
1.3 部署
启动脚本赋权： chmod +x datax-executor
执行命令：./bin/datax-executor {start|stop|status|restart} {dev|test|demo|aqdn}
其中{dev|test|demo|aqdn}表示启动哪个环境的配置文件
