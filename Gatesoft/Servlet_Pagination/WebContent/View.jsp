<%@page import="com.bean.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border='1' cellpadding="4" width="20%">

<%List<Emp> list=(List<Emp>)request.getAttribute("list"); %>
<tr>
<th>EMP_ID</th>
<th>EMP_NAME</th>
</tr>

<% for(Emp e:list){ %>
<tr>
<td><%=e.getEmpid() %></td>
<td><%=e.getEmpname() %></td>
</tr>
<%} %>

</table>

<h3>
<a href='ViewEmpData?page=1'>1</a>
<a href='ViewEmpData?page=2'>2</a>
<a href='ViewEmpData?page=3'>3</a>
</h3>
</body>
</html>