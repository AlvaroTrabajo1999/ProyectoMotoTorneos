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
	</head>
	<body>
	
		<div id="header">
			<h1>Moto Torneos</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Torneo">Torneo</a>
		</div>
	
		<div id="body">
			<h1>Crear un nuevo participante</h1>
			
			
			<form method="post" action="ParticipanteNuevo">
				
				<!-- Mostrar Todos Los Piloto En Un Select Si Selecciona La Opcion Crear Piloto Muestra El Formulario -->
			
				<select name="PilotoFormulario">
				<option value="crearPiloto">Crear Piloto Nuevo</option>
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
				
				<fieldset>
					<legend>Piloto</legend>
					
					<label>DNI: </label><input type="text">
					<label>Nombre: </label><input type="text">
					<label>Apellido: </label><input type="text">
					<label>Edad: </label><input type="number" min="18" max="110">
					<label>Peso(kg): </label><input type="number" min="0" max="300">
					<label>Altura(cm): </label><input type="text" min="0" max="300">
					<label>Sexo</label><select>
						<option value="Hombre">Hombre</option>
						<option value="Mujer">Mujer</option>
						<option value="Otro">Otro</option>
					</select>
				</fieldset><br>
				
				<!-- Mostrar Todas Las Motos En Un Select Si Selecciona La Opcion Crear Moto Muestra el Formulario -->
				
				<select name="MotoFormulario">
				<option value="crearMoto">Crear Moto Nueva</option>
				<%
					// tomamos el atributo de las motos:
					ArrayList<Motocicleta> motos = (ArrayList<Motocicleta>) request.getAttribute("motociletas");
				
					//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
					if (motos != null){
						for (Motocicleta m : motos){
							out.print("<option value='"+m.getMATRICULA()+"'>"+m.getMarca()+"-"+m.getMATRICULA()+"</option>");
						}
					}
				%>
				</select>
				
				<fieldset>
					<legend>Motocicleta</legend>
					
					<label>Matricula: </label><input type="text">
					<label>Marca: </label><input type="text">
					<label>Escape: </label><input type="text">
				</fieldset><br>
				
				<input type="submit" formaction="CrearTorneo" value="Cancelar"><input type="submit" value="Crear Participante">
				
			</form>
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>