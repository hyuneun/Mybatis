<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="pack.business.DataDto"/>
<jsp:setProperty property="*" name="dto"/>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%
boolean b = processDao.insertData(dto);
response.sendRedirect("list.jsp");
%>
