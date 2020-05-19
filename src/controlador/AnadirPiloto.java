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
import modelo.pojo.Piloto;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirPiloto")
public class AnadirPiloto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AnadirPiloto.class);
	
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirPiloto.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		float peso = Float.parseFloat(request.getParameter("peso"));
		String sexo = request.getParameter("sexo");
		float altura = Float.parseFloat(request.getParameter("altura"));
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		Piloto piloto = new Piloto(dni, nombre, apellido, edad, peso, altura);
		
		anadirEjb.insertPiloto(piloto);
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
		rs.forward(request, response);
		
	}

}
