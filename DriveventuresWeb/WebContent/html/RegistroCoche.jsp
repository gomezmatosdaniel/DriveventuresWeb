<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="com.driveventures.Controller.utils.*"%>


<%@include file="/html/common/header.jsp"%>

<h3>Registro</h3>
      
      <form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.REGISTRO_COCHE%>" />
      <input type="text" name="Nombre" placeholder="Nombre"/>
      <input type="number" name="anho_creacion" placeholder="A�o Creaci�n"/>
      <input type="number" name="Plazas" placeholder="Plazas"/>
      <input type="text" value="Matricula" name="Matricula"/>
      <select name="Idioma">
		<option value=Espa�ol>Espa�ol</option>
		<option value=Ingl�s>Ingl�s</option>
		<option value=Franc�s>Franc�s</option>
		<option value=Alem�n>Alem�n</option>
		<option value=Gallego>Gallego</option>
      <input type="submit" value="Registrarse" name="usuario"/>
      </form>

</body>
</html>