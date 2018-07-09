package controller.users;

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

public class UsersControllerDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			PersistenceManager pm = PMF.get().getPersistenceManager();

			User borrar = pm.getObjectById(User.class, Long.parseLong(request.getParameter("accountID")));
			try {
				pm.deletePersistent(borrar);
			} finally {
				pm.close();
			}
			response.sendRedirect("/Users");
		}
	}
}
