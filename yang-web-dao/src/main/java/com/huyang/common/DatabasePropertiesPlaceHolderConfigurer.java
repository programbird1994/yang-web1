package com.huyang.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabasePropertiesPlaceHolderConfigurer extends Properties implements InitializingBean {
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private String nameColumn = "name";

    private String tokenColumn = "token";

    private String valueColumn = "value";

    private String componentColumn = "componentname";

    public void afterPropertiesSet() throws Exception {
        loadProperties(this);

    }

    protected void loadProperties(final Properties props) {
        jdbcTemplate.setFetchSize(1000);
        jdbcTemplate.query("select * from properties", new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                String name = rs.getString(nameColumn);
                String token = rs.getString(tokenColumn);
                String value = rs.getString(valueColumn);
                String componentName = rs.getString(componentColumn);
                props.put(name + "." + token, value);
            }
        });

    }
}
