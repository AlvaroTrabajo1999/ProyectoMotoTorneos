<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MoTorneos</title>
		<link rel="stylesheet" type="text/css" href="Vista/General.css"/>
	</head>
	<body>
	
		<div id="header">
			<img src="img/Logo.png" width="75">
			<h1>HOME</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Records">Records</a>
			<a href="MultimediaGeneral">Multimedia</a>
			<a href="Torneo">Torneo</a>
			<a href="Register">Registro</a>
		</div>
	
		<div id="body">
			
			<form action="Login" method="post">
				<fieldset>
					<legend>Login</legend>
					
					<%
						String errorLogin = (String) request.getAttribute("errorLogin");
					
						if (errorLogin != null){
							out.print("<p>Error al comprobar el usuario</p>");
						}
					%>
				
					<label>Usuario </label><input type="text" name="user"><br>
					<label>Contraseña </label><input type="text" name="contrasena"><br>
					
					<input type="submit">
				</fieldset>
			</form>
			
			
			
			<form action="Register" method="post">
				<fieldset>
					<legend>Register</legend>
					
					<%
						String errorRegistro =  (String) request.getAttribute("errorRegistro");
					
// 						if (errorRegistro.equals("usuario")){
// 							out.print("<p>El usuario que intenta registrar</p>");
// 						} else if (errorRegistro.equals("contrasena")) {
// 							out.print("Las contraseñas introducidas no coinciden");
// 						}

						if (errorRegistro != null){
							out.print("<p>Error al registrar al usuario</p>");
						}
					%>
					
					<label>Usuario </label><input type="text" name="user"><br>
					<label>Contraseña </label><input type="text" name="contrasena"><br>
					<label>Confirmación contaseña </label><input type="text" name="confirmacion"><br>
					
					<label>Nombre</label><input type="text" name="nombre"><br>
					<label>Apellidos</label><input type="text" name="apellidos"><br>
					<label>Mail</label><input type="text" name="mail"><br>
					
					<input type="submit">
				</fieldset>
			</form>
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>