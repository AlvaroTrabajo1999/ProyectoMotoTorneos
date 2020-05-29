<%@page import="modelo.pojo.Piloto"%>
<%@page import="modelo.pojo.Participacion"%>
<%@page import="modelo.ejb.BaseEjb"%>
<%@page import="modelo.pojo.Carrera"%>
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
                <div class="masthead-subheading">¡Comprueba todos tus torneoss creados!</div>
            </div>
        </header>

		<%
			BaseEjb baseEjb = new BaseEjb();
			Torneo torneo = (Torneo) request.getAttribute("torneo");
			ArrayList<Carrera> carreras = (ArrayList<Carrera>) request.getAttribute("carreras");
			
			int rondas = 0;
			switch (torneo.getParticipantes()){
			case 4:
				rondas = 2; break;
			case 8:
				rondas = 3; break;
			case 16:
				rondas = 4; break;
			}
		%>

        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                <%
                	if (baseEjb.getCarreraEspecifica(1, 1, torneo.getID()).getGanador() != 0){
                		Carrera c = baseEjb.getCarreraEspecifica(1, 1, torneo.getID());
                		Participacion part = baseEjb.getParticipacionById(c.getGanador());
                		Piloto pil = baseEjb.getPilotoFromDni(part.getId_piloto());
                		out.print("<h2 class='section-heading text-uppercase'>¡¡¡Ganador Del Torneo!!!</h2>");
                		out.print("<h2 class='section-heading text-uppercase'>¡¡¡"+pil.getNombre() + " " + pil.getApellido() +"!!!</h2> <br>");
                	} else {
                		out.print("<h2 class='section-heading text-uppercase'>Torneo " + torneo.getNombre() + "</h2>");
                		out.print("<h3 class='section-subheading text-muted'>Pon a punto tu torneo</h3>");
                	};
                %>
                </div>
                
                <div class="row">
                <%
                	for (int i = rondas; i > 0; i--){

                		out.print("<div class='col'>");
                		out.print("	<table class='table table-bordred table-striped'>");
                		
                		if (i == 4){
                			
                			ArrayList<Carrera> carrers = baseEjb.getCarrerasTorneoRondas(torneo.getID(), 4);
                			
                    		for (Carrera c : carrers){
								out.print("<tr>");
                    			
                    			ArrayList<Participacion> participantes = baseEjb.getParticipacionesByIdCarrera(c.getID());

                    			if (participantes.size() == 2){
                    				int participacion0 = participantes.get(0).getID();
                        			int participacion1 = participantes.get(1).getID();
                        			Piloto piloto0 = baseEjb.getPilotoFromDni(participantes.get(0).getId_piloto());
                        			Piloto piloto1 = baseEjb.getPilotoFromDni(participantes.get(1).getId_piloto());
                        			
                        			if (c.getGanador() != 0){
                        				if (c.getGanador() == participacion0){
                        					out.print("			<td><i class='fas fa-crown verde'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				} else {
                        					out.print("			<td><i class='fas fa-times rojo'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				}
                                		out.print("			<br>");
                                		if (c.getGanador() == participacion1){
                                    		out.print("			<i class='fas fa-crown verde'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				} else {
                                    		out.print("			<i class='fas fa-times rojo'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				}
                        			} else {
                        				out.print("			<td>"+piloto0.getNombre() + " " + piloto0.getApellido() + " <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion0+"'><i class='fas fa-crown'></i></a>");
                                		out.print("			<br><br>");
                                		out.print("			"+ piloto1.getNombre() + " " + piloto1.getApellido()+" <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion1+"'><i class='fas fa-crown'></i></a></td>");
                        			}
                    			} else {
                    				out.print("<td>falta seleccionar ganadores</td>");
                    			}
                    			
                        		out.print("</tr>");
                    		}
                    		
                		} else if (i == 3){
                			
                			ArrayList<Carrera> carrers = baseEjb.getCarrerasTorneoRondas(torneo.getID(), 3);
                			
                    		for (Carrera c : carrers){
                    			out.print("<tr>");
                    			
                    			ArrayList<Participacion> participantes = baseEjb.getParticipacionesByIdCarrera(c.getID());

                    			if (participantes.size() == 2){
                    				int participacion0 = participantes.get(0).getID();
                        			int participacion1 = participantes.get(1).getID();
                        			Piloto piloto0 = baseEjb.getPilotoFromDni(participantes.get(0).getId_piloto());
                        			Piloto piloto1 = baseEjb.getPilotoFromDni(participantes.get(1).getId_piloto());
                        			
                        			if (c.getGanador() != 0){
                        				if (c.getGanador() == participacion0){
                        					out.print("			<td><i class='fas fa-crown verde'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				} else {
                        					out.print("			<td><i class='fas fa-times rojo'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				}
                                		out.print("			<br>");
                                		if (c.getGanador() == participacion1){
                                    		out.print("			<i class='fas fa-crown verde'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				} else {
                                    		out.print("			<i class='fas fa-times rojo'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				}
                        			} else {
                        				out.print("			<td>"+piloto0.getNombre() + " " + piloto0.getApellido() + " <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion0+"'><i class='fas fa-crown'></i></a>");
                                		out.print("			<br><br>");
                                		out.print("			"+ piloto1.getNombre() + " " + piloto1.getApellido()+" <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion1+"'><i class='fas fa-crown'></i></a></td>");
                        			}
                    			} else {
                    				out.print("<td>falta seleccionar ganadores</td>");
                    			}
                    			
                        		out.print("</tr>");
                    		}
                			
                		} else if (i == 2){
                			
                			ArrayList<Carrera> carrers = baseEjb.getCarrerasTorneoRondas(torneo.getID(), 2);
                			
                    		for (Carrera c : carrers){
								out.print("<tr>");
                    			
                    			ArrayList<Participacion> participantes = baseEjb.getParticipacionesByIdCarrera(c.getID());

                    			if (participantes.size() == 2){
                    				int participacion0 = participantes.get(0).getID();
                        			int participacion1 = participantes.get(1).getID();
                        			Piloto piloto0 = baseEjb.getPilotoFromDni(participantes.get(0).getId_piloto());
                        			Piloto piloto1 = baseEjb.getPilotoFromDni(participantes.get(1).getId_piloto());
                        			
                        			if (c.getGanador() != 0){
                        				if (c.getGanador() == participacion0){
                        					out.print("			<td><i class='fas fa-crown verde'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				} else {
                        					out.print("			<td><i class='fas fa-times rojo'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				}
                                		out.print("			<br>");
                                		if (c.getGanador() == participacion1){
                                    		out.print("			<i class='fas fa-crown verde'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				} else {
                                    		out.print("			<i class='fas fa-times rojo'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				}
                        			} else {
                        				out.print("			<td>"+piloto0.getNombre() + " " + piloto0.getApellido() + " <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion0+"'><i class='fas fa-crown'></i></a>");
                                		out.print("			<br><br>");
                                		out.print("			"+ piloto1.getNombre() + " " + piloto1.getApellido()+" <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion1+"'><i class='fas fa-crown'></i></a></td>");
                        			}
                    			} else {
                    				out.print("<td>falta seleccionar ganadores</td>");
                    			}
                    			
                        		out.print("</tr>");
                    		}
                			
                		} else {

                			ArrayList<Carrera> carrers = baseEjb.getCarrerasTorneoRondas(torneo.getID(), 1);
                			
                    		for (Carrera c : carrers){
								out.print("<tr>");
                    			
                    			ArrayList<Participacion> participantes = baseEjb.getParticipacionesByIdCarrera(c.getID());

                    			if (participantes.size() == 2){
                    				int participacion0 = participantes.get(0).getID();
                        			int participacion1 = participantes.get(1).getID();
                        			Piloto piloto0 = baseEjb.getPilotoFromDni(participantes.get(0).getId_piloto());
                        			Piloto piloto1 = baseEjb.getPilotoFromDni(participantes.get(1).getId_piloto());
                        			
                        			if (c.getGanador() != 0){
                        				if (c.getGanador() == participacion0){
                        					out.print("			<td><i class='fas fa-crown verde'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				} else {
                        					out.print("			<td><i class='fas fa-times rojo'></i> "+piloto0.getNombre() + " " + piloto0.getApellido());
                        				}
                                		out.print("			<br>");
                                		if (c.getGanador() == participacion1){
                                    		out.print("			<i class='fas fa-crown verde'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				} else {
                                    		out.print("			<i class='fas fa-times rojo'></i> "+piloto1.getNombre() + " " + piloto1.getApellido()+"</td>");
                        				}
                        			} else {
                        				out.print("			<td>"+piloto0.getNombre() + " " + piloto0.getApellido() + " <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion0+"'><i class='fas fa-crown'></i></a>");
                                		out.print("			<br><br>");
                                		out.print("			"+ piloto1.getNombre() + " " + piloto1.getApellido()+" <a class='btn btn-dark' href='Ganador?torneo="+torneo.getID()+"&carrera="+c.getID()+"&part="+participacion1+"'><i class='fas fa-crown'></i></a></td>");
                        			}
                    			} else {
                    				out.print("<td>falta seleccionar ganadores</td>");
                    			}
                    			
                        		out.print("</tr>");
                    		}
                			
                		}
                		
                		out.print("	</table>");
                		out.print("</div>");
                		
                	}
                %>
                </div>
                
                
                
                <table id="mytable" class="table table-bordred table-striped">

                    <tbody>
	                    <%
	                    
						%>
                    </tbody>

                </table>
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