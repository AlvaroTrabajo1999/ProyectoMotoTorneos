<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear Torneo</title>
		<link rel="stylesheet" type="text/css" href="Vista/General.css"/>
	</head>
	<body>
	
		<div id="header">
			<h1>Crear Torneos</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Torneo">Torneo</a>
		</div>
	
		<div id="body">
			<form action="CrearTorneo" method="post">
				<fieldset>
					<legend>Crear Torneo</legend>
					
					<lablel>Nombre del Torneo</lablel>
					<input type="text" placeholder="Nombre Torneo">
					
					<br><br><input type="text" value="Crear">
				</fieldset>
			</form>
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>