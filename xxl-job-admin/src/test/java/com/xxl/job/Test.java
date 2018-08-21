package com.xxl.job;

import com.xxl.job.core.enums.TriggerType;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xuruhong on 2018/8/17.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        System.out.println(TriggerType.PARENT_JOB == TriggerType.NORMAL);


        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();

        // 每天早上10：15触发
        cronTriggerImpl.setCronExpression("0/1 * * * * ? *");

        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);// 把统计的区间段设置为从现在到1月后的今天（主要是为了方法通用考虑)

        List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, 1);


        // 这里的时间是根据corn表达式算出来的值
//        List<Date> dates = TriggerUtils.computeFireTimesBetween(
//                cronTriggerImpl, null, now,
//                calendar.getTime());
//        System.out.println(dates.size());

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        for (Date date : dates) {
            System.out.println(dateFormat.format(date));
        }

    }
}
