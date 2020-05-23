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
import modelo.pojo.Motocicleta;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirMoto")
public class AnadirMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AnadirEjb anadirEjb;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirMoto.class);
	
	/**
	 * do get, reenvia a otro servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al jsp de añadir moto
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirMoto.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * do post, toma los datos del formulario e inserta una moto nueva en la base de datos, finalmente reenvia a otro servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario
		String Matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String escape = request.getParameter("escape");
		
		//creamos una moto con los datos anteriores
		Motocicleta moto = new Motocicleta(Matricula, marca, escape);
		
		try {
			//y lo añadimos a la base de datos por medio del ejb
			anadirEjb.insertMotocicleta(moto);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de añadir circuito al tratar  de insertar el corcuito, causa: " + e.getCause());
		} finally {
			//terminamos reenviando a otro servlet
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=motos");
			rs.forward(request, response);
		}
		
	}

}
