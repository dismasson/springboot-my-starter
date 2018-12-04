package com.sxli.mystarter.config;

import com.sxli.mystarter.service.DefaultSayHelloService;
import com.sxli.mystarter.service.SayHelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 引用的项目中必须存在MyStarterConfig.Mark的实例即可启用
@ConditionalOnBean(MyStarterMarkerConfig.Marker.class)
public class MyStarterConfig {

    @Bean
    public SayHelloService getSayHelloService() {
        return new DefaultSayHelloService();
    }
}
