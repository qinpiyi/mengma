package com.dmcq.contentcenter.configuration.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/17 16:11
 */
public class GlobalFeignConfiguration {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
