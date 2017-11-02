package com.svse.util;

import java.util.HashMap;
import java.util.Map;

public class CreateTable
{
    private Map map;
    private static int num;
    public static String strGetTableName()
    {
        String s="";
        
        Map map=new HashMap();
        map.put(new Integer(0),"z");
        map.put(new Integer(1),"o");
        map.put(new Integer(2),"t");
        map.put(new Integer(3),"s");
        map.put(new Integer(4),"d");
        map.put(new Integer(5),"f");
        map.put(new Integer(6),"g");
        map.put(new Integer(7),"h");
        map.put(new Integer(8),"k");
        map.put(new Integer(9),"j");
        
        String mess= MessageFilter.strGetTimeStr(RealTime.strGetAllTimeToSecond())+String.valueOf(num);
        for(int i=0;i<mess.length();i++)
        {
            s+=map.get(new Integer(mess.substring(i,i+1))).toString();
        }
        num++;
        return s;
    }
    
    public static String strGetDocId()
    {
        String s="";
        
        Map map=new HashMap();
        map.put(new Integer(0),"2");
        map.put(new Integer(1),"1");
        map.put(new Integer(2),"0");
        map.put(new Integer(3),"9");
        map.put(new Integer(4),"8");
        map.put(new Integer(5),"7");
        map.put(new Integer(6),"6");
        map.put(new Integer(7),"5");
        map.put(new Integer(8),"4");
        map.put(new Integer(9),"3");
        
        String mess= MessageFilter.strGetTimeStr(RealTime.strGetAllTimeToSecond())+String.valueOf(num);
        for(int i=0;i<mess.length();i++)
        {
            s+=map.get(new Integer(mess.substring(i,i+1))).toString();
        }
        num++;
       // System.out.println("fffffffffffffffffffffffds"+s+"|file");
        return s+"|file";
        //return s;
        
    }
    
    public static void main(String[] args)
    {
        System.out.println("asfdffffffffffffffff"+CreateTable.strGetDocId());
        
    }
}
