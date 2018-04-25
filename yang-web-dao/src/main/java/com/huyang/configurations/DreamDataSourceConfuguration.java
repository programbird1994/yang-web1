package com.huyang.configurations;

import com.huyang.dao.DreamDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.huyang")
@PropertySource("classpath:dataSource.properties")
public class DreamDataSourceConfuguration {
    @Value("${mysql.jdbc.url}")
    private String url;
    @Value("${mysql.jdbc.user}")
    private String user;
    //    @Autowired
//    private Environment environment;
    @Value("${mysql.jdbc.password}")
    private String password;

    @Bean
    public DreamDataSource dreamDataSource() {
        DreamDataSource dreamDataSource = new DreamDataSource();
        dreamDataSource.setPassword(password);
        dreamDataSource.setUrl(url);
        dreamDataSource.setUsername(user);
        return dreamDataSource;
    }
}
