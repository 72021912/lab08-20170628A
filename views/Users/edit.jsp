<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
  
    <%@page import="model.entity.*" %>
    <%@page import="java.text.*" %>
    <%@page import="java.util.*" %>
    <%@page import="controller.roles.*"%>
    <%@page import="controller.users.*" %>
    <%@page import="controller.resources.*" %>
    <%@page import="controller.access.*" %>
    <%@page import="controller.facturas.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuario</title>
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
		List<Role> roles = (List<Role>) request.getAttribute("roles");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		User editarUsuario=(User)request.getAttribute("editUser");
		
		%>		
		<form action="/Users/Edit?action=guardar&cambiarID=<%=editarUsuario.getID() %>" method="Post">
	
		<table class="tabla_añadir">
		<tr>
			<td id="titulo">Editar Usuario</td>
		</tr>
		<tr >
			<td><label for="nombre">Nombre</label></td>
         </tr>
		<tr>
			<th><input type="text" name="nombre" value=<%=editarUsuario.getNombre()%> id="nombre"></th>
		</tr>
		<tr >
			<td><label for="apellido">Apellido</label></td>
         </tr>
		<tr>
			<th><input type="text" name="apellido" value=<%=editarUsuario.getApellido()%> id="apellido"></th>
		</tr>
		<tr >
			<td><label for="correo">Email</label></td>
         </tr>
		<tr>
			<th><input type="email" name="correo" value=<%=editarUsuario.getCorreo()%> id="correo"></th>
		</tr>
		<tr>
			<td><label for="role">Rol</label></td>
         </tr>
         <tr>
         	<th><select name="role">
				<%
					for (int i = 0; i < roles.size(); i++) {
				%>
					<option value=<%=roles.get(i).getID() %>><%=roles.get(i).getNombre()%></option>
				<%}%>
			</select></th>
         </tr>
         <tr>
			<td><label for="cumpleaños">Birth</label></td>
        </tr>
        <tr>
			<td><input type="date" name="cumpleaños" value=<%=sdf.format(editarUsuario.getFecha())%> id="cumpleaños"></td>
		</tr>
		<tr>
			<td><label for="genero">Genero</label></td>
        </tr>
        <tr>
        	<th>
			Hombre:<input type="radio" id="genero" name="genero" value="Hombre" required/>
			Mujer:<input type="radio" id="genero" name="genero" value="Mujer" required/>
			</th>
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
			<td><input type="date" name="fecha" value=<%=sdf.format(editarUsuario.getFecha())%> id="fecha"></td>
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