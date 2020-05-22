<%@page import="modelo.pojo.Usuario"%>
<%@page import="modelo.pojo.Torneo"%>
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

        <!-- Main CSS-->
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
                <div class="masthead-subheading">¡Comprueba todos tus torneoss creados!</div>
            </div>
        </header>

        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Torneos</h2>
                    <h3 class="section-subheading text-muted">Revisa todos tus torneos y añade mas</h3>
                </div>
                <table id="mytable" class="table table-bordred table-striped">

                    <thead>
                    <th>Nombre</th>
                    <th>Participantes</th>
                    <th>Circcuito</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>

                    <tbody>
	                    <%
							// tomamos el atributo de los torneos:
							ArrayList<Torneo> torneos = (ArrayList<Torneo>) request.getAttribute("torneos");
						
							//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
							if (torneos != null){
								for (Torneo t : torneos){
									out.print("<tr>");
									out.print("		<td>"+t.getNombre()+"</td>");
									out.print("		<td>"+t.getRondas()+"</td>");
									out.print("		<td>"+t.getId_circuito()+"</td>");
									out.print("		<td><button class='btn btn-primary btn-xs'><i class='fas fa-edit'></i></button></td>");
									out.print("		<td><button class='btn btn-danger btn-xs'><i class='fas fa-trash'></i></button></td>");
									out.print("</tr>");
								}
							} else {
								out.print("<tr>");
								out.print("		<td>Sin Datos</td>");
								out.print("		<td>0</td>");
								out.print("		<td>Sin Datos</td>");
								out.print("		<td><button class='btn btn-primary btn-xs'><i class='fas fa-edit'></i></button></td>");
								out.print("		<td><button class='btn btn-danger btn-xs'><i class='fas fa-trash'></i></button></td>");
								out.print("</tr>");
							}
						%>
                        <tr>
                            <td colspan="5"><button class="btn btn-secondary btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" style="width: 100%" ><i class="fas fa-plus"></i></button></td>
                        </tr>
                    </tbody>

                </table>
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