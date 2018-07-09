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
	String email=(String)request.getAttribute("email");
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
			<td><label for="correo">Email</label></td>
        </tr>
        <tr>
			<th><input type="text" name="correo" id="correo" readonly="readonly" value=<%=email %>></th>
		</tr>
		
	</table>
			<a href="/Users"><input type="submit" value="Aceptar" class="boton_crear"></a>
</body>
</html>