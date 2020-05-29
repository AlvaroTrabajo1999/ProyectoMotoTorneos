<!DOCTYPE html>
<%@page import="modelo.ejb.MultimediaEjb"%>
<%@page import="modelo.pojo.Piloto"%>
<%@page import="modelo.pojo.Circuito"%>
<%@page import="modelo.pojo.Motocicleta"%>
<%@page import="modelo.pojo.MultimediaPiloto"%>
<%@page import="modelo.pojo.MultimediaCircuito"%>
<%@page import="modelo.pojo.MultimediaMotocicleta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.pojo.Usuario"%>
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
                <div class="masthead-subheading">¡Visualizar el pasado para poder avanzar al futuro!</div>
            </div>
        </header>

        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Multimedia</h2>
                    <h3 class="section-subheading text-muted">Archivos multimedia de los diferentes circuitos, pilotos y motocicletas</h3>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-sm-6 mb-4 mb-lg-0">
                        <div class="portfolio-item">
                            <a class="portfolio-link" href="MultimediaGeneral?imagenes=motos">
                           		<div class="portfolio-hover">
                                	<div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="Vista/assets/img/moto/MotoLogo.png"/>
                            </a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Motocicletas</div>
                                <div class="portfolio-caption-subheading text-muted">Branding</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
                        <div class="portfolio-item">
                            <a class="portfolio-link" href="MultimediaGeneral?imagenes=circuitos">
                            	<div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="Vista/assets/img/circuito/CircuitoLogo.png"/>
                           	</a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Circuitos</div>
                                <div class="portfolio-caption-subheading text-muted">Website Design</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <div class="portfolio-item">
                            <a class="portfolio-link" href="MultimediaGeneral?imagenes=pilotos">
                            	<div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="Vista/assets/img/piloto/PilotoLogo.png"/>
                           	</a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Pilotos</div>
                                <div class="portfolio-caption-subheading text-muted">Photography</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <%
        	//tomamos el valor que nos dira que tipo de datos pintaremos
        	String TiposDatos = (String) request.getAttribute("datosTipo");
        	
        	MultimediaEjb multimediaEjb = new MultimediaEjb();
        
        	//si los datos no son nulos
        	if (TiposDatos != null){
            	
        		// pintaremos una seccion nueva
        		out.print("<section class='page-section bg-light'>");
        		
        		out.print("	<div class='container'>");
        		out.print("		<div class='text-center'>");
        		out.print("			<h2 class='section-heading text-uppercase'>Multimedia Especifica</h2>");
       			out.print("		</div>");
        		out.print("		<div class='row'>");
            	
            	if (TiposDatos.equals("motos")){
            		
            		//tomamos el arraylist en el que metemos todas las motos
            		ArrayList<Motocicleta> motocicletas = (ArrayList<Motocicleta>) request.getAttribute("datos");
            		
            		out.print("<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
            		out.print("		<div class='portfolio-item'>");
            		out.print("			<a class='portfolio-link' href='AnadirMoto'>");
            		out.print("				<div class='portfolio-hover'>");
            		out.print("					<div class='portfolio-hover-content'><i class='fas fa-plus fa-3x'></i></div>");
            		out.print("				</div>");
            		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenMas.png'/>");
           			out.print("			</a>");
            		out.print("			<div class='portfolio-caption'>");
            		out.print("				<div class='portfolio-caption-heading'>Añadir Motocicleta</div>");
            		out.print("			</div>");
            		out.print("		</div>");
            		out.print("</div>");

            		//si el arraylist no es nulo
            		if (motocicletas != null){
            			// por cada moto añadimos una foto
            			for (Motocicleta m : motocicletas){
                    		out.print("	<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
                    		out.print("		<div class='portfolio-item'>");
                    		out.print("			<a class='portfolio-link' href='FichaMoto?id="+m.getMatricula()+"'>");
                    		out.print("				<div class='portfolio-hover'>");
                    		out.print("					<div class='portfolio-hover-content'><i class='fas fa-search fa-3x'></i></div>");
                    		out.print("				</div>");
                    		if (multimediaEjb.getMultimediaMotocicletasById(m.getMatricula()) != null){
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/moto/"+multimediaEjb.getMultimediaMotocicletasById(m.getMatricula()).getFoto1()+"' />");
                    		}else{
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenInterrogacion.png'/>");
                    		}
                   			out.print("			</a>");
                    		out.print("			<div class='portfolio-caption'>");
                    		out.print("				<div class='portfolio-caption-heading'>"+m.getMatricula()+"</div>");
                    		out.print("			</div>");
                    		out.print("		</div>");
                    		out.print("	</div>");
                		}
            		}
            		
            	} else if (TiposDatos.equals("circuitos")){
            		//tomamos el arraylist en el que metemos todas los circuitos
            		ArrayList<Circuito> Multimedia = (ArrayList<Circuito>) request.getAttribute("datos");
            		
            		out.print("<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
            		out.print("		<div class='portfolio-item'>");
            		out.print("			<a class='portfolio-link' href='AnadirCircuito'>");
            		out.print("				<div class='portfolio-hover'>");
            		out.print("					<div class='portfolio-hover-content'><i class='fas fa-plus fa-3x'></i></div>");
            		out.print("				</div>");
            		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenMas.png'/>");
           			out.print("			</a>");
            		out.print("			<div class='portfolio-caption'>");
            		out.print("				<div class='portfolio-caption-heading'>Añadir Circuito</div>");
            		out.print("			</div>");
            		out.print("		</div>");
            		out.print("</div>");

            		//si el arraylist no es nulo
            		if (Multimedia != null){
            			// por cada moto añadimos una foto
            			for (Circuito c : Multimedia){
                    		out.print("	<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
                    		out.print("		<div class='portfolio-item'>");
                    		out.print("			<a class='portfolio-link' href='FichaCircuito?id="+c.getID()+"'>");
                    		out.print("				<div class='portfolio-hover'>");
                    		out.print("					<div class='portfolio-hover-content'><i class='fas fa-search fa-3x'></i></div>");
                    		out.print("				</div>");
                    		if (multimediaEjb.getMultimediaCircuitoById(c.getID()) != null){
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/circuito/"+multimediaEjb.getMultimediaCircuitoById(c.getID()).getFoto1()+"' />");
                    		}else{
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenInterrogacion.png'/>");
                    		}
                   			out.print("			</a>");
                    		out.print("			<div class='portfolio-caption'>");
                    		out.print("				<div class='portfolio-caption-heading'>"+c.getLocalidad()+"</div>");
                    		out.print("			</div>");
                    		out.print("		</div>");
                    		out.print("	</div>");
                		}
            		}
            	} else {
            		//tomamos el arraylist en el que metemos todas los pilotos
            		ArrayList<Piloto> Multimedia = (ArrayList<Piloto>) request.getAttribute("datos");
            		
            		out.print("<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
            		out.print("		<div class='portfolio-item'>");
            		out.print("			<a class='portfolio-link' href='AnadirPiloto'>");
            		out.print("				<div class='portfolio-hover'>");
            		out.print("					<div class='portfolio-hover-content'><i class='fas fa-plus fa-3x'></i></div>");
            		out.print("				</div>");
            		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenMas.png'/>");
           			out.print("			</a>");
            		out.print("			<div class='portfolio-caption'>");
            		out.print("				<div class='portfolio-caption-heading'>Añadir Piloto</div>");
            		out.print("			</div>");
            		out.print("		</div>");
            		out.print("</div>");

            		//si el arraylist no es nulo
            		if (Multimedia != null){
            			// por cada moto añadimos una foto
            			for (Piloto p : Multimedia){
                    		out.print("	<div class='col-lg-4 col-sm-6 mb-4 mb-lg-0'>");
                    		out.print("		<div class='portfolio-item'>");
                    		out.print("			<a class='portfolio-link' href='FichaPiloto?id="+p.getDNI()+"'>");
                    		out.print("				<div class='portfolio-hover'>");
                    		out.print("					<div class='portfolio-hover-content'><i class='fas fa-search fa-3x'></i></div>");
                    		out.print("				</div>");
                    		if (multimediaEjb.getMultimediaPilotoById(p.getDNI()) != null){
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/moto/"+multimediaEjb.getMultimediaPilotoById(p.getDNI()).getFoto1()+"' />");
                    		}else{
                        		out.print("				<img class='img-fluid' src='Vista/assets/img/logos/ImagenInterrogacion.png'/>");
                    		}
                   			out.print("			</a>");
                    		out.print("			<div class='portfolio-caption'>");
                    		out.print("				<div class='portfolio-caption-heading'>"+p.getNombre()+" "+p.getApellido()+"</div>");
                    		out.print("			</div>");
                    		out.print("		</div>");
                    		out.print("	</div>");
                		}
            		}
            	}
            	
        		out.print("		</div>");
        		out.print("	</div>");
        		out.print("</section>");
        		
        	}

        %>

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