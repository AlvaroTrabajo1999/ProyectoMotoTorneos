package controlador;

import java.io.IOException;

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
import modelo.pojo.Circuito;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirCircuito")
public class AnadirCircuito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AnadirEjb anadirEjb;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirCircuito.class);
	
	/**
	 * do get, lo unico que hace es reenviar a otro servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al jsp de anadir circuito
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirCircuito.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * do post, toma los datos del formulario e inserta el circuito en la base de datos, finalmente reenvia a otro servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos necesarios para crear un circuito del formulario de la vista
		String localidad = request.getParameter("localidad");
		float distancia = Float.parseFloat(request.getParameter("distancia"));
		float recta = Float.parseFloat(request.getParameter("recta"));
		
		//creamos un circuito con dichos datos
		Circuito circuito = new Circuito(localidad, distancia, recta);
		
		try {
			//y con el ejb lo añadimos a la base de datos
			anadirEjb.insertCircuito(circuito);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de añadir circuito al tratar  de insertar el corcuito, causa: " + e.getCause());
		} finally {
			//finalizamos enviando a la vista de multimedia para que pueda ver que si lo ha añadido
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=circuitos");
			rs.forward(request, response);
		}
		
	}

}