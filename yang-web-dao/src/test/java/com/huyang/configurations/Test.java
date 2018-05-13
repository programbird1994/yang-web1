package com.huyang.configurations;

import com.huyang.common.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestAppConfiguration.class);
        User user = applicationContext.getBean("user", User.class);
    }
}
