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
import modelo.ejb.BaseEjb;
import modelo.ejb.RecordsEjb;
import modelo.pojo.Circuito;

/**
 * Servlet implementation class Records
 */
@WebServlet("/Records")
public class Records extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Records.class);
	
	@EJB
	RecordsEjb RecordsEjb;
	@EJB
	BaseEjb baseEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//guardamos en un array todos los datos necesarios
			ArrayList<Circuito> circuitos = baseEjb.getCircuitos();
			
			//ponemos los torneos que hemos guardado como un Atributo de la sesion:
			request.setAttribute("circuitos", circuitos);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Records");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Records.jsp");
			rs.forward(request, response);
		}
		
	}

}
