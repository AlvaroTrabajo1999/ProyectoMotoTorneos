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
import modelo.ejb.EditarEjb;
import modelo.ejb.MultimediaEjb;
import modelo.pojo.Circuito;
import modelo.pojo.MultimediaCircuito;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/EditarCircuito")
public class EditarCircuito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EditarCircuito.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	@EJB
	EditarEjb editarEjb;
	
	/**
	 * do get, toma el circuito deseado y la multimedia de esta y reenvia al jsp de editar circuito
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tomamos la id del circuito deseado
			int id = Integer.parseInt(request.getParameter("id"));
			
			//sacamos los datos de circuito y multimedia gracias a ese id
			Circuito circuito = baseEjb.getCircuitoFromId(id);
			MultimediaCircuito multimedia = multimediaEjb.getMultimediaCircuitoById(id);
			
			//ponemos los atributos
			request.setAttribute("circuito", circuito);
			request.setAttribute("multimedia", multimedia);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de Editar circuito al tratar de buscar un circuito y su multimedia con su id, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp de editar circuito
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarCircuito.jsp");
			rs.forward(request, response);
		}
		
	}

	/**
	 * do post, toma los datos del circcuito en concreto del formulario y los cambia en la base de datos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//datos que tomamos del formulario de editar circuito
		int id = Integer.parseInt(request.getParameter("id"));
		String localidad = request.getParameter("localidad");
		float distancia = Float.parseFloat(request.getParameter("distancia"));
		float recta = Float.parseFloat(request.getParameter("recta"));
		
		//si los datos estan vacios devolvemos a editar circuito con un error
		if (id < 0 || localidad == null || distancia < 0 || recta < 0) {
			request.setAttribute("error", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarCircuito.jsp");
			rs.forward(request, response);
		}
		
		//creamos el circuito para mandarlo a editar
		Circuito circuito = new Circuito(id,localidad,distancia,recta);
		
		
		
		
		
		try {
			//tratamos de editar el circuito
			editarEjb.updateCircuito(circuito);
			
			// TODO: FALTA LA POSIBILIDAD DE EDITAR MULTIMEDIA
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de editar circuito al tratar de modificar el circuito, causa: " + e.getCause());
		} finally {
			//reenviamos al servlet de multimedia general
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=circuitos");
			rs.forward(request, response);
		}
		
	}

}
