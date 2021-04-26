<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.driveventures.Controller.utils.*" pageEncoding="ISO-8859-1"%>



<%@include file="/common/header.jsp"%>

<form action="<%=ControllerPaths.RESIDENCIA%>" method="post">
<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.RESIDENCIA%>" /> <br> <br>
	<h3>Buscar por Residencia:</h3>
	<input type="text" name="residencia" placeholder="Residencia" /> <input
		type="submit" value="Buscar" name="residencia" />
</form>

<form action="<%=ControllerPaths.VIAJES%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.VIAJES%>" /> <br> <br>
	<h3>Buscar por Viajes:</h3>
	<select name="Viajes">
		<option value=101>Mayor de 100</option>
		<option value=99>Menor de 100</option>

	</select> <input type="submit" value="Buscar" name="Viajes" />
</form>

<form action="<%=ControllerPaths.BUENARUTA%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.BUENARUTA%>" /> <br> <br>
	<h3>Buscar por Buenas Rutas:</h3>
	<select name="Viajes">
		<option value=101>Mayor de 100</option>
		<option value=99>Menor de 100</option>

	</select> <input type="submit" value="Buscar" name="Viajes" />
</form>


<form action="<%=ControllerPaths.BUENACONVERSACION%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.BUENACONVERSACION%>" /> <br> <br>
	<h3>Buscar por Buena Conversacion:</h3>
	<select name="Viajes">
		<option value=101>Mayor de 100</option>
		<option value=99>Menor de 100</option>

	</select> <input type="submit" value="Buscar" name="Viajes" />
</form>

<form action="<%=ControllerPaths.EXCELENTESERVICIO%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION%>"
		value="<%=Actions.EXCELENTESERVICIO%>" /> <br> <br>
	<h3>Buscar por Excelente Servicio:</h3>
	<select name="Viajes">
		<option value=101>Mayor de 100</option>
		<option value=99>Menor de 100</option>

	</select> <input type="submit" value="Buscar" name="Viajes" />
</form>



</body>
</html>