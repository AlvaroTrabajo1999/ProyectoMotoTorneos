<%@page import="modelo.pojo.Motocicleta"%>
<%@page import="modelo.pojo.Piloto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Torneo Motos</title>
		<link rel="stylesheet" type="text/css" href="Vista/General.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
			  	$("#cambioPiloto").change(function(){
			  		var valor = $(this).val();
			    	if (valor=="crearPiloto") {
			    		$("#pilotoExtra").show();
			    	} else {
			    		$("#pilotoExtra").hide();
			    	}
			  	});
			  	
			  	$("#cambioMoto").change(function(){
			  		var valor = $(this).val();
			    	if (valor=="crearMoto") {
			    		$("#motoExtra").show();
			    	} else {
			    		$("#motoExtra").hide();
			    	}
			  	});
			});
		</script>
	</head>
	<body>
	
		<div id="header">
			<h1>Moto Torneos</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Records">Records</a>
			<a href="MultimediaGeneral">Multimedia</a>
			<a href="Torneo">Torneo</a>
			<a href="Register">Registro</a>
		</div>
	
		<div id="body">
			<h1>Crear un nuevo participante</h1>
			
			
			<form method="post" action="ParticipanteNuevo">
				
				<!-- Mostrar Todos Los Piloto En Un Select Si Selecciona La Opcion Crear Piloto Muestra El Formulario -->
			
				<select name="PilotoFormulario" id="cambioPiloto">
				<option value="crearPiloto" selected="selected">Crear Piloto Nuevo</option>
				<%
					// tomamos el atributo de los pilotos:
					ArrayList<Piloto> pilotos = (ArrayList<Piloto>) request.getAttribute("pilotos");
				
					//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
					if (pilotos != null){
						for (Piloto p : pilotos){
							out.print("<option value='"+p.getDNI()+"'>"+p.getNombre()+" "+p.getApellido()+"</option>");
						}
					}
				%>
				</select>
				
				<fieldset id="pilotoExtra">
					<legend>Piloto</legend>
					
					<label>DNI: </label><input type="text" name="dni">
					<label>Nombre: </label><input type="text" name="nom">
					<label>Apellido: </label><input type="text" name="apellido">
					<label>Edad: </label><input type="number" min="18" max="110" name="edad">
					<label>Peso(kg): </label><input type="number" min="0" max="300" name="peso">
					<label>Altura(cm): </label><input type="text" min="0" max="300" name="altura">
					<label>Sexo</label><select name="sexo">
						<option value="Hombre">Hombre</option>
						<option value="Mujer">Mujer</option>
						<option value="Otro">Otro</option>
					</select>
				</fieldset><br>
				
				<!-- Mostrar Todas Las Motos En Un Select Si Selecciona La Opcion Crear Moto Muestra el Formulario -->
				
				<select name="MotoFormulario" id="cambioMoto">
				<option value="crearMoto" selected="selected">Crear Moto Nueva</option>
				<%
					// tomamos el atributo de las motos:
					ArrayList<Motocicleta> motos = (ArrayList<Motocicleta>) request.getAttribute("motociletas");
				
					//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
					if (motos != null){
						for (Motocicleta m : motos){
							out.print("<option value='"+m.getMatricula()+"'>"+m.getMarca()+"-"+m.getMatricula()+"</option>");
						}
					}
				%>
				</select>
				
				<fieldset id="motoExtra">
					<legend>Motocicleta</legend>
					
					<label>Matricula: </label><input type="text" name="Matriculs">
					<label>Marca: </label><input type="text" name="Marcs">
					<label>Escape: </label><input type="text" name="Escaps">
				</fieldset><br>
				
				<input type="submit" formaction="CrearTorneo" value="Cancelar"><input type="submit" value="Crear Participante">
				
			</form>
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>