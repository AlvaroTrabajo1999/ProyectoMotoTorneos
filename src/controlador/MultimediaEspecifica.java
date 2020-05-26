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
import modelo.ejb.MultimediaEjb;
import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

/**
 * Servlet implementation class MultimediaEspecifica
 */
@WebServlet("/MultimediaEspecifica")
public class MultimediaEspecifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MultimediaEspecifica.class);
	
	@EJB
	MultimediaEjb multimediaEjb;
	
	/**
	 * do get, toma el tipo de multimedia que se requiere, y lo toma de la base de datos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//toma el tipo de dato que se necesita
			String tipoMultimedia = request.getParameter("especifico");
			
			//comprueba que dato se necesita y toma de la base de datos esto y lo añade como atributo
			if (tipoMultimedia.equals("circuito")) {
				ArrayList<MultimediaCircuito> multimediaCircuito = multimediaEjb.getMultimediaCircuitos();
				request.setAttribute("multimedia", multimediaCircuito);
			} else if (tipoMultimedia.equals("moto")) {
				ArrayList<MultimediaMotocicleta> multimediaMoto = multimediaEjb.getMultimediaMotocicletas();
				request.setAttribute("multimedia", multimediaMoto);
			} else {
				ArrayList<MultimediaPiloto> multimediaPiloto = multimediaEjb.getMultimediaPilotos();
				request.setAttribute("multimedia", multimediaPiloto);
			}
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de Multimedia general al tomar las diferentes multimedias, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
			rs.forward(request, response);
		}
		
	}

}
