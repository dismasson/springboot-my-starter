## 一、如何自定义一个复杂SpringBoot Starter（非引用依赖可用，需要声明启用）
#### 1.新建一个SpringBoot工程并且创建依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
#### 2.在resources文件夹下面新建文件夹：`MATE-INF`，在新建的文件夹下面建立文件：`spring.factories`

#### 3.创建下面的类或者注解
    @Configuration
    // 引用的项目中必须存在MyStarterMarkerConfig.Marker的实例即可启用
    @ConditionalOnBean(MyStarterMarkerConfig.Marker.class)
    public class MyStarterConfig {
    
        @Bean
        public SayHelloService getSayHelloService() {
            return new DefaultSayHelloService();
        }
    }
    
    /**
     * 此处创建一个Marker实例标记启用Starter
     */
    @Configuration
    public class MyStarterMarkerConfig {
    
        @Bean
        public Marker getMarker() {
            return new Marker();
        }
    
        /**
         * 作用是标记启用此STARTER
         */
        protected class Marker {
    
        }
    }
    
    /**
     * 启用自定义的Starter
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    // 导入MyStarterMarkerConfig
    @Import(MyStarterMarkerConfig.class)
    public @interface EnableMyStarter {
    }
#### 4.修改`spring.factories`文件
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.sxli.mystarter.config.MyStarterConfig,com.sxli.mystarter.config.MyStarterMarkerConfig
#### 5.将当前项目打包上传到本地Maven仓库
    mvn install:install-file -Dfile=F:\GitHub\my-starter\target\my-starter-2.0.jar -DgroupId=com.sxli -DartifactId=my-starter -Dversion=2.0 -Dpackaging=jar
## 二、验证自定义的SpringBoot Starter是否生效
#### 1.创建测试项目并且导入依赖
    <dependency>
        <groupId>com.sxli</groupId>
        <artifactId>my-starter</artifactId>
        <version>1.0</version>
    </dependency>
#### 2.声明启用
    @SpringBootApplication
    // 声明启用自定义starter
    @EnableMyStarter
    public class SpringbootStarterTestApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringbootStarterTestApplication.class, args);
        }
    }
#### 3.启动测试项目
#### 4.访问
    http://localhost:8080/mystarter/say
