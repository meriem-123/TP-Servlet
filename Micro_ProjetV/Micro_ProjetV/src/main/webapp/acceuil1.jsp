<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>acceuil1</title><style>
h1{
margin-left: 20px;
 border-bottom : groove blue 1px;
 color : blue;
 font-style:italic;
 padding-bottom: 10px;
 
}
.links{
 margin: 20px;

}
a{
color : purple;
}
</style>

</head>
<body>
<h1> <% request.getSession(false);  
	String n=(String)session.getAttribute("username");  
	out.print("Bonjour "+n);  %> 
</h1>
	
<div class="links">

<a href="WebForm1.jsp">Consulter le Catalogue</a><br>
<h2>           </h2>
<a href="inscrire.jsp">Suivre vos Commandes</a><br>
<h2>           </h2>

<a href="inscrire.jsp">Visualiser votre panier</a>
</div>


</body>
</html>