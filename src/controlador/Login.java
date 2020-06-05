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

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import modelo.ejb.SesionEJB;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	SesionEJB sesionEjb;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(FichaPiloto.class);
	
	/**
	 * do get, simplemente reenvia al jsp deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al jsp de registro
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * do post, tomamos los datos del login y si el usuario es correcto se iniciará sesion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("contrasena");
		
		//si los datos son nulos reenvia al registro con un error
		if (usuario.equals("") || contrasena.equals("")) {
			request.setAttribute("errorEmpty", "algo");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}

		//creamos el usuario y tomamos la sesion
		Usuario usu = null;
		HttpSession session = request.getSession(false);
		session = request.getSession(true);
		
		try {
			//miramos si existe el usuario en la base de datos
			usu = sesionEjb.existsUsuario(usuario, contrasena);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Login al tratar de comprobar el usuario, causa: " + e.getCause());
		} finally {
			if (usu == null) {
				//si el usuario es nulo es que no coincide y te reenviara con un error
				request.setAttribute("errorEmpty", "error");
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
				rs.forward(request, response);
			} else {
				//si por el contrario el usuario existe te iniciará sesion
				sesionEjb.loginUsuario(session, usu);
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
				rs.forward(request, response);
			}
		}
		
	}

}
