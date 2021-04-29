<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="com.driveventures.utils.*"

pageEncoding="ISO-8859-1"%>

<%@include file="/common/header.jsp"%>


<% Cookie[] cookies=request.getCookies(); %>


 <form action="<%=ControllerPaths.USUARIO%>" method="post">
 <input type="hidden" name="<%=ParameterNames.ACTION%>"
			value="<%=Actions.LOGIN%>" />
			


      <input type="email" id="email" name="<%=ParameterNames.EMAIL%>" value ="<%=ParamUtils.getParameter(request, ParameterNames.EMAIL)%>" placeholder="email"/>
      <input type="password" name="<%=ParameterNames.PASSWORD%>" placeholder="password"/>
      <br>
      <div class="g-recaptcha" data-sitekey="6Ld1ersaAAAAAMGemmgw9c8uIu0oY19MVcdH8DB3"></div>

      <input type="submit" value="Login" name="UsuarioServlet" id="login-form-submit"/>
      </form>
    
    
    <script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
</body>
</html>