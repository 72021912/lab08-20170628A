package controller.access;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import controller.access.*;
import controller.roles.*;
import controller.resources.*;
import model.entity.*;

public class AccessControllerAdd extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		if(Restriccion.restringe(PMF.get().getPersistenceManager(),UserServiceFactory.getUserService().getCurrentUser() ,request.getServletPath(),request,response)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		String queryRoles = "select from "+ Role.class.getName()+" where exist=='role' ";
		List<Role> roles = (List<Role>) pm.newQuery(queryRoles).execute();
		
		String queryResource = "select from "+ Resource.class.getName()+" where exist=='resource' ";
		List<Resource> resources = (List<Resource>) pm.newQuery(queryResource).execute();
		
		if (request.getParameter("role")!=null&&request.getParameter("resource")!=null&&request.getParameter("status")!=null
			&&request.getParameter("fecha")!=null){	
			
			Long roleID=Long.parseLong(request.getParameter("role"));
			Long recursoID=Long.parseLong(request.getParameter("resource"));
			Boolean status=Boolean.parseBoolean(request.getParameter("status"));
		
		Date fecha = null;
		try {
			fecha = sdf.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			System.out.println("Error al ingresar la fecha");
		}
			Access nuevo= new Access(roleID,recursoID,status,fecha);
		
			try {
				pm.makePersistent(nuevo);
			} finally {
				pm.close();
			}
		
		response.sendRedirect("/Access");
		}
		else{
			request.setAttribute("roles", roles);
			request.setAttribute("resources", resources);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Access/add.jsp");
			dispatcher.forward(request, response);
		}
	}
	}
}