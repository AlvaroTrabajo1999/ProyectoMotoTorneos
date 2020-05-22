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
import modelo.pojo.MultimediaPiloto;
import modelo.pojo.Piloto;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/EditarPiloto")
public class EditarPiloto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EditarPiloto.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	@EJB
	EditarEjb editarEjb;
	
	/**
	 * do get, tomamos el piloto y su multimedia deseada y finalmente reenviamos al jsp de editar piloto
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tomamos el identificador de piloto
			String dni = request.getParameter("id");
			
			//tomamos el pojo y la multimedia gracias a esa id
			Piloto piloto = baseEjb.getPilotoFromDni(dni);
			MultimediaPiloto multimedia = multimediaEjb.getMultimediaPilotoById(dni);
			
			//ponemos los atributos
			request.setAttribute("piloto", piloto);
			request.setAttribute("multimedia", multimedia);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de Editar piloto al tratar de tomar los datos pojo y multimedia con una id, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarPiloto.jsp");
			rs.forward(request, response);
		}
		
	}

	/**
	 * do post, tomamos los datos del formulario de editar y modificamos los datos de la base de datos, finalmente reevia a otro servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos del formulario de edicion
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		float altura = Float.parseFloat(request.getParameter("altura"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		//comprobamosque estos no esten vacios y si lo estan reenviamos con un error
		if (dni == null || nombre == null || apellido == null || altura < 0 || peso < 0 || edad < 0) {
			request.setAttribute("error", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarPiloto.jsp");
			rs.forward(request, response);
		}
		
		// si no estan vacios creamos un piloto
		Piloto piloto = new Piloto(dni,nombre,apellido,edad,peso,altura);
		
		try {
			//tratamos de modificar el piloto
			editarEjb.updatePiloto(piloto);
			
			// TODO: FALTA LA POSIBILIDAD DE EDITAR MULTIMEDIA
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Editar piloto al tratar de modificar el piloto y su multimedia, causa: " + e.getCause());
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=pilotos");
			rs.forward(request, response);
		}
	
	}

}
