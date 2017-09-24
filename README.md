# xiaotian.shi-plat

基于spring cloud的跨应用共享会话

使用此架构，您需要准备如下资源

1.redis
2.内存大于2g（需要启动5个tomcat多实例）
3.机器上有maven


注意：此架构没有挂载数据库，需要的可以自己添加，csdn有大量的教学资源

准备步骤：

* 执行build.sh

1.修改/etc/hosts文件(当然，能看懂配置的话，可以修改成自己的配置)

2.进入命令行进入deploy项目文件夹，执行mvn -Dmaven.test.skip=true package deploy
（打包多个项目需要依赖的父依赖）

3.公共包plat, 进入plat项目文件夹 执行mvn -Dmaven.test.skip=true package deploy

(2-3两步，如果直接执行build.sh 无问题可以忽略，已经在bulid-mvn.sh中做掉了)


127.0.0.1 login.xiaotiandev.shi
127.0.0.1 www.xiaotiandev.shi
127.0.0.1 portal.xiaotiandev.shi
127.0.0.1 monitor.xiaotiandev.shi
127.0.0.1 eureka.xiaotiandev.shi

启动顺序

1.redis. (用户存储会话数据，默认端口6379)
2.eureka. (用于服务注册，为下面基于接口访问权限数据提供服务，即fegin，端口8089)
3.login. (单点登录，用于登录，与提供简单的demo权限数据,端口8081)
4.www. (首页站点，端口8082)
5.portal. (管理站点，端口8083)
6.monitor. (监控站点，端口8084)

注意: 您只有一台机器的情况下，可能需要tomcat多实例支持

登陆账号密码
admin admin
user1 user1
user2 user2
