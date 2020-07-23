package com.fanbo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期处理工具类
 * @author wanghc
 *
 */
public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddmmHHss");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyyMM");
    public static SimpleDateFormat sdf7 = new SimpleDateFormat("MM-dd HH:mm:ss");
    public static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat sdf9 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy");

    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);

    
    public DateUtil() {
    	
	}

	public Date getEndOfDate(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        c.set(Calendar.MILLISECOND,999);
        return c.getTime();
    }

    /**
     * 将long字符串转为日期类型
     *
     * @param date
     * @param format
     * @return
     */
    public String getDateFormatLong(Long date, String format) {
    	String d = null;
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
    		d = sdf.format(new Date(date));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return d;
    }
    
	/**
     * 将日期字符串转为日期类型
     *
     * @param date
     * @param format
     * @return
     */
    public Date getString2Date(String date, String format) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将日期转为字符串
     *
     * @param date
     * @param format
     * @return
     */
    public String getDate2FormatString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将日期格式的字符串转换为另一种格式
     * @param date
     * @param format
     * @return
     */
    public String getString2FormatString(String date, String format) {
        String d = getDate2FormatString(getString2Date(date, format), format);
        return d;
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public String getCurrentDateString() {
        return sdf2.format(new Date());
    }

    public String getCurrentDateString1() {
        return sdf1.format(new Date());
    }

    public String getCurrentDateString3(Date date) {
        return sdf3.format(date);
    }

    public String getCurrentDateString4(Date date) {
        return sdf4.format(date);
    }

    public String getCurrentDateString2(Date date) {
        return sdf2.format(date);
    }

    public String getCurrentDateString5() {
        return sdf5.format(new Date());
    }
    /**
     * 编辑日期
     *
     * @param dayNum
     * @param monthNum
     * @param yearNum
     * @return
     */
    public Date editDate(int dayNum, int monthNum, int yearNum) {
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(System.currentTimeMillis());
        if (dayNum != 0) {
            cl.add(Calendar.DAY_OF_YEAR, dayNum);
        }
        if (monthNum != 0) {
            cl.add(Calendar.MONTH, monthNum);
        }
        if (yearNum != 0) {
            cl.add(Calendar.YEAR, yearNum);
        }
        return new Date(cl.getTimeInMillis());
    }

    /**
     * 编辑日期
     *
     * @param dayNum
     * @param monthNum
     * @param yearNum
     * @return
     */
    public Date editDate(int dayNum, int monthNum, int yearNum,Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        if (dayNum != 0) {
            cl.add(Calendar.DAY_OF_YEAR, dayNum);
        }
        if (monthNum != 0) {
            cl.add(Calendar.MONTH, monthNum);
        }
        if (yearNum != 0) {
            cl.add(Calendar.YEAR, yearNum);
        }
        return new Date(cl.getTimeInMillis());
    }
    /**
     * 按天加减日期
     *
     * @param dayNum
     * @return
     */
    public Date addDateByDay(int dayNum) {
        return editDate(dayNum, 0, 0);
    }

    public Date addDateByDay(int dayNum,Date date) {
        return editDate(dayNum, 0, 0,date);
    }
    /**
     * 按秒加减日期
     *
     * @param seconds
     * @return
     */
    public Date addDateBySecond(int seconds,Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.SECOND,seconds);
        return new Date(cl.getTimeInMillis());
    }

    /**
     * 按月加减日期
     *
     * @param monthNum
     * @return
     */
    public Date addDateByMonth(int monthNum) {
        return editDate(0, monthNum, 0);
    }
    /**
     * 按月加减日期
     *
     * @param monthNum
     * @return
     */
    public Date addDateByMonth(int monthNum,Date date) {
        return editDate(0, monthNum, 0,date);
    }

    /**
     * 按年加减日期
     *
     * @param yearNum
     * @return
     */
    public Date addDateByYear(int yearNum) {
        return editDate(0, 0, yearNum);
    }
    /**
     * 指定日期按年加减日期
     *
     * @param yearNum
     * @return
     */
    public Date addDateByYear(int yearNum,Date date) {
        return editDate(0, 0, yearNum,date);
    }
    /**
     * 获取日期所在周的第一天(默认为当前时间所在周的第一天)
     *
     * @param date
     * @return
     */
    public Date getFirstDayOfWeek(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setFirstDayOfWeek(Calendar.MONDAY);
        if (date == null) {
            cl.setTimeInMillis(System.currentTimeMillis());
        } else {
            cl.setTimeInMillis(date.getTime());
        }
        cl.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cl.set(Calendar.HOUR_OF_DAY, 0);
        cl.set(Calendar.MINUTE, 0);
        cl.set(Calendar.SECOND, 0);
        return new Date(cl.getTimeInMillis());
    }

    /**
     * 获取日期所在周的最后一天(默认为当前时间所在周的最后一天)
     *
     * @param date
     * @return
     */
    public Date getLastDayOfWeek(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setFirstDayOfWeek(Calendar.MONDAY);
        if (date == null) {
            cl.setTimeInMillis(System.currentTimeMillis());
        } else {
            cl.setTimeInMillis(date.getTime());
        }
        cl.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY + 6);
        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);
        return new Date(cl.getTimeInMillis());
    }
    
    /**
     * 获取当前时间到本周末的毫秒数
     *
     * @param
     * @return
     */
    public Long getLastDayOfWeekTimeMillis() {
        Calendar cl = Calendar.getInstance();
        cl.setFirstDayOfWeek(Calendar.MONDAY);
        cl.setTimeInMillis(System.currentTimeMillis());
        cl.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY + 6);
        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);
        return (cl.getTimeInMillis() - System.currentTimeMillis());
    }

    /**
     * 获取日期所在月的第一天(默认为当前时间所在月的第一天)
     *
     * @param date
     * @return
     */
    public Date getFirstDayOfMonth(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setFirstDayOfWeek(Calendar.MONDAY);
        if (date == null) {
            cl.setTimeInMillis(System.currentTimeMillis());
        } else {
            cl.setTimeInMillis(date.getTime());
        }
        cl.set(Calendar.DAY_OF_MONTH, cl.getActualMinimum(Calendar.DAY_OF_MONTH));
        cl.set(Calendar.HOUR_OF_DAY, 0);
        cl.set(Calendar.MINUTE, 0);
        cl.set(Calendar.SECOND, 0);
        return new Date(cl.getTimeInMillis());
    }
    /**
     * 获取日期所在月的最后一天(默认为当前时间所在月的最后一天)
     * @param date
     * @return
     */
    public Date getLastDayOfMonth(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setFirstDayOfWeek(Calendar.MONDAY);
        if (date == null) {
            cl.setTimeInMillis(System.currentTimeMillis());
        } else {
            cl.setTimeInMillis(date.getTime());
        }
        cl.set(Calendar.DAY_OF_MONTH, cl.getActualMaximum(Calendar.DAY_OF_MONTH));
        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);
        return new Date(cl.getTimeInMillis());
    }
    /**
     * 根据指定日期字符串date向后跳转i个自然日
     * @param date
     * @param i
     * @return
     */
    public String addDay(String date, int i) {

        GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)));
        gCal.add(GregorianCalendar.DATE, i);
        return sdf_date_format.format(gCal.getTime());
    }

    /**
     * 根据指定日期字符串date向后跳转i个自然日
     * @param date
     * @param i
     * @return
     */
    public String addDay(String date, int i, SimpleDateFormat format) {

        GregorianCalendar gCal = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)));
        gCal.add(GregorianCalendar.DATE, i);
        return format.format(gCal.getTime());
    }

    /**
     * 日期相减
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
            //System.out.println("相隔的天数="+day);   
        } catch (ParseException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 日期相减
     * @param beginDate
     * @param endDate
     * @return
     */
    public int getYearSub(Date beginDate, Date endDate) {
        int year = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(beginDate);
            end.setTime(endDate);
            if(end.get(Calendar.YEAR)>start.get(Calendar.YEAR)){
                year=end.get(Calendar.YEAR)-start.get(Calendar.YEAR);
                if(end.get(Calendar.MONTH)+1>=start.get(Calendar.MONTH)+1){
                    if(end.get(Calendar.DATE)>=start.get(Calendar.DATE)){
                        return year;
                    }else{
                        return year-1;
                    }
                }else{
                    return year-1;
                }

            }else{
                return 0;
            }
        } catch (Exception e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return year;
    }

    /*改时区*/
    public Date getDate(String millis) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        c.setTimeInMillis(Long.parseLong(millis));
        return c.getTime();
    }
    /*生成两个时间段内的随机时间*/
    public String getRandomDate(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -6);//前六个月
        Date m = c.getTime();
        String towMonthAgo = getDate2FormatString(m,"yyyy-MM-dd");
        String today = getDate2FormatString(new Date(),"yyyy-MM-dd");
        Date randomDate=randomDate(towMonthAgo,today);
        return getDate2FormatString(randomDate,"yyyy-MM-dd HH:mm:ss");
    }
    public Date randomDate(String beginDate,String  endDate ){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);//构造开始日期
            Date end = format.parse(endDate);//构造结束日期
            //getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }
    public String getString2DateString(String format, String date, String format1) {

        String resDate = "";
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat(format);
            Date d = (Date) sdf1.parse(date);
            SimpleDateFormat sdf2 = new SimpleDateFormat(format1);
            resDate = sdf2.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resDate;
    }

	/**
	 * date转yyyyMMdd
	 */
	public String getDay(Date date) throws Exception{
		return sdf5.format(date);
	}
    /**
     * date转yyyyMM
     */
    public String getMonth(Date date) throws Exception{
        return sdf6.format(date);
    }
	/**
	 * date转yyyyMMdd
	 */
	public Date getDayDate(String str) throws Exception{
		return sdf5.parse(str);
	}
    /**
     * date转yyyyMM
     */
    public Date getMonthDate(String str) throws Exception{
        return sdf6.parse(str);
    }
	/**
	 * yyyyMMddHHmmss转date
	 */
	public Date getDatefromStr(String str) throws Exception{
		return sdf1.parse(str);
	}
    /**
     * yyyy-MM-dd转date
     */
    public Date getDatefromStr2(String str) throws Exception{
        return sdf2.parse(str);
    }
	/**
	 * yyyy-MM-dd HH:mm:ss转date
	 */
	public Date getDatefromStrs(String str) throws Exception{
		return sdf4.parse(str);
	}
	/**
	 * date转 yyyy-MM-dd HH:mm:ss
	 */
	public String getSimpleDate(Date date) throws Exception{
		return sdf4.format(date);
	}


	/**
	 * yyyy-MM-dd HH:mm:ss转yyyyMMddHHmmss
	 */
	public String getDateStr(String str) throws Exception{
		return sdf1.format(sdf4.parse(str));
	}
	/**
	 * yyyyMMdd转 yyyy-MM-dd
	 */
	public String getDateStr2(String str) throws Exception{
		return sdf2.format(sdf5.parse(str));
	}
	
	public String getDateStr3(String str) throws Exception{
		return sdf4.format(sdf4.parse(str));
	}

    // 根据年月日计算年龄,birthTimeString:"1994-11-14"
    public int getAgeFromBirthTime(String birthTimeString,String nowTimeString) {
        // 先截取到字符串中的年、月、日
        String strs[] = birthTimeString.trim().split("-");
        int selectYear = Integer.parseInt(strs[0]);
        int selectMonth = Integer.parseInt(strs[1]);
        int selectDay = Integer.parseInt(strs[2]);
        // 得到当前时间的年、月、日
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(DateUtil.sdf2.parse(nowTimeString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) +1;
        int dayNow = cal.get(Calendar.DATE);

        // 用当前年月日减去生日年月日
        int yearMinus = yearNow - selectYear;
        int monthMinus = monthNow - selectMonth;
        int dayMinus = dayNow - selectDay;

        int age = yearMinus;// 先大致赋值
        if (yearMinus < 0) {// 选了未来的年份
            age = 0;
        } else if (yearMinus == 0) {// 同年的，要么为1，要么为0
            if (monthMinus < 0) {// 选了未来的月份
                age = 0;
            } else if (monthMinus == 0) {// 同月份的
                if (dayMinus < 0) {// 选了未来的日期
                    age = 0;
                } else if (dayMinus >= 0) {
                    age = 1;
                }
            } else if (monthMinus > 0) {
                age = 1;
            }
        } else if (yearMinus > 0) {
            if (monthMinus < 0) {// 当前月>生日月
            } else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄
                if (dayMinus < 0) {
                } else if (dayMinus >= 0) {
                    age = age + 1;
                }
            } else if (monthMinus > 0) {
                age = age + 1;
            }
        }
        return age;
    }
	
    /**
    * @Description: 得到时间转换成yyyyMM
    * @Param:
    * @return:
    * @Author: guol
    * @Date: 2019/2/26
    */
    public Integer getDateStringYYYYMM(Date date,int month){
        String mmDate=getDate2FormatString(addDateByMonth(month),"yyyyMM");
        if(mmDate!=null){
            return Integer.parseInt(mmDate);
        }
        return 0;
    }

    /**
     * @Description: 得到时间转换成yyyyMM
     * @Param:
     * @return:
     * @Author: guol
     * @Date: 2019/2/26
     */
    public String getDateStringYYYYMMAddMonth(Date date,int year,int month){
        String mmDate=getDate2FormatString(editDate(0,month,year),"yyyyMM");
        return  mmDate;
    }

    /**
     * 判断计算范围
     *
     * @param hiredate 入职时间
     * @return
     */
    public Map<String, String> range(int hiredate) {

        Calendar endDate = Calendar.getInstance();//月底最后一天
        endDate.set(Calendar.DATE, 1);
        endDate.add(Calendar.MONTH, 1);
        endDate.add(Calendar.DAY_OF_YEAR, -1);

        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.DATE, hiredate);

        if (hiredate > 15) { //大于15,累加到上个月
            startDate.add(Calendar.MONTH, -1);
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("start", sdf2.format(startDate.getTime()));
        map.put("end", sdf2.format(endDate.getTime()));

        System.out.println("入职日期= " + hiredate + "日,计算周期" + map);

        return map;
    }
    
    
    /**
     * 前三个月时间点
     *
     * @return
     */
    public Date getThreeMothBefore() {

    	Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.MONTH, -3);  //设置为前3月
		dBefore = calendar.getTime();   //得到前3月的时间
//		String defaultStartDate = sdf6.format(dBefore);    //格式化前3月的时间
//		String defaultEndDate = sdf4.format(dNow); //格式化当前时间

        return dBefore;
    }
    
    /**
     * 前N月时间点
     *
     * @return
     */
    public Date getMothBefore(Integer n) {
    	Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.MONTH, -n);  //设置为前3月
		dBefore = calendar.getTime();   //得到前3月的时间
        return dBefore;
    }
    /**
     * 返回指定日期的季的第一天
     *
     * @return
     */
    public Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }
    /**
     * 返回指定日期的季的最后一天
     *
     * @return
     */
    public Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                getQuarterOfYear(date));
    }
    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }
    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }
    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }
    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }
    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    
    /**获取超时时间
	 * 
	 * @return
	 */
	public Date getTimeOutDate(Long timeOut){
		Long today = new Date().getTime();
		Long sum= today + timeOut;
		Date date = new Date(sum);
		return date;
	}

	/**
	* @Description: 获取当前时间到第二天凌晨的毫秒
	* @Param: []
	* @return: java.lang.Long
	* @Author: guol
	* @Date: 2019-12-02
	*/
    public Long getMillisNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 改成这样就好了
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis());
    }

    public List<Date> findDates(Date dBegin, Date dEnd)
    {
        List lDate = new ArrayList();
        //lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            lDate.add(calBegin.getTime());
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
        }
        return lDate;
    }

    public boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    //获取昨天的yyyy-MM-dd格式的日期
    public String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();

        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(yesterday);
    }

    //获取上个月的yyyy-MM格式日期
    public String getLastMonth(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date lastMonth = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM");
        return sp.format(lastMonth);
    }


    public static void main(String [] agrs)throws Exception{
        /*DateUtil dateUtil=new DateUtil();

        Date scheduleTime=dateUtil.getString2Date("2019-12-25 14:50","yyyy-MM-dd HH:mm");


        System.out.println(dateUtil.addDateBySecond(900,scheduleTime));
        int p = 1;
        byte q = (byte)(1);
        System.out.println(p==q);*/
        /*String dateStr="2020-02-20 16:13";
        Date date=sdf3.parse(dateStr);*/
        //System.out.println(formatDateTime(dateStr));
//        String t="2020-03-10 12:12:12";
//        Date time=sdf4.parse(t);
//        DateUtil dateUtil=new DateUtil();
//        String startTime="2019-01-16";
//        startTime=dateUtil.addDay(startTime,1,sdf2);
//        System.out.println(startTime);
//        float a= Float.parseFloat("2.4.1");
//        System.out.println(a);
//        float b=Float.parseFloat("2.4");
//        System.out.println(a>=b);
//        DateUtil dateUtil=new DateUtil();
//        System.out.println(dateUtil.compareVersion("2.4.1","2.4"));

        String priceKey="y-5_yy-106";
        String enums="yy-106,y-5";
        System.out.println(priceKey.split("-")[0]);
        System.out.println(priceKey.split("-")[1]);
        System.out.println(priceKey.split("-")[0].equals(enums.split(",")[1]));
        System.out.println(priceKey.split("-")[1].equals(enums.split(",")[0]));
        System.out.println(priceKey.split("_")[0].equals(enums.split(",")[1]) &&
                priceKey.split("_")[1].equals(enums.split(",")[0]));


    }

    /**
     * v1>v2 =1 v1=v2 =0 v1<v2 =-1
     * @param v1
     * @param v2
     * @return
     */
    public int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[.]");
        String[] version2Array = v2.split("[.]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * 判断time是否在now的n天之内
     * @param time
     * @param now
     * @param n    正数表示在条件时间n天之后，负数表示在条件时间n天之前
     * @return
     */
    public String belongDate(Date time, Date now, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(now);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, n);
        Date before7days = calendar.getTime();   //得到n前的时间
        if (before7days.getTime() < time.getTime()) {
            return "1";
        } else {
            return "0";
        }
    }


        public String formatDateTime(String datetime) {


//
//        SimpleDateFormat format = new java.text.SimpleDateFormat(
//                "yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = sdf3.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        try {
//            date = format.parse(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (java.text.ParseException e) {
//
//            e.printStackTrace();
//        }

        Calendar current = Calendar.getInstance();

        Calendar today = Calendar.getInstance(); // 今天

        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        // Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        Calendar yesterday = Calendar.getInstance(); // 昨天

        yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 1);
        yesterday.set(Calendar.HOUR_OF_DAY, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);

        Calendar qianTian = Calendar.getInstance(); // 前天

        qianTian.set(Calendar.YEAR, current.get(Calendar.YEAR));
        qianTian.set(Calendar.MONTH, current.get(Calendar.MONTH));
        qianTian.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 2);
        qianTian.set(Calendar.HOUR_OF_DAY, 0);
        qianTian.set(Calendar.MINUTE, 0);
        qianTian.set(Calendar.SECOND, 0);

        Calendar daQianTian = Calendar.getInstance(); // 大前天

        daQianTian.set(Calendar.YEAR, current.get(Calendar.YEAR));
        daQianTian.set(Calendar.MONTH, current.get(Calendar.MONTH));
        daQianTian.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) -3);
        daQianTian.set(Calendar.HOUR_OF_DAY, 0);
        daQianTian.set(Calendar.MINUTE, 0);
        daQianTian.set(Calendar.SECOND, 0);

        Calendar mintianday = Calendar.getInstance(); // 明天

        mintianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        mintianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        mintianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) +1);
        mintianday.set(Calendar.HOUR_OF_DAY, 0);
        mintianday.set(Calendar.MINUTE, 0);
        mintianday.set(Calendar.SECOND, 0);

        Calendar houtianday = Calendar.getInstance(); // 后天

        houtianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        houtianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        houtianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) + 2);
        houtianday.set(Calendar.HOUR_OF_DAY, 0);
        houtianday.set(Calendar.MINUTE, 0);
        houtianday.set(Calendar.SECOND, 0);

        Calendar dahoutianday = Calendar.getInstance(); // da后天
        dahoutianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        dahoutianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        dahoutianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) + 3);
        dahoutianday.set(Calendar.HOUR_OF_DAY, 0);
        dahoutianday.set(Calendar.MINUTE, 0);
        dahoutianday.set(Calendar.SECOND, 0);

        current.setTime(date);

        if (current.after(today)&& current.before(mintianday)) {
            return "今天 " ;//+ datetime.split(" ")[1];
        }else if (current.before(today) && current.after(yesterday)) {

            return "一天前 " ;//+ datetime.split(" ")[1];
        }else if(current.before(yesterday) && current.after(qianTian)){
            return "两天前 " ;//+ datetime.split(" ")[1];
        }else if(current.before(qianTian) && current.after(daQianTian)){
            return "三天前 " ;//+ datetime.split(" ")[1];
        }else if (current.after(mintianday) && current.before(houtianday)) {

            return "明天 " + datetime.split(" ")[1];
        }else if (current.after(houtianday) && current.before(dahoutianday)) {

            return "后天 " + datetime.split(" ")[1];
        }else {
            if(datetime.substring(0,4).equals(sdf11.format(new Date()))){
                int index = datetime.indexOf("-") + 1;
                return datetime.substring(index, datetime.indexOf(" ") + 1);
            }else{
                return datetime.substring(0, datetime.indexOf(" ") + 1);
            }

        }
    }

    public String formatDateTime(Date date) {
        String datetime=this.getCurrentDateString4(date);

        Calendar current = Calendar.getInstance();

        Calendar today = Calendar.getInstance(); // 今天

        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        // Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        Calendar yesterday = Calendar.getInstance(); // 昨天

        yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 1);
        yesterday.set(Calendar.HOUR_OF_DAY, 0);
        yesterday.set(Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);

        Calendar qianTian = Calendar.getInstance(); // 前天

        qianTian.set(Calendar.YEAR, current.get(Calendar.YEAR));
        qianTian.set(Calendar.MONTH, current.get(Calendar.MONTH));
        qianTian.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 2);
        qianTian.set(Calendar.HOUR_OF_DAY, 0);
        qianTian.set(Calendar.MINUTE, 0);
        qianTian.set(Calendar.SECOND, 0);

        Calendar daQianTian = Calendar.getInstance(); // 大前天

        daQianTian.set(Calendar.YEAR, current.get(Calendar.YEAR));
        daQianTian.set(Calendar.MONTH, current.get(Calendar.MONTH));
        daQianTian.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) -3);
        daQianTian.set(Calendar.HOUR_OF_DAY, 0);
        daQianTian.set(Calendar.MINUTE, 0);
        daQianTian.set(Calendar.SECOND, 0);

        Calendar mintianday = Calendar.getInstance(); // 明天

        mintianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        mintianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        mintianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) +1);
        mintianday.set(Calendar.HOUR_OF_DAY, 0);
        mintianday.set(Calendar.MINUTE, 0);
        mintianday.set(Calendar.SECOND, 0);

        Calendar houtianday = Calendar.getInstance(); // 后天

        houtianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        houtianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        houtianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) + 2);
        houtianday.set(Calendar.HOUR_OF_DAY, 0);
        houtianday.set(Calendar.MINUTE, 0);
        houtianday.set(Calendar.SECOND, 0);

        Calendar dahoutianday = Calendar.getInstance(); // da后天
        dahoutianday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        dahoutianday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        dahoutianday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) + 3);
        dahoutianday.set(Calendar.HOUR_OF_DAY, 0);
        dahoutianday.set(Calendar.MINUTE, 0);
        dahoutianday.set(Calendar.SECOND, 0);

        current.setTime(date);

        if (current.after(today)&& current.before(mintianday)) {
            return "今天 " ;//+ datetime.split(" ")[1];
        }else if (current.before(today) && current.after(yesterday)) {

            return "一天前 " ;//+ datetime.split(" ")[1];
        }else if(current.before(yesterday) && current.after(qianTian)){
            return "两天前 " ;//+ datetime.split(" ")[1];
        }else if(current.before(qianTian) && current.after(daQianTian)){
            return "三天前 " ;//+ datetime.split(" ")[1];
        }else if (current.after(mintianday) && current.before(houtianday)) {

            return "明天 " ;//+ datetime.split(" ")[1];
        }else if (current.after(houtianday) && current.before(dahoutianday)) {

            return "后天 ";// + datetime.split(" ")[1];
        }else {
            if(datetime.substring(0,4).equals(sdf11.format(new Date()))){
                int index = datetime.indexOf("-") + 1;
                return datetime.substring(index, datetime.indexOf(" ") + 1);
            }else{
                return datetime.substring(0, datetime.indexOf(" ") + 1);
            }

        }
    }

    /**
     * @param date 指定日期
     * @Description : 返回指定日期当年第一天日期
     * @Return :
     * @uthor : hudongsheng
     * @Date : 2020/6/15 10:40
     */
    public static Date getCurrentYearFirstDayDateOfYear(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        return cal.getTime();
    }
    
    public synchronized Long getOrderId() {
		Date date = new Date();

		return Long.valueOf(sdf8.format(date) + getUum());
	}
    
    public static String getUum() {
    	int num = 1;
		if (num > 999) {
			num = 1;
		}
		String count = "" + num++;
		if (count.length() == 1) {
			count = "00" + count;
		}else if (count.length() == 2) {
			count = "0" + count;
		}
		return count;
	}

    /**
     * @param d1
     * @param d2
     * @Description :获取两个日期相差的月数
     * @Return : a
     * @Author : hudongsheng
     * @Date : 2020/6/18 17:52
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }
}
