package com.huyang.common;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySources;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class GeneralPropertiesPlaceHolderConfiguer extends PropertyPlaceholderConfigurer {
    public GeneralPropertiesPlaceHolderConfiguer() {
        super();
        System.out.println("general oroperties plac eholder construct complete");
    }

}
