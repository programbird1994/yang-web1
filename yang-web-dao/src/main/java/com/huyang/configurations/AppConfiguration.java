package com.huyang.configurations;

import com.huyang.common.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({TimeZoneConfiguration.class, CommonConfuguration.class})
public class AppConfiguration {


}
