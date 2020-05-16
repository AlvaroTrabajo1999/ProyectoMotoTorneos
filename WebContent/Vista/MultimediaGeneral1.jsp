<%@page import="modelo.pojo.MultimediaPiloto"%>
<%@page import="modelo.pojo.MultimediaMotocicleta"%>
<%@page import="modelo.pojo.MultimediaCircuito"%>
<%@page import="modelo.ejb.RecordsEjb"%>
<%@page import="modelo.pojo.MejoresVueltasRecord"%>
<%@page import="java.util.ArrayList"%>
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
			<h1>Records</h1>
		</div>
	
		<div id="navigator">
			<a href="Princial">Home</a>
			<a href="Records">Records</a>
			<a href="MultimediaGeneral">Multimedia</a>
			<a href="Torneo">Torneo</a>
			<a href="Register">Registro</a>
		</div>
	
		<div id="body">
			<%
				ArrayList<MultimediaCircuito> circuitos = (ArrayList<MultimediaCircuito>) request.getAttribute("multimediaCircuito");
				ArrayList<MultimediaMotocicleta> motos = (ArrayList<MultimediaMotocicleta>) request.getAttribute("multimediaMoto");
				ArrayList<MultimediaPiloto> pilotos = (ArrayList<MultimediaPiloto>) request.getAttribute("multimediaPiloto");
				
				out.print("<div>");
				out.print("<img>");
				out.print("<p>Circuitos</p>");
				out.print("</div>");
				
				out.print("<div>");
				out.print("<img>");
				out.print("<p>Motocicletas</p>");
				out.print("</div>");
				
				out.print("<div>");
				out.print("<img>");
				out.print("<p>Pilotos</p>");
				out.print("</div>");
			%>
		</div>
	
		<div id="footer">
			<pre>Alvaro Del Campo - 603 016 222</pre>
		</div>
	
	</body>
</html>