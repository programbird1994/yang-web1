package com.huyang.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.Iterator;
import java.util.Properties;

@Configuration
@PropertySource("classpath:dataSource.properties")
public class InitFilePropsConfiguration {
    @Autowired
    Environment environment;

    @Bean
    @Qualifier("local")
    public PropertiesFactoryBean localFileProperties() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("dataSource.properties"));
        return props;

    }
}
