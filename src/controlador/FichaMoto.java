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
import modelo.pojo.Motocicleta;
import modelo.pojo.MultimediaMotocicleta;

/**
 * Servlet implementation class FichaMoto
 */
@WebServlet("/FichaMoto")
public class FichaMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(FichaMoto.class);
    
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Matricula = request.getParameter("id");
		
		try {
			Motocicleta moto = baseEjb.getMotocicletaFromMatricula(Matricula);
			MultimediaMotocicleta multimediaMoto = multimediaEjb.getMultimediaMotocicletasById(Matricula);
			request.setAttribute("Moto", moto);
			request.setAttribute("multimediaMoto", multimediaMoto);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Principal");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/FichaMoto.jsp");
			rs.forward(request, response);
		}
		
	}

}
