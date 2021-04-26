<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.driveventures.Controller.utils.*"%>


<%@include file="/common/header.jsp"%>


<h3>Registro</h3>
      
      <form action="<%=ControllerPaths.USUARIO%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.REGISTRO%>" />
      <input type="email" name="email" placeholder="email"/>
      <input type="text" name="Nombre" placeholder="Nombre"/>
      <input type="text" name="Apellidos" placeholder="Apellidos"/>
      <input type="password" name="Password" placeholder="Password"/>
      <input type="submit" value="Registrarse" name="usuario"/>
      </form>
      
      <p><a href="formlogin.jsp">Si ya tienes una cuenta haz click aqu�</a></p>
      
      <form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.REGISTRO_CONDUCTOR%>" />
			
	  <input type="hidden" name="user_id" value="${usr.id}">
      <input type="text" name="dni" placeholder="Introduzca su DNI" pattern="[0-9]{8}[A-Za-z]{1}" title="Debe poner 8 n�meros y una letra" />
      <input type="text" name="Residencia" placeholder="Residencia"/>
      <select name="Idioma">
		<option value=Espa�ol>Espa�ol</option>
		<option value=Ingl�s>Ingl�s</option>
		<option value=Franc�s>Franc�s</option>
		<option value=Alem�n>Alem�n</option>
		<option value=Gallego>Gallego</option>

	</select>
      <input type="submit" value="Registrarse" name="usuario"/>
      
      </form>
      
      <p><a href="formlogin.jsp">Si ya tienes una cuenta haz click aqu�</a></p>

</body>
</html>