package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.ejb.AnadirEjb;
import modelo.ejb.BaseEjb;
import modelo.pojo.Circuito;
import modelo.pojo.Torneo;

/**
 * Servlet implementation class CrearTorneo
 */
@WebServlet("/CrearTorneo")
public class CrearTorneo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CrearTorneo.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ArrayList<Circuito> circuitos = baseEjb.getCircuitos();
			
			request.setAttribute("circuitos", circuitos);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de Crear Torneo al tratar de tomar los datos de los circuitos, causa: " + e.getCause());
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/CrearTorneo.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		int partcipantes = Integer.parseInt(request.getParameter("participantes"));
		int circuito = Integer.parseInt(request.getParameter("circuito"));
		
		Torneo torneo = new Torneo(partcipantes, circuito, nombre);
		
		Torneo torn = null;
		
		try {
			if (baseEjb.getTorneoByName(nombre) != null) {
				request.setAttribute("circuitos", baseEjb.getCircuitos());
				request.setAttribute("error", "error");
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/CrearTorneo.jsp");
				rs.forward(request, response);
			} else {
				anadirEjb.insertTorneo(torneo);
				torn = baseEjb.getTorneoByName(nombre);
			}
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Crear torneo al tratar de añadir a la base de datos el nuevo torneo, causa: " + e.getCause());
		} finally {
			if (torn != null) {
				response.sendRedirect("Participantes?id="+torn.getID());
			} else {
				response.sendRedirect("Participantes");
			}
		}
		
		
	}

}
