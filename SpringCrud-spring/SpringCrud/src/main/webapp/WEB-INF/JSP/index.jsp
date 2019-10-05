<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function saveData() {
		var array = {};
		$('#springcrud').find('input').each(function() {
			array[$(this).attr('id')] = $(this).val();
		});
		$.ajax({
			url : "/saveData",
			type : 'Post',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(array),
			success : function(resp) {
				console.log(resp);
			}
		});
	}
</script>
</head>
<body>
<table id="myTable">
		<thead>
			<tr>
				<th width="12%">User ID</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Active</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="i" items="${displaylist}">
			<tr>
				<td>${i[0]}</td>
				<td>${i[1]}</td>
				<td>${i[2]}</td>
				<td>${i[3]}</td>
				<td>${i[4]}</td>
			</tr>
		</c:forEach>
		</tbody>
</table><br/><br/><br/><br/>
	<form>
		<div id="springcrud">
			Name<input type="text" id="name" name="name">
			Password<input type="password" id="password" name="password">
			Email<input type="text" id="email" name="email">
			Contact<input type="text" id="contact" name="contact"> 
			<a href="javaScript:saveData()">Submit</a>
		</div>
	</form>
</body>
<script type="text/javascript" src="jquery/jquery.min.js"></script>
</html>