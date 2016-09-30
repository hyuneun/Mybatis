<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="pack.business.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="processDao" class="pack.business.ProcessDao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<a href="ins.jsp">회원추가</a>
<table>
	<tr><th>id</th><th>na</th><th>pw</th><th>date</th></tr>
<%
List<DataDto> list = processDao.selectDataAll();

if(list == null){
	out.println("<tr><td colspan='4'>자룡벗음</td></tr>");
}else{
	for(DataDto d:list){
	%>
	<tr>
		<td><a href="del.jsp?id=<%=d.getId() %>"><%=d.getId() %></a></td>
		<td><a href="up.jsp?id=<%=d.getId() %>"><%=d.getName() %></a></td>
		<td><%=d.getPassword() %></td>
		<td><%=d.getRegdata() %></td>
	</tr>
	<%	
		
	}
}
%>
	<tr><td colspan="4">id클릭은 삭제</td></tr>
</table>
</head>
<body>
</body>
</html>