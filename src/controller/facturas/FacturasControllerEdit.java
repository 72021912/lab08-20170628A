package controller.facturas;

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
public class FacturasControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if (Restriccion.restringe(PMF.get().getPersistenceManager(),
				UserServiceFactory.getUserService().getCurrentUser(), request.getServletPath(), request, response)) {

			PersistenceManager pm = PMF.get().getPersistenceManager();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

			if (request.getParameter("action").equals("guardar")) {
				Factura nuevo = pm.getObjectById(Factura.class, Long.parseLong(request.getParameter("cambiarID")));

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

				nuevo.setCliente(cliente);
				nuevo.setProducto(producto);
				nuevo.setUnidades(unidades);
				nuevo.setPrecio(precio);
				nuevo.setTelefono(telefono);
				nuevo.setDireccion(direccion);
				nuevo.setFecha(fecha);
				response.sendRedirect("/Facturas");
			} else {

				Factura cambio = pm.getObjectById(Factura.class, Long.parseLong(request.getParameter("cambiarID")));

				request.setAttribute("editFactura", cambio);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Facturas/edit.jsp");
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