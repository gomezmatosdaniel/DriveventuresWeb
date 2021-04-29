<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ page import="java.util.*,com.driveventures.model.*"
	import="com.driveventures.utils.*"%>

<!DOCTYPE html>
<html lang="es">

  <head>
  
<link rel="icon" type="image/png" href="https://img.icons8.com/plasticine/100/000000/car--v1.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Driveventures</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- fonts -->
    <link href="<%=request.getContextPath()%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="<%=request.getContextPath()%>/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- styles -->
    <link href="<%=request.getContextPath()%>/css/creative.min2.css" rel="stylesheet">
    <script src="/DriveventuresWeb/html/js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="/DriveventuresWeb/html/js/ajax-listeners.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/js/login.js" ></script>
    

  </head>


  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="<%=request.getContextPath()%>/common/Home.jsp"> Driveventures</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/html/Residencia.jsp">Viajes</a>
            </li>
            
             <% if (SessionManager.get(request, SessionAttributeNames.USER) != null) {
            
            } else {
%>
            	  <li class="nav-item">
                  <a class="nav-link js-scroll-trigger" href="<%=request.getContextPath()%>/html/registro.jsp">Registrate</a>
                </li>
            	
     <%   }%>
             <li class="nav-item">
             <p> <a style="color:white;" href ="<%=request.getContextPath()%>/html/user/Perfil.jsp">  Usuario: <strong>${usr.nombre}</strong> </a></p>
             
            </li>
            
                         <% if (SessionManager.get(request, SessionAttributeNames.USER) == null) {
            
            } else {
%>
            
            <li class="nav-item">
             <a style="color: blue;" href="<%=request.getContextPath()%>/Usuario?action=logout">Salir</a>
            </li>
            
             <%   }%>
            
          </ul>
        </div> 
      </div>
    </nav>
    
    
    
  
