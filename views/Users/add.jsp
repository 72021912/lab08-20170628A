<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@page import="controller.*" %>
    <%@page import="model.entity.*" %>
    <%@page import="java.util.*" %>
    <%@page import="controller.roles.*" %>
    <%@page import="controller.users.*" %>
    <%@page import="controller.resources.*" %>
    <%@page import="controller.access.*" %>
    <%@page import="controller.facturas.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear Nuevo Usuario</title>
<link rel="stylesheet" href="CSS/estilos.css">
<link rel="stylesheet" href="CSS/add/add.css">
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
		%>
	<form action="/Users/Add" method="Get">
		
	<table  class="tabla_añadir">
		<tr>
        	<td id="titulo">Crear Nuevo Usuario</td>
        </tr>
        <tr >
			<td><label for="nombre">Nombre</label></td>
         </tr>
         <tr>
			<th><input type="text" name="nombre" required placeholder="Ingrese su Nombre" id="nombre"></th>
		</tr>
		<tr >
			<td><label for="apellido">Apellido</label></td>
         </tr>
         <tr>
			<th><input type="text" name="apellido" required placeholder="Ingrese su Apellido" id="apellido"></th>
		</tr>
		<tr >
			<td><label for="correo">Email</label></td>
         </tr>
         <tr>
			<th><input type="email" name="correo" required placeholder="Ingrese su Email" id="correo"></th>
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
				<%} %>
			</select></th>
         </tr>
         
         <tr>
			<td><label for="cumpleaños">Birth</label></td>
         </tr>
         <tr>
			<th><input type="date" name="cumpleaños" id="cumpleaños" required></th>
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
			True:<input type="radio" id="status" name="status" value="True" required/>
			False:<input type="radio" id="status" name="status" value="False" required/>
			</th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
           </tr>
         <tr>
			<th><input type="date" name="fecha" id="fecha" required></th>
		</tr>
		<tr>
			<th>
			<input type="submit" value="Crear Usuario" class="boton_crear">
			</th>
           
		</tr>
	</table>
 
	</form>
</body>
</html>