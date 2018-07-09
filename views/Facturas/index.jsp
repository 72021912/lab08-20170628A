<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ page import="model.entity.*"%>
<%@ page import="controller.*" %>
<%@page import="controller.users.*" %>
<%@page import="controller.roles.*"%>
<%@page import="controller.resources.*" %>
<%@page import="controller.access.*" %>
<%@page import="controller.facturas.*" %>


<%
	List<Factura> facturas = (List<Factura>) request.getAttribute("facturas");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Facturas</title>
<link rel="stylesheet" href="CSS/estilos.css">
<link rel="stylesheet" href="CSS/index/index.css">
</head>
<body>
<header>
 <nav class="menu">
 	<ul>
 		<li><a href="/Users">Usuarios</a></li>
 		<li><a href="/Roles">Roles</a></li>
 		<li><a href="/Resources">Resources</a></li>
 		<li><a href="/Access">Access</a></li>
 		<li><a href="/Facturas">Facturas</a></li>
 		<li><a href="/Users/Login">Login</a></li>
 		<li><a href="/Users/Logout">Logaout</a></li>
 	</ul>
 </nav>

</header>

<center><h1>Lista de Facturas</h1><br></center>

	<%
		if (facturas.size() > 0) {
	%>
	<div id="main-container">
	<table>
	<thead>
		<tr>
			<th>Cliente</th>
			<th>Producto</th>
			<th>Unidades</th>
			<th>Precio</th>
			<th>Telefono</th>
			<th>Direccion</th>
			<th>Fecha</th>
			<th>Delete</th>
			<th>UpDate</th>
			<th>Read</th>
			
		</tr>
	</thead>
		<%
			for (int i = 0; i < facturas.size(); i++) {
		%>
		<%
			Factura a = facturas.get(i);
		%>
		<tr>
			<td><%=a.getCliente()%></td>
			<td><%=a.getProducto()%></td>
			<td><%=a.getUnidades()%></td>
			<td><%=a.getPrecio()%></td>
			<td><%=a.getTelefono()%></td>
			<td><%=a.getDireccion()%></td>
			<td><%=sdf.format(a.getFecha())%></td>
			
			<td><a href="/Facturas/Delete?accountID=<%=a.getID()%>"><input type="submit" value="Delete" class="boton_delete"> </a></td>
			<td><a href="/Facturas/Edit?action=primero&cambiarID=<%=a.getID()%>"><input type="submit" value="Update" class="boton_update"> </a></td>
			<td><a href="/Facturas/View?leerID=<%=a.getID()%>"><input type="submit" value="Read" class="boton_read"> </a></td>
			
			
		</tr>
		<%
			}
		%>
	</table>
	</div>
	<% 
		} else {
	%>
	<center><span class="heading">No matching accounts found.</span></center>
	<%
		}
	%>
	</br></br>
	<center>
	<a href="/Facturas/Add" ><input type="submit" value="Crear Factura" class="boton_crear"></a>
	</center>

</body>
</html>