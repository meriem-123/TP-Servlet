package com.meriem.Controllers;

import java.io.IOException;

import com.meriem.Dao.ClientDao;
import com.meriem.Models.Client;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDao clientDao = new ClientDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/acceuil1.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Email = request.getParameter("Email");
		String Nom = request.getParameter("Nom");
		String Prenom = request.getParameter("Prenom");
		String Adresse = request.getParameter("Adresse");
		int CodePostal = Integer.parseInt(request.getParameter("CodePostal"));
		String Ville = request.getParameter("Ville");
		String MotPasse = request.getParameter("MotPasse");
		int Tel = Integer.parseInt(request.getParameter("Tel"));
		
		Client client = new Client();
		client.setEmail(Email);
		client.setNom(Nom);
		client.setPrenom(Prenom);
		client.setAdresse(Adresse);
		client.setCodePostal(CodePostal);
		client.setVille(Ville);
		client.setMotPasse(MotPasse);
		client.setTel(Tel);
		
		try {
			clientDao.registerClient(client);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/acceuil1.jsp");
		dispatcher.forward(request, response);
	}

}
