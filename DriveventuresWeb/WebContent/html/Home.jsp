<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Driveventures</title>


    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">

  </head>

  <body id="page-top">
  
  

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="Home.jsp"> Driveventures</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="Residencia.jsp">Viajes</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">Tarifas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Como funciona</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Contacto</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="registro.jsp">Registrate</a>
            </li>
            
            <li class="nav-item">
             <p>Usuario: <strong>${usr.nombre}</strong></p>
            </li>
            
          </ul>
        </div> 
      </div>
    </nav>
    


    <header id="header" class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <h1>
              Contrata tu <strong>Viaje</strong> ahora!
            </h1>
            <hr>
          </div>
          <div class="col-lg-8 mx-auto">
            <p class="text-faded mb-5">Usa nuestra calculadora para obtener una <strong>estimación gratuita</strong>.</p>
            <div>
              
               <div class="pac-card" id="pac-card">
                     <div id="pac-container">
                     <div class="form-group">
				    <label>Direccion actual</label>
                   <input id="start" type="text" class="form-control" placeholder="¿Dónde estás ahora mismo?">
                    </div>
                    <div class="form-group">
				    <label>Dirección final</label>
                   <input id="end" type="text" class="form-control" placeholder="¿Dónde quieres ir?">
                    </div>
                </div>
                </div>
                    <div class="form-group">
				    <label>Numero de pasajeros</label>
                   <select id="select">
                       <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="4">5</option>
                      <option value="4">6</option>
                      <option value="4">7</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Si llevas mascotas debes añadir <strong>$10 por la tarifa de mascotas</strong></label>
                   <div class="form-check">
  <input class="form-check-input" type="checkbox" value="Yes" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Sí
  </label>
</div>
                    </div>
                    <button id="eventButton" class="btn btn-primary ">
                        VALE
                    </button>
                    
                    <a id="invisibleButton" href="#output" class="js-scroll-trigger"></a>
                    
                    <!--onclick="start()" -->
				    
				</div>
          </div>
        </div>
      </div>
    </header>
    
    <section id="output" style="display: none">
       <div class="container">
       <div class="row">
        <div class="col-md-6 col-sm-12" id="map" style="height:500px;"></div>
        <div class="col-md-6 col-sm-12">
            <div class="row" style="margin-top: 25px;">
                <div class="col-md-6 col-sm-12">
                    
                    <h5><i class="fa fa-map-marker text-primary "></i> <strong>Comienzo</strong></h5>
                    <p id="startResult"></p>
                </div>
                <div class="col-md-6 col-sm-12">
                    <h5><i class="fa fa-map-marker text-primary "></i> <strong>Destino</strong></h5>
                    <p id="endResult"></p>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="col-md-6 col-sm-12">
                    <h5><i class="fa fa-arrows-h text-primary "></i> <strong>Distancia</strong></h5>
                    <p id="distanceResult"></p>
                </div>
                <div class="col-md-6 col-sm-12">
                    <h5><i class="fa fa-hourglass text-primary "></i> <strong>Duracion</strong></h5>
                    <p id="durationResult"></p>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                
                <div class="col-md-6 col-sm-12">
                    <h5><i class="fa fa-dollar text-primary "></i> <strong>Tarifa</strong></h5>
                    <p id="fareResult"></p>
                </div>
                <div class="col-md-6 col-sm-12">
                 <h5><strong>Buscar conductores cercanos</strong></h5>
                    <div id="paymentArea">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="">
  Buscar
</button>
                        <button id="hiddenButton1" style="display: none" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong"></button>
                        <a id="hiddenButton2" style="display: none" class="btn btn-primary js-scroll-trigger"href="#header"></a>
                   
                    </div>
                    <p id="fareMessage"></p>
                </div>
            </div>
            
        </div>
           </div>
        </div>
    </section>

    <section class="bg-primary" style="background-color: #f9dd39" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-white">Nuestros Precios</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">En Driveventures le ofrecemos la posibilidad de calcular la estimación de la tarifa de su taxi individual en un par de segundos, de forma gratuita.</p>
            <p class="text-faded mb-4">Nuestra tarifa estimada tiene en cuenta la cantidad de pasajeros, la distancia y la duración del viaje.</p>
              
            
          </div>
        </div>
      </div>
    </section>
    
    <script src="https://js.stripe.com/v3/"></script>



    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading">Como funciona</h2>
            <hr class="my-4">
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-4 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-map-marker text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">Ruta</h3>
              <p class="text-muted mb-0">Primero, calculamos la ruta, la duración y la distancia del viaje.</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-4 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-calculator text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">Precio</h3>
              <p class="text-muted mb-0">Luego usamos estos factores para calcular el precio del viaje.</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-4 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-check-square text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">Registro</h3>
              <p class="text-muted mb-0">¡Entonces, si no estás registrado, tendrás la opción de registrarte con nosotros y pagar el viaje!</p>
            </div>
          </div>
         
        </div>
      </div>
    </section>



    <section id="contact" style="background-color: #212529; color: white">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">Contacto</h2>
            <hr class="my-4">
            <p class="mb-5">¡Llámanos o envíanos un correo electrónico y nos pondremos en contacto contigo lo antes posible!</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 ml-auto text-center">
            <i class="fa fa-phone fa-3x mb-3 sr-contact"></i>
            <p>111-111-111</p>
          </div>
          <div class="col-lg-4 mr-auto text-center">
            <i class="fa fa-envelope-o fa-3x mb-3 sr-contact"></i>
            <p>
              <a href="mailto:your-email@your-domain.com">example@direveventures.com</a>
            </p>
          </div>
        </div>
      </div>
    </section>
        

    
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

 
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

 
    <script src="js/creative.min.js"></script>
    
    <script type="text/javascript" src="js/main.js"> </script>

  
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyARFfy8e5YPQHD5xS_9VP4N1PYCHXsI5Xc&libraries=places&callback=initMap"async defer></script>

  </body>

</html>
