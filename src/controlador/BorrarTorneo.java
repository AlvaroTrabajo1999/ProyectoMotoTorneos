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
import modelo.ejb.EditarEjb;

/**
 * Servlet implementation class BorrarTorneo
 */
@WebServlet("/BorrarTorneo")
public class BorrarTorneo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BorrarTorneo.class);
	
	@EJB
	EditarEjb editarEjb;
	
	/**
	 * do get, toma una id de un torneo y borra este de la base de datos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos la id del torneo que deseamos borrar
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			//y intentamos borrar el torneo asociado de la base de datos
			editarEjb.borrarTorneo(id);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de borrar torneo al tratar de borrar torneo, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Torneo");
			rs.forward(request, response);
		}
		
		
		
	}

}