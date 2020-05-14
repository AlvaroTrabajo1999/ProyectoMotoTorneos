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
 * Servlet implementation class MultimediaGeneral
 */
@WebServlet("/MultimediaGeneral")
public class MultimediaGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MultimediaGeneral.class);
    
	@EJB
	MultimediaEjb multimediaEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ArrayList<MultimediaCircuito> multimediaCircuito = multimediaEjb.getMultimediaCircuitos();
			ArrayList<MultimediaMotocicleta> multimediaMoto = multimediaEjb.getMultimediaMotocicletas();
			ArrayList<MultimediaPiloto> multimediaPiloto = multimediaEjb.getMultimediaPilotos();

			request.setAttribute("multimediaCircuito", multimediaCircuito);
			request.setAttribute("multimediaMoto", multimediaMoto);
			request.setAttribute("multimediaPiloto", multimediaPiloto);
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
			rs.forward(request, response);
		}

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
