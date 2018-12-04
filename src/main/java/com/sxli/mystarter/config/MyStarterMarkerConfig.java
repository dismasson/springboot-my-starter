package com.sxli.mystarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
