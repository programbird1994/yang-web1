package com.huyang.configurations;

import com.huyang.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Import(CommonConfuguration.class)
public class TestAppConfiguration {

    @Value(value = "${huyang.util.test}")
    private String userName;
    @Autowired
    Environment environment;

    @Bean
    public User user() {

        System.out.println(userName);
        return new User();
    }


}
