<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	  <script type="text/javascript" src="${pageContext.request.contextPath }/js/myupload.js"></script>
	</head>

	<body>
		<form action="./MyServlet?action=add" method="post">
			<table border="1" align="center" width="60%">
				<tr>
					<td>
						标题：
					</td>
					<td>
						<input type="text" name="w_title">
					</td>
				</tr>

				<tr>
					<td>
						附件：
					</td>
					<jsp:include flush="true" page="uploade/myfile.jsp"></jsp:include>
				</tr>

				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="确定">
					</td>

				</tr>
			</table>
		</form>
	</body>
</html>
