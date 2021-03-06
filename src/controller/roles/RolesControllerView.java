package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.*;

public class RolesControllerView extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role leer=pm.getObjectById(Role.class,Long.parseLong(request.getParameter("leerID")));
		
		request.setAttribute("read", leer);
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/Roles/view.jsp");
		dispatcher.forward(request, response);
	}
}