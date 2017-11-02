package com.svse.util;

import java.util.Calendar;

public class RealTime
{
    //得到当前时间的Calendar形式
    public static Calendar calGetCalendarTime()
    {
        Calendar caltime=Calendar.getInstance();
        return caltime;
    }
    //得到程序中标准的全显示时间
    public static String strGetAllTimeToSecond()
    {
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.MONTH)+1));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.DAY_OF_MONTH)));
        dttime+=" "+LenMore1(String.valueOf(temptime.get(Calendar.HOUR_OF_DAY)));
        dttime+=":"+LenMore1(String.valueOf(temptime.get(Calendar.MINUTE)));
        dttime+=":"+LenMore1(String.valueOf(temptime.get(Calendar.SECOND)));
        return dttime;
    }
    //根据日期字符串得到年，返回数字
    public static int intGetYear(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(0,4));
        return dttime;
    }
    //  根据日期字符串得到月，返回数字
    public static int intGetMonth(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(5,7));
        return dttime;
    }
    //  根据日期字符串得到日，返回数字
    public static int intGetDay(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(8,10));
        return dttime;
    }
    //  根据日期字符串得到年，返回字符串
    public static String strGetYear(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(0,4);
        return dttime;
    }
    //  根据日期字符串得到月，返回字符串
    public static String strGetMonth(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(5,7);
        return dttime;
    }
    //  根据日期字符串得到日，返回字符串
    public static String strGetDay(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(8,10);
        return dttime;
    }
    //得到程序中标准时间到分
    public static String strGetTimeToMinute()
    {
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.MONTH)+1));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.DAY_OF_MONTH)));
        dttime+=" "+LenMore1(String.valueOf(temptime.get(Calendar.HOUR_OF_DAY)));
        dttime+=":"+LenMore1(String.valueOf(temptime.get(Calendar.MINUTE)));
        return dttime;
    }
//  得到程序中标准时间到月
    public static String strGetTimeToMonth()
    {
        /**生成时间类型如：2005年3月
         * */
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR))+"年";
        dttime+=String.valueOf(temptime.get(Calendar.MONTH)+1)+"月";
        return dttime;
    }
    public static String strGetTimeToMonth2()
    {
        /**生成时间类型如：2005-3
         * */
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+String.valueOf(temptime.get(Calendar.MONTH)+1);
        return dttime;
    }
    //得到程序中标准时间到小时
    public static String strGetTimeToHour()
    {
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.MONTH)+1));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.DAY_OF_MONTH)));
        dttime+=" "+LenMore1(String.valueOf(temptime.get(Calendar.HOUR_OF_DAY)));
        return dttime;
    }
    //得到程序中标准时间到天
    public static String strGetTimeToDay()
    {
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.MONTH)+1));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.DAY_OF_MONTH)));
        return dttime;
    }
    //如果数字长度小于2位则在前面补"0"
    public static String LenMore1(String param1)
    {
        if(param1.length()<2)
        {
            param1="0"+param1;
        }
        return param1;
    }
    
    /**
     * 如输入 2006-07-20(time),6(alt) 则返回 2007-03-20
     * @param time	最近一次时间
     * @param alt	时间间隔（月份）
     * @return 下一次时间
     */
    public static String strGetNextTimeByMonth(String time,int alt){
//    	String strYear =RealTime.strGetYear(time);
    	String strMonth =RealTime.strGetMonth(time);
    	String strDay = RealTime.strGetDay(time);
    	
    	int intYear = RealTime.intGetYear(time);
        int intMonth=RealTime.intGetMonth(time);
//        int intDay=RealTime.intGetDay(time);
        
//        System.out.println("(intMonth+alt)%12===="+(intMonth+alt)%12); 
//        System.out.println("(intMonth+alt)/12===="+(intMonth+alt)/12); 
        
        if((intMonth+alt)%12==0){//能被12整除的情况
//        	System.out.println("能被12整除的情况");
        	intYear=intYear+(intMonth+alt)/12-1;
        	intMonth=12;
        }
        else if((intMonth+alt)%12!=0){//不能被12整除的情况
//        	System.out.println("不能被12整除的情况:");
        	intYear=intYear+(intMonth+alt)/12;
        	intMonth=(intMonth+alt)%12;
        }
//        System.out.println("上一次时间为===="+time);
        
        if(0<intMonth && intMonth<10){
        	strMonth = "0"+intMonth;
        }
        else if(10<=intMonth && intMonth<=12){
        	strMonth = String.valueOf(intMonth);
        }
        time=intYear+"-"+strMonth+"-"+strDay;
        
//        System.out.println("时间间隔为"+alt+"个月");
//        System.out.println("下一次时间为===="+time);
        
        return time;
    }
    
    
    
    
    /**
     * 如输入 2006-07-20(time),6(alt) 则返回 2007-03-20
     * @param time	最近一次时间
     * @param alt	时间间隔（天数）
     * @return 下一次时间
     */
    public static String strGetNextTimeByday(String time,int alt)
     {
//    	String strYear =RealTime.strGetYear(time);
    	String strMonth =RealTime.strGetMonth(time);
    	String strDay = RealTime.strGetDay(time);
    	
    	int intYear = RealTime.intGetYear(time);
        int intMonth=RealTime.intGetMonth(time);
       int intDay=RealTime.intGetDay(time);
        
//        System.out.println("(intMonth+alt)%12===="+(intMonth+alt)%12); 
//        System.out.println("(intMonth+alt)/12===="+(intMonth+alt)/12); 
        
        if((intDay+alt)%30==0)
         {//能被12整除的情况
//        	System.out.println("能被12整除的情况");
        	intMonth=intMonth+(intMonth+alt)/30-1;
        	intDay=30;
         }
        else if((intDay+alt)%30!=0)
         {//不能被12整除的情况
//        	System.out.println("不能被12整除的情况:");
        	intMonth=intMonth+(intDay+alt)/30;
        	intDay=(intDay+alt)%30;
        }
//        System.out.println("上一次时间为===="+time);
        
        if(0<intDay && intDay<10){
        	strDay = "0"+intDay;
        }
        else if(10<=intDay && intDay<=30)
        {
        	strDay = String.valueOf(intDay);
        }
        time=intYear+"-"+strMonth+"-"+strDay;
        
//        System.out.println("时间间隔为"+alt+"个月");
//        System.out.println("下一次时间为===="+time);
        
        return time;
    }
    
    
    
    public static void main(String[] args)
    {
    	String time=RealTime.strGetNextTimeByMonth("2006-07-02",6);
    	System.out.println(time);
        
    }
}
