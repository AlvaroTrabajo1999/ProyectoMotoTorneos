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
import modelo.ejb.BaseEjb;
import modelo.ejb.MultimediaEjb;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

/**
 * Servlet implementation class MultimediaGeneral
 */
@WebServlet("/MultimediaGeneral")
public class MultimediaGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MultimediaGeneral.class);
    
	@EJB
	MultimediaEjb multimediaEjb;
	@EJB
	BaseEjb baseEjb;
	
	/**
	 * do get, toma un parametro y si este no es nulo reenvia al post, si en cambio este es nulo reenviara al jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//toma el parametro, si este es nulo reenvia al servlet si no este renvia al post
		if (request.getParameter("imagenes") != null) {
			request.setAttribute("datos", request.getParameter("imagenes"));
			doPost(request, response);
		} else {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
			rs.forward(request, response);
		}

	}

	/**
	 * do post, dependiendo de el dato que se pida pondra un arraylist como atributo de la multimedia requerida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creamos un string vacio
		String datos = "";
		
		//y rellenamos el string con el dato dependiendo si es nulo o no
		if (request.getParameter("imagenes") != null) {
			datos = request.getParameter("imagenes");
		} else {
			datos = (String) request.getAttribute("datos");
		}
		
		//y ponemos la variable de datos como atributo
		request.setAttribute("datosTipo", datos);
		
		try {
			//dependiendo del contenido de la variable tomaremos un arraylist o otro
			if (datos.equals("motos")) {
				
				//tomamos los datos de todas las motocicletas
				ArrayList<Motocicleta> multimedia = null;
				if (baseEjb.getMotocicletas() != null) {
					multimedia = baseEjb.getMotocicletas();
				}
				request.setAttribute("datos", multimedia);
				
			} else if (datos.equals("circuitos")) {
				
				//tomamos los datos de todos los circuitos
				ArrayList<Circuito> multimedia = null;
				if (baseEjb.getCircuitos() != null) {
					multimedia = baseEjb.getCircuitos();
				}
				request.setAttribute("datos", multimedia);
				
			} else {
				
				//tomamos los datos de todos los pilotos
				ArrayList<Piloto> multimedia = null;
				if (baseEjb.getPilotos() != null) {
					multimedia = baseEjb.getPilotos();
				}
				request.setAttribute("datos", multimedia);
				
			}
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Login al tratar de comprobar el usuario, causa: " + e.getCause());
		} finally {
			//finalmente redireccioamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
			rs.forward(request, response);
		}
		
	}

}
