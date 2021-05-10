<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.driveventures.model.*"
	import="com.driveventures.utils.*"%>

<%@include file="/common/header.jsp"%>



<%
Usuario usuario = (Usuario) SessionManager.get(request, SessionAttributeNames.USER);
%>


<h3>
	Perfil de <strong>${usr.nombre}</strong>
</h3>

<form action="<%=ControllerPaths.USUARIO%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.EDITPROFILE%>" />

	<h2>
		<input type="text" value=<%=usuario.getNombre()%> name="Nombre">
	</h2>


	<input type="text" value=<%=usuario.getApellidos()%> name="Apellidos">

	<input type="text" value=<%=usuario.getEmail()%> name="Email">

	<input type="submit" value="Guardar" name="usuario" />

</form>

<form action="<%=ControllerPaths.USUARIO%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.DELETE_ACCOUNT%>" />
		
		<input type="submit" value="Borrar Cuenta" name="usuario" />
		
		</form>
		
		
		
		<p><a href="<%=request.getContextPath()%>/html/user/RegistroConductor.jsp">Registro Conductor</a></p>
		
		<p><a href="<%=request.getContextPath()%>/html/user/RegistroCoche.jsp">Registro Coche</a></p>
		
		

<form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.MIS_COCHES%>" />
		
		<input type="submit" value="Ver mi coche" name="usuario" />
		
		</form>
		
		

</body>
</html>