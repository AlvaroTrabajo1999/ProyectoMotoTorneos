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
	
	/**
	 * do get, toma todos los circuitos de la base de datos y los envia al jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tomamos todos los circuitos de la base de datos
			ArrayList<Circuito> circuitos = baseEjb.getCircuitos();
			//ponemos los circuitos como atributos
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

	/**
	 * do post, toma todos los datos del formulario y mira si no existe ningun torneo con el mismo nombre y lo añade a la base de datos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario del jsp anterior
		String nombre = request.getParameter("nombre");
		int partcipantes = Integer.parseInt(request.getParameter("participantes"));
		int circuito = Integer.parseInt(request.getParameter("circuito"));
		
		//creamos un torneo con dichos parametros
		Torneo torneo = new Torneo(partcipantes, circuito, nombre);
		
		//creamos un torneo vacio que nos ayudara a saber si el torneo ya existe en la base de datos
		Torneo torn = null;
		
		try {
			//comprobamos si el nombre del torneo ya existe en la base de datos
			if (baseEjb.getTorneoByName(nombre) != null) {
				//si ya existe volveremos al jsp de crear torneo avisandoles que hay un error
				request.setAttribute("circuitos", baseEjb.getCircuitos());
				request.setAttribute("error", "error");
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/CrearTorneo.jsp");
				rs.forward(request, response);
			} else {
				//por el contrario si el torneo no existe lo añadiremos a la base de datos y lo añadiremos a la variable creada anteriormente
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
