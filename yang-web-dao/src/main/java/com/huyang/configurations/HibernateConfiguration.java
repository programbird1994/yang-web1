package com.huyang.configurations;

import com.huyang.dao.DreamDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.io.IOException;
//import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;

@Configuration
@Import(DreamDataSource.class)
public class HibernateConfiguration {
    @Bean
    @Autowired
    public SessionFactory sessionFactory(DreamDataSource dreamDataSource) throws IOException {
        SessionFactory sessionFactory = new SessionFactoryImpl();
        return localSessionFactoryBean().getObject();
    }

    public LocalSessionFactoryBean localSessionFactoryBean() throws IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.afterPropertiesSet();
        return localSessionFactoryBean;
    }

}
