package com.huyang.configurations;

import com.huyang.dao.DreamHibernateDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfiguration.class)
public class DaoConfiguration {
    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public DreamHibernateDao dreamHibernateDao() {
        DreamHibernateDao dreamHibernateDao = new DreamHibernateDao();
        dreamHibernateDao.setSessionFactory(sessionFactory);
        return dreamHibernateDao;
    }
}
