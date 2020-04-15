<%@page import="modelo.pojo.Torneo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Torneos</title>
		<link rel="stylesheet" type="text/css" href="Vista/General.css"/>
</head>
	<body>
	
		<div id="header">
			<h1>Crear Torneos</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Torneo">Torneo</a>
			<a href="CrearTorneo">Crear torneo</a>
		</div>
	
		<div id="body">
			<h1>Elección participante</h1>
			
			<form action="ParticipanteExistente">
			
				<input type="submit" value="Elegir uno existente">
				<input type="submit" formaction="ParticipanteNuevo" value="Crear uno nuevo">
				<input type="submit" formaction="CrearTorneo" value="Cancelar">
			
			</form>
			
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>