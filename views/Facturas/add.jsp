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
<title>Crear Nueva Factura</title>
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
		
		<form action="/Facturas/Add" method="Get">
		
	<table  class="tabla_añadir">
		<tr>
        	<td id="titulo">Crear Nueva Factura</td>
        </tr>
		<tr >
			<td><label for="cliente">Cliente</label></td>
         </tr>
         <tr>
			<th><input type="text" name="cliente" required placeholder="Ingrese el Cliente" id="cliente"></th>
		</tr>
		<tr >
			<td><label for="producto">Producto</label></td>
         </tr>
         <tr>
			<th><input type="text" name="producto" required placeholder="Ingrese el Producto" id="producto"></th>
		</tr>
		<tr >
			<td><label for="unidades">N° Unidades</label></td>
         </tr>
         <tr>
			<th><input type="number" name="unidades" required placeholder="Ingrese las Unidades" id="unidades"></th>
		</tr>
		<tr >
			<td><label for="precio">Precio</label></td>
         </tr>
         <tr>
			<th><input type="number" name="precio" required placeholder="Ingrese el Precio" id="precio"></th>
		</tr>
		<tr >
			<td><label for="telefono">Telefono</label></td>
         </tr>
         <tr>
			<th><input type="number" name="telefono" required placeholder="Ingrese el telefono del cliente" id="telefono"></th>
		</tr>
		<tr >
			<td><label for="direccion">Direccion</label></td>
         </tr>
         <tr>
			<th><input type="text" name="direccion" required placeholder="Ingrese la direccion del CLiente" id="direccion"></th>
		</tr>
		<tr>
			<td><label for="fecha">Fecha</label></td>
           </tr>
           <tr>
			<th><input type="date" name="fecha" id="fecha" required></th>
		</tr>
		<tr>
       
			<th>
			<input type="submit" value="Crear Factura" class="boton_crear">
			</th>
           
		</tr>
	</table>
  
	</form>
</body>
</html>