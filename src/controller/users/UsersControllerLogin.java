package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

public class UsersControllerLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService us=UserServiceFactory.getUserService();
		
		User usuarioGoogle=us.getCurrentUser();
		
		if(usuarioGoogle==null){
			resp.sendRedirect(us.createLoginURL("/Users/Login"));
		}
		else{
			resp.sendRedirect("/UsersRestriccionLogin");
		}
	}
}
