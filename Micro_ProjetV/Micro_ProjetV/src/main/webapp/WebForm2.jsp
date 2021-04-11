<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebForm2</title>
<style >
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
font-style : italic;
font-size : 15px;
}
.foo{
display : block;
text-align : center;
}

.input2{
width: 150px;
margin-left : 7px;
margin-right : 7px;
}
.att{
float : left;
color : red;
font-size : 12px;
}
.tab{
margin-bottom : 50px;
}
.links{
 margin: 20px;

}
a{
color : purple;
padding : 60px;
font-size : 12px;
}
img{
border : groove black 1px;
}
</style>
</head>
<body>
<h1>Détail de l'article</h1>
<div class="foo">
<form action="">

<table style="with: 50%" class="tab">
				<tr >
					<td><img alt="" src="${param.photo}" width="90px"></td>
					<td></td>
				</tr>

				<tr>
					<td><label>Référence :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="${param.id}"/></td>
					<td><label>Titre :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="${param.titre}"/></td>
					
				</tr>
				<tr>
					<td><label>Auteur :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="Min Yoongi"/></td>
					<td><label>Editeur :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="Jin Hit"/></td>
					
				</tr>
				<tr>
					<td><label>Quentité en stock :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="${param.stock}"/></td>
					<td><label>Pour le prix modique de :</label></td>
					<td><input type="text" name="prenom" class="input2" placeholder="${param.prix}"/></td>
					
				</tr>
				
				
				</table>
				<div class="links">
				<a href="">Retour</a>
				<a href="">Ajouter au panier</a>
				</div>
				</form>
				</div>
				

</body>
</html>