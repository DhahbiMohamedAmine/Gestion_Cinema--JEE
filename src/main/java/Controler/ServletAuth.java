package Controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoUser;
import Model.Entities.User;
import Model.Metier.*;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/index.html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email != null && password != null) {
			ModelUser mu = new ModelUser();
			boolean isAuthentificated = mu.authentification(email, password);
			if (isAuthentificated) {
				DaoUser dao=new DaoUser();
				User u =dao.getUserByEmailAndPassword(email, password);
				if(u.getRole().equals("admin"))
					response.sendRedirect(request.getContextPath() + "/ServletUser/admin");
				else
					response.sendRedirect(request.getContextPath() + "/ServletProgramme/user");
			} else {
				response.sendRedirect(request.getContextPath() + "/Erreur.html");
			}
		} else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
