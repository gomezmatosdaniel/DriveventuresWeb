<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.driveventures.model.*"
	import="com.driveventures.utils.*"%>
    
    <%@include file="/common/header.jsp"%>
    

<h2>Mi Coche</h2>
      <table border="1">
        <tbody>
          <tr>
          <td>Nombre</td>
            <td>Fecha Matriculacion:</td>
            <td>Plazas</td>
            <td>Matricula</td>
            <td>Marca</td>
            <td>Modelo</td>
          </tr>
<%
	Coche c = (Coche) request.getAttribute("Coche");



  out.println("<tr>" +
		  "<td> "+c.getNombre()          +"      </td>"+
               "<td> "+c.getFechaMatriculacion()         +"      </td>"+
               "<td> "+c.getPlazas()   +"    </td>"+
               "<td> "+c.getMatricula()           +"    </td>"+
               "<td> "+c.getNombreMarca()           +"    </td>"+
               "<td> "+c.getNombreModelo()      +"      </td>"+
             "</tr>");
  


%>

</table>

<form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.DELETE_COCHE%>" />
		
		<input type="submit" value="Borrar coche" name="conductor" />
		
		</form>


</body>
</html>