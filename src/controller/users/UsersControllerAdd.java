package controller.users;

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
import controller.roles.*;
import model.entity.*;

public class UsersControllerAdd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			PersistenceManager pm = PMF.get().getPersistenceManager();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

			String queryRole = "select from " + Role.class.getName() + " where exist=='role' ";
			List<Role> roles = (List<Role>) pm.newQuery(queryRole).execute();

			if (request.getParameter("nombre") != null && request.getParameter("correo") != null
					&& request.getParameter("role") != null && request.getParameter("cumpleaños") != null
					&& request.getParameter("genero") != null && request.getParameter("status") != null) {

				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");

				String correo = request.getParameter("correo");

				Long role = Long.parseLong(request.getParameter("role"));

				Date cumpleaños = null;
				try {
					cumpleaños = sdf.parse(request.getParameter("cumpleaños"));
				} catch (ParseException e1) {
					System.out.print("Error al ingresar la Fecha");
				}
				String genero = request.getParameter("genero");
				boolean status = Boolean.parseBoolean(request.getParameter("status"));
				Date fecha = null;
				try {
					fecha = sdf.parse(request.getParameter("fecha"));
				} catch (ParseException e) {
					System.out.println("Error al ingresar la fecha");
				}

				User nuevo = new User(nombre, apellido, correo, role, cumpleaños, genero, status, fecha);

				try {
					pm.makePersistent(nuevo);
				} finally {
					pm.close();
				}
				response.sendRedirect("/Users");
			} else {
				request.setAttribute("roles", roles);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Users/add.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}