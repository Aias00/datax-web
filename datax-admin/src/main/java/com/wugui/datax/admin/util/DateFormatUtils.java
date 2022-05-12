package com.wugui.datax.admin.util;

import java.util.ArrayList;
import java.util.List;

public class DateFormatUtils {

    public static final String DATE_FORMAT = "yyyy/MM/dd";
    public static final String DATE_FORMAT1_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT1_2 = "yyyy-MM";
    public static final String DATE_FORMAT1_3 = "yyyy";
    public static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIMESTAMP = "Timestamp";

    public static final List<String> formatList() {
        List<String> formatList = new ArrayList<>();
        formatList.add(DATE_FORMAT);
        formatList.add(DATE_FORMAT1_1);
        formatList.add(DATE_FORMAT1_2);
        formatList.add(DATE_FORMAT1_3);
        formatList.add(TIME_FORMAT);
        formatList.add(DATETIME_FORMAT);
        formatList.add(TIMESTAMP);
        return formatList;
    }

}
