# my-cloud
1. 新版Spring-security的basic模式默认开启了csrf保护，会阻止服务注册到eureka，所以需要手动关闭此特性，才能注册成功。
2. 由于eureka服务端依赖EJB-lib，如果缺失就无法启动，但是自jdk9开始，不再包含EJB，所以需要手动引入EJB。
3. 由于eureka时Netflix的项目，spring-cloud的官方注册中心已经时cosule了。
