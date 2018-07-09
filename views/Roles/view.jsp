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
	Role rol=(Role)request.getAttribute("read");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leer Rol</title>
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
 		<li><a href="/UsersRestriccionLogin">Login</a></li>
 		<li><a href="/Users/Logout">Logaout</a></li>
 	</ul>
 </nav>

</header>
	
	<table  class="tabla_añadir">
		
		<tr>
        	<td id="titulo">Datos del Rol</td>
        </tr>
		<tr >
			<td><label for="nombre">Nombre</label></td>
        </tr>
        <tr>
			<th><input type="text" name="nombre" id="nombre" readonly="readonly" value=<%=rol.getNombre() %>></th>
		</tr>
		<tr>
			<td><label for="status">Status</label></td>
         </tr>
         <tr>
			<th><input type="text" name="nombre"  id="nombre" readonly="readonly" value=<%=rol.getStatus() %>></th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
        </tr>
        <tr>
			<th><input type="text" name="fecha"  id="fecha" readonly="readonly" value=<%=sdf.format(rol.getFecha())%>></th>
		
		</tr>
		<tr>
			<th>
			<a href="/Roles/Add"><input type="submit" value="Crear Nuevo Rol" class="boton_crear"></a>
			<a href="/Roles"><input type="submit" value="Ir a la Lista" class="boton_index"></a>
			</th>
			
		</tr>
	</table>
			
</body>
</html>