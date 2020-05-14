<%@page import="modelo.pojo.Participacion"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear Torneo</title>
		<link rel="stylesheet" type="text/css" href="Vista/General.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				
				for (var i = 0; i < 4; i++) {
	        		$("#listaParticipantes").append('<li><a href="ParticipanteNuevo">Añadir/Crear Participante</a></li>');
				}
				
			  	$("#numeroRondas").change(function(){
			  		var valor = $(this).val();
			  		switch (valor) {

			        case "4":
		        		$("#listaParticipantes").empty();
			        	for (var i = 0; i < valor; i++) {
		        			$("#listaParticipantes").append('<li><input type="submit" value="Añadir/Crear Participante" formaction="ParticipanteNuevo"></li>');
// 			        		$("#listaParticipantes").append('<li><a href="ParticipanteNuevo">Añadir/Crear Participante</a></li>');
						}
			          break;

			        case "8":
		        		$("#listaParticipantes").empty();
			        	for (var i = 0; i < valor; i++) {
			        		$("#listaParticipantes").append('<li><a href="ParticipanteNuevo">Añadir/Crear Participante</a></li>');
						}
			          break;

			        case "16":
		        		$("#listaParticipantes").empty();
			        	for (var i = 0; i < valor; i++) {
			        		$("#listaParticipantes").append('<li><a href="ParticipanteNuevo">Añadir/Crear Participante</a></li>');
						}
			          break;

			      }
			  	});
			});
		</script>
	</head>
	<body>
	
		<div id="header">
			<h1>Crear Torneos</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Records">Records</a>
			<a href="MultimediaGeneral">Multimedia</a>
			<a href="Torneo">Torneo</a>
			<a href="Register">Registro</a>
		</div>
	
		<div id="body">
			<form action="CrearTorneo" method="post">
				<fieldset>
					<legend>Crear Torneo</legend>
					
					<lablel>Nombre del Torneo</lablel>
					<input type="text" placeholder="Nombre Torneo"><br><br>
					
					<label>Rondas:</label>
					<select id="numeroRondas">
						<option value="4" selected="selected">4</option>
						<option value="8">8</option>
						<option value="16">16</option>
					</select><br><br>
					
					<label>Participantes:</label>
					<ul id="listaParticipantes">
						
					</ul><br><br>
					
					<input type="submit" value="Crear">
				</fieldset>
			</form>
			
			
			<%
				ArrayList<Participacion> participantesLista = (ArrayList<Participacion>) request.getAttribute("participantesTotales");
				
				if (participantesLista != null){
					for (int i = 0; i < participantesLista.size(); i++) {
						out.print("<p>"+participantesLista.get(i).getId_piloto()+"</p>");
					}
				}
			%>
			
			
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>