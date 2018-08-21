package com.xxl.job.admin.core.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuruhong on 2018/8/16.
 */
public class DateUtil {
    public static Date getToday0(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    public static void main(String[] args) {
        Date d = DateUtil.getToday0();
        System.out.println(d);
    }
}
