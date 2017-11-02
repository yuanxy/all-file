<%@ page contentType="text/html;charset=GBK"%>
<%@page
	import="java.util.*,java.text.*,java.io.*"%>
<jsp:directive.page import="com.svse.util.DealString"/>
<%
	try
	{ 
		DealString ds = new DealString();

		//上传文件信息
		String k_id = ds.toGBK((String) request.getParameter("k_id"));
		String delfile = ds.toString(request.getParameter("delfile"));
		int delsize = Integer.parseInt(ds.toString(request
		.getParameter("delsize")));
		String strfile = ds.toGBK((String) request
		.getParameter("strfile"));
		String strname = ds.toGBK((String) request
		.getParameter("strname"));
		String strsize = ds.toString((String) request
		.getParameter("strsize"));
		String onesize = ds.toString((String) request
		.getParameter("sumsize"));
		String sumsize = ds.toString((String) request
		.getParameter("onesize"));
		String upmonth = ds.toString((String) request
		.getParameter("upmonth"));
		long cursize = Long.parseLong(ds.toString((String) request
		.getParameter("cursize")));
		String count = ds.toString((String) request
		.getParameter("count"));

		//取得附件的位置	
		String savedir = ds.toString((String) request
		.getParameter("savedir")); //上传路径

		//delete file
		File file = new File(savedir + delfile);
		if (file.exists())
		{
			file.delete();

			//把原文件名串分割成数组
			if (strfile.charAt(0) == ',')
			{
		strfile = strfile.substring(1, strfile.length());
		strname = strname.substring(1, strname.length());
		strsize = strsize.substring(1, strsize.length());
			}
			//把改名后的文件名串分割成数组
			String[] newfile = strfile.split(",");
			String[] newname = strname.split(",");
			String[] newsize = strsize.split(",");
			strfile = "";
			strname = "";
			strsize = "";
			cursize = 0;

			for (int i = 0; i < newname.length; i++)
			{
		if (!newname[i].equals(delfile))
		{
			strfile = strfile + "," + newfile[i];
			strname = strname + "," + newname[i];
			strsize = strsize + "," + newsize[i];
			cursize += Long.parseLong(newsize[i]);
		}

			}
		}
		String go = "uploade.jsp?k_id=" + k_id + "&onesize=" + onesize
		+ "&sumsize=" + sumsize + "&upmonth=" + upmonth
		+ "&savedir=" + savedir + "&count=" + count
		+ "&cursize=" + cursize + "&strsize=" + strsize
		+ "&strname=" + strname + "&strfile="
		+ ds.toUtf8String(strfile);
		response.sendRedirect(go);

	}
	catch (Exception e)
	{
		out.print(e);
	}
%>
