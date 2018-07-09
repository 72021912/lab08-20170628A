<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="model.entity.*"%>
<%@ page import="controller.*" %>
<%@page import="java.text.*" %>
<%@page import="controller.users.*" %>
<%@page import="controller.roles.*"%>
<%@page import="controller.resources.*" %>
<%@page import="controller.access.*" %>
<%@page import="controller.facturas.*" %>

<%
	Factura factura=(Factura)request.getAttribute("read");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leer Factura</title>
<link rel="stylesheet" href="CSS/estilos.css">
<link rel="stylesheet" href="CSS/view/view.css">
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
	
	<table  class="tabla_añadir">
		
		<tr>
        	<td id="titulo">Datos de la Factura</td>
        </tr>
		<tr >
			<td><label for="cliente">Cliente</label></td>
        </tr>
        <tr>
			<th><input type="text" name="cliente" id="cliente" readonly="readonly" value=<%=factura.getCliente() %>></th>
		</tr>
		<tr >
			<td><label for="producto">Producto</label></td>
        </tr>
        <tr>
			<th><input type="text" name="producto" id="producto" readonly="readonly" value=<%=factura.getProducto() %>></th>
		</tr>
		<tr >
			<td><label for="Unidades">Unidades</label></td>
        </tr>
        <tr>
			<th><input type="text" name="unidades" id="unidades" readonly="readonly" value=<%=factura.getUnidades() %>></th>
		</tr>
		<tr >
			<td><label for="precio">Precio</label></td>
        </tr>
        <tr>
			<th><input type="text" name="precio" id="precio" readonly="readonly" value=<%=factura.getPrecio() %>></th>
		</tr>
		<tr >
			<td><label for="telefono">Telefono</label></td>
        </tr>
        <tr>
			<th><input type="text" name="telefono" id="telefono" readonly="readonly" value=<%=factura.getTelefono() %>></th>
		</tr>
		<tr >
			<td><label for="direccion">Direccion</label></td>
        </tr>
        <tr>
			<th><input type="text" name="direccion" id="direccion" readonly="readonly" value=<%=factura.getDireccion() %>></th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
        </tr>
        <tr>
			<th><input type="text" name="fecha"  id="fecha" readonly="readonly" value=<%=sdf.format(factura.getFecha())%>></th>
		
		</tr>
		<tr>
			<th>
			<a href="/Facturas/Add"><input type="submit" value="Crear Nueva Factura" class="boton_crear"></a>
			<a href="/Facturas"><input type="submit" value="Ir a la Lista" class="boton_index"></a>
			</th>
			
		</tr>
	</table>
			
</body>
</html>