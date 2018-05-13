package com.huyang.configurations;

import com.huyang.common.DatabasePropertiesPlaceHolderConfigurer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(InitFilePropsConfiguration.class)
public class InitDbPropsConfiguration {

    @Bean
    @Autowired
    public DatabasePropertiesPlaceHolderConfigurer databasePropertiesPlaceHolderConfigurer(DataSource initDatasource) {

        DatabasePropertiesPlaceHolderConfigurer propertyPlaceholderConfigurer = new DatabasePropertiesPlaceHolderConfigurer();
        propertyPlaceholderConfigurer.setDataSource(initDatasource);

        return propertyPlaceholderConfigurer;

    }

    @Bean
    @Autowired
    public DataSource initDataSource(@Qualifier("local") Properties properties) {
        BasicDataSource initDataSource = new BasicDataSource();
        initDataSource.setUrl(properties.getProperty("mysql.jdbc.url"));
        initDataSource.setUsername(properties.getProperty("mysql.jdbc.user"));
        initDataSource.setPassword(properties.getProperty("mysql.jdbc.password"));
        initDataSource.setMaxIdle(10);
        return initDataSource;
    }
}
