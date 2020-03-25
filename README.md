# springboot-dubbo
基于spring boot + dubbo搭建的分布式系统<br>
* 前后端分离<br>
    * 前端管理项目：https://github.com/scrpio/park-view<br>
    ![image](https://github.com/scrpio/images/blob/master/park-dashboard.png)<br>
    * 微信小程序：https://github.com/scrpio/park-wx<br>
    ![image](https://github.com/scrpio/images/blob/master/park-wx3.png)<br>
* Maven项目管理
* Shiro安全框架
* Mybatis持久化
* Redis缓存
* Swagger2接口文档
* 统一异常管理
* 云之讯短信服务

# 本地开发运行部署
## Maven
1. 下载地址： https://maven.apache.org/download.cgi<br>
2. window系统下的环境配置： 
* 添加环境变量 MAVEN_HOME: 右键 "计算机"，选择 "属性"→"高级系统设置"→"环境变量"，新建系统变量 MAVEN_HOME，变量值： D:\Maven\apache-maven-3.5.2<br>
![image](https://github.com/scrpio/images/blob/master/MAVEN_HOME.png)<br>
* 编辑系统变量 Path，添加变量值： ;%MAVEN_HOME%\bin<br>
![image](https://github.com/scrpio/images/blob/master/path.png)<br>
注意：注意多个值之间需要有分号隔开，然后点击确定。<br>

## Redis(Window 下安装)
1. 下载地址： https://github.com/MSOpenTech/redis/releases<br>
2. 打开一个 cmd 窗口使用 cd 命令切换到 redis 目录下运行： redis-server.exe redis.windows.conf<br>
![image](https://github.com/scrpio/images/blob/master/redis-server.png)<br>
3. 这时候另启一个 cmd 窗口，原来的不要关闭，不然就无法访问服务端了。切换到 redis 目录下运行： redis-cli.exe -h 127.0.0.1 -p 6379<br>
设置密码，运行命令： config set requirepass "123456"<br>
![image](https://github.com/scrpio/images/blob/master/redis-cli.png)<br>

## Zookeeper
1. 下载地址: http://mirrors.hust.edu.cn/apache/zookeeper/<br>
2. 解压，进入到conf目录下，将文件名zoo_sample.cfg更名为zoo.cfg。更改dataDir和dataDirLog的路径，如图: <br>
![image](https://github.com/scrpio/images/blob/master/zookeeper.png)<br>
3. 启动 zookeeper，打开 cmd 窗口使用 cd 命令切换到 bin 目录下运行: zkServer.cmd<br>
![image](https://github.com/scrpio/images/blob/master/zkServer.png)<br>

## dubbo-admin
1. 前往 GitHub 中获取源码: https://github.com/apache/dubbo-admin/tree/0.2.0<br>
2. 点击 Clone or download -> Download ZIP，保存到本地<br>
![image](https://github.com/scrpio/images/blob/master/dubbo-download.png)<br>
3. 解压刚刚下载压缩包（dubbo-admin-0.2.0.zip）<br>
4. 打开 cmd 窗口使用 cd 命令切换到 dubbo-admin-0.2.0 目录下运行: mvn clean package -Dmaven.test.skip=true，如果出现 BUILD SUCCESS 就证明打包成功。<br>
5. 启动 dubbo-admin（执行此步骤时最好启动 zookeeper）,使用 cd 命令切换到 dubbo-admin-0.2.0 目录下运行: mvn --projects dubbo-admin-server spring-boot:run<br>
6. dubbo-admin 启动成功后，访问地址：http://localhost:8080<br>
![image](https://github.com/scrpio/images/blob/master/dubbo-admin.png)<br>

