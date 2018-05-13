package com.huyang.ApplicationLauncher;

import com.huyang.configurations.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        System.out.println(applicationContext.getBean("test"));
    }
}
