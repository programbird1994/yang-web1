package com.huyang.configurations;

import com.huyang.common.DatabasePropertiesPlaceHolderConfigurer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class InitDbPropsConfiguration {

    @Bean
    @Autowired
    public DatabasePropertiesPlaceHolderConfigurer databasePropertiesPlaceHolderConfigurer(DataSource initDatasource) {

        DatabasePropertiesPlaceHolderConfigurer propertyPlaceholderConfigurer = new DatabasePropertiesPlaceHolderConfigurer();
        propertyPlaceholderConfigurer.setDataSource(initDatasource);

        return propertyPlaceholderConfigurer;

    }

    @Autowired
    @Qualifier("local")
    Properties properties;

    @Bean
    @DependsOn({"localFileProperties"})
    public DataSource initDataSource() {
        // properties=(Properties)properties;
        BasicDataSource initDataSource = new BasicDataSource();
        initDataSource.setUrl(properties.getProperty("mysql.jdbc.url"));
        initDataSource.setUsername(properties.getProperty("mysql.jdbc.user"));
        initDataSource.setPassword(properties.getProperty("mysql.jdbc.password"));
        initDataSource.setMaxIdle(10);
        return initDataSource;
    }
}
