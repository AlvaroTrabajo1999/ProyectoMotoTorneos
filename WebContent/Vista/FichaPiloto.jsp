<%@page import="modelo.pojo.MultimediaPiloto"%>
<%@page import="modelo.pojo.Piloto"%>
<%@page import="modelo.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>MoTorneos</title>
        <link rel="icon" type="image/x-icon" href="Vista/assets/img/favicon.ico" />

        <!--Iconos de Font Awesome-->
        <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>

        <!--Family fonts de Google-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />

        <!--CSS/Boostrap-->
        <link href="Vista/css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-shrink" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="Principal"><img src="Vista/assets/img/LogoTorneos.png" /></a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu<i class="fas fa-bars ml-1"></i></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Records">Records</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="MultimediaGeneral">Multimedia</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Torneo">Torneos</a></li>
                        <%
	                        HttpSession sesion = request.getSession(false);
                        	Usuario user = (Usuario) sesion.getAttribute("usuario");
                        
                        	if (user != null){
                        		out.print("<li class='nav-item'><a class='nav-link js-scroll-trigger' href='Usuario'>Usuario</a></li>");
                        	} else {
                        		out.print("<li class='nav-item'><a class='nav-link js-scroll-trigger' href='Register'>Registro</a></li>");
                        	}
                        %>
                    </ul>
                </div>
            </div>
        </nav>

        <header class="masthead">
            <div class="container">
                <div class="masthead-heading">MoTorneos</div>
                <div class="masthead-subheading">Revisa los datos de tus pilotos</div>
            </div>
        </header>

        <section class="page-section" id="about">
            <div class="container">
                <div class="text-center">
                	<%
                		Piloto piloto = (Piloto) request.getAttribute("piloto");
                		if (piloto != null){
                			out.print("<h2 class='section-heading text-uppercase'>Piloto</h2>");
                		} else {
                			out.print("<h2 class='section-heading text-uppercase'>Ha ocurrido un error porfavor vuelva a la pagina principal</h2>");
                		}
                	%>
                </div>
                <div class="swiper-container main-slider" id="myCarousel">
                	<%
                		if (piloto != null){
                			MultimediaPiloto multimedia = (MultimediaPiloto) request.getAttribute("multimediaPiloto");
                			
		            		out.print("<div class='row'>");
		            		out.print("	<div class='col mt-3'>");
		            		if (multimedia != null){
		            			out.print("		<img src='Vista/assets/img/moto/"+multimedia.getFoto1()+"' width='400' height='300' style='border: solid; border-radius: 20px'></img>");
		            		} else {
		            			out.print("		<img src='Vista/assets/img/logos/ImagenInterrogacion.png' width='400' height='300' style='border: solid; border-radius: 20px'></img>");
		            		}
		            		out.print("	</div>");
		            		out.print("	<table class='col mt-3 table' style='display: inline-block;'>");
		            		out.print("		<tr><td><h3>DNI: </h3></td><td><h3>"+piloto.getDNI()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Nombre: </h3></td><td><h3>"+piloto.getNombre()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Apellido: </h3></td><td><h3>"+piloto.getApellido()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Edad: </h3></td><td><h3>"+piloto.getEdad()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Altura: </h3></td><td><h3>"+piloto.getAltura()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Peso: </h3></td><td><h3>"+piloto.getPeso()+"</h3></td></tr>");
		            		out.print("		<tr><td colspan='2'><a href='EditarPiloto?id="+piloto.getDNI()+"'><button class='btn btn-secondary btn-xs' style='width: 100%'><i class='fas fa-edit'></i></button></a></td></tr>");
		            		out.print("	</table>");
		            		out.print("</div>");
                		}
                	%>
				</div>
            </div>
        </section>

        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright © MoTorneos 2020</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a><a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a><a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-right"><a class="mr-3" href="#!">Privacy Policy</a><a href="#!">Terms of Use</a></div>
                </div>
            </div>
        </footer>

        <!-- Bootstrap-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        
        <!--Javascript-->
        <script src="Vista/js/scripts.js"></script>
    </body>
</html>