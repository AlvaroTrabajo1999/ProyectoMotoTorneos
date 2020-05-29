package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.ejb.BaseEjb;
import modelo.ejb.EditarEjb;
import modelo.ejb.MultimediaEjb;
import modelo.ejb.SesionEJB;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EditarUsuario.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	@EJB
	EditarEjb editarEjb;
	@EJB
	SesionEJB sesionEJB;
	
	/**
	 * do get, tomamos el piloto y su multimedia deseada y finalmente reenviamos al jsp de editar piloto
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tomamos el identificador de piloto
			String id = request.getParameter("id");
			//tomamos el pojo y la multimedia gracias a esa id
			Usuario usu = baseEjb.getUsuario(Integer.parseInt(id));
			
			//ponemos los atributos
			request.setAttribute("usuario", usu);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de Editar piloto al tratar de tomar los datos pojo y multimedia con una id, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarUsuario.jsp");
			rs.forward(request, response);
		}
		
	}

	/**
	 * do post, tomamos los datos del formulario de editar y modificamos los datos de la base de datos, finalmente reevia a otro servlet
	 */
	@POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos del formulario de edicion
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String contrasena = request.getParameter("contrasena");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String usuario = request.getParameter("usuario");
		
		//comprobamosque estos no esten vacios y si lo estan reenviamos con un error
		if (nombre == null || apellido == null || mail == null || contrasena == null || telefono < 0 || usuario == null) {
			request.setAttribute("error", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarUsuario.jsp");
			rs.forward(request, response);
		}
		
		Usuario usu = new Usuario(id, nombre, apellido, usuario, mail, contrasena, telefono);
		
		try {
			//tratamos de modificar el piloto
			editarEjb.updateUsuario(usu);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Editar piloto al tratar de modificar el piloto y su multimedia, causa: " + e.getCause());
		} finally {
			response.sendRedirect("/MotoServidorRest/Principal");
		}
	
	}

}
