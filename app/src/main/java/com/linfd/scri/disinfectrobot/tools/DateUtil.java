package com.linfd.scri.disinfectrobot.tools;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;

    /**
     * 日期转换为字符串 格式自定义
     *
     * @param date
     * @param f
     * @return
     */
    public static String dateStr(Date date, String f) {
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }

    public static long getSubDay(Date d) {
        Calendar nowDate = Calendar.getInstance(), oldDate = Calendar.getInstance();
        nowDate.setTime(new Date());// 设置为当前系统时间
        oldDate.setTime(DateUtil.valueOf(DateUtil.dateStr2(d)));
        long timeNow = nowDate.getTimeInMillis();
        long timeOld = oldDate.getTimeInMillis();
        long subDay = (timeNow - timeOld) / (1000 * 60 * 60 * 24);// 化为天
        return subDay;
    }

    /**
     * 两日期间的天数
     *
     * @param sd
     * @param ed
     * @return
     */
    public static long getSubDay(Date sd, Date ed) {
        Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
        endDate.setTime(DateUtil.valueOf(DateUtil.dateStr2(ed)));// 设置为当前系统时间
        startDate.setTime(DateUtil.valueOf(DateUtil.dateStr2(sd)));
        long timeStart = startDate.getTimeInMillis();
        long timeEnd = endDate.getTimeInMillis();
        long subDay = (timeEnd - timeStart) / (1000 * 60 * 60 * 24);// 化为天
        return subDay;
    }

    /**
     * 两日期间的天数
     *
     * @param
     * @return
     */
    public static long getSubDayHour(Date sd, Date ed) {
        Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
        endDate.setTime(DateUtil.getDate10ByStr(DateUtil.dateStr4(ed), "yyyy-MM-dd HH:mm:ss"));// 设置为当前系统时间
        startDate.setTime(DateUtil.getDate10ByStr(DateUtil.dateStr4(sd), "yyyy-MM-dd HH:mm:ss"));
        long timeStart = startDate.getTimeInMillis();
        long timeEnd = endDate.getTimeInMillis();
        long subDay = (timeEnd - timeStart);// 化为天
        return subDay;
    }

    /**
     * 日期转换为字符串 MM月dd日 hh:mm
     *
     * @param date
     * @return
     */
    public static String dateStr(Date date) {
        return dateStr(date, "MM月dd日 hh:mm");
    }

    /**
     * 日期转换为字符串 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String dateStr2(Date date) {
        return dateStr(date, "yyyy-MM-dd");
    }

    /**
     * yyyy年MM月dd日HH时mm分ss秒
     *
     * @param date
     * @return
     */
    public static String dateStr5(Date date) {
        return dateStr(date, "yyyy年MM月dd日HH时mm分ss秒");
    }

    /**
     * yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String dateStr3(Date date) {
        return dateStr(date, "yyyyMMddHHmmss");
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String dateStr4(Date date) {
        return dateStr(date, "yyyy-MM-dd HH:mm:ss");

    }

    /**
     * yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String dateStr6(Date date) {
        return dateStr(date, "yyyy年MM月dd日");
    }

    /**
     * yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String dateStr7(Date date) {
        return dateStr(date, "yyyyMMdd");
    }

    /**
     * MM-dd
     *
     * @param date
     * @return
     */
    public static String dateStr8(Date date) {
        return dateStr(date, "MM-dd");
    }

    /**
     * yyyy年MM月
     *
     * @param date
     * @return
     */
    public static String dateStr9(Date date) {
        return dateStr(date, "yyyy年MM月");
    }

    /**
     * MM月dd日
     *
     * @param date
     * @return
     */
    public static String dateStr10(Date date) {
        return dateStr(date, "MM月dd日");
    }

    /**
     * MM
     *
     * @param date
     * @return
     */
    public static String dateStr11(Date date) {
        return dateStr(date, "MM");
    }

    /**
     * MMdd
     *
     * @param date
     * @return
     */
    public static String dateStr12(Date date) {
        return dateStr(date, "MMdd");
    }

    /**
     * dd
     *
     * @param date
     * @return
     */
    public static String dateStr13(Date date) {
        return dateStr(date, "dd");
    }

    /**
     * 日期转换为Date yyyy-MM-dd
     *
     * @param date
     * @return date
     */
    public static Date dateStr14(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String sd = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_s = formatter.parse(sd, pos);
        return currentTime_s;
    }

    /**
     * 日期转换为Date yyyy-MM-ddTHH:mm:ss
     *
     * @param string yyyy-MM-ddTHH:mm:ss
     * @return date
     */
    public static Date dateStr15(String string) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime;
        try {
            startTime = df.parse(string);
            return startTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将时间戳转换为Date
     *
     * @param times
     * @return
     */
    public static Date getDate(String times) {
        long time = Long.parseLong(times);
        return new Date(time * 1000);
    }

    public static String dateStr(String times) {
        return dateStr(getDate(times));
    }

    public static String dateStr2(String times) {
        return dateStr2(getDate(times));
    }

    public static String dateStr3(String times) {
        return dateStr3(getDate(times));
    }

    public static String dateStr4(String times) {
        return dateStr4(getDate(times));
    }

    public static String dateStr5(String times) {
        return dateStr5(getDate(times));
    }

    /**
     * 将Date转换为时间戳
     *
     * @param date
     * @return
     */
    public static long getTime(Date date) {
        return date.getTime() / 1000;
    }

    public static int getDay(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * s - 表示 "yyyy-mm-dd" 形式的日期的 String 对象
     *
     * @param
     * @return
     */
    public static Date valueOf(String s) {
        final int YEAR_LENGTH = 4;
        final int MONTH_LENGTH = 2;
        final int DAY_LENGTH = 2;
        final int MAX_MONTH = 12;
        final int MAX_DAY = 31;
        int firstDash;
        int secondDash;
        int threeDash = 0;
        int fourDash = 0;
        Date d = null;

        if (s == null) {
            throw new java.lang.IllegalArgumentException();
        }

        firstDash = s.indexOf('-');
        secondDash = s.indexOf('-', firstDash + 1);
        if (s.contains(":")) {
            threeDash = s.indexOf(':');
            fourDash = s.indexOf(':', threeDash + 1);
        }
        if ((firstDash > 0) && (secondDash > 0) && (secondDash < s.length() - 1)) {
            String yyyy = s.substring(0, firstDash);
            String mm = s.substring(firstDash + 1, secondDash);
            String dd = "";
            String hh = "";
            String MM = "";
            String ss = "";
            if (s.contains(":")) {
                dd = s.substring(secondDash + 1, threeDash - 3);
                hh = s.substring(threeDash - 2, threeDash);
                MM = s.substring(threeDash + 1, fourDash);
                ss = s.substring(fourDash + 1);
            } else {
                dd = s.substring(secondDash + 1);
            }
            if (yyyy.length() == YEAR_LENGTH && mm.length() == MONTH_LENGTH && dd.length() == DAY_LENGTH) {
                int year = Integer.parseInt(yyyy);
                int month = Integer.parseInt(mm);
                int day = Integer.parseInt(dd);
                int hour = 0;
                int minute = 0;
                int second = 0;
                if (s.contains(":")) {
                    hour = Integer.parseInt(hh);
                    minute = Integer.parseInt(MM);
                    second = Integer.parseInt(ss);
                }
                if (month >= 1 && month <= MAX_MONTH) {
                    int maxDays = MAX_DAY;
                    switch (month) {
                        // February determine if a leap year or not
                        case 2:
                            if ((year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0)) {
                                maxDays = MAX_DAY - 2; // leap year so 29 days in
                                // February
                            } else {
                                maxDays = MAX_DAY - 3; // not a leap year so 28 days
                                // in February
                            }
                            break;
                        // April, June, Sept, Nov 30 day months
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            maxDays = MAX_DAY - 1;
                            break;
                    }
                    if (day >= 1 && day <= maxDays) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month - 1, day, hour, minute, second);
                        cal.set(Calendar.MILLISECOND, 0);
                        d = cal.getTime();
                    }
                }
            }
        }
        if (d == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return d;
    }

    /**
     * @author lijie
     * @param Begin
     * @param end
     *            传入开始时间 和 结束时间 格式如：2012-09-07
     * @return 返回Map 获取相隔多少年 get("YEAR")及为俩个时间年只差，月 天，类推 Key ： YEAR MONTH DAY 如果开始时间
     *         晚于 结束时间 return null；
     */

//    @SuppressWarnings("rawtypes")
//    public static Map getApartTime(String Begin, String end) {
//        String[] temp = Begin.split("-");
//        String[] temp2 = end.split("-");
//        if (temp.length > 1 && temp2.length > 1) {
//            Calendar ends = Calendar.getInstance();
//            Calendar begin = Calendar.getInstance();
//
//            begin.set(StringUtil.toInt(temp[0]), StringUtil.toInt(temp[1]), StringUtil.toInt(temp[2]));
//            ends.set(StringUtil.toInt(temp2[0]), StringUtil.toInt(temp2[1]), StringUtil.toInt(temp2[2]));
//            if (begin.compareTo(ends) < 0) {
//                Map map = new HashMap();
//                ends.add(Calendar.YEAR, -StringUtil.toInt(temp[0]));
//                ends.add(Calendar.MONTH, -StringUtil.toInt(temp[1]));
//                ends.add(Calendar.DATE, -StringUtil.toInt(temp[2]));
//                map.put("YEAR", ends.get(Calendar.YEAR));
//                map.put("MONTH", ends.get(Calendar.MONTH) + 1);
//                map.put("DAY", ends.get(Calendar.DATE));
//                return map;
//            }
//        }
//        return null;
//    }

    /**
     * 前/后?分钟
     *
     * @param d
     * @param minute
     * @return
     */
    public static Date rollMinute(Date d, int minute) {
        return new Date(d.getTime() + minute * 60 * 1000);
    }

    /**
     * 前/后?天
     *
     * @param d
     * @param day
     * @return
     */
    public static Date rollDay(Date d, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 前/后?月
     *
     * @param d
     * @param mon
     * @return
     */
    public static Date rollMon(Date d, int mon) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, mon);
        return cal.getTime();
    }

    /**
     * 前/后?年
     *
     * @param d
     * @param year
     * @return
     */
    public static Date rollYear(Date d, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    public static Date rollDate(Date d, int year, int mon, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, year);
        cal.add(Calendar.MONTH, mon);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 获取当前时间-时间戳字符串
     *
     * @return
     */
    public static String getNowTimeStr() {
        String str = Long.toString(System.currentTimeMillis() / 1000);
        return str;
    }

    /**
     * 将Date转换为时间戳
     *
     * @param time
     * @return
     */
    public static String getTimeStr(Date time) {
        long date = time.getTime();
        String str = Long.toString(date / 1000);
        return str;
    }

    public static String getTimeStr(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
        String str = DateUtil.getTimeStr(date);
        return str;
    }

    public static Date getIntegralTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getLastIntegralTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getLastSecIntegralTime(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(d.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获取本周日的日期
    public static String getCurrentWeekday() {
        int weeks = 0;
        int mondayPlus = DateUtil.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得当前日期与本周日相差的天数
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // 获得本周一的日期
    public static String getMondayOFWeek() {
        int weeks = 0;
        int mondayPlus = DateUtil.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获取当前月第一天：
    public static String getFirstDayOfMonth(String first) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        first = format.format(c.getTime());
        return first;
    }

    // 获取当月最后一天
    public static String getLastDayOfMonth(String last) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        last = format.format(ca.getTime());
        return last;
    }

    /**
     * 日期月份处理
     *
     * @param d     时间
     * @param month 相加的月份，正数则加，负数则减
     * @return
     */
    public static Date timeMonthManage(Date d, int month) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(d);
        rightNow.add(Calendar.MONTH, month);
        return rightNow.getTime();
    }

    /**
     * 获取指定年月的最后一天
     *
     * @param year_time  指定年
     * @param month_time 指定月
     * @return
     */
    public static Date monthLastDay(int year_time, int month_time) {
        Calendar cal = Calendar.getInstance();
        cal.set(year_time, month_time, 0, 23, 59, 59);
        return cal.getTime();
    }

    /**
     * 获取指定年月的第一天
     *
     * @param year_time  指定年
     * @param month_time 指定月
     * @return
     */
    public static Date monthFirstDay(int year_time, int month_time) {
        Calendar cal = Calendar.getInstance();
        cal.set(year_time, month_time - 1, 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间月的第一天
     *
     * @param d 指定时间，为空代表当前时间
     * @return
     */
    public static Date currMonthFirstDay(Date d) {
        Calendar cal = Calendar.getInstance();
        if (d != null)
            cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间月的最后一天
     *
     * @param d 指定时间，为空代表当前时间
     * @return
     */
    public static Date currMonthLastDay(Date d) {
        Calendar cal = Calendar.getInstance();
        if (d != null)
            cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
        return cal.getTime();
    }

    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromToday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        if (ago <= ONE_HOUR) {
            if (ago / ONE_MINUTE == 0) {
                return "刚刚";
            }
            return ago / ONE_MINUTE + "分钟前";
        } else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时前";
//                    + (ago % ONE_HOUR / ONE_MINUTE) + "分钟前";
        else if (ago <= ONE_DAY * 2)
            return "昨天";
//                    + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_DAY * 3)
            return "前天";
//                    + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else {
            return dateStr6(date);
        }
    }

    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromToday(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        if (ago <= ONE_HOUR)
            return ago / ONE_MINUTE + "分钟前";
        else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE) + "分钟前";
        else if (ago <= ONE_DAY * 2)
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_DAY * 3)
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            return day + "天前" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天前" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE)
                    + "分";
        } else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0
            // so month+1
            return year + "年前" + month + "月" + calendar.get(Calendar.DATE) + "日";
        }

    }

    /**
     * 距离今天多久
     *
     * @param date
     * @return
     */
    public static String fromTodayAfter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = time - now;
        if (ago <= ONE_HOUR)
            return ago / ONE_MINUTE + "分钟后";
        else if (ago <= ONE_DAY)
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE) + "分钟后";
        else if (ago <= ONE_DAY * 2)
            return "明天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_DAY * 3)
            return "后天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            return day + "天后" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天后" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE)
                    + "分";
        } else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0
            // so month+1
            return year + "年后" + month + "月" + calendar.get(Calendar.DATE) + "日";
        }

    }

    /**
     * 获取指定时间的年
     *
     * @param date 指定时间
     * @return
     */
    public static int getTimeYear(Date date) {
        if (date == null)
            date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取指定时间的月
     *
     * @param date 指定时间
     * @return
     */
    public static int getTimeMonth(Date date) {
        if (date == null)
            date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定时间的天
     *
     * @param date 指定时间
     * @return
     */
    public static int getTimeDay(Date date) {
        if (date == null)
            date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    public static Date getFirstSecIntegralTime(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(d.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DATE, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间天的结束时间
     *
     * @param d
     * @return
     */
    public static Date getDayEndTime(long d) {
        Date day = new Date(d * 1000);
        if (d <= 0)
            day = new Date();
        Calendar cal = Calendar.getInstance();
        if (day != null)
            cal.setTimeInMillis(day.getTime());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
        return cal.getTime();
    }

    /**
     * 获取指定时间天的开始时间
     *
     * @param d
     * @return
     */
    public static Date getDayStartTime(long d) {
        Date day = new Date(d * 1000);
        if (d <= 0)
            day = new Date();
        Calendar cal = Calendar.getInstance();
        if (day != null)
            cal.setTimeInMillis(day.getTime());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取19位的格式时间
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getDateByFullDateStr(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取10位的格式时间
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date getDate10ByStr(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得当前年份和月
     *
     * @param date
     * @param i
     * @return
     */
    public static String currYearMonth(Date date, int i) {
        String currDate;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + i;
        int year = cal.get(Calendar.YEAR);
        currDate = year + String.format("%02d", month);
        return currDate;
    }

    /**
     * 字符串转为日期
     *
     * @param dateTime
     * @param format
     * @return
     */
    public static Date str2Date(String dateTime, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转换字符串
     *
     * @param
     * @param
     * @return
     */
    public static String date2Str(Date date, String f) {
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }

    /**
     * 在日期上增加天数
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 发布时间格式化
     */
    public static String publishTimeFormat(Date publishTime) {

        // 刚刚发布：一小时内发布
        // 今日发布：1小时前-24小时内
        // 昨日发布：24小时前-48小时内
        // 三日内发布：48小时前-72小时
        // 七日内发布：72小时前-7天内
        // 七日前发布：超过7天的
        if (publishTime != null) {
            long timeDiff = System.currentTimeMillis() - publishTime.getTime();

            if (timeDiff <= 1 * 60 * 60 * 1000) {
                return "刚刚发布";
            } else if (timeDiff > 1 * 60 * 60 * 1000 && timeDiff <= 24 * 60 * 60 * 1000) {
                return "今日发布";
            } else if (timeDiff > 48 * 60 * 60 * 1000 && timeDiff <= 72 * 60 * 60 * 1000) {
                return "三日内发布";
            } else if (timeDiff > 72 * 60 * 60 * 1000 && timeDiff <= 168 * 60 * 60 * 1000) {
                return "七日内发布";
            } else {
                return "七日前发布";
            }
        }
        return "刚刚发布";

    }

    /**
     * 市场动态格式化
     */
    public static String formationDate(Date date) {
        String dateString = "";
        // 获取系统当前时间
        Date now = new Date();
        long endTime = now.getTime();
        long currentTime = date.getTime();
        // 计算两个时间点相差的秒数
        long seconds = (endTime - currentTime);
        if (seconds < 60 * 60 * 1000) {
            dateString = seconds / 1000 / 60 + "分钟前";
        } else if (seconds < 60 * 60 * 24 * 1000) {
            dateString = seconds / 1000 / 60 / 60 + "小时前";
        } else if (seconds > 60 * 60 * 24 * 1000) {
            dateString = seconds / 1000 / 60 / 60 / 24 + "天前";
        }
        return dateString;
    }

    /**
     * 距离要求时间的具体时间 （天-时-分）
     */
    public static String overdueDate(Date date) {
        String dateString = "";
        // 获取系统当前时间
        Date now = new Date();
        long endTime = now.getTime();
        long currentTime = date.getTime();
        // 计算两个时间点相差的秒数
        long seconds = (endTime - currentTime);
        if (seconds < 60 * 60 * 1000) {
            dateString = seconds / 1000 / 60 + "分钟";
        } else if (seconds < 60 * 60 * 24 * 1000) {
            dateString = seconds / 1000 / 60 / 60 + "小时";
        } else if (seconds > 60 * 60 * 24 * 1000) {
            dateString = seconds / 1000 / 60 / 60 / 24 + "天";
        }
        return dateString;
    }

    /**
     * 距离要求时间的绝对时间 （时-分）
     */
    public static String overdueDate2(Date date) {
        String dateString = "";
        // 获取系统当前时间
        Date now = new Date();
        long endTime = now.getTime();
        long currentTime = date.getTime();
        // 获得两个时间的毫秒时间差异
        long diff = Math.abs((endTime - currentTime));
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 计算差多少天
        //long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if (hour < 1) {
            dateString = min + "分钟";
        } else {
            dateString = hour + "小时";
        }
        return dateString;
    }

    /**
     * 计算距离结束时间还有多长时间---转为-天-时-分-秒
     */
    public static Date yesterday(){
        //获取当前时间24小时前的时间
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY,c.get(Calendar.HOUR_OF_DAY) - 24);
        Date time= c.getTime();
        return time;
    }
}

