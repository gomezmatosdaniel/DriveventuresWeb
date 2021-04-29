
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
      
      <p><a href="formlogin.jsp">Si ya tienes una cuenta haz click aquí</a></p>
      

</body>
</html>