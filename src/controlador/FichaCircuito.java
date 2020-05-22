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
import modelo.ejb.BaseEjb;
import modelo.ejb.MultimediaEjb;
import modelo.pojo.Circuito;
import modelo.pojo.MultimediaCircuito;

/**
 * Servlet implementation class FichaMoto
 */
@WebServlet("/FichaCircuito")
public class FichaCircuito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(FichaCircuito.class);
    
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	
	/**
	 * do get, tomamos los datos del circuito deseado y su multimedia y lo enviamos al jsp deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos el id del circuito
		int circuitoid = Integer.parseInt(request.getParameter("id"));
		
		try {
			//sacamos de la base de datos el circuito y su multimedia
			Circuito circuito = baseEjb.getCircuitoFromId(circuitoid);
			MultimediaCircuito multimediaCircuito = multimediaEjb.getMultimediaCircuitoById(circuitoid);
			
			//ponemos los datos obtenidos en atributos
			request.setAttribute("circuito", circuito);
			request.setAttribute("multimediaCircuito", multimediaCircuito);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de ficha circuito al tratar de obtener el circuito y su multimedia, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/FichaCircuito.jsp");
			rs.forward(request, response);
		}
		
	}

}
