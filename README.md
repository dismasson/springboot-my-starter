## 一、如何自定义一个SpringBoot Starter
#### 1.新建一个SpringBoot工程并且创建依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
#### 2.在resources文件夹下面新建文件夹：`MATE-INF`，在新建的文件夹下面建立文件：`spring.factories`

#### 3.新建一个`Configuration`类
    @Configuration
    public class MyStarterConfig {
    
        @Bean
        public SayHelloService getSayHelloService() {
            return new DefaultSayHelloService();
        }
    }
#### 4.修改`spring.factories`文件
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.sxli.mystarter.config.MyStarterConfig
#### 5.将当前项目打包上传到本地Maven仓库
    mvn install:install-file -Dfile=F:\GitHub\my-starter\target\my-starter-1.0.jar -DgroupId=com.sxli -DartifactId=my-starter -Dversion=1.0 -Dpackaging=jar

## 二、验证自定义的SpringBoot Starter是否生效
#### 1.创建测试项目并且导入依赖
    <dependency>
        <groupId>com.sxli</groupId>
        <artifactId>my-starter</artifactId>
        <version>1.0</version>
    </dependency>
#### 2.启动测试项目
#### 3.访问
    http://localhost:8080/mystarter/say
