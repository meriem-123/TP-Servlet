package mesCommandes;

import java.io.IOException;

import java.io.PrintWriter;

import javax.sql.rowset.serial.SerialException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class InscriptionClient extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String nomRecu = null, motPasseRecu = null;
		String nomCookie = null, motPasseCookie = null;
		// initialisation cookies et parametres
				
				nomRecu=request.getParameter("nom");
				motPasseRecu=request.getParameter("motdepasse");
				
				Cookie[] cookies = request.getCookies();
				if(cookies!=null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("nom")) {
							nomCookie=cookie.getValue();
						}
						else if(cookie.getName().equals("motdepasse")){
							motPasseCookie=cookie.getValue();
						}
					}
				}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		
		if(nomCookie == null && nomRecu == null ) {
			//case 1
			out.println("<html>");
			out.println("<body>");
			out.println("<head>");
			out.println("<title> inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >");
			out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
			out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
			out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
			out.print(" <form action='sinscrire' method='GET' > ");
			out.println("nom");
			out.println("<input type='text' size='20' name='nom' >");
			out.println("<br>");
			out.println("mot de passe");
			out.println("<input type='password' size='20' name='motdepasse'> <br>");
			out.println("<input type='submit' value='inscription'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			nomRecu = request.getParameter("nom");
			motPasseRecu = request.getParameter("motdepasse");
			} else if (nomCookie==null && nomRecu!="" ){
				//case 2
				
				Cookie ck1= new Cookie("nom",nomRecu);
				Cookie ck2=new Cookie("motdepasse",motPasseRecu);
				response.addCookie(ck1);
				response.addCookie(ck2);
				
				
			}else if (identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie))
			{
				// Case 4 
				response.sendRedirect("/OrderManagmentV/achat");
				}
				else {
				// Case 3
					
					if(nomRecu==null) {
						nomRecu = "";}
					
					out.println("<html>");
					out.println("<body>");
					out.println("<head>");
					out.println("<title> Login d'un client </title>");
					out.println("</head>");
					out.println("<body bgcolor='white' >");
					out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
					out.println("<h3>" + "Bonjour, vous devez vous s'identifier " + "</h3>");
					out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
					out.print(" <form action='sinscrire' method='GET' > ");
					out.println("nom");
					out.println("<input type='text' size='20' name='nom' value='"+nomRecu+"'>");
					out.println("<br>");
					out.println("mot de passe");
					out.println("<input type='password' size='20' name='motdepasse'> <br>");
					out.println("<input type='submit' value='Login'>");
					out.println("</form>");
					out.println("</body>");
					out.println("</html>");
				}
				}
				public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
					doGet(request, response);
				}
				
				
				boolean identique (String recu, String cookie) {
				return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
				}

		}
		
		
	

