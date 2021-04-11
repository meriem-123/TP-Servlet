package com.meriem.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.meriem.Dao.ClientDao;
import com.meriem.Models.Client;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDao clientDao = new ClientDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String MotPasse = request.getParameter("MotPasse");
		
		Client client = new Client();
		
		client.setEmail(Email);
		client.setMotPasse(MotPasse);
		
		try {
            if (clientDao.validate(client)) {
                jakarta.servlet.http.HttpSession session = request.getSession();
                session.setAttribute("username", clientDao.checkName(Email));
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/acceuil1.jsp");
        		dispatcher.forward(request, response);
            } else {
                jakarta.servlet.http.HttpSession session = request.getSession();
                session.setAttribute("user", clientDao.checkName(Email));
                response.sendRedirect("/identifier.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
}
