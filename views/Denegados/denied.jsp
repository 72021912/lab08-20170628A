<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	 <%@page import="controller.*" %>
    <%@page import="model.entity.*" %>
    <%@page import="java.util.*" %>
    <%@page import="controller.roles.*" %>
    <%@page import="controller.users.*" %>
    <%@page import="controller.resources.*" %>
    <%@page import="controller.access.*" %>
    <%@page import="controller.facturas.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accion Denegada</title>
</head>
<body>

	
	<script type="text/javascript">
		alert('Usted no cuenta con los permisos necesarios para realizar esta accion, verifique sus accesos')
	</script>
	<center><a href="/Access"><h2>Verificar mis Accesos</h2></a></center>
	
	
	
</body>
</html>