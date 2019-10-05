<html>
<body>
<marquee>Student Login</marquee>
<form name="studLoginForm" action="studController">
<%= request.getAttribute("errMsg") %>
<table border="1">

<tr><td>ID</td><td><input type="text" name="studId"/></td></tr>
<tr><td>Username</td><td><input type="text" name="studUn"/></td></tr>
<tr><td>Name</td><td><input type="text" name="studName"/></td></tr>
<tr><td>Password</td><td><input type="password" name="studPwd"/></td></tr>
<tr><td colspan="2"><input type="submit" value="submit"/></td></tr>

<tr><td><a href="index.jsp">Back to Home page</a></td></tr>
</table>
</form>
</body>
</html>