<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="com.driveventures.Controller.utils.*"%>


<%@include file="/html/common/header.jsp"%>

<h3>Registro</h3>
      
      <form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.REGISTRO_COCHE%>" />
      <input type="text" name="Nombre" placeholder="Nombre"/>
      <input type="number" name="anho_creacion" placeholder="Año Creación"/>
      <input type="number" name="Plazas" placeholder="Plazas"/>
      <input type="text" value="Matricula" name="Matricula"/>
      <select name="Idioma">
		<option value=Español>Español</option>
		<option value=Inglés>Inglés</option>
		<option value=Francés>Francés</option>
		<option value=Alemán>Alemán</option>
		<option value=Gallego>Gallego</option>
      <input type="submit" value="Registrarse" name="usuario"/>
      </form>

</body>
</html>