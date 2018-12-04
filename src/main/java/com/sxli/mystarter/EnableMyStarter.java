package com.sxli.mystarter;

import com.sxli.mystarter.config.MyStarterMarkerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

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
