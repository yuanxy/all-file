<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/c.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


	</head>

	<body>
		<table border="1" align="center" width="60%">
			<tr>
				<td align="center">
					编号
				</td>
				<td  align="center">
					标题
				</td>
				<td  align="center">
					下载
				</td>
			</tr>
			<c:forEach var="x" items="${myall}">
				<tr>
					<td  align="center">
						${x.w_id }
					</td>
					<td  align="center">
						${x.w_title }
					</td>
					<td  align="center">
						<a href="${pageContext.request.contextPath }/lisheng/${x.w_lj }">下载</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
			  <td colspan="3" align="center"><a href="addwen.jsp">增加</a></td>
			</tr>
		</table>
	</body>
</html>
