package controller.access;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

@SuppressWarnings("serial")
public class AccessControllerDelete extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		if(Restriccion.restringe(PMF.get().getPersistenceManager(),UserServiceFactory.getUserService().getCurrentUser() ,request.getServletPath(),request,response)){
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			Access borrar=pm.getObjectById(Access.class,Long.parseLong(request.getParameter("accountID")));
			try{
			pm.deletePersistent(borrar);
			}finally{	
			pm.close();
			}
			response.sendRedirect("/Access");
		}
		
		
	}
}
