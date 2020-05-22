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
	
	/**
	 * do get, tomamos la id de la moto y obtenemos la moto y su multimedia, lo reenviaremos al jsp deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos la matricula de la moto deseado
		String Matricula = request.getParameter("id");
		
		try {
			//tomamos los datos de la moto y su multimedia de la base de datos
			Motocicleta moto = baseEjb.getMotocicletaFromMatricula(Matricula);
			MultimediaMotocicleta multimediaMoto = multimediaEjb.getMultimediaMotocicletasById(Matricula);
			
			//ponemos los atributos para enviarlos al jsp
			request.setAttribute("Moto", moto);
			request.setAttribute("multimediaMoto", multimediaMoto);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de ficha moto al tratar de obtener la moto y su multimedia, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/FichaMoto.jsp");
			rs.forward(request, response);
		}
		
	}

}
