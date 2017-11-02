package com.svse.util;

import java.util.Date;
import java.util.Random;
import java.util.Vector;

import sun.io.ByteToCharConverter;
import sun.io.CharToByteConverter;


public class DealString
{
	public long makeID ( int uid )
	{
		//用户占5位
		uid += 10000 ;
		
		//时间占9位:秒，去掉第一位
		java.util.Date time = new java.util.Date();
		long second = time.getTime() / 1000 ;
		String str = second + "" ;
		str = str.substring(1,str.length());

		//群发占5位
		str = uid + str + 10000 ;
          
		return Long.parseLong(str);
	}

	public String toLikeSql ( int sum , int cur , char like , char c )
	{
		char ch[] = new char[sum] ;
		for ( int i = 0 ; i < sum ; i++ )
		{
			ch[i] = like ;
		}
		ch[cur] = c ;
		String str = new String ( ch ) ;
		return str ;
	}

	public int getRandom ( int min , int max , int seed )
	{
		String time = getDateTime ( ) ;
		Random rand ;
		if ( seed == 0 )
		{
			rand = new Random ( Integer.parseInt( time .substring ( 17 , 19 ) ) ) ;
		}
		else
		{
			rand = new Random ( seed ) ;
		}
		int t = rand.nextInt(max);
		while ( t < min )
		{
			t = rand.nextInt(max);
		}
		return t ;
	}

	/**把null转化为""*/
	public String toString(String str)
	{
		if(str==null)str = "";
		if(str.equals("null"))str = "";
		str = str.trim();
		return str;
	}	

	public String toMKByte(long size)
	{
		if(size>(1024*1024)){return ((float)size/(1024*1024)+"").substring(0,4)+"MB";}
		else if(size>1024){return ((float)size/1024+"").substring(0,4)+"KB";}
		else return size+"B";
	}

	/**转换编码*/
	public String toGBK(String str)
	{
		try 
		{
			if(str==null)
				str = "";
			else
				str=new String(str.getBytes("ISO-8859-1"),"GBK"); 
		}catch (Exception e) {System.out.println("DealString::toGBK(String)运行时出错：错误为："+e);}
		return str;
	}

	/**UTF8*/
	public String toUtf8String(String src)
	{
		byte[] b = src.getBytes();
		char[] c = new char[b.length];
		for(int i=0;i<b.length;i++)
		{
			c[i] = (char)(b[i]&0x00FF);
		}
		return new String(c);
	}

	public String toASCII(String str)
	{
		try 
		{
			if(str==null)
				str = "";
			else 
				str=new String(str.getBytes("GBK"),"ISO-8859-1"); 
		}catch (Exception e) {System.out.println("DealString::toGBK(String)运行时出错：错误为："+e);}
		return str;
	}
	/**分割字符串*/
	public String[] splitStr(String str,char c)
	{
		str+=c;
		int n=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==c)n++;
		}

		String out[] = new String[n];

		for(int i=0;i<n;i++)
		{
			int index = str.indexOf(c);
			out[i] = str.substring(0,index);
			str = str.substring(index+1,str.length());
		}
		return out;
	}

	/**取得系统时间*/
	public String getDateTime()
	{
		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		String time = f.format(new java.util.Date());
		return time;
	}

	/**替换字符串*/
	public String Replace(String source, String oldString, String newString)
	{ 
       StringBuffer output = new StringBuffer(); 

       int lengthOfSource = source.length();   // 源字符串长度 
       int lengthOfOld = oldString.length();   // 老字符串长度 
       int posStart = 0;   // 开始搜索位置 
       int pos;            // 搜索到老字符串的位置 

       while ((pos = source.indexOf(oldString, posStart)) >= 0) { 
           output.append(source.substring(posStart, pos)); 
           output.append(newString); 
           posStart = pos + lengthOfOld; 
       } 
       if (posStart < lengthOfSource) { 
           output.append(source.substring(posStart)); 
       } 
       return output.toString(); 
	}

	/**取得两个日期的天数之差*/
	public long getDaysInterval(Date d1,Date d2)
	{
		return (d2.getTime()-d1.getTime())/86400000;
	}
	
	/**将字符串格式化为固定长度*/
	public String toLengthStr(String instr,int len)
	{
		int n = instr.length();
		for(int i=0;i<(len-n);i++)
		{
			instr = " "+instr;
		}
		return instr;
	}
	/**将字符串格式化为固定长度(右边补空格)*/
	public String toLengthStrRight(String instr,int len)
	{
		int n = instr.length();
		for(int i=0;i<(len-n);i++)
		{
			instr = instr+" ";
		}
		return instr;
	}
	/*ASCII转化为字符串*/
	public String AsciiToChineseString(String s) 
	{
		char[] orig = s.toCharArray();
		byte[] dest = new byte[orig.length];
		for (int i=0;i<orig.length;i++)
		dest[i] = (byte)(orig[i]&0xFF);
		try 
		{
			ByteToCharConverter toChar = ByteToCharConverter.getConverter("gb2312");
			return new String(toChar.convertAll(dest));
		}
		catch (Exception e) 
		{
			System.out.println("DealString::AsciiToChineseString(String)运行时出错；错误为："+e);
			return s;
		}
	}

	/**字符串转化为ASCII*/
	public String ChineseStringToAscii(String s) 
	{
		try 
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("gb2312");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i=0;i<orig.length;i++)
				dest[i] = (char)(orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e) 
		{
			System.out.println("DealString::ChineseStringToAscii(String)运行时出错："+e);
			return s;
		}
	}
	
	/**Unicode转化成GB的源码*/
	public String UnicodetoGB(String s)  
	{  
		StringBuffer  sb  =  new  StringBuffer();  
		boolean  escape  =  false;  
		for(int  i=0;  i<s.length();  i++)  
		{  
			char  c  =  s.charAt(i);  
			switch  (c)  
			{  
				case  '\\': escape = true; break;  
				case  'u':  
				case  'U':  
				if(escape)  
				{  
					try  
					{  
						 sb.append((char)Integer.parseInt(s.substring(i+1,i+5),16));  
						 escape  =  false;  
					}  
					catch(NumberFormatException e)  
					{  System.out.println("DealString::UnicodetoGB(String)运行时出错："+e+"并抛出新的IllegalArgumentException异常.");
						 throw new IllegalArgumentException();  
					}  
					i += 4;  
				}  
				else  
				{    
					sb.append(c);  
				}  
				break;  
				default:sb.append(c); break;
			}  
		} 
		return  sb.toString();  
	} 
	/*将str中重复的去掉*/
	public String strDistinct(String str)
	{
		String[] strArr=str.split(",");
		String   strAim = ",";
		for(int i=0;i<strArr.length;i++)
		{
			if(strArr[i].equals(""))
				continue;
			if (strAim.indexOf(","+strArr[i]+",")==-1)
			{
				strAim = strAim + strArr[i] + ",";
			}
		}
		if(!strAim.equals(","))
		strAim = strAim.substring(1,strAim.length()-1);
		else strAim = "";
		return strAim;
	}

	/**字符转化为ASCII*/
	public int toASCII(char c)
	{
		int i = c;
		return i;
	}

	/**取得字符字节长度*/
	public int byteLength(String str)
	{
		return ((str.getBytes()).length);
	}

	/**取得字符串从头开始指定长度子串*/	
	public String strByteCopy(String str,int nEnd)
	{
		if(nEnd==0)
			return "";
		byte[] byteStr=str.getBytes();
		int k=byteStr.length;
		String strSub=new String(byteStr,0,nEnd<k?nEnd:k);
		if (strSub.length()==0) strSub=new String(byteStr,0,nEnd-1);
		return strSub;
	}
        public boolean strMatch(String motherStr,String childStr)
        {
          boolean matched=false;
          int mLength=motherStr.length();
          int cLength=childStr.length();
          int starWith;
          if(mLength>=cLength){
            starWith=mLength-cLength;
            for(int i=0;i<=starWith;i++){
              matched=motherStr.startsWith(childStr,i);
              if(matched)break;
            }
          }
          return matched;
        }
/*

	//把字符串转化为以ＵＴＦ８编码
	public String toUtf8String(String s) {
                 StringBuffer sb = new StringBuffer();
                 for (int i=0;i<s.length();i++) {
                   char c = s.charAt(i);
                   if (c >= 0 && c <= 255) {
                     sb.append(c);
                   }
                   else {
                     byte[] b;
                     try {
                       b = Character.toString(c).getBytes("utf-8");
                     }
                     catch (Exception ex) {
                       System.out.println(ex);
                       b = new byte[0];
                     }
                     for (int j = 0; j < b.length; j++) {
                       int k = b[j];
                       if (k < 0)
                         k += 256;
                       sb.append("%" + Integer.toHexString(k).
                                 toUpperCase());
                     }
                   }
                 }
                 return sb.toString();
       }
*/
	public Vector simplify(String[] str){
		Vector vect = new Vector();
		for(int i=0;i<str.length;i++)
			vect.add(str[i]);
		for(int i=0;i<vect.size();i++){
			String[] s1 = ((String)vect.get(i)).split("_");
			for(int j=i+1;j<vect.size();){
				boolean out = true;
				String[] s2 = ((String)vect.get(j)).split("_");
				for(int k=0;k<s1.length;k++){
					if(!s1[k].equals(s2[k])&&!s1[k].equals("0")){
						out = false;
						break;
					}
				}
				if(out)
					vect.remove(j);
				else
					j++;
			}
		}
		return vect;
	}
	public Vector simplify(Vector vstr){
		Vector vect = new Vector();
		for(int i=0;i<vstr.size();i++)
			vect.add(vstr.get(i));
		for(int i=0;i<vect.size();i++){
			String[] s1 = ((String)vect.get(i)).split("_");
			for(int j=i+1;j<vect.size();){
				boolean out = true;
				String[] s2 = ((String)vect.get(j)).split("_");
				for(int k=0;k<s1.length;k++){
					if(!s1[k].equals(s2[k])&&!s1[k].equals("0")){
						out = false;
						break;
					}
				}
				if(out)
					vect.remove(j);
				else
					j++;
			}
		}
		return vect;
	}
	

	public static void main(String args[]) throws Exception
	{
		DealString mb = new DealString();
		System.out.println("begin\r\n\r\n");
		
	/*	System.out.println("Please  input  string  to  be  translated");  
        String  oldStr  =  null;  
		java.io.BufferedReader in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));  
		oldStr  =  in.readLine(); 
		while(oldStr!=null)  
		{  			                           
			System.out.println(mb.UnicodetoGB(oldStr)); 
			oldStr  =  in.readLine(); 
		}   
*/
		System.out.println(mb.toMKByte(12345678));
		System.out.print("fdsafd");
		System.out.print("\rggggggggggggggg");
		System.out.println("\rend                 ");
	}

}
