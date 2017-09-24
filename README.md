# xiaotian.shi-plat

基于spring cloud的跨应用共享会话

使用此架构，您需要准备如下资源

1.redis
2.内存大于2g（需要启动5个tomcat多实例）


注意：此架构没有挂载数据库，需要的可以自己添加，csdn有大量的教学资源

修改/etc/hosts文件(当然，能看懂配置的话，可以修改成自己的配置)

127.0.0.1 login.xiaotiandev.shi
127.0.0.1 www.xiaotiandev.shi
127.0.0.1 portal.xiaotiandev.shi
127.0.0.1 monitor.xiaotiandev.shi
127.0.0.1 eureka.xiaotiandev.shi

启动顺序

1.redis. (用户存储会话数据)
2.eureka. (用于服务注册，为下面基于接口访问权限数据提供服务，即fegin)
3.login. (单点登录，用于登录，与提供简单的demo权限数据)
4.www. (首页站点)
5.portal. (管理站点)
6.monitor. (监控站点)