package controller.users;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

@SuppressWarnings("serial")
public class UsersControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {

			PersistenceManager pm = PMF.get().getPersistenceManager();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

			String query = "select  from " + Role.class.getName() + " where exist =='role' ";
			List<Role> roles = (List<Role>) pm.newQuery(query).execute();

			if (request.getParameter("action").equals("guardar")) {
				User nuevo = pm.getObjectById(User.class, Long.parseLong(request.getParameter("cambiarID")));
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");

				String correo = request.getParameter("correo");

				Long role = Long.parseLong(request.getParameter("role"));

				Date cumpleaños = null;
				try {
					cumpleaños = sdf.parse(request.getParameter("cumpleaños"));
				} catch (ParseException e) {

				}

				String genero = request.getParameter("genero");

				boolean status = Boolean.parseBoolean(request.getParameter("status"));

				Date fecha = null;
				try {
					fecha = sdf.parse(request.getParameter("fecha"));
				} catch (ParseException e) {

				}
				nuevo.setNombre(nombre);
				nuevo.setApellido(apellido);
				nuevo.setCorreo(correo);
				nuevo.setRole(role);
				nuevo.setCumpleaños(cumpleaños);
				nuevo.setGenero(genero);
				nuevo.setStatus(status);
				nuevo.setFecha(fecha);
				response.sendRedirect("/Users");
			} else {
				User cambio = pm.getObjectById(User.class, Long.parseLong(request.getParameter("cambiarID")));

				request.setAttribute("editUser", cambio);
				request.setAttribute("roles", roles);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Users/edit.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			doGet(request, response);
		}
	}

}