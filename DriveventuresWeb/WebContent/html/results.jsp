<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.driveventures.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Conductor c = (Conductor) request.getAttribute("results");
%>

<h1>
<%=c.getNombre()%>  <%=c.getApellidos()%>
</h1>

<h2> Años Experiencia: <%=c.getAñosexp()%></h2>

<h2> Viajes Realizados: <%=c.getNumviajes()%></h2>

<h2> Buena Conversacion: <%=c.getBuenaconversacion()%></h2>

<h2> Buena Ruta: <%=c.getBuenaruta()%></h2>

<h2> Excelente Servicio: <%=c.getExcelenteserviscio()%></h2>

<h2> Residencia: <%=c.getResidencia()%></h2>

</body>
</html>