package com.huyang.configurations;

import com.huyang.dao.DreamDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.core.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DreamDataSourceConfugurationTest {
    @org.junit.jupiter.api.Test
    void dreamDataSource() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        DreamDataSource dreamDataSource = (DreamDataSource) annotationConfigApplicationContext.getBean("dreamDataSource");
        System.out.println(dreamDataSource.getPassword());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dreamDataSource);
        int z = jdbcTemplate.execute(new StatementCallback<Integer>() {
            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.executeQuery("select count(1) from user");
                rs.next();
                return rs.getInt(1);
            }
        });
        System.out.println(z);
    }

}