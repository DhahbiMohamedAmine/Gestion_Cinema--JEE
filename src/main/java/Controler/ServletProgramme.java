package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoProgramme;
import Model.Entities.Programme;
import Model.Metier.ModelProgramme;

/**
 * Servlet implementation class ServletProgramme
 */
@WebServlet("/ServletProgramme/*")
public class ServletProgramme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProgramme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);

		if (pathInfo.equals("/user")) {
			ArrayList<Programme> programmes;

			ModelProgramme daoprogramme = new ModelProgramme();
			programmes = daoprogramme.getProgrammes();

			request.setAttribute("programmes", programmes);
			System.out.println(programmes);

			request.getRequestDispatcher("/Programme/afficheProgrammeClient.jsp").forward(request, response);
		}else if(pathInfo.equals("/admin")) {
			ArrayList<Programme> programmes;

			ModelProgramme daoprogramme = new ModelProgramme();
			programmes = daoprogramme.getProgrammes();

			request.setAttribute("programmes", programmes);
			System.out.println(programmes);

			request.getRequestDispatcher("/Programme/afficherProgramme.jsp").forward(request, response);
		}
		
		else if (pathInfo.equals("/admin/add")) {
			if(request.getParameter("id_film")!=null && request.getParameter("id_salle")!=null && request.getParameter("date_programme")!=null) {
				int id_film = Integer.parseInt(request.getParameter("id_film"));
				int id_salle = Integer.parseInt(request.getParameter("id_salle"));
			    String date_programme = request.getParameter("date_programme");
			    Programme p = new Programme(0, id_film, id_salle,date_programme);
			    DaoProgramme daoprogramme = new DaoProgramme();
			    daoprogramme.insertProgramme(p);
			    response.sendRedirect(request.getContextPath() + "/ServletProgramme/admin");
				
			}else {
			request.getRequestDispatcher("/Programme/addProgramme.jsp").forward(request, response);
		} 
		}
		
		else if (pathInfo.equals("/admin/del")) {
			if(request.getParameter("id")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoProgramme daoprogramme = new DaoProgramme();
				daoprogramme.deleteProgramme(id);
				response.sendRedirect(request.getContextPath() + "/ServletProgramme/admin");
			}
		else {			
			int id_programme = Integer.parseInt(request.getParameter("id"));
			 
			request.setAttribute("id_programme", id_programme);
			request.getRequestDispatcher("/Programme/deleteProgramme.jsp").forward(request, response);
		} 
		}
		
		else if (pathInfo.equals("/admin/edit")) {
		    String id = request.getParameter("id_programme");
		    if (id != null) {
		    	int id_film = Integer.parseInt(request.getParameter("id_film"));
				int id_salle = Integer.parseInt(request.getParameter("id_salle"));
			    String date_programme = request.getParameter("date_programme");
		        Programme p = new Programme(Integer.parseInt(id), id_film, id_salle,date_programme);
		        DaoProgramme daoprogramme = new DaoProgramme();
		        daoprogramme.updateProgramme(p);
		        response.sendRedirect(request.getContextPath() + "/ServletProgramme/admin");
		    } else {
		        DaoProgramme daoprogramme = new DaoProgramme();
		        int id_programme = Integer.parseInt(request.getParameter("id"));
		        Programme p = daoprogramme.getProgramme(id_programme);

		        request.setAttribute("id", p.getId_programme()); // Change "id_film" to "id"
		        request.setAttribute("id_film", p.getId_film());
		        request.setAttribute("id_salle", p.getId_salle());
		        request.setAttribute("date_programme", p.getDate_programme());

		        request.getRequestDispatcher("/Programme/editProgramme.jsp").forward(request, response);
		    }
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
