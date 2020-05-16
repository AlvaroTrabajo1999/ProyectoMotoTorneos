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
        <link href="Vista/css/main.css" rel="stylesheet" media="all">
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
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Register">Registro</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <header class="masthead">
            <div class="container">
                <div class="masthead-heading">MoTorneos</div>
                <div class="masthead-subheading">�Unete a nosotros y comencemos algo mejor!</div>
            </div>
        </header>

         <div class="page-wrapper p-t-130 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Formulario De Identificaci�n</h2>
                        <form method="POST">
                            <div class="row row-space">
	                            <%
									String errorLogin = (String) request.getAttribute("errorLogin");
								
									if (errorLogin != null){
										out.print("<p class='invalid-feedback'>Datos erroneos, la contrase�a o el usuario no coinciden</p>");
									}
								%>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Usuario</label>
                                        <input class="input--style-4" type="text" name="first_name">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Contrase�a</label>
                                        <input class="input--style-4" type="text" name="last_name">
                                    </div>
                                </div>
                            </div>
                            <div class="p-t-15">
                                <button class="btnForm btn--radius-2 btn--blue" type="submit">Identificarse</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="page-wrapper p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Formulario De Registro</h2>
                        <form method="POST">
                            <div class="row row-space">
	                            <%
									String errorRegistro =  (String) request.getAttribute("errorRegistro");
			
									if (errorRegistro != null){
										out.print("<p class='invalid-feedback'>Error al registrar al usuario</p>");
									}
								%>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Noombre</label>
                                        <input class="input--style-4" type="text" name="nombre">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Apellido</label>
                                        <input class="input--style-4" type="text" name="apellidos">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Contrase�a</label>
                                        <input class="input--style-4" type="text" name="contrasena">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Confirmar contrase�a</label>
                                        <input class="input--style-4" type="text" name="confirmacion">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Email</label>
                                        <input class="input--style-4" type="email" name="mail">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Usuario</label>
                                        <input class="input--style-4" type="text" name="user">
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="input-group">
                                        <label class="label">Telefono movil</label>
                                        <input class="input--style-4" type="text" name="telefono">
                                    </div>
                                </div>
                            </div>
                            <div class="p-t-15">
                                <button class="btnForm btn--radius-2 btn--blue" type="submit">Registrarse</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright � MoTorneos 2020</div>
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