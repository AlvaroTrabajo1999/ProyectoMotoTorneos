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
import modelo.ejb.MultimediaEjb;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

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
	@EJB
	BaseEjb baseEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			
			if (request.getParameter("imagenes") != null) {
				request.setAttribute("datos", request.getParameter("imagenes"));
				doPost(request, response);
			} else {
				//reenviamos al servlet deseado
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
				rs.forward(request, response);
			}
		}

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String datos = "";
		
		if (request.getParameter("imagenes") != null) {
			datos = request.getParameter("imagenes");
		} else {
			datos = (String) request.getAttribute("datos");
		}
		
		request.setAttribute("datosTipo", datos);
		
		if (datos.equals("motos")) {
			
			ArrayList<Motocicleta> multimedia = null;
			if (baseEjb.getMotocicletas() != null) {
				multimedia = baseEjb.getMotocicletas();
			}
			request.setAttribute("datos", multimedia);
			
		} else if (datos.equals("circuitos")) {
			
			ArrayList<Circuito> multimedia = null;
			if (baseEjb.getCircuitos() != null) {
				multimedia = baseEjb.getCircuitos();
			}
			request.setAttribute("datos", multimedia);
			
		} else {
			
			ArrayList<Piloto> multimedia = null;
			if (baseEjb.getPilotos() != null) {
				multimedia = baseEjb.getPilotos();
			}
			request.setAttribute("datos", multimedia);
			
		}
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/MultimediaGeneral.jsp");
		rs.forward(request, response);
		
	}

}
