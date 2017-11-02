<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="com.svse.util.DealString"/>
 <%
				String strfile = "";
				String upmonth = "";
				String strname = "";
				String strsize = ""; 
				String cursize = "0";
				DealString ds = new DealString();

				//初始化总大小
				int onesize = 20 * 1024 * 1024;
				int sumsize = 100 * 1024 * 1024;

				//初始化年月日-------------------------------------------------
				if (upmonth.equals(""))
				{
					upmonth = ds.getDateTime().substring(0, 10);
					upmonth = ds.Replace(upmonth, "-", "/") + "/";
				}
				//新建目录
				String savedir = request.getRealPath("/") + "lisheng/";
				savedir = savedir.replaceAll("\\\\", "/");
				//初始化年目录
				java.io.File f = new java.io.File(savedir + upmonth.substring(0, 5));
				if (!f.exists())
				{
					f.mkdir();
				}
				//初始化月目录
				f = new java.io.File(savedir + upmonth.substring(0, 8));
				if (!f.exists())
				{
					f.mkdir();
				}
				//初始化日目录
				f = new java.io.File(savedir + upmonth.substring(0, 11));
				if (!f.exists())
				{
					f.mkdir();
				}
			%>
         <td>
           
					<div align="left">
						<input type=text name=strfile class="zi" value="<%=strname%>" readonly size="40">
						<INPUT class="fmbtn" type="button" value="上 传" name="send" onclick="go()">
						<input type=hidden name=strname value="<%=strname%>">
						<input type=hidden name=strsize value="<%=strsize%>">
						<input type=hidden name=cursize value="<%=cursize%>">
						<input type=hidden name=onesize value="<%=onesize%>">
						<input type=hidden name=sumsize value="<%=sumsize%>">
						<input type=hidden name=savedir value="<%=savedir%>">
						<input type=hidden name=upmonth value="<%=upmonth%>">
						<input type=hidden name=count value="10">
						<input type=hidden name=goto value="">
						<input type=hidden name=action value="1">
					</div>
				</td>
       
