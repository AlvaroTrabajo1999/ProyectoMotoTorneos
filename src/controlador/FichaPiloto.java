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
import modelo.pojo.MultimediaPiloto;
import modelo.pojo.Piloto;

/**
 * Servlet implementation class FichaMoto
 */
@WebServlet("/FichaPiloto")
public class FichaPiloto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(FichaPiloto.class);
    
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("id");
		
		try {
			Piloto piloto = baseEjb.getPilotoFromDni(dni);
			MultimediaPiloto multimediaPiloto = multimediaEjb.getMultimediaPilotoById(dni);
			request.setAttribute("piloto", piloto);
			request.setAttribute("multimediaPiloto", multimediaPiloto);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Principal");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/FichaPiloto.jsp");
			rs.forward(request, response);
		}
		
	}

}
