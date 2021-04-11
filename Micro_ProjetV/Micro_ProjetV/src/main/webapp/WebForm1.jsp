<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebForm1</title>
<style >
h1{
	text-align : center;
	font-weight : bolder;
	font-size :70px;
	color : purple;
	font-style :italic;

}
.lab2{

 
 color : blue;
 font-style:italic;
 
 font-size :20px;
 font-weight : bolder;
 margin-right : 30px;
 }
 .navbar{
 
 padding-bottom: 10px;
 margin-left: 20px;
 }
 .lab1{
 color : orange;
 font-style:italic;
 
 font-size :18px;
 font-weight : bolder;
 margin-right : 30px;
}
.tabb{
 margin :10px 0 0 20px;

 }
</style>
</head>

<body>
<sql:setDataSource
    var="myDS"
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/micro-projetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
    user="root" password="justpass"
/>
<sql:query var="listArticle" dataSource="${myDS}">
    SELECT * FROM articles;
</sql:query>

	<h1>Catalogue</h1>
	<div class="navbar">
		<label class="lab2">Choisissez le genre :</label>
		<select name="genre" id="genre">
           <option value="pop">POP</option>
           <option value="edm">EDM</option>
           <option value="rnb">R&B</option>
           <option value="ballads">Ballads</option>
           <option value="rap">HipHop/RAP</option>
       </select>
    </div>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr >
		<td><label class="lab1">Référence</label></td>
		<td><label class="lab1">Titre</label></td>
		<td><label class="lab1">Prix</label></td>
		<td><label class="lab1">Stock</label></td>
		<td><label class="lab1">Categorie</label></td>
		<td><label class="lab1">Photo</label></td>
		<td></td>
	</tr>
	<c:forEach var="article" items="${listArticle.rows}">
		<tr>
			<td><a href="WebForm2.jsp?id=${article.CodeArticle}&titre=${article.Titre}&prix=${article.Prix}&stock=${article.Stock}&photo=${article.Photo}"><c:out value="${article.CodeArticle}" /></a></td>
			<td><c:out value="${article.Titre}" /></td>
			<td><c:out value="${article.Prix}" /></td>
			<td><c:out value="${article.Stock}" /></td>
			<td><c:out value="${article.Categorie}" /></td>
			<td><img src="${article.Photo}" type="image" width="50" height="50"></td>
			<td><label class="lab1"><a href="#">Ajouter au panier</a></label></td>
		</tr>
	</c:forEach>
</table>  
</body>
</html>