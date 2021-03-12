<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Driveventures</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.min2.css" rel="stylesheet">
    
    <style>
    
    body,
html {
    width: 100%;
    height: 100%
}

body {
    font-family: Merriweather, 'Helvetica Neue', Arial, sans-serif
}

hr {
    max-width: 50px;
    border-width: 3px;
    border-color: rgb(211, 187, 48)
}

hr.light {
    border-color: #fff
}

a {
    color: rgb(211, 187, 48);
    -webkit-transition: all .2s;
    -moz-transition: all .2s;
    transition: all .2s
}

a:hover {
    color: rgb(211, 187, 48)
}

h1,
h2,
h3,
h4,
h5,
h6 {
    font-family: 'Open Sans', 'Helvetica Neue', Arial, sans-serif
}

.bg-primary {
    background-color: rgb(211, 187, 48) !important
}

.bg-dark {
    background-color: #212529 !important
}

.text-faded {
    color: rgba(255, 255, 255, .7)
}

section {
    padding: 8rem 0
}

.section-heading {
    margin-top: 0
}

#mainNav {
    border-bottom: 1px solid rgba(33, 37, 41, .1);
    background-color: #fff;
    font-family: 'Open Sans', 'Helvetica Neue', Arial, sans-serif;
    -webkit-transition: all .2s;
    -moz-transition: all .2s;
    transition: all .2s
}

#mainNav .navbar-brand {
    font-weight: 700;
    text-transform: uppercase;
    color: rgb(211, 187, 48);
    font-family: 'Open Sans', 'Helvetica Neue', Arial, sans-serif
}

#mainNav .navbar-brand:focus,
#mainNav .navbar-brand:hover {
    color: rgb(211, 187, 48)
}

#mainNav .navbar-nav>li.nav-item>a.nav-link,
#mainNav .navbar-nav>li.nav-item>a.nav-link:focus {
    font-size: .9rem;
    font-weight: 700;
    text-transform: uppercase;
    color: #212529
}

#mainNav .navbar-nav>li.nav-item>a.nav-link:focus:hover,
#mainNav .navbar-nav>li.nav-item>a.nav-link:hover {
    color: rgb(211, 187, 48)
}



@media (min-width:992px) {
    #mainNav {
        border-color: transparent;
        background-color: rgb(211, 187, 48)
    }

    #mainNav .navbar-brand {
        color: rgba(255, 255, 255, .7)
    }

    #mainNav .navbar-brand:focus,
    #mainNav .navbar-brand:hover {
        color: black
    }

    #mainNav .navbar-nav>li.nav-item>a.nav-link {
        padding: .5rem 1rem
    }

    #mainNav .navbar-nav>li.nav-item>a.nav-link,
    #mainNav .navbar-nav>li.nav-item>a.nav-link:focus {
        color: rgba(255, 255, 255, .7)
    }

    #mainNav .navbar-nav>li.nav-item>a.nav-link:focus:hover,
    #mainNav .navbar-nav>li.nav-item>a.nav-link:hover {
        color: #fff
    }
}

body {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: #ffffff;
  }

  /* Reset Select */
  select {
    -webkit-appearance: none;
    -moz-appearance: none;
    -ms-appearance: none;
    appearance: none;
    outline: 0;
    box-shadow: none;
    border: 0 !important;
    background: #2c3e50;
    background-image: none;
    
  }
  /* Remove IE arrow */
  select::-ms-expand {
    display: none;
  }
  /* Custom Select */
  .select {
    position: relative;
    display: flex;
    width: 20em;
    height: 3em;
    line-height: 3;
    background: #2c3e50;
    overflow: hidden;
    border-radius: .25em;
    margin-left: 1200px;
    margin-top: -300px;
  }
  select {
    flex: 1;
    padding: 0 .5em;
    color: #fff;
    cursor: pointer;
  }
  /* Arrow */
  .select::after {
    content: '\25BC';
    position: absolute;
    top: 0;
    right: 0;
    padding: 0 1em;
    background: #34495e;
    cursor: pointer;
    pointer-events: none;
    -webkit-transition: .25s all ease;
    -o-transition: .25s all ease;
    transition: .25s all ease;
  }
  /* Transition */
    
    
    </style>

  </head>

  <body id="page-top">
  
  
   <form action="http://localhost:8080/HelloWorld/html/login" method="post">

        <p>Id: <input type="text" name="usuario"></p>
      
        <p><input type="submit" value="id" name="id"></p>
      
      </form>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top"> Driveventures</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#header">Viajes</a>
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
              <a class="nav-link js-scroll-trigger" href="">Registrate</a>
            </li>
            
          </ul>
        </div> 
      </div>
    </nav>
    


    <header id="header" class="masthead text-center text-white d-flex">
    
        <div class="select">
          <select name="slct" id="slct">
            <option selected disabled>Criteros de Búsqueda</option>
            <option value="1" name="1">Nº de Viajes > 50</option>
            <option value="2" name="2">Nº de Viajes < 50</option>
            <option value="3" name="3">Experiencia</option>
            <option value="4" name="4">Nº Plazas</option>
            <option value="5" name="5">Distancia > 2km</option>
            <option value="6" name="6">Distancia < 2km</option>
          </select>
        </div>