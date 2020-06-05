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
import modelo.pojo.Piloto;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirPiloto")
public class AnadirPiloto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AnadirEjb anadirEjb;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirPiloto.class);
	
	/**
	 * do get, simplemente reenvia a otro servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al jsp de añadir piloto
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirPiloto.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * do post, toma los datos del formulario e inserta en la base de datos el nuevo piloto, finalmente reenvia a otro serlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos del formulario 
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float altura = Float.parseFloat(request.getParameter("altura"));
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		//creamos un piloto con los datos anteriormente recolectados
		Piloto piloto = new Piloto(dni, nombre, apellido, edad, peso, altura);
		
		try {
			//insertamos en la base de datos el piloto
			anadirEjb.insertPiloto(piloto);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de añadir circuito al tratar  de insertar el corcuito, causa: " + e.getCause());
		} finally {
			//reenviamos a otro servlet
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=pilotos");
			rs.forward(request, response);
		}
		
	}

}