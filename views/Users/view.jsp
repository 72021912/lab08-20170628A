<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="model.entity.*"%>
<%@ page import="controller.*" %>
<%@page import="java.text.*" %>
<%@page import="controller.roles.*" %>
<%@page import="controller.users.*" %>
<%@page import="controller.resources.*" %>
<%@page import="controller.access.*" %>
<%@page import="controller.facturas.*" %>


<%
	User usuario=(User)request.getAttribute("read");
	Role name_rol=(Role)request.getAttribute("name_rol");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leer Usuario</title>
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
        	<td id="titulo">Datos del Usuario</td>
        </tr>
        <tr >
			<td><label for="nombre">Nombre</label></td>
        </tr>
        <tr>
			<th><input type="text" name="nombre" id="nombre" readonly="readonly" value=<%=usuario.getNombre() %>></th>
		</tr>
		<tr >
			<td><label for="apellido">Apellido</label></td>
        </tr>
        <tr>
			<th><input type="text" name="apellido" id="apellido" readonly="readonly" value=<%=usuario.getApellido() %>></th>
		</tr>
		<tr >
			<td><label for="correo">Email</label></td>
        </tr>
        <tr>
			<th><input type="text" name="correo" id="correo" readonly="readonly" value=<%=usuario.getCorreo() %>></th>
		</tr>
		<tr >
			<td><label for="role">Role</label></td>
        </tr>
        <tr>
			<th><input type="text" name="role" id="role" readonly="readonly" value=<%=name_rol.getNombre()%>></th>
		</tr>
		<tr>
			<td><label for="cumpleaños">Birth</label></td>
        </tr>
        <tr>
			<th><input type="text" name="cumpleaños"  id="cumpleaños" readonly="readonly" value=<%=sdf.format(usuario.getFecha())%>></th>
		
		</tr>
		<tr>
			<td><label for="genero">Genero</label></td>
         </tr>
         <tr>
			<th><input type="text" name="genero"  id="genero" readonly="readonly" value=<%=usuario.getGenero() %>></th>
		</tr>
		
		<tr>
			<td><label for="status">Status</label></td>
         </tr>
         <tr>
			<th><input type="text" name="status"  id="status" readonly="readonly" value=<%=usuario.getStatus() %>></th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
        </tr>
        <tr>
			<th><input type="text" name="fecha"  id="fecha" readonly="readonly" value=<%=sdf.format(usuario.getFecha())%>></th>
		
		</tr>
		<tr>
			<th>
			<a href="/Users/Add"><input type="submit" value="Crear Nuevo Usuario" class="boton_crear"></a>
			<a href="/Users"><input type="submit" value="Ir a la Lista" class="boton_index"></a>
			</th>
			
		</tr>
	</table>
			
</body>
</html>