<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.driveventures.model.*" %>

<%@include file="/html/common/header.jsp"%>


<%
	Usuario u = (Usuario) request.getAttribute("Registrado");
%>

<h1>
<%=u.getNombre()%>  <%=u.getApellidos()%>
</h1>

<h2> Email: <%=u.getEmail()%></h2>

<p></p>

</body>
</html>