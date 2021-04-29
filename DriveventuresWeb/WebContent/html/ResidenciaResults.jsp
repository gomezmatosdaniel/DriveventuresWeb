<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.driveventures.model.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


<%@include file="/common/header.jsp"%>

<h2>Conductores cercanos:</h2>
<table border="1">
	<tbody>
		<tr>
			<td>Nombre</td>
			<td>Buena Conversacion:</td>
			<td>Buena Ruta</td>
			<td>ExcelenteServicio</td>
			<td>NumViajes</td>
			<td>Residencia</td>
		</tr>
		<%
	List<Conductor> c = (List<Conductor>) request.getAttribute("ResidenciaResults");

for (Conductor co : c) 
{
  out.println("<tr>" +
		  "<td>"+co.getNombre()+"</td>"+ 
               "<td> "+co.getBuenaconversacion()+"</td>"+
               "<td> "+co.getBuenaruta()+"</td>"+
               "<td> "+co.getExcelenteserviscio()+"</td>"+
               "<td> "+co.getNumviajes()+"</td>"+
               "<td> "+co.getResidencia()+"</td>"+ 
              
             "</tr>");
  
} 

%>


		</body>
		</html>