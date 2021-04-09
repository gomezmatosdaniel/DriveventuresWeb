<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="com.driveventures.Controller.utils.*"%>


<%@include file="/html/common/header.jsp"%>

<h3>Registro</h3>
      
      <form action="<%=ControllerPaths.CONDUCTOR%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.REGISTRO_COCHE%>" />
      <input type="email" name="email" placeholder="email"/>
      <input type="text" name="Nombre" placeholder="Nombre"/>
      <input type="text" name="Apellidos" placeholder="Apellidos"/>
      <input type="password" name="Password" placeholder="Password"/>
      <input type="submit" value="Registrarse" name="usuario"/>
      </form>

</body>
</html>