package controller.facturas;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.*;

public class FacturasControllerAdd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

			if (request.getParameter("cliente") != null && request.getParameter("producto") != null
					&& request.getParameter("unidades") != null && request.getParameter("precio") != null
					&& request.getParameter("telefono") != null && request.getParameter("direccion") != null) {

				String cliente = request.getParameter("cliente");
				String producto = request.getParameter("producto");
				int unidades = Integer.parseInt(request.getParameter("unidades"));
				double precio = Double.parseDouble(request.getParameter("precio"));
				int telefono = Integer.parseInt(request.getParameter("telefono"));
				String direccion = request.getParameter("direccion");
				Date fecha = null;
				try {
					fecha = sdf.parse(request.getParameter("fecha"));

				} catch (ParseException e) {

				}

				Factura nuevo = new Factura(cliente, producto, unidades, precio, telefono, direccion, fecha);

				try {
					pm.makePersistent(nuevo);
				} finally {
					pm.close();
				}

				response.sendRedirect("/Facturas");

			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Facturas/add.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}