package controller.users;

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
import controller.roles.*;
import model.entity.*;

public class UsersRestriccionLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		com.google.appengine.api.users.User usuarioGoogle =UserServiceFactory.getUserService().getCurrentUser();
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String queryUser = "select from " + User.class.getName() + " where exist=='user' ";
			@SuppressWarnings("unchecked")
			List<User> usuarios = (List<User>) pm.newQuery(queryUser).execute();
			for( int i=0;i<usuarios.size();i++){
				if(usuarios.get(i).getCorreo().equals(usuarioGoogle.getEmail())){
					response.sendRedirect("/Users/View?leerID="+usuarios.get(i).getID());
				}
			}
			
			request.setAttribute("logueado", usuarioGoogle.getEmail());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Users/login.jsp");
				dispatcher.forward(request, response);
			
	}
}
