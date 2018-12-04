package com.sxli.mystarter.config;

import com.sxli.mystarter.service.DefaultSayHelloService;
import com.sxli.mystarter.service.SayHelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStarterConfig {

    @Bean
    public SayHelloService getSayHelloService() {
        return new DefaultSayHelloService();
    }
}
