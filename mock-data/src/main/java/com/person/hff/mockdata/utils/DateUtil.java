package com.person.hff.mockdata.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String now() {
        return sdf.format(new Date());
    }

    public static Date nowDate() {
        return new Date();
    }
}
