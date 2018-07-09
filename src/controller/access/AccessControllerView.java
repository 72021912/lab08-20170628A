package controller.access;

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
import controller.roles.*;

public class AccessControllerView extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Access leer=pm.getObjectById(Access.class,Long.parseLong(request.getParameter("leerID")));
		Role rol=pm.getObjectById(Role.class,leer.getRol());
		Resource recurso=pm.getObjectById(Resource.class,leer.getResource());
		request.setAttribute("name_rol", rol);
		request.setAttribute("read", leer);
		request.setAttribute("name_recurso", recurso);
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/Access/view.jsp");
		dispatcher.forward(request, response);
	}
}