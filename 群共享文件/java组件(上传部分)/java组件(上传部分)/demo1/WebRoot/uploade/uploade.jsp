<%@page language="java" contentType="text/html;charset=gb2312"%>
<jsp:directive.page import="com.svse.util.DealString"/>

<% 
	DealString ds = new DealString();
	//上传文件信息
	String strfile = ds.toGBK((String) request.getParameter("strfile"));//上传文件的原名称
	String strname = ds.toGBK((String) request.getParameter("strname"));//上传文件更改后的名称

	String strsize = ds.toString((String) request
			.getParameter("strsize"));
	String cursize = ds.toString((String) request
			.getParameter("cursize"));
	String onesize = ds.toString((String) request
			.getParameter("onesize"));//一个文件的大小

	String sumsize = ds.toString((String) request
			.getParameter("sumsize"));//总共上传文件的大小
	String upmonth = ds.toString((String) request
			.getParameter("upmonth"));//上传文件的年月日(如:2007/03/26)
	String count = ds.toString((String) request.getParameter("count"));
	String savedir = ds.toString((String) request
			.getParameter("savedir"));//上传路径
	String lj = ds.toString((String) request.getParameter("lj"));
	String err = ds.toString((String) request.getParameter("err"));

	if (!strname.equalsIgnoreCase(""))
	{
		String bb = strname.substring(1, strname.length());
		lj = bb;
	}
	else
	{
		lj = "";
	}

	boolean have = true;
	//把原文件名串分割成数组
	String[] t_strfile = strfile.split(",");
	String[] t_strname = strname.split(",");
	String[] t_strsize = strsize.split(",");
	if (!strfile.equals("")
			&& t_strfile.length == (Integer.parseInt(count) + 1)
			|| count.equals("1") && t_strfile.length == 1
			&& !strfile.equals("")) have = false;
%>
<html>
	<script language="JavaScript">
<!--

function closeWin(uploadfileName)
{
	if(lj!="")
	{
		window.opener.document.form1.strfile.value=lj;
	    window.close();	 
    }	
}
//-->
</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>文件上传</title>
		<link href="../css/z1.css" rel="stylesheet" type="text/css">
		<style type="text/css">
<!--
.style5 {font-size: 14px}
-->
<!--
.style6 {font-size: 12px}
-->
</style>
		<link href="../css/zi.css" rel="stylesheet" type="text/css">
	</head>
	<BODY background="../images/soft/010.jpg" leftmargin=15 topmargin=15
		onload="closeWin('<%=lj%>');">
		<CENTER>
			<FIELDSET align=left>
				<LEGEND align=left>
					<span class="style6"><font color="">联系记录上传面板</font>
					</span>
				</LEGEND>
				<br>
				<TABLE cellSpacing=0 borderColorDark=#ffffff cellPadding=0
					width="90%" align=center borderColorLight=#0a426b border=1>
					<TBODY>

						<tr align="center" valign="middle" bgcolor="#A5DAE0" class="zi">
							<td width="50%" height="25" align=center bgColor="">
								<span class="zi"><B><font color="">文件名称</font>
								</B>
								</span>
							</td>
							<td width="30%" align=center bgColor="">
								<span class="style5"><B>
								</span><span class="zi"><font color=""><strong>共</strong>
								</font>
								</span><font color=""><span class="style5"><%=ds.toMKByte(Long.parseLong(cursize))%>
								</span>
								</font>
							</td>
							<td width="20%" align=center>
								<span class="zi"><B><font color="">操作</font>
								</B>
								</span>
							</td>
						</tr>
						<%
							int c = 0;
							for (int i = 0; i < t_strfile.length; i++)
							{

								if (!t_strfile[i].equals(""))
								{
									c++;
						%>

						<tr bgcolor="EFFBFF" class="zi">
							<td height="25" align=center bgColor="">
								<span class="style5"><font color=""><%=t_strfile[i]%>
								</span>
							</td>

							<td align=center>
								<span class="style5"><font color=""><%=ds.toMKByte(Long.parseLong(t_strsize[i]))%>
								</span>
							</td>

							<td align=center>
								<span class="style5"><font color="">
								</span><span class="zi"><a href="#"
									onclick="del('<%=t_strname[i]%>','<%=t_strsize[i]%>');return false;">删除</a>
								</span>
							</td>
						</tr>
						<%
							}
							}
							for (int i = c; i < Integer.parseInt(count) - 9; i++)
							{
						%>

						<tr bgcolor="EFFBFF" class="zi">
							<td height="25" align=left bgColor="">
								<span class="style5"><font color="">&nbsp;
								</span>
							</td>

							<td align=center>
								<span class="style5"><font color="">&nbsp;
								</span>
							</td>

							<td align=center>
								<span class="style5"><font color="">&nbsp;
								</span>
							</td>
						</tr>
						<%
						}
						%>
					
				</table>

				<br>
				<form name="form1" method="post" target="_self"
					enctype="multipart/form-data">
					<table width="70%">
						<TR>
							<TD>
								<input type="file" name="file11" size=20>
								<!--上传得新文件-->
								<%
									if (have)
									{
								%>
								<input type="button" value="上 传" onclick="upload();">
								<%
								}
								%>
								<input type=hidden name="txt_file11" size=20>
								<input type=hidden name="txt_name11" value="">
								<input type=hidden name="strfile" value="<%=lj%>">
								<input type=hidden name="strname" value="<%=strname%>">
								<input type=hidden name=strsize value="<%=strsize%>">
								<input type=hidden name=cursize value="<%=cursize%>">
								<input type=hidden name=onesize value="<%=onesize%>">
							</td>
							<td align=center width="20%">
								<input name="send" type="button" value="完 成" class=button1
									onclick="ok()">
							</td>
						</TR>
					</table>
					
				</form>

				
				<br>
			</fieldset>
	</body>
</html>
<script>

	//上传单个文件
	function upload()
	{		
		document.all.txt_file11.value = document.all.file11.value;
		if(document.all.file11.value=="")
			return false;
		
		//取新上传的文件后缀
		var name1 = document.all.txt_file11.value;
		var i = name1.lastIndexOf(".");
		name1 = name1.substring(i);


		//取原文件名
		var name2=document.all.file11.value;
		var j=name2.lastIndexOf("\\");
		name2=name2.substring(j+1);

		if(document.all.strname.value=="")
		{	
			document.all.txt_file11.value=name2;
		}
		else
		{		
			document.all.txt_file11.value=name2;
			
		}
		
		document.all.form1.action="upfile.jsp?onesize=<%=onesize%>&strfile=<%=strfile%>&strname=<%=strname%>&cursize=<%=cursize%>&strsize=<%=strsize%>&sumsize=<%=sumsize%>&upmonth=<%=upmonth%>&count=<%=count%>&savedir=<%=savedir%>&txt_file11="+document.all.txt_file11.value;
		document.all.form1.submit();
	}

	//完成上传
	function ok()
	{
		var strfile=document.all.strfile.value;
		var strname=document.all.strname.value;
		var strsize=document.all.strsize.value;
		var cursize=document.all.cursize.value;
		var onesize=document.all.onesize.value;
		if(strname.charAt(0)==',')
		 {
			strname=strname.substring(1,strname.length);
			strfile=strfile.substring(0,strfile.length);
			strsize=strsize.substring(1,strsize.length);
		 }
		opener.document.all.strfile.value=strfile;
		opener.document.all.strname.value=strname;
		opener.document.all.strsize.value=strsize;
		opener.document.all.cursize.value=cursize;
		opener.document.all.onesize.value=onesize;
	
		window.close();
	}

	//删除文件
	function del(str,delsize)
	{
		var where = "delfile.jsp?onesize=<%=onesize%>&delsize="+delsize+"&delfile="+str+"&strfile=<%=strfile%>&strname=<%=strname%>&cursize=<%=cursize%>&strsize=<%=strsize%>&sumsize=<%=sumsize%>&upmonth=<%=upmonth%>&savedir=<%=savedir%>&count=<%=count%>";
		window.location = where;
	}

	err = "<%=err%>";
	if(err!=null&err!="null")
	{
		if(err=="1")alert("该文件超过规定大小，不能上传!");
		else if(err=="2")alert("该文件将超过总空间，不能上传!");
	}
</script>
