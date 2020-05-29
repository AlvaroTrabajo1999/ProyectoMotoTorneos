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
import modelo.pojo.Carrera;
import modelo.pojo.Torneo;

/**
 * Servlet implementation class FichaTorneo
 */
@WebServlet("/FichaTorneo")
public class FichaTorneo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EditarMoto.class);
	
	@EJB
	BaseEjb baseEjb;
	
	/**
	 * do get, toma el torneo y sus carreras y las manda al jsp como atributo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int TorneoId = Integer.parseInt(request.getParameter("id"));
			Torneo torneo = baseEjb.getTorneoById(TorneoId);
			
			int rondas = 0;
			switch (torneo.getParticipantes()){
			case 4:
				rondas = 2; break;
			case 8:
				rondas = 3; break;
			case 16:
				rondas = 4; break;
			}
			ArrayList<Carrera> carreras = baseEjb.getCarrerasTorneoRondas(TorneoId, rondas);
			
			request.setAttribute("carreras", carreras);
			request.setAttribute("torneo", torneo);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de ficha torneo al tratar de obtener el torneo y sus carreras, causa: " + e.getCause());
		} finally {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/FichaTorneo.jsp");
			rs.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
