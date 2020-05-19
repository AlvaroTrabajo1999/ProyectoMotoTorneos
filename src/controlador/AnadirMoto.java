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
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirMoto.class);
	
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirMoto.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String escape = request.getParameter("escape");
		
		Motocicleta moto = new Motocicleta(Matricula, marca, escape);
		
		anadirEjb.insertMotocicleta(moto);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
		rs.forward(request, response);
		
	}

}
