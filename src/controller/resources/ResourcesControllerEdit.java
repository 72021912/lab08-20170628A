package controller.resources;

import java.io.IOException;
import java.util.Date;
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
public class ResourcesControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

			if (request.getParameter("action").equals("guardar")) {
				Resource nuevo = pm.getObjectById(Resource.class, Long.parseLong(request.getParameter("cambiarID")));

				String nombre = request.getParameter("nombre");
				boolean status = Boolean.parseBoolean(request.getParameter("status"));
				Date fecha = null;
				try {
					fecha = sdf.parse(request.getParameter("fecha"));
				} catch (ParseException e) {

				}

				nuevo.setNombre(nombre);
				nuevo.setStatus(status);
				nuevo.setFecha(fecha);
				response.sendRedirect("/Resources");
			} else {

				Resource cambio = pm.getObjectById(Resource.class, Long.parseLong(request.getParameter("cambiarID")));

				request.setAttribute("editResource", cambio);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Resources/edit.jsp");
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