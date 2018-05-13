package com.huyang.configurations;

import com.huyang.common.DatabasePropertiesPlaceHolderConfigurer;
import com.huyang.common.GeneralPropertiesPlaceHolderConfiguer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

@Configuration
@Import(InitDbPropsConfiguration.class)
public class CommonConfuguration {

    @Bean
    public String test(@Value("${test}") String test) {
        return test;
    }


    @Bean
    @Autowired
    public PropertyPlaceholderConfigurer generalPropertyPlaceHolderConfigurer(DatabasePropertiesPlaceHolderConfigurer databasePropertiesPlaceHolderConfigurer,
                                                                              @Qualifier("local") Properties local) {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new GeneralPropertiesPlaceHolderConfiguer();
        Properties[] propertiesArray = new Properties[]{local, databasePropertiesPlaceHolderConfigurer};
        propertyPlaceholderConfigurer.setPropertiesArray(propertiesArray);
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        return propertyPlaceholderConfigurer;
    }

//    @Autowired
//    Environment environment;

    @Bean
    @Qualifier("local")
    public Properties localFileProperties(@Value("${initPropsFileLocation}") String initPropsFileLocation) {
        //  String initPropsFileLocation= environment.getProperty("initPropsFileLocation");
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource(initPropsFileLocation));
        try {
            return props.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
