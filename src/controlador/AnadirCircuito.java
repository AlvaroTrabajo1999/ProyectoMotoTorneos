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
import modelo.pojo.Motocicleta;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirCircuito")
public class AnadirCircuito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirCircuito.class);
	
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirCircuito.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String localidad = request.getParameter("localidad");
		float distancia = Float.parseFloat(request.getParameter("distancia"));
		float recta = Float.parseFloat(request.getParameter("recta"));
		
		Circuito circuito = new Circuito(localidad, distancia, recta);
		
		anadirEjb.insertCircuito(circuito);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
		rs.forward(request, response);
		
	}

}
