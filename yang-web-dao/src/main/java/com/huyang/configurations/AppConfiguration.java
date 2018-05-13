package com.huyang.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(DaoConfiguration.class)
public class AppConfiguration {


}
