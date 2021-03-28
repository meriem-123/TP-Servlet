package mesCommandes;


import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.jdi.connect.spi.Connection;

public class EnregistrerCommande extends HttpServlet {
	 java.sql.Connection connexion=null;
	 java.sql.Statement stmt=null;
	 PreparedStatement pstmt=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	 { String nom = null;
	 int nbreProduit = 0;
	 Cookie[] cookies = request.getCookies();
	 boolean connu = false;
	 nom = Identification. chercheNom (cookies);
	 OuvreBase();
	 AjouteNomBase(nom);
	 
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 out.println("<html>");
	 out.println("<body>");
	 out.println("<head>");
	 out.println("<title> votre commande </title>");
	 out.println("</head>");
	 out.println("<body bgcolor=\"white\">");
	 
	 out.println("<h3>" + "Bonjour " + nom + " voici ta nouvelle commande" + "</h3>");
	 HttpSession session = request.getSession();
	 Enumeration names = session.getAttributeNames();
	 while (names.hasMoreElements()) {
	 nbreProduit++;
	 String name = (String) names.nextElement(); 
	 String value = session.getAttribute(name).toString();
	 out.println(name + " = " + value + "<br>");
	 }
	 AjouteCommandeBase(nom,session);
	 out.println("<h3>" + "et voici " + nom + " ta commande complete" + "</h3>");
	 MontreCommandeBase(nom, out);
	 out.println("<A HREF=vider> Vous pouvez commandez un autre disque </A><br> ");
	 out.println("</body>");
	 out.println("</html>");
	 }
	 protected void OuvreBase() {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/magasin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	 connexion.setAutoCommit(true);
	 stmt = connexion.createStatement();
	 }
	 catch (Exception E) { 
	 log(" -------- probeme " + E.getClass().getName() );
	 E.printStackTrace();
	 }
	 }
	 protected void fermeBase() {
	 try {
	 stmt.close(); 
	 connexion.close(); 
	 }
	 catch (Exception E) { 
	 log(" -------- probeme " + E.getClass().getName() );
	 E.printStackTrace();
	 }
	 }
	 protected void AjouteNomBase(String nom) {
		 try {
		 ResultSet rset = null;
		 pstmt= connexion.prepareStatement("select numero from personnel where nom=?");
		 pstmt.setString(1,nom);
		 rset=pstmt.executeQuery();
		 if (!rset.next()) 
		 stmt.executeUpdate("INSERT INTO personnel(nom) VALUES ('" + nom + "' )" );
		 }
		 catch (Exception E) {
		 log(" - probeme " + E.getClass().getName() );
		 E.printStackTrace();
		 }
		 }
		 protected void AjouteCommandeBase(String nom, HttpSession session ) {
		 // ajoute le contenu du panier dans la base 
			 Enumeration names = session.getAttributeNames();
				int num=0;
				try {
					ResultSet rset = null;
					pstmt= connexion.prepareStatement("select numero from personnel where nom=?");
					pstmt.setString(1,nom);
					rset=pstmt.executeQuery();
					if (rset.next()) num =rset.getInt("numero");
					if(num!=0) {
						while (names.hasMoreElements()) {
							String name = (String) names.nextElement();
							String value = session.getAttribute(name).toString();
							pstmt= connexion.prepareStatement("INSERT INTO COMMANDE (ARTICLE,QUI) VALUES (?,?)");
							pstmt.setString(1, value);
							pstmt.setInt(2, num);
							pstmt.executeUpdate();
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		 }
		 protected void MontreCommandeBase(String nom, PrintWriter out) {
		 // affiche les produits présents dans la base
			 int num=0;
				ResultSet rset = null;
				try {
					pstmt= connexion.prepareStatement("select numero from personnel where nom=?");
					pstmt.setString(1,nom);
					rset=pstmt.executeQuery();
					if (rset.next()) num =rset.getInt("numero");
					if(num!=0) {
						pstmt=connexion.prepareStatement("SELECT * FROM COMMANDE WHERE QUI=?");
						pstmt.setInt(1, num);
						ResultSet rset2 =null;
						rset2=pstmt.executeQuery();
						out.println("<table border=1>");
						while(rset2.next()) {
							out.println( "<tr> <td>" + rset2.getInt("num")+ "</td>");
							out.println("<td>"+rset2.getString("article")+"</td>" );
							out.println("<td>"+rset2.getInt("qui")+"</td></tr>");
						}
						out.println("</table> </form>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
		 {
		 doGet(request, response);
		 }
		 }
