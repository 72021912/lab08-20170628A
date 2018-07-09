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

public class AccessControllerIndex extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
					String queryAccess = "select  from " + Access.class.getName()+" where exist =='access' ";
					List<Access> accesos = (List<Access>) pm.newQuery(queryAccess).execute();
					
					
					// pass the list to the jsp
					request.setAttribute("accesos", accesos);
					// forward the request to the jsp
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Access/index.jsp");
					dispatcher.forward(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		doGet(request,response);
	}
}