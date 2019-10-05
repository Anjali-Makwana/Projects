<%@page import="com.bean.Bean"%>
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
<table>
<tr>
<%List<Bean> l=(List<Bean>)request.getAttribute("list"); %>
<%for(Bean b:l){ %>

<td><%=b.getId() %> </td>
<td> <%=b.getName() %> </td>
<td> <a href="Delete_Controller?&del=<%=b.getId()%>">Delete</a> </td>
<td> <a href="Update_Controller?&param=<%=b.getId()%>">Edit</a> </td>
</tr>
<%} %>
</table>

</body>
</html>