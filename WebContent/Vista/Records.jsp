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
				//llamamos al ejb que utilizaremos
				RecordsEjb recordsEjb = new RecordsEjb();
			
				// tomamos las mejores vueltas registradas
				ArrayList<MejoresVueltasRecord> mejoresVueltas = (ArrayList<MejoresVueltasRecord>) request.getAttribute("mejoresVueltas");
			
				//comprobamos que tenga algun contenido, y pintamos segun tenga este contenido
				if (mejoresVueltas != null){
					for (MejoresVueltasRecord m : mejoresVueltas){
						out.print("<div>");
						if (recordsEjb.getMultimediaCircuitoById(m.getId_circuito()) != null){
							out.print("		<img src='"+recordsEjb.getMultimediaCircuitoById(m.getId_circuito()).getFotoZenital()+"' width='100'>");
						}
						out.print("		<h2>"+recordsEjb.getCircuitoById(m.getId_circuito()).getLocalidad()+"  "+m.getMejorVuelta()+"</h2>");
						out.print("		<h3></h3>");
						out.print("</div>");
					}
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