package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoUser;
import Model.Entities.User;
import Model.Metier.ModelUser;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet("/ServletUser/*")
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);

		if (pathInfo.equals("/admin")) {
			ArrayList<User> users;

			ModelUser daouser = new ModelUser();
			users = daouser.getUsers();

			request.setAttribute("users", users);
			//System.out.println(salles);

			request.getRequestDispatcher("/User/afficherUser.jsp").forward(request, response);
		}

		else if (pathInfo.equals("/admin/add") ) {
			if(request.getParameter("name")!=null && request.getParameter("role")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
				String name = request.getParameter("name");
			    String role = request.getParameter("role");
			    String email = request.getParameter("email");
			    String password = request.getParameter("password");
			    User user = new User(0, name, role,email,password);
			    System.out.println(user);
			    DaoUser daouser = new DaoUser();
			    daouser.insertUser(user);
			    response.sendRedirect(request.getContextPath() + "/ServletUser/admin");
			    }else {
			request.getRequestDispatcher("/User/addUser.jsp").forward(request, response);
			}
			
		}else if(pathInfo.equals("/user/add")) {
			if(request.getParameter("name")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null) {
				String name = request.getParameter("name");
			    String email = request.getParameter("email");
			    String password = request.getParameter("password");
			    User user = new User(0, name,"client",email,password);
			    System.out.println(user);
			    DaoUser daouser = new DaoUser();
			    daouser.insertUser(user);
			    response.sendRedirect(request.getContextPath() + "/ServletProgramme/user");
			    }else {
			request.getRequestDispatcher("/User/addUserClient.jsp").forward(request, response);
			}
			
		}
		
		
		else if (pathInfo.equals("/admin/del")) {
			if(request.getParameter("id")!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				DaoUser daouser = new DaoUser();
				daouser.deleteUser(id);
				response.sendRedirect(request.getContextPath() + "/ServletUser");
			}else {
			int id_user = Integer.parseInt(request.getParameter("id"));
			 //System.out.println("deleting : "+id_salle);
			request.setAttribute("id_user", id_user);
			request.getRequestDispatcher("/User/deleteUser.jsp").forward(request, response);
			}
			
		} else if (pathInfo.equals("/admin/edit")) {
			String id = request.getParameter("id_user");
			System.out.println(id);
			if(id !=null) {
		    String name = request.getParameter("name");
		    String role = request.getParameter("role");
		    String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    User user = new User(Integer.parseInt(id), name, role,email,password);
		    DaoUser daouser = new DaoUser();
		    daouser.updateUser(user);
		    response.sendRedirect(request.getContextPath() + "/ServletUser/admin");
			}
			
			else {
			DaoUser daouser = new DaoUser();
			int id_user = Integer.parseInt(request.getParameter("id"));
			User u= daouser.getUser(id_user);

			// System.out.println(request.getContextPath());
			request.setAttribute("id", u.getId_user());
			request.setAttribute("name", u.getName());
			request.setAttribute("role", u.getRole());
			request.setAttribute("email", u.getEmail());
			request.setAttribute("password", u.getPassword());
			request.getRequestDispatcher("/User/editUser.jsp").forward(request, response);
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
