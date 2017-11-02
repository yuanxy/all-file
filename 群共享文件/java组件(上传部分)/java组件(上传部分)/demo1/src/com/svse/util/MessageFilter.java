package com.svse.util;

import java.util.StringTokenizer;

public class MessageFilter
{
	//临时攻关模块页面中现实的人员加逗号
	public synchronized static String strGetFiltedMessagedou(String param)
    {
        String retMessage=null;
        //将字符串回车（\n）换行(\r)替换成空格和逗号
        retMessage = param.replaceAll("\n"," "); 
        retMessage = retMessage.replaceAll("\r"," 、");
        //如果原字符串和生成的字符串长度不等，说明原字符串有回车
        //则将最后一个逗号和两个空格去掉
        if(param.length()!=retMessage.length())
        {
        	retMessage=retMessage.substring(0,(retMessage.length()-3));
        }
        return retMessage;
    }
    public static void main(String[] args)
    {
/*        String bl="hello\r\nttttttt";
        bl=MessageFilter.strGetFiltedMessagedou(bl);
        System.out.println("bl.length2()=="+bl.length());*/
    	String s="&nbsp sadfsdafsdafdfsdafdsafsad";
    	String m=null;
    	m=strGetFiltedMessage5(s);    	
    	System.out.println(m);
    }
	
    public static String strGetFiltedMessage4(String s)
    {
    	String str="";    
    	if(s!=null&&!s.equals(""))
    	{
    		str=s.replaceAll("<p>","");
    		str=str.replaceAll("</p>","<br>");
    	}
    	return str;
    }
    
    public static String strGetFiltedMessage5(String s)
    {
    	String str="";
    	if(s!=null&&!s.equals(""))
    	{
    		str=str.replaceAll("BR/P","");
    		str=s.replaceAll("P","");
    		str=str.replaceAll("/P","");
    		str=str.replaceAll("&nbsp;","");
    		str=str.replaceAll("BR","");
    		str=str.replaceAll("/","");
    		str=str.replaceAll("<","");
    		str=str.replaceAll(">","");
    	}
    	return str;
    }
    
    
    //过滤字符串
    public synchronized static String strGetFiltedMessage(String param)
    {
        String retMessage=null;
        retMessage = param.replace ('<','_'); 
        retMessage = retMessage.replace ('>','_'); 
        retMessage = retMessage.replace ('"','_'); 
        retMessage = retMessage.replace ('\'','_'); 
        retMessage = retMessage.replace ('%','_'); 
        retMessage = retMessage.replace (';','_'); 
        retMessage = retMessage.replace ('(','_'); 
        retMessage = retMessage.replace (')','_'); 
        retMessage = retMessage.replace ('&','_'); 
        retMessage = retMessage.replace ('+','_');
        
        return retMessage;
    }
    
    public synchronized static String strGetTimeStr(String param)
    {
        String retMessage=null;
        retMessage = param.replace ('-','0'); 
        retMessage = retMessage.replace (':','1'); 
        retMessage = retMessage.replace (' ','2');
        return retMessage;
    }
    //过滤字符串
    public synchronized static String strGetFiltedMessage2(String param)
    {
        String retMessage=null;
        retMessage = param.replaceAll("<","&lt;"); 
        retMessage = retMessage.replaceAll (">","&gt;"); 
        retMessage = retMessage.replaceAll ("“","&ldquo;");         
        retMessage=retMessage.replaceAll("”","&rdquo;");
        retMessage=retMessage.replaceAll("\"","&quot;");
       // retMessage = retMessage.replace ('\'','|'); 
        //retMessage = retMessage.replaceAll ("&","&amp;"); 
        //retMessage = retMessage.replace (';','|'); 
        //retMessage = retMessage.replaceAll ("(","&lsaquo;"); 
        //retMessage = retMessage.replace (')','|'); 
        //retMessage = retMessage.replaceAll ("&","&amp;"); 
        //retMessage = retMessage.replace ('+','|');
        //retMessage = retMessage.replace ('_','|');        
        
        return retMessage;
    }
    public synchronized static String strGetFiltedMessage3(String param)
    {
        String retMessage=param;
        retMessage = param.replaceAll("<",""); 
        retMessage = retMessage.replaceAll (">",""); 
        retMessage = retMessage.replaceAll ("\"","");
        retMessage = retMessage.replaceAll("%","");
        retMessage = retMessage.replaceAll("&","");
        retMessage = retMessage.replace('+','、');
        retMessage = retMessage.replaceAll("'","");
        retMessage = retMessage.replaceAll("_","");
        return retMessage;
    }
    //判断字符串是否全为字母和数字
    public synchronized static boolean isValidInput(String str) 
    { 
	    if(str.matches("[A-Za-z0-9]+"))
	    {
	        return true; 
	    }else{
	        return false; 
	    }
    }
    
    //判断传输的参数是不是数字
    public synchronized static boolean isNumber(String str)
    {
    	if(str.matches("[0-9]+"))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    //删除字符串中的空格
    public synchronized static String delBlank(String str)
    {
    	String newStr="";
    	if(str!=null)
    	{
	    	StringTokenizer stk=new StringTokenizer(str," ");
	    	while(stk.hasMoreTokens()){	
	    		newStr+=stk.nextToken();
	    	}
    	}
    	return newStr;
    }

}
