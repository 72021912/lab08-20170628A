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
<title>Editar Rol</title>
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
 		<li><a href="/UsersRestriccionLogin">Login</a></li>
 		<li><a href="/Users/Logout">Logaout</a></li>
 	</ul>
 </nav>

</header>

		<%
		Role editarRole=(Role)request.getAttribute("editRole");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		%>		
		<form action="/Roles/Edit?action=guardar&cambiarID=<%=editarRole.getID() %>" method="Post">
	
		<table class="tabla_añadir">
		<tr>
			<td id="titulo">Editar Rol</td>
		</tr>
		<tr >
			<td><label for="nombre">Nombre</label></td>
         </tr>
		<tr>
			<th><input type="text" name="nombre" value=<%=editarRole.getNombre()%> id="nombre"></th>
		</tr>
		<tr>
			<td><label for="status">Status</label></td>
        </tr>
        <tr>
        	<th>
			True:<input type="radio" id="status" name="status" value="true" required/>
			False:<input type="radio" id="status" name="status" value="false" required/>
			</th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
        </tr>
        <tr>
			<td><input type="date" name="fecha" value=<%=sdf.format(editarRole.getFecha())%> id="fecha"></td>
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