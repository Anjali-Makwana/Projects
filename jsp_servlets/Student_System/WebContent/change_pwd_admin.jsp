<%= request.getAttribute("errMsg") %>
<form action="changePwdAdminController">
<table border="1">
<tr><td> Enter your old password </td><td><input type="password" name="oldPwd"></td></tr>
<tr><td> Enter your new password </td><td><input type="password" name="newPwd"></td></tr>
<tr> <td colspan="2"><input type="submit"></td></tr>
</table>

</form>