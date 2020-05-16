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
import modelo.ejb.SesionEJB;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Register.class);
	
	@EJB
	SesionEJB sesionEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Login/Registro");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("contrasena");
		String confContrasena = request.getParameter("confirmacion");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("mail");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		
		if (sesionEJB.getUsuarioByUser(usuario) == null) {
			if (contrasena.equals(confContrasena)) {
				Usuario usu = new Usuario(nombre,apellidos,usuario,contrasena,mail,telefono);
				
				sesionEJB.registerUsuario(usu);
			} else {
				request.setAttribute("errorRegistro", "contrasena");
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
				rs.forward(request, response);
			}
		} else {
			request.setAttribute("errorRegistro", "usuario");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}
		
		
	}

}
