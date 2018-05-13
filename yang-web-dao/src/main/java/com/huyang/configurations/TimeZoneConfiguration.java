package com.huyang.configurations;

import com.huyang.common.DateUtil;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeZoneConfiguration {
    @Bean
    public MethodInvokingFactoryBean setDefaultTimeZone() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setTargetClass(DateUtil.class);
        methodInvokingFactoryBean.setTargetMethod("setDefaultTimeZoneToShanghaiTime");
        return methodInvokingFactoryBean;
    }
}
