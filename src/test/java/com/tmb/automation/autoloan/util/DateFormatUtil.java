package com.tmb.automation.autoloan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    /**
     * Pattern yyyy-MM-dd
     * @return
     */
    public static String dateFormatYYYYMMDD(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
