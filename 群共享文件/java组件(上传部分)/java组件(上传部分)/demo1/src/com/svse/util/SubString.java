package com.svse.util;

import java.io.IOException;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;    
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUploadException;
import com.jspsmart.upload.SmartUpload;

public class SubString
{
    
    //返回文件的后缀名称
	public static String strGetString1(String str)
	{
		StringTokenizer stk=new StringTokenizer(str,".");
		String[] s=new String[stk.countTokens()];
		int i=0;
		while(stk.hasMoreTokens())
		{
			s[i]=stk.nextToken();
			i++;	
		}
		return s[1];
	}
	
	public static String[] strGetString(String str)
	{
	    String[] s=null;
	    if(str==null || str.equals(""))
	    {
	        
	        return s;
	    }
		StringTokenizer stk=new StringTokenizer(str,"|");
		s=new String[stk.countTokens()];
		int i=0;
		while(stk.hasMoreTokens())
        {
			s[i]=stk.nextToken();
			i++;
		}
		return s;
	}
	//
	public static String getFileName(SmartUpload mySmartUpload,PageContext pageContext,String path,HttpServletRequest request)
	 {
		//文件的名称
		String fileName="";
		String filepoint="";
		try
		{
			//mySmartUpload.initialize(pageContext);
          //设定文件最大上限，这里为100KB
			mySmartUpload.initialize(pageContext);
		} 
		catch (ServletException e2) 
		{
			e2.printStackTrace();
		}
		mySmartUpload.setTotalMaxFileSize(300000000);
		try
		{
			mySmartUpload.upload();
		}
		catch (SmartUploadException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		} catch (ServletException e1) 
		{
			e1.printStackTrace();
		}
		Files file=mySmartUpload.getFiles();
		
		File f=file.getFile(0);
		//得到当前的时间
		 fileName=CreateTable.strGetTableName();
		//得到文件的后缀
		filepoint=strGetString1(f.getFileName());
		
		//把生成的前面的文件名称和后面的文件后缀组合起来
		fileName=fileName+"."+filepoint;
		String pa=request.getSession().getServletContext().getRealPath("/")+path;

		try
		{
			java.io.File fil=new java.io.File(pa);
			if(!fil.exists())
			 {
				fil.mkdir();
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try 
		{
			//System.out.println(path+"/"+fileName);
			//System.out.println("111111111111111111111111111111111111111");
			//System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload/"+fileName);
			f.saveAs(pa+"/"+fileName);
			//f.saveAs("/xz/www/vh_whhzxl/jsproot/web/upload/"+fileName);
			//f.saveAs("/xz/www/vh_zgxz_cn/jsproot/web/"+fileName);
			//System.out.println("/xz/www/vh_whhzxl/jsproot/web/"+path+"/"+fileName);
			new Exception();
		}
		catch (SmartUploadException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			new Exception();
		}
		return fileName;
    }


	


//	字符串转换


	
	    //字符串str,param为截取的第几个字符串
	    public static String strGetString(String str,int param)
	    {
	        //初始化参数字符串
	        String tempStr="";
	        String[] s=null;
	        if(str==null || str.equals(""))
	        {
	            return tempStr;
	        }
	        StringTokenizer stk=new StringTokenizer(str,"|");
	        s=new String[stk.countTokens()];
	        int i=0;
	        while(stk.hasMoreTokens())
	        {
	            s[i]=stk.nextToken();
	            i++;
	        }
	        //返回第几个字符串
	        return s[param];
	    }
	    public static String strGetString1(String str,int param)
	    {
	        //初始化参数字符串
	        String tempStr="";
	        String[] s=null;
	        if(str==null || str.equals(""))
	        {
	            return tempStr;
	        }
	        StringTokenizer stk=new StringTokenizer(str,"(");
	        s=new String[stk.countTokens()];
	        int i=0;
	        while(stk.hasMoreTokens())
	        {
	            s[i]=stk.nextToken();
	            i++;
	        }
	        //返回第几个字符串
	        return s[param];
	    }
	   
	    public static int strGetStringLen(String str)
	    {
	        int t=0;
	        if(str==null || str.equals(""))
	        {
	            return t;
	        }
	        StringTokenizer stk=new StringTokenizer(str,"|");
	        t=stk.countTokens();
	        return t;
	    }
		
		public static String[] strGetString7(String str){
			StringTokenizer stk=new StringTokenizer(str,";");
			String[] s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens()){
				s[i]=stk.nextToken();
				i++;	
			}
			return s;
		}
		
		public static String[] strGetString6(String str){
			StringTokenizer stk=new StringTokenizer(str," ");
			String[] s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens()){
				s[i]=stk.nextToken();
				i++;	
			}
			return s;
		}
		
		public static String[] strGetString5(String str){
			StringTokenizer stk=new StringTokenizer(str,":");
			String[] s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens()){
				s[i]=stk.nextToken();
				i++;	
			}
			return s;
		}
		
		public static String[] strGetString4(String str){
			StringTokenizer stk=new StringTokenizer(str,"\r\n");
			String[] s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens()){
				s[i]=stk.nextToken();
				i++;	
			}
			return s;
		}
		public static String strGetString2(String str){
			String str2="";
			if(str!=null&&!str.equals(""))
			{
				StringTokenizer stk=new StringTokenizer(str,"\n");		
				
				
				while(stk.hasMoreTokens()){			
					str2+=stk.nextToken()+"<br>";			
				}
			}
			return str2;
		}
		
		public static String strGetString3(String str){
		    String str2="";
			StringTokenizer stk=new StringTokenizer(str,"|");		
			
			
			while(stk.hasMoreTokens()){			
				str2+=stk.nextToken()+"<br>";			
			}
			return str2;
			
			
		}
		public static String[] strGetString8(String str){
			StringTokenizer stk=new StringTokenizer(str,",");
			String[] s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens()){
				s[i]=stk.nextToken();
				i++;	
			}
			return s;
		}
		
		public static String[] strGetString9(String str){		
			StringTokenizer stk=new StringTokenizer(str,"\n");	
			String[] str2=new String[stk.countTokens()];
			int i=0;
			
			while(stk.hasMoreTokens()){			
				str2[i]=stk.nextToken();
				i++;
			}
			return str2;
		}
		
		public static String[] strGetStringE(String str){
		    String[] s=null;
		    if(str==null || str.equals(""))
		    {
		        
		        return s;
		    }
			StringTokenizer stk=new StringTokenizer(str,"E");
			s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens())
	        {
				s[i]=stk.nextToken();
				i++;
			}
			return s;
		}
		//把 "fdjasjdfsad,fdsadjfasld,fdasdfkas," ,转换为"fdjasjdfsad,str2|fdsadjfasld,str2|fdasdfkas,str2",str2为参数
		public static String strGetString9(String str,String str2){
		    String result="";
		    String[] temp=strGetString8(str);
		    for (int i=0;i<temp.length;i++){
		        if(i==temp.length-1){
		            result+=temp[i]+","+str2;
		        }else{
		            result+=temp[i]+","+str2+"|";
		        }
		        
		    }
		    return result;
		}
		
		//得到实际的权限值String[] str：经过字符串转换后得到的数组，int index：子模块在大模块中的位置，从0开始
		public static int intPurviewValuse(String[] str,int index){
			int purviewValuse=0;		
			switch(index){
				case 0:
					if(str!=null && 0<str.length){
						purviewValuse=Integer.parseInt(str[0]);
					}else{
			 			System.out.println("下标越界!");
			 		}
					break;
				case 1:
					if(str!=null && 1<str.length){
						purviewValuse=Integer.parseInt(str[1]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 2:
			 		if(str!=null && 2<str.length){
						purviewValuse=Integer.parseInt(str[2]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 3:
			 		if(str!=null && 3<str.length){
						purviewValuse=Integer.parseInt(str[3]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 4:
			 		if(str!=null && 4<str.length){
						purviewValuse=Integer.parseInt(str[4]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 5:
			 		if(str!=null && 5<str.length){
						purviewValuse=Integer.parseInt(str[5]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 6:
			 		if(str!=null && 6<str.length){
						purviewValuse=Integer.parseInt(str[6]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 7:
			 		if(str!=null && 7<str.length){
						purviewValuse=Integer.parseInt(str[7]);
					}else{
			 			System.out.println("下标越界!");
			 		}
			 		break;
			 	case 8:
			 		if(str!=null && 8<str.length){
						purviewValuse=Integer.parseInt(str[8]);
					}else{
			 			System.out.println("下标越界!");
			 		}		 		
			 		break;
			 	case 9:
			 		if(str!=null && 9<str.length){
						purviewValuse=Integer.parseInt(str[9]);
					}else{
			 			System.out.println("下标越界!");
			 		}		 		
			 		break;
			 	default:
			 		System.out.println("模块溢出!");	
			}
			return purviewValuse;
		}
		
		public static String getStr(String str)
		{
		    String tempStr=str;
			if(tempStr==null || tempStr.equals(""))
			{
			    tempStr="";
			}
			else
			{
			    tempStr=MessageFilter.strGetFiltedMessage3(tempStr);
			}
			return tempStr;
		}
	    /**
	     * 如果一个字符串为NULL,将其设置成"",与上面的方法只是方法名不同
	     * 推荐使用
	     * @author Administrator
	     */
		public static String strIsParamNull(String param)
		{
			String tempStr=param;
		    tempStr=SubString.strCheckParamValue(tempStr);
			return tempStr;
		}
		public static String strIsParamNull(int param)
		{
			    String tempStr=String.valueOf(param);
	            tempStr=SubString.strCheckParamValue(tempStr);
	            return tempStr;
		  	
		}
		public static String strIsParamNull(char param)
		{
			String tempStr=String.valueOf(param);
		    tempStr=SubString.strCheckParamValue(tempStr);
			return tempStr;
		}
		public static String strIsParamNull(long param)
		{
			    String tempStr=String.valueOf(param);
	            tempStr=SubString.strCheckParamValue(tempStr);
	            return tempStr;
		}
		public static String strIsParamNull(float param)
		{
			String tempStr=String.valueOf(param);
		    tempStr=SubString.strCheckParamValue(tempStr);
			return tempStr;
		}
		public static String strIsParamNull(double param)
		{
			String tempStr=String.valueOf(param);
		    tempStr=SubString.strCheckParamValue(tempStr);
			return tempStr;
		}
		
		public static String strIsParamNull(Object param)
		{
		    //如果传入一个对象类型的参数，如果传入String类型的对象
			//且String不为null则直接返回传入值，如果为其它类型或者null，
			//则返回string类型的异常报错信息。

		    Object obj=param;
		    if(obj instanceof String)
		    {
		        if(obj!=null)
		        {
		            return (String.valueOf(obj));
		        }
		    }
		    return "";
		}
		public static String strIsParamNull(boolean param)
		{
			String tempStr="";
		    if(param==true)
		    {
		        tempStr="true";
		    }else if(param==false)
		    {
		        tempStr="false";
		    }
		    tempStr=SubString.strCheckParamValue(tempStr);
			return tempStr;
		}
		public static String strChangeToValue(String str)
		{
			String temp=str;
			if(temp==null)
			{
				temp="";
			}
			return temp;
		}
		/*
		 * 检查一个字符串是否为“”而不是null，过滤字符串
		 */
		public static String strCheckParamValue(String str)
		{
			String tempStr=str;
			if(tempStr==null || tempStr.equals("") || tempStr.equals("0") || tempStr.equals("null") || tempStr.equals("0.0"))
			{
			    tempStr="";
			}
/*			else
			{
			    tempStr=MessageFilter.strGetFiltedMessage3(tempStr);
			}*/
			return tempStr;
		}

		
		public static String subStringOfThree(String str){
			if(str.length()>3){
				str=str.substring(0,3)+"...";
			}
			return str;
		}
		public static String subStringOfSixty(String str)
		{
			if(str.length()>70){
				str=str.substring(0,70)+"...";
			}
			return str;			
		}
		public static String subStringOfFour(String str){
			if(str.length()>4){
				str=str.substring(0,4)+"...";
			}
			return str;
		}
		public static String subStringOfFive(String str){
			if(str.length()>5){
				str=str.substring(0,5)+"...";
			}
			return str;
		}
		public static String subStringOfSix(String str){
			if(str.length()>6){
				str=str.substring(0,6)+"...";
			}
			return str;
		}
		public static String subStringOfSeven(String str){
			if(str.length()>7){
				str=str.substring(0,7)+"...";
			}
			return str;
		}
		public static String subStringOfEight(String str){
			if(str.length()>8){
				str=str.substring(0,8)+"...";
			}
			return str;
		}
		public static String subStringOfNine(String str){
			if(str.length()>9){
				str=str.substring(0,9)+"...";
			}
			return str;
		}
		public static String subStringOfTen(String str){
			if(str.length()>10){
				str=str.substring(0,10)+"...";
			}
			return str;
		}
		public static String subStringOfNineteen(String str){
			if(str.length()>19){
				str=str.substring(0,19)+"...";
			}
			return str;
		}
		public static String subStringOfFourteen(String str){
			if(str.length()>14){
				str=str.substring(0,14)+"...";
			}
			return str;
		}
		public static String subStringOfTwentyOne(String str){
			if(str.length()>21){
				str=str.substring(0,21)+"...";
			}
			return str;
		}
		public static String subStringOfTwentyEight(String str){
			if(str.length()>28){
				str=str.substring(0,28)+"...";
			}
			return str;
		}
		public static double subStringOfTwo(String str){
			double agio=1.0;
			if(str.equalsIgnoreCase("不打折")){
				return agio;
			}
			else{
				agio=Double.parseDouble("0."+str.substring(0,2));
				return agio;
			}
			
		}
		
//		获得文件的后缀名
		public static String strGetStringPoint(String str){
			String result="";
		    String[] s={"",""};
		    if(str==null || str.equals(""))
		    {
		        
		        return s[1];
		    }
			StringTokenizer stk=new StringTokenizer(str,".");
			s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens())
	        {
				s[i]=stk.nextToken();
				i++;
			}
			if(s.length>1&&s[1]!=null){
				result=s[1];
			}
			return result;
		}
		
		// 转变成金额格式的字符串 如：88.88
		public static String strGetMoney(String str){
			String result=str;
		    String[] s={"",""};
		    if(str==null || str.equals(""))
		    {
		        return s[1];
		    }
			StringTokenizer stk=new StringTokenizer(str,".");
			s=new String[stk.countTokens()];
			int i=0;
			while(stk.hasMoreTokens())
	        {
				s[i]=stk.nextToken();
				i++;
			}
//			System.out.println(s[0]);
//			System.out.println(s[1]);
			if(s.length>1){
				if(s[1].length()>2&&s[1]!=null){
					result=s[0]+"."+s[1].substring(0,2);
				}
				else if(s[1].length()<2&&s[1]!=null){
					result=s[0]+"."+s[1]+"0";
				}
			}
			else{
				result=result+".00";
			}
//			System.out.println(result);
			return result;
		}
		
//		在非文本域的页面上显示文本text类型的值时的字符转换操作
		//将两个半角空格转换为一个全角空格
		public static String strGetText(String str){
			str=str.replaceAll("  ","　");//显示空格
			str=str.replaceAll("\n","<br>");//显示回车
			return str;
		}

		/**
		 * 防止在页面上出现null
		 * @param str
		 * @return
		 */
		public static String nullToString(String str){
			if(str==null){
				str="";
			}
			return str;
		}
		public static void main(String[] args){
			SubString.strGetMoney("100");
		}  
}
