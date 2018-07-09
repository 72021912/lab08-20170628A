package controller.resources;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

public class ResourcesControllerAdd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Restriccion.restringe(PMF.get().getPersistenceManager(),UserServiceFactory.getUserService().getCurrentUser() ,request.getServletPath(),request,response)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		
		if (request.getParameter("nombre") != null && request.getParameter("status") != null
				&& request.getParameter("fecha") != null) {

			String nombre = request.getParameter("nombre");
			boolean status = Boolean.parseBoolean(request.getParameter("status"));
			Date fecha = null;
			try {
				fecha = sdf.parse(request.getParameter("fecha"));
				
			} catch (ParseException e) {
				
			}

			
			Resource nuevo = new Resource(nombre, status,fecha);

			try {
				pm.makePersistent(nuevo);
			} finally {
				pm.close();
			}
			
			response.sendRedirect("/Resources");
		
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Resources/add.jsp");
			dispatcher.forward(request, response);
		}

	}
	}
}