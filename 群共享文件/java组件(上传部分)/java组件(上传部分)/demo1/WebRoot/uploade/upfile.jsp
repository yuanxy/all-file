<%@page language="java" contentType="text/html;charset=GBK"%>
<jsp:directive.page import="com.svse.util.DealString"/>
<jsp:directive.page import="com.jspsmart.upload.SmartUpload"/>

<% 
	DealString ds = new DealString();
	//�ϴ��ļ���Ϣ
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
			.getParameter("savedir")); //�ϴ�·��
	// System.out.println("�ļ��ϴ�·��"+savedir);
	SmartUpload mySmartUpload = new SmartUpload();

	//�ϴ��ļ�
	mySmartUpload.initialize(config, request, response);
	mySmartUpload.upload();

	//�¾��ļ�����
	String upfile = mySmartUpload.getFiles().getFile(0).getFileName();
	String ext = ds.toString(upfile.substring(upfile.lastIndexOf("."))); //ȡ��׺��
	String upfile_new = ds.getDateTime().replaceAll(":", "") + ext;

	//�����С
	int filesize = mySmartUpload.getFiles().getFile(0).getSize();
	cursize += filesize;
	//System.out.println("�ļ��ϴ�·��"+upfile_new);
	//System.out.println("ԭ�ļ��ļ�����"+upfile);
	//System.out.println("���ļ��ļ�����"+upfile_new);
	int s = 0;

	String nn = "/" + upfile_new;
	String mm = ds.toString((String) request.getParameter(nn));

	//vo.setGg_fj(mm);//�õ��ϴ�������·��
	//vo.setGg_upname(upfile);//�õ�ԭ���ϴ��ļ�������

	//�����ļ�
	int count1 = mySmartUpload.save(savedir + upmonth);

	strfile += "," + upfile;
	strname += "," + upmonth + upfile_new;
	// strname = upmonth + upfile_new;
	strsize += "," + filesize;

	//�������ļ�
	java.io.File f2 = new java.io.File(savedir + upmonth + upfile_new);
	if (f2.exists())//���ļ�������
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

