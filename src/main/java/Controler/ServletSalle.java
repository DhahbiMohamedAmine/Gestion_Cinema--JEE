package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Entities.*;
import java.util.ArrayList;
import Model.Metier.*;
import Dao.DaoSalle;

/**
 * Servlet implementation class ServletSalle
 */
@WebServlet("/salle/*")
public class ServletSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);

		if (pathInfo==null) {
			ArrayList<Salle> salles;

			ModelSalle daoSalle = new ModelSalle();
			salles = daoSalle.getSalles();

			request.setAttribute("Salles", salles);
			System.out.println(salles);

			request.getRequestDispatcher("/Salle/afficherSalle.jsp").forward(request, response);
		}

		else if (pathInfo.equals("/add")) {
			if(request.getParameter("name")!=null && request.getParameter("nb_place")!=null) {
				String name = request.getParameter("name");
			    int nb_place = Integer.parseInt(request.getParameter("nb_place"));
			    Salle salle = new Salle(0, name, nb_place);
			    DaoSalle daoSalle = new DaoSalle();
			    daoSalle.insertSalle(salle);
			    response.sendRedirect(request.getContextPath() + "/salle");
			}else {
			request.getRequestDispatcher("/Salle/addSalle.jsp").forward(request, response);
			}
		} else if (pathInfo.equals("/del")) {
			if(request.getParameter("id")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoSalle daoSalle = new DaoSalle();
				daoSalle.deleteSalle(id);
				response.sendRedirect(request.getContextPath() + "/salle");
			}else {
			int id_salle = Integer.parseInt(request.getParameter("id"));
			 //System.out.println("deleting : "+id_salle);
			request.setAttribute("id_salle", id_salle);
			request.getRequestDispatcher("/Salle/deleteSalle.jsp").forward(request, response);
			}
		} else if (pathInfo.equals("/edit")) {
			String id = request.getParameter("id_salle");
			System.out.println(id);
			if(id !=null) {
		    String name = request.getParameter("name");
		    int nb_place = Integer.parseInt(request.getParameter("nb_place"));
		    Salle salle = new Salle(Integer.parseInt(id), name, nb_place);
		    DaoSalle daoSalle = new DaoSalle();
		    daoSalle.updateSalle(salle);
		    response.sendRedirect(request.getContextPath() + "/salle");
			}
			
			else {
			DaoSalle daosalle = new DaoSalle();
			int id_salle = Integer.parseInt(request.getParameter("id"));
			Salle s = daosalle.getSalle(id_salle);

			// System.out.println(request.getContextPath());
			request.setAttribute("id_salle", s.getId());
			request.setAttribute("name", s.getNomSalle());
			request.setAttribute("nb_place", s.getNb_place());
			request.getRequestDispatcher("/Salle/editSalle.jsp").forward(request, response);
			}

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
