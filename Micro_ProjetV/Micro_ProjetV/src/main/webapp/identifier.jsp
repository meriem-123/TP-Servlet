<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>identifier</title>
<style>
h1{
	text-align : center;
	font-weight : bolder;
	font-size :70px;
	color : purple;
	font-style :italic;
	

}

form{
display : inline-block;
}

.som{
margin-left: 60px;
min-width : 100px;
}

label{
float : left;
color : blue;
font-weight : bolder;
}

.foo{
display : block;
text-align : center;
}
</style>
</head>
<body>
<h1>Identifiez-vous</h1>
<div class="foo">
<form action="<%= request.getContextPath() %>/identifier" method="POST">
<table style="with: 50%">
				<tr class="tt">
					<td><label>Email :</label></td>
					<td><input type="text" name="Email" /></td>
				</tr>
				<tr>
					<td><label>Mot de passe :</label></td>
					<td><input type="password" name="MotPasse" /></td>
					<td><input type="submit" value="OK" class="som" /></td>
				</tr>
				</table>
				</form>
				</div>
</body>
</html>