<%@page import="modelo.ejb.MultimediaEjb"%>
<%@page import="modelo.pojo.Circuito"%>
<%@page import="modelo.pojo.Usuario"%>
<%@page import="modelo.ejb.RecordsEjb"%>
<%@page import="modelo.pojo.MejorVueltaCircuito"%>
<%@page import="java.util.ArrayList"%>
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
                <div class="masthead-subheading">Records guardados por la aplicación</div>
            </div>
        </header>

        <section class="page-section" id="about">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Mejores Marcas</h2>
                    <h3 class="section-subheading text-muted">Te animamos a intentar mejorar estas marcas<br>¡ANIMO!</h3>
                </div>
                <ul class="timeline">
                <%
                	RecordsEjb recordsEjb = new RecordsEjb();
            		MultimediaEjb multimediaEjb = new MultimediaEjb();
               		ArrayList<Circuito> circuitos = (ArrayList<Circuito>) request.getAttribute("circuitos");
              	
              		if (circuitos != null){
      					for (int i = 0; i < circuitos.size() ; i++){
      						Circuito actual = circuitos.get(i);
      						
							if (i % 2 == 0){
       							out.print("<li>");
							} else {
       							out.print("<li class='timeline-inverted'>");
							}
				
							if (multimediaEjb.getMultimediaCircuitoById(actual.getID()) != null){
								out.print("<div class='timeline-image'><img class='rounded-circle img-fluid' src='"+multimediaEjb.getMultimediaCircuitoById(actual.getID()).getFoto1()+"'/></div>");
							} else {
								out.print("<div class='timeline-image'><img class='rounded-circle img-fluid' src='Vista/assets/img/logos/logoCircuito.jpg'/></div>");
							}
				
      						out.print("<div class='timeline-panel'>");
      						out.print("		<div class='timeline-heading'>");
      						out.print("			<h4>"+actual.getLocalidad()+"</h4>");
      						if (recordsEjb.getMejorVueltaCircuitoById(actual.getID()) != null){
      							out.print("			<h4 class='subheading'>Record General: "+recordsEjb.getMejorVueltaCircuitoById(actual.getID()).getMejorVuelta()+"</h4>");
      						} else {
      							out.print("			<h4 class='subheading'>Record General: NA</h4>");
      						}
      						
      						out.print("		</div>");
     						out.print("		<div class='timeline-body'><p class='text-muted'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt ut voluptatum eius sapiente, totam reiciendis temporibus qui quibusdam, recusandae sit vero unde, sed, incidunt et ea quo dolore laudantium consectetur!</p></div>");
      						out.print("</div>");
      						out.print("</li>");
      					}
      				}
               	%>
                	
                    <li class="timeline-inverted">
                        <div class="timeline-image">
                            <h4>No Existen<br/>Mas<br/>Datos</h4>
                        </div>
                    </li>
                </ul>
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