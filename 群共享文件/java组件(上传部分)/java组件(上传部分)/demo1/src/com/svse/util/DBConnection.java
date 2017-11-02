package com.svse.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnection
{
	   Connection conn=null;

	   public Connection  getConnection()
	   {
		
	       try 
	       {  //�����ļ�
	    	   Properties prop=new Properties();
	    	   InputStream is=this.getClass().getResourceAsStream("/systemconfig.properties");
	    	   //���������ж�ȡ�����б�
	    	   prop.load(is);
	    	   
	           Class.forName(prop.getProperty("driver"));
	           conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
	        
	          
	       } 
	       catch (Exception e) 
	       {
	           e.printStackTrace();
	           System.out.println("���ݿ������쳣��");
	       }
	       return conn;
	   }
	  
	  
   }
