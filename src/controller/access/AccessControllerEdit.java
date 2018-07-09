package controller.access;

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
import controller.access.*;
import controller.roles.*;
import controller.resources.*;

@SuppressWarnings("serial")
public class AccessControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		String queryRoles = "select from " + Role.class.getName() + " where exist=='role' ";
		List<Role> roles = (List<Role>) pm.newQuery(queryRoles).execute();

		String queryResource = "select from " + Resource.class.getName() + " where exist=='resource' ";
		List<Resource> resources = (List<Resource>) pm.newQuery(queryResource).execute();

		if (request.getParameter("action").equals("guardar")) {
			Access nuevo = pm.getObjectById(Access.class, Long.parseLong(request.getParameter("cambiarID")));

			Long role = Long.parseLong(request.getParameter("role"));

			Long recurso = Long.parseLong(request.getParameter("resource"));

			boolean status = Boolean.parseBoolean(request.getParameter("status"));

			Date fecha = null;
			try {
				fecha = sdf.parse(request.getParameter("fecha"));
			} catch (ParseException e) {

			}

			nuevo.setRol(role);
			nuevo.setResource(recurso);
			nuevo.setStatus(status);
			nuevo.setFecha(fecha);
			response.sendRedirect("/Access");
		} else {
			if (Restriccion.restringe(PMF.get().getPersistenceManager(),
					UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request,
					response)) {
				Access cambio = pm.getObjectById(Access.class, Long.parseLong(request.getParameter("cambiarID")));

				request.setAttribute("editAccess", cambio);
				request.setAttribute("roles", roles);
				request.setAttribute("resources", resources);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Access/edit.jsp");
				dispatcher.forward(request, response);
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
