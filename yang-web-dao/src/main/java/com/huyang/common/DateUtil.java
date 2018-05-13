package com.huyang.common;

import com.huyang.configurations.InitDbPropsConfiguration;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.InitializingBean;

import java.util.TimeZone;

public class DateUtil {
    public static String DEFAULT_TIME_ZONE = "Asia/Shanghai";

    public static void setDefaultTimeZoneToShanghaiTime() throws Exception {

        System.out.println("DateUtil.setDefaultTimeZoneToShanghaiTime - " +
                "current time zone is: [" + TimeZone.getDefault().getID() +
                "] and will change to [" + DEFAULT_TIME_ZONE + "]");

        TimeZone.setDefault(TimeZone.getTimeZone(DEFAULT_TIME_ZONE));

        DateTimeZone.setDefault(DateTimeZone.forID(DEFAULT_TIME_ZONE));

        System.out.println("DateUtil.setDefaultTimeZoneToShanghaiTime - " +
                "now current time zone is: [" + TimeZone.getDefault().getID() + "]");
    }
}
