<html>
<body>
<marquee>Admin Login</marquee>
<form name="adminLoginForm" action="adminController">
<%= request.getAttribute("errMsg") %>
<table border="1">

<tr><td>Username</td><td><input type="text" name="adminUn"/></td></tr>
<tr><td>Password</td><td><input type="password" name="adminPwd"/></td></tr>
<tr><td colspan="2"><input type="submit"/></td></tr>

<tr><td><a href="index.jsp">Back to Home page</a></td></tr>
</table>
</form>
</body>
</html>