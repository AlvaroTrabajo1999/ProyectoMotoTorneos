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
			
			<!-- Mostrar Todos Los Piloto En Un Select Si Selecciona La Opcion Crear Piloto Muestra El Formulario -->
			
			<form action="">
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
				</fieldset>
			</form>
			
			<!-- Mostrar Todas Las Motos En Un Select Si Selecciona La Opcion Crear Moto Muestra el Formulario -->
			
			<form action="">
				<fieldset>
					<legend>Motocicleta</legend>
					
					<label>Matricula: </label><input type="text">
					
				</fieldset>
			</form>
			
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>