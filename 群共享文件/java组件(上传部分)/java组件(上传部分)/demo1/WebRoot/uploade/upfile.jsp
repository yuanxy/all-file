<%@page language="java" contentType="text/html;charset=GBK"%>
<jsp:directive.page import="com.svse.util.DealString"/>
<jsp:directive.page import="com.jspsmart.upload.SmartUpload"/>

<% 
	DealString ds = new DealString();
	//上传文件信息
	String strfile = ds.toGBK((String) request.getParameter("strfile"));
	String strname = ds.toGBK((String) request.getParameter("strname"));

	String strsize = ds.toString((String) request
			.getParameter("strsize"));
	String sumsize = ds.toString((String) request
			.getParameter("sumsize"));
	String onesize = ds.toString((String) request
			.getParameter("onesize"));
	String upmonth = ds.toString((String) request
			.getParameter("upmonth"));
	long cursize = Long.parseLong(ds.toString((String) request
			.getParameter("cursize")));
	String count = ds.toString((String) request.getParameter("count"));
	String savedir = ds.toString((String) request
			.getParameter("savedir")); //上传路径
	// System.out.println("文件上传路："+savedir);
	SmartUpload mySmartUpload = new SmartUpload();

	//上传文件
	mySmartUpload.initialize(config, request, response);
	mySmartUpload.upload();

	//新旧文件名称
	String upfile = mySmartUpload.getFiles().getFile(0).getFileName();
	String ext = ds.toString(upfile.substring(upfile.lastIndexOf("."))); //取后缀名
	String upfile_new = ds.getDateTime().replaceAll(":", "") + ext;

	//计算大小
	int filesize = mySmartUpload.getFiles().getFile(0).getSize();
	cursize += filesize;
	//System.out.println("文件上传路："+upfile_new);
	//System.out.println("原文件文件名："+upfile);
	//System.out.println("新文件文件名："+upfile_new);
	int s = 0;

	String nn = "/" + upfile_new;
	String mm = ds.toString((String) request.getParameter(nn));

	//vo.setGg_fj(mm);//得到上传完整的路径
	//vo.setGg_upname(upfile);//得到原来上传文件的名字

	//保存文件
	int count1 = mySmartUpload.save(savedir + upmonth);

	strfile += "," + upfile;
	strname += "," + upmonth + upfile_new;
	// strname = upmonth + upfile_new;
	strsize += "," + filesize;

	//重命名文件
	java.io.File f2 = new java.io.File(savedir + upmonth + upfile_new);
	if (f2.exists())//新文件名存在
	{
		f2.delete();
	}
	java.io.File f1 = new java.io.File(savedir + upmonth + upfile);
	f1.renameTo(new java.io.File(savedir + upmonth + upfile_new));


	String go = "uploade.jsp?onesize=" + onesize + "&sumsize="
			+ sumsize + "&upmonth=" + upmonth + "&count=" + count
			+ "&cursize=" + cursize + "&strsize=" + strsize
			+ "&strname=" + strname + "&strfile="
			+ ds.toUtf8String(strfile) + "&savedir=" + savedir + "&lj="
			+ mm;
	response.sendRedirect(go);


%>

