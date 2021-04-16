<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.driveventures.model.*" %>

<%@include file="/html/common/header.jsp"%>


<%
	Usuario u = (Usuario) request.getAttribute("Perfil");
%> 


<h3>Perfil de <strong>${usr.nombre}</strong></h3>

<h2> Nombre: <%=u.getNombre()%></h2>

<h2> Apellidos: <%=u.getApellidos()%></h2>

<h2> Email: <%=u.getEmail()%></h2>

</body>
</html>