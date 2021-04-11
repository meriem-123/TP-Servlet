<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>s'inscrire</title>
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
.input1{
width: 75px;
float : left;
margin-right : 20px;
}
.input2{
width: 200px;
}
.att{
float : left;
color : red;
font-size : 12px;
}
.tab{
margin-bottom : 100px;
}
</style>

</head>
<body>
<h1>Inscriez-vous</h1>
<div class="foo">
<form action="<%= request.getContextPath() %>/inscrire" method="POST">
<table style="with: 50%" class="tab">
				<tr >
					<td><label>Nom :</label></td>
					<td><input type="text" name="Nom" class="input2"/></td>
				</tr>
				<tr>
					<td><label>Prénom :</label></td>
					<td><input type="text" name="Prenom" class="input2"/></td>
					
				</tr>
				<tr>
					<td><label>Adresse :</label></td>
					<td><input type="text" name="Adresse" class="input2" /></td>
					
					
				</tr>
				<tr>
					<td><label></label></td>
					<td><table><tr><td><input type="text" name="CodePostal" class="input1" /></td><td><input type="text" name="Ville" class="input1" /></td></tr></table></td>
					
					
				</tr>
				<tr >
					<td><label>Télephone :</label></td>
					<td><input type="text" name="Tel" class="input2"/></td>
				</tr>
				<tr >
					<td><label>Email :</label></td>
					<td><input type="text" name="Email" class="input2"/></td><td><label class="att">*</label></td>
				</tr>
				
				<tr >
					<td><label>Mot de passe :</label></td>
					<td><input type="text" name="MotPasse" class="input2"/></td><td><label class="att">*</label></td>
					<td><input type="submit" value="OK" class="som" /></td>
				</tr>
				
				</table>
				
				<label class="att">* Mot de passe obligatoire</label><br>
				<label class="att">* E-mail erroné</label>
				</form>
				
				
				</div>

</body>
</html>