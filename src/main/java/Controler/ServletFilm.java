package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoFilm;
import Model.Entities.Film;
import Model.Metier.ModelFilm;

/**
 * Servlet implementation class ServletFilm
 */
@WebServlet("/ServletFilm/*")
public class ServletFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilm() {
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
			ArrayList<Film> films;

			ModelFilm daofilm = new ModelFilm();
			films = daofilm.getFilms();

			request.setAttribute("films", films);
			System.out.println(films);

			request.getRequestDispatcher("/Film/afficheFilmClient.jsp").forward(request, response);
		}else if(pathInfo.equals("/admin")) {
			ArrayList<Film> films;

			ModelFilm daofilm = new ModelFilm();
			films = daofilm.getFilms();

			request.setAttribute("films", films);
			System.out.println(films);

			request.getRequestDispatcher("/Film/afficherFilm.jsp").forward(request, response);
		}
		
		else if (pathInfo.equals("/admin/add")) {
			if(request.getParameter("titre")!=null && request.getParameter("nom_auteur")!=null) {
				String titre = request.getParameter("titre");
			    String nom_auteur = request.getParameter("nom_auteur");
			    Film f = new Film(0, titre, nom_auteur);
			    DaoFilm daofilm = new DaoFilm();
			    daofilm.insertFilm(f);
			    response.sendRedirect(request.getContextPath() + "/ServletFilm/admin");
				
			}else {
			request.getRequestDispatcher("/Film/addFilm.jsp").forward(request, response);
		} 
		}
		
		else if (pathInfo.equals("/admin/del")) {
			if(request.getParameter("id")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoFilm daofilm = new DaoFilm();
				daofilm.deleteFilm(id);
				response.sendRedirect(request.getContextPath() + "/ServletFilm/admin");
			}
		else {			
			int id_film = Integer.parseInt(request.getParameter("id"));
			 //System.out.println("deleting : "+id_salle);
			request.setAttribute("id_film", id_film);
			request.getRequestDispatcher("/Film/deleteFilm.jsp").forward(request, response);
		} 
		}
		
		else if (pathInfo.equals("/admin/edit")) {
		    String id = request.getParameter("id_film");
		    if (id != null) {
		        String titre = request.getParameter("titre");
		        String nom_auteur = request.getParameter("nom_auteur");
		        Film f = new Film(Integer.parseInt(id), titre, nom_auteur);
		        DaoFilm daofilm = new DaoFilm();
		        daofilm.updateFilm(f);
		        response.sendRedirect(request.getContextPath() + "/ServletFilm/admin");
		    } else {
		        DaoFilm daofilm = new DaoFilm();
		        int id_film = Integer.parseInt(request.getParameter("id"));
		        Film f = daofilm.getFilm(id_film);

		        request.setAttribute("id", f.getId_film()); // Change "id_film" to "id"
		        request.setAttribute("titre", f.getTitre());
		        request.setAttribute("nom_auteur", f.getNom_auteur());

		        request.getRequestDispatcher("/Film/editFilm.jsp").forward(request, response);
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
