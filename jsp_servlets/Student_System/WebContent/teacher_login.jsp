<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automated Feedback System</title>
</head>
<body bgcolor="#cce6ff">
<br>
<marquee style="color: #FF0000; font-size: 25px">Teacher Login</marquee>
<br>
<form name="teacherLoginForm" action="teacherController">
<%= request.getAttribute("errMsg") %>

<table border="3" align="center" cellpadding="8px" cellspacing="5px" style="background-color: #ffe6e6; font-size: 20px">
<tr><td>Username</td><td><input type="text" name="teacherUn"/></td></tr>
<tr><td>Password</td><td><input type="password" name="teacherPwd"/></td></tr>
<tr><td colspan="2"><input type="submit"/></td></tr>

<tr><td><a href="index.jsp">Back to Home page</a></td></tr>
</table>
</form>
</body>
</html>