package controller.resources;

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

public class ResourcesControllerDelete extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		if(Restriccion.restringe(PMF.get().getPersistenceManager(),UserServiceFactory.getUserService().getCurrentUser() ,request.getServletPath(),request,response)){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Resource borrar=pm.getObjectById(Resource.class,Long.parseLong(request.getParameter("accountID")));
		//Lista de Access que tengan este Recurso
		String queryAccess = "select  from " + Access.class.getName() + " where exist =='access' && resource=="
				+ Long.parseLong(request.getParameter("accountID"));
		List<Access> accesos = (List<Access>) pm.newQuery(queryAccess).execute();
		try{
			//Eliminando los access que utilizen este recurso
			for(int i=0;i<accesos.size();i++){
				pm.deletePersistent(accesos.get(i));
			}
		pm.deletePersistent(borrar);
		}finally{	
		pm.close();
		}
		response.sendRedirect("/Resources");
	}
	}
}