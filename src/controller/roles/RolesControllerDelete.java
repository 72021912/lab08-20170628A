package controller.roles;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

public class RolesControllerDelete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			Role borrar = pm.getObjectById(Role.class, Long.parseLong(request.getParameter("accountID")));
			//Lista de Usuarios que tengan este ROL
			String queryUser = "select  from " + User.class.getName() + " where exist =='user' && role=="
					+ Long.parseLong(request.getParameter("accountID"));
			List<User> usuarios = (List<User>) pm.newQuery(queryUser).execute();
			//Lista de Access que tengan este ROL
			String queryAccess = "select  from " + Access.class.getName() + " where exist =='access' && role=="
					+ Long.parseLong(request.getParameter("accountID"));
			List<Access> accesos = (List<Access>) pm.newQuery(queryAccess).execute();
			
			if (usuarios.isEmpty()) {
				try {
						//Borrando todos los accesos con este rol
						for(int i=0;i<accesos.size();i++){
							pm.deletePersistent(accesos.get(i));
						}
					pm.deletePersistent(borrar);
				} finally {
					pm.close();
				}
				response.sendRedirect("/Roles");
			}

			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Denegados/incluido.jsp");
				dispatcher.forward(request, response);
			}
		}

	}
}
