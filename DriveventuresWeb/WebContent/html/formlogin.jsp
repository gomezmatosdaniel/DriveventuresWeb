<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="com.driveventures.Controller.utils.*"

pageEncoding="ISO-8859-1"%>

<%@include file="/html/common/header.jsp"%>


<% Cookie[] cookies=request.getCookies(); %>

 <form action="<%=ControllerPaths.USUARIO%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.LOGIN%>" />
      <input type="email" name="<%=ParameterNames.EMAIL%>" value ="<%=ParamUtils.getParameter(request, ParameterNames.EMAIL)%>" placeholder="email"/>
      <input type="password" name="<%=ParameterNames.PASSWORD%>" placeholder="password"/>
      <input type="submit" value="Login" name="UsuarioServlet"/>
      </form>
      

</body>
</html>