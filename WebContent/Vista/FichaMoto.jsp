<%@page import="modelo.ejb.MultimediaEjb"%>
<%@page import="modelo.pojo.MultimediaMotocicleta"%>
<%@page import="modelo.pojo.Motocicleta"%>
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
                        <%
                        	//si el usuario esta logueado mostrara un nav o otro
	                        HttpSession sesion = request.getSession(false);
                        	Usuario user = (Usuario) sesion.getAttribute("usuario");
                        
                        	if (user == null){
                        		response.sendRedirect("Principal");
                        	} 
                        %>
                        <li class='nav-item'><a class='nav-link js-scroll-trigger' href='Records'>Records</a></li>
                        <li class='nav-item'><a class='nav-link js-scroll-trigger' href='MultimediaGeneral'>Multimedia</a></li>
                        <li class='nav-item'><a class='nav-link js-scroll-trigger' href='Torneo'>Torneos</a></li>
                        <li class='nav-item'><a class='nav-link js-scroll-trigger' href='Usuario'>Usuario</a></li>
                        <li class='nav-item'><a class='nav-link js-scroll-trigger' href='Logout'>Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <header class="masthead">
            <div class="container">
                <div class="masthead-heading">MoTorneos</div>
                <div class="masthead-subheading">Revisa los datos de tus motocicletas</div>
            </div>
        </header>

        <section class="page-section" id="about">
            <div class="container">
                <div class="text-center">
                	<%
                		//tomamos la motocicleta, si esta es nula le decimos al usuario que ha cocurrido un error
                		Motocicleta moto = (Motocicleta) request.getAttribute("Moto");
                		if (moto != null){
                			out.print("<h2 class='section-heading text-uppercase'>Motocicleta</h2>");
                		} else {
                			out.print("<h2 class='section-heading text-uppercase'>Ha ocurrido un error porfavor vuelva a la pagina principal</h2>");
                		}
                	%>
                </div>
                <div class="swiper-container main-slider" id="myCarousel">
                	<%
                		MultimediaEjb multimediaEjb = new MultimediaEjb();
                		
                		if (moto != null){
                			//tomamos los datos de multimedia
                			MultimediaMotocicleta multimedia = (MultimediaMotocicleta) request.getAttribute("multimediaMoto");
                			
                			//pintamos la imagen si la tiene
		            		out.print("<div class='row'>");
		            		out.print("	<div class='col mt-3'>");
		            		if (multimedia != null){
		            			out.print("		<img src='Vista/assets/img/moto/"+multimedia.getFoto1()+"' width='400' height='300' style='border: solid; border-radius: 20px'></img>");
		            		} else {
		            			out.print("		<img src='Vista/assets/img/logos/ImagenInterrogacion.png' width='400' height='300' style='border: solid; border-radius: 20px'></img>");
		            		}
		            		out.print("	</div>");
		            		
		            		//pintamos una tabla con todos los datos relevantes
		            		out.print("	<table class='col mt-3 table' style='display: inline-block;'>");
		            		out.print("		<tr><td><h3>Matricula: </h3></td><td><h3>"+moto.getMatricula()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Marca: </h3></td><td><h3>"+moto.getMarca()+"</h3></td></tr>");
		            		out.print("		<tr><td><h3>Tubo de escape: </h3></td><td><h3>"+moto.getTuboEscape()+"</h3></td></tr>");
		            		if (multimediaEjb.getMultimediaMotocicletasById(moto.getMatricula()) == null){
			            		out.print("		<tr><td><h3>Multimedia: </h3></td><td><h3><a href='SubirImagenMoto?id="+moto.getMatricula()+"'><button class='btn btn-secondary btn-xs' style='width: 100%'><i class='fas fa-edit'></i></button></a></td></tr>");
		            		}
		            		out.print("		<tr><td colspan='2'><a href='EditarMoto?id="+moto.getMatricula()+"'><button class='btn btn-secondary btn-xs' style='width: 100%'><i class='fas fa-edit'></i></button></a></td></tr>");
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
                        <a class="btn btn-dark btn-social mx-2" href="https://twitter.com/home?lang=ES"><i class="fab fa-twitter"></i></a><a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/"><i class="fab fa-facebook-f"></i></a><a class="btn btn-dark btn-social mx-2" href="https://es.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
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