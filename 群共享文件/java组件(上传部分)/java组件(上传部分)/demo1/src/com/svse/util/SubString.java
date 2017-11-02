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
    
    //�����ļ��ĺ�׺����
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
		//�ļ�������
		String fileName="";
		String filepoint="";
		try
		{
			//mySmartUpload.initialize(pageContext);
          //�趨�ļ�������ޣ�����Ϊ100KB
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
		//�õ���ǰ��ʱ��
		 fileName=CreateTable.strGetTableName();
		//�õ��ļ��ĺ�׺
		filepoint=strGetString1(f.getFileName());
		
		//�����ɵ�ǰ����ļ����ƺͺ�����ļ���׺�������
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


	


//	�ַ���ת��


	
	    //�ַ���str,paramΪ��ȡ�ĵڼ����ַ���
	    public static String strGetString(String str,int param)
	    {
	        //��ʼ�������ַ���
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
	        //���صڼ����ַ���
	        return s[param];
	    }
	    public static String strGetString1(String str,int param)
	    {
	        //��ʼ�������ַ���
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
	        //���صڼ����ַ���
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
		//�� "fdjasjdfsad,fdsadjfasld,fdasdfkas," ,ת��Ϊ"fdjasjdfsad,str2|fdsadjfasld,str2|fdasdfkas,str2",str2Ϊ����
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
		
		//�õ�ʵ�ʵ�Ȩ��ֵString[] str�������ַ���ת����õ������飬int index����ģ���ڴ�ģ���е�λ�ã���0��ʼ
		public static int intPurviewValuse(String[] str,int index){
			int purviewValuse=0;		
			switch(index){
				case 0:
					if(str!=null && 0<str.length){
						purviewValuse=Integer.parseInt(str[0]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
					break;
				case 1:
					if(str!=null && 1<str.length){
						purviewValuse=Integer.parseInt(str[1]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 2:
			 		if(str!=null && 2<str.length){
						purviewValuse=Integer.parseInt(str[2]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 3:
			 		if(str!=null && 3<str.length){
						purviewValuse=Integer.parseInt(str[3]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 4:
			 		if(str!=null && 4<str.length){
						purviewValuse=Integer.parseInt(str[4]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 5:
			 		if(str!=null && 5<str.length){
						purviewValuse=Integer.parseInt(str[5]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 6:
			 		if(str!=null && 6<str.length){
						purviewValuse=Integer.parseInt(str[6]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 7:
			 		if(str!=null && 7<str.length){
						purviewValuse=Integer.parseInt(str[7]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}
			 		break;
			 	case 8:
			 		if(str!=null && 8<str.length){
						purviewValuse=Integer.parseInt(str[8]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}		 		
			 		break;
			 	case 9:
			 		if(str!=null && 9<str.length){
						purviewValuse=Integer.parseInt(str[9]);
					}else{
			 			System.out.println("�±�Խ��!");
			 		}		 		
			 		break;
			 	default:
			 		System.out.println("ģ�����!");	
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
	     * ���һ���ַ���ΪNULL,�������ó�"",������ķ���ֻ�Ƿ�������ͬ
	     * �Ƽ�ʹ��
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
		    //�������һ���������͵Ĳ������������String���͵Ķ���
			//��String��Ϊnull��ֱ�ӷ��ش���ֵ�����Ϊ�������ͻ���null��
			//�򷵻�string���͵��쳣������Ϣ��

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
		 * ���һ���ַ����Ƿ�Ϊ����������null�������ַ���
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
			if(str.equalsIgnoreCase("������")){
				return agio;
			}
			else{
				agio=Double.parseDouble("0."+str.substring(0,2));
				return agio;
			}
			
		}
		
//		����ļ��ĺ�׺��
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
		
		// ת��ɽ���ʽ���ַ��� �磺88.88
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
		
//		�ڷ��ı����ҳ������ʾ�ı�text���͵�ֵʱ���ַ�ת������
		//��������ǿո�ת��Ϊһ��ȫ�ǿո�
		public static String strGetText(String str){
			str=str.replaceAll("  ","��");//��ʾ�ո�
			str=str.replaceAll("\n","<br>");//��ʾ�س�
			return str;
		}

		/**
		 * ��ֹ��ҳ���ϳ���null
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
