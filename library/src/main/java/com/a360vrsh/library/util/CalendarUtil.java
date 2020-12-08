package com.a360vrsh.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    /**
     * 获取指定日期N个月后的日期
     */
    public static String getAfterMonth(String inputDate, int number) {
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(inputDate);//初始日期
        } catch (Exception e) {

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH, number);//在日历的月份上增加N个月
        String strDate = sdf.format(c.getTime());//的到你想要得N个月后的日期

//        Logger.e("getAfterMonth", strDate);
        return strDate;
    }

    /**
     * 格式化的日期字符串转换 如 yyyyMMdd->yyyy-MM-dd  20200701 -> 2020-07-01
     *
     * @param inputDate
     * @param originFormat
     * @param targetFormat
     */
    public static String stringTimeFormat(String inputDate, String originFormat, String targetFormat) {
        String strDate = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(originFormat);
            Date date = sdf.parse(inputDate);
            strDate = new SimpleDateFormat(targetFormat).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strDate;
    }

    /*
     * 获取当前日期
     * */
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /*
     * long转时间
     * @param format "yyyy-MM-dd"
     * */
    public static String longToDate(long timeStamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(timeStamp));
    }

    /*
     * date转时间
     * @param format "yyyy-MM-dd"
     * */
    public static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /*
     * 判断日期在某个区间
     * */
    public static boolean isDateInRange(String startDateVal, String endDateVal, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
//        Logger.e("isDateInRange", "today:" + date);
        try {
            startDate = simpleDateFormat.parse(startDateVal);
            endDate = simpleDateFormat.parse(endDateVal);

            if (startDate.getTime() <= date.getTime() && endDate.getTime() > date.getTime()) {
//                Logger.e("isDateInRange", date + "日期在范围内");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
