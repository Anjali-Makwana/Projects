<%@page import="com.bean.Bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Integer i=Integer.parseInt(request.getParameter("param")) ;%>
<%Bean bean=(Bean)request.getAttribute("b"); %>
<form  action="Update_Controller" method="post">
<table>

<tr>
<td>ID</td>
<td><input type="text" name="param" value="<%=bean.getId() %>"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" value="<%=bean.getName() %>"></td>
</tr>
<tr>
<td><input type="submit" value="submit">  </td>
</tr>
</table>
</form>
</body>
</html>