package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.*;

public class RolesControllerIndex extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
					String query = "select  from " + Role.class.getName()+" where exist =='role' ";
					List<Role> roles = (List<Role>) pm.newQuery(query).execute();
					// pass the list to the jsp
					request.setAttribute("roles", roles);
					// forward the request to the jsp
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Roles/index.jsp");
					dispatcher.forward(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		doGet(request,response);
	}
}