# my-cloud
## 每一个微服务一定要通过spring-initializer的方式选择依赖，同时每个服务模块中都要引入spring-cloud-dependence
1. 新版Spring-security的basic模式默认开启了csrf保护，会阻止服务注册到eureka，所以需要手动关闭此特性，才能注册成功。
2. 由于eureka服务端依赖EJB-lib，如果缺失就无法启动，但是自jdk9开始，不再包含EJB，所以需要手动引入EJB。
3. 由于eureka时Netflix的项目，spring-cloud的官方注册中心已经时cosule了。
4. 在实践中，【推荐】producer来定义Feign接口，同时定义出返回值类型、熔断回退等处理细节，然后以服务为单位，
    将定义的接口打成remote-order-service-starter.jar，发布到仓库，需要的consumer引入starter就行了。
---
. Eureka-OK
. Ribbon-OK
. Feign-OK
. 自定义Feign-
. Local-Hystrix-OK
. Feign-Hystrix-OK 要在配置文件中手动打开
.......由于Feign定义的是接口，所以无法在接口中编写回退方法，
此时有两种方法解决：1.需要给接口添加回退工厂类，并用@FeignClient接口的fallbackFactory属性指定该回退工厂就可以，并在工厂返回的实现类中实现接口的方法，即可达成为Feign接口指定回退方法的目的。
2.定义一个Feign接口的实现类，并用@FeignClient接口的fallback属性指定该实现类就可以
. Hystrix-Metrics-OK：接通了dashboard，但是有些细节没搞
. Zuul-OK：可以用，但是高级机制需要研究
. Config-center-client-OK分别实现了从浏览器、client获取git配置的功能呢，尚未集成到其他项目中
---
