package com.svse.util;

import java.util.Calendar;

public class RealTime
{
    //�õ���ǰʱ���Calendar��ʽ
    public static Calendar calGetCalendarTime()
    {
        Calendar caltime=Calendar.getInstance();
        return caltime;
    }
    //�õ������б�׼��ȫ��ʾʱ��
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
    //���������ַ����õ��꣬��������
    public static int intGetYear(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(0,4));
        return dttime;
    }
    //  ���������ַ����õ��£���������
    public static int intGetMonth(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(5,7));
        return dttime;
    }
    //  ���������ַ����õ��գ���������
    public static int intGetDay(String tempStr)
    {
        int dttime=0;
        dttime=Integer.parseInt(tempStr.substring(8,10));
        return dttime;
    }
    //  ���������ַ����õ��꣬�����ַ���
    public static String strGetYear(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(0,4);
        return dttime;
    }
    //  ���������ַ����õ��£������ַ���
    public static String strGetMonth(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(5,7);
        return dttime;
    }
    //  ���������ַ����õ��գ������ַ���
    public static String strGetDay(String tempStr)
    {
        String dttime="";
        dttime=tempStr.substring(8,10);
        return dttime;
    }
    //�õ������б�׼ʱ�䵽��
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
//  �õ������б�׼ʱ�䵽��
    public static String strGetTimeToMonth()
    {
        /**����ʱ�������磺2005��3��
         * */
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR))+"��";
        dttime+=String.valueOf(temptime.get(Calendar.MONTH)+1)+"��";
        return dttime;
    }
    public static String strGetTimeToMonth2()
    {
        /**����ʱ�������磺2005-3
         * */
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+String.valueOf(temptime.get(Calendar.MONTH)+1);
        return dttime;
    }
    //�õ������б�׼ʱ�䵽Сʱ
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
    //�õ������б�׼ʱ�䵽��
    public static String strGetTimeToDay()
    {
        String dttime=null;
        Calendar temptime=RealTime.calGetCalendarTime();
        dttime= String.valueOf(temptime.get(Calendar.YEAR));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.MONTH)+1));
        dttime+="-"+LenMore1(String.valueOf(temptime.get(Calendar.DAY_OF_MONTH)));
        return dttime;
    }
    //������ֳ���С��2λ����ǰ�油"0"
    public static String LenMore1(String param1)
    {
        if(param1.length()<2)
        {
            param1="0"+param1;
        }
        return param1;
    }
    
    /**
     * ������ 2006-07-20(time),6(alt) �򷵻� 2007-03-20
     * @param time	���һ��ʱ��
     * @param alt	ʱ�������·ݣ�
     * @return ��һ��ʱ��
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
        
        if((intMonth+alt)%12==0){//�ܱ�12���������
//        	System.out.println("�ܱ�12���������");
        	intYear=intYear+(intMonth+alt)/12-1;
        	intMonth=12;
        }
        else if((intMonth+alt)%12!=0){//���ܱ�12���������
//        	System.out.println("���ܱ�12���������:");
        	intYear=intYear+(intMonth+alt)/12;
        	intMonth=(intMonth+alt)%12;
        }
//        System.out.println("��һ��ʱ��Ϊ===="+time);
        
        if(0<intMonth && intMonth<10){
        	strMonth = "0"+intMonth;
        }
        else if(10<=intMonth && intMonth<=12){
        	strMonth = String.valueOf(intMonth);
        }
        time=intYear+"-"+strMonth+"-"+strDay;
        
//        System.out.println("ʱ����Ϊ"+alt+"����");
//        System.out.println("��һ��ʱ��Ϊ===="+time);
        
        return time;
    }
    
    
    
    
    /**
     * ������ 2006-07-20(time),6(alt) �򷵻� 2007-03-20
     * @param time	���һ��ʱ��
     * @param alt	ʱ������������
     * @return ��һ��ʱ��
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
         {//�ܱ�12���������
//        	System.out.println("�ܱ�12���������");
        	intMonth=intMonth+(intMonth+alt)/30-1;
        	intDay=30;
         }
        else if((intDay+alt)%30!=0)
         {//���ܱ�12���������
//        	System.out.println("���ܱ�12���������:");
        	intMonth=intMonth+(intDay+alt)/30;
        	intDay=(intDay+alt)%30;
        }
//        System.out.println("��һ��ʱ��Ϊ===="+time);
        
        if(0<intDay && intDay<10){
        	strDay = "0"+intDay;
        }
        else if(10<=intDay && intDay<=30)
        {
        	strDay = String.valueOf(intDay);
        }
        time=intYear+"-"+strMonth+"-"+strDay;
        
//        System.out.println("ʱ����Ϊ"+alt+"����");
//        System.out.println("��һ��ʱ��Ϊ===="+time);
        
        return time;
    }
    
    
    
    public static void main(String[] args)
    {
    	String time=RealTime.strGetNextTimeByMonth("2006-07-02",6);
    	System.out.println(time);
        
    }
}
