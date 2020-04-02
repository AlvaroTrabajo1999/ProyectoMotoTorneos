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
		</div>
	
		<div id="body">
			<h1>Torneo</h1>
			
			<%
				// tomamos el atributo de los torneos:
				ArrayList<Torneo> torneos = (ArrayList<Torneo>) request.getAttribute("torneos");
			
				//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
				if (torneos != null){
					out.print("<table>");
					out.print("<tr><th>Identificador</th>  <th>Rondas</th>  <th>Circuito</th>  <th>Nombre</th></tr>");
					
					for (Torneo t : torneos){
						out.print("<tr><td>"+t.getID()+"</td>  <td>"+t.getRondas()+"</td>  <td>"+t.getId_circuito()+"</td>  <td>"+t.getNombre()+"</td></tr>");
					}
					
					out.print("</table>");
				} else {
					out.print("<table>");
					out.print("<tr><th>Identificador</th>  <th>Rondas</th>  <th>Circuito</th>  <th>Nombre</th></tr>");
					out.print("<tr><td colspan='4'>En estos momentos no disponemos de estos datos</td></tr>");
					out.print("</table>");
				}
			%>
			
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>