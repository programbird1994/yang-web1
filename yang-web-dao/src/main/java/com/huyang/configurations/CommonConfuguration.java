package com.huyang.configurations;

import com.huyang.common.DatabasePropertiesPlaceHolderConfigurer;
import com.huyang.common.GeneralPropertiesPlaceHolderConfiguer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

@Configuration
@Import(InitDbPropsConfiguration.class)
public class CommonConfuguration {
    @Bean
    @Autowired
    public PropertyPlaceholderConfigurer generalPropertyPlaceHolderConfigurer(DatabasePropertiesPlaceHolderConfigurer databasePropertiesPlaceHolderConfigurer,
                                                                              @Qualifier("local") Properties local) {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new GeneralPropertiesPlaceHolderConfiguer();
        Properties[] propertiesArray = new Properties[]{local, databasePropertiesPlaceHolderConfigurer};
        propertyPlaceholderConfigurer.setPropertiesArray(propertiesArray);
        return propertyPlaceholderConfigurer;
    }
}
