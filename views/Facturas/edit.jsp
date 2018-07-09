<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@page import="model.entity.*" %>
    <%@page import="java.text.*" %>
    <%@page import="java.util.*" %>
    <%@page import="controller.users.*" %>
    <%@page import="controller.roles.*"%>
    <%@page import="controller.resources.*" %>
    <%@page import="controller.access.*" %>
    <%@page import="controller.facturas.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Factura</title>
<link rel="stylesheet" href="CSS/estilos.css">
<link rel="stylesheet" href="CSS/edit/edit.css">
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

		<%
		Factura editarFactura=(Factura)request.getAttribute("editFactura");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		%>		
		<form action="/Facturas/Edit?action=guardar&cambiarID=<%=editarFactura.getID() %>" method="Post">
	
		<table class="tabla_añadir">
		<tr>
			<td id="titulo">Editar Factura</td>
		</tr>
		<tr >
			<td><label for="cliente">Cliente</label></td>
         </tr>
		<tr>
			<th><input type="text" name="cliente" value=<%=editarFactura.getCliente()%> id="cliente"></th>
		</tr>
		<tr >
			<td><label for="producto">Producto</label></td>
         </tr>
		<tr>
			<th><input type="text" name="producto" value=<%=editarFactura.getProducto()%> id="producto"></th>
		</tr>
		<tr >
			<td><label for="unidades">Unidades</label></td>
         </tr>
		<tr>
			<th><input type="number" name="unidades" value=<%=editarFactura.getUnidades()%> id="unidades"></th>
		</tr>
		<tr >
			<td><label for="precio">Precio</label></td>
         </tr>
		<tr>
			<th><input type="number" name="precio" value=<%=editarFactura.getPrecio()%> id="precio"></th>
		</tr>
		<tr >
			<td><label for="telefono">Telefono</label></td>
         </tr>
		<tr>
			<th><input type="number" name="telefono" value=<%=editarFactura.getTelefono()%> id="telefono"></th>
		</tr>
		<tr >
			<td><label for="direccion">Direccion</label></td>
         </tr>
		<tr>
			<th><input type="text" name="direccion" value=<%=editarFactura.getDireccion()%> id="direccion"></th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
        </tr>
        <tr>
			<td><input type="text" name="fecha" value=<%=sdf.format(editarFactura.getFecha())%> id="fecha"></td>
		</tr>
		<tr>
			<th>
			<input type="submit" value="Guardar Cambios" class="boton_crear">
			</th>
		</tr>
	</table>
	</form>
</body>
</html>