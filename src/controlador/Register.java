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
	
	/**
	 * do get, reenvia al jsp deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al servlet deseado
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * do post, toma los datos del usuario y si no hay problemas con este lo añade a la base de datos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String contrasena = request.getParameter("contrasena");
		String confContrasena = request.getParameter("confirmacion");
		String mail = request.getParameter("mail");
		String usuario = request.getParameter("user");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		
		//miramos que ningun dato del formulario sea nulo o este vacio
		if (nombre.equals("") || apellidos.equals("") || contrasena.equals("") || confContrasena.equals("") || mail.equals("") || usuario.equals("") || telefono == 0) {
			//si alguno esta vacio reenviaremos al jsp de nuevo con un error
			request.setAttribute("errorVacio", "algo");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}
		
		//comprobamos que el usuario que ha puesto no existe 
		if (sesionEJB.getUsuarioByUser(usuario) == null) {
			//y si las dos contraseñas coinciden se crea el usuario y se añade a la base de datos
			if (contrasena.equals(confContrasena)) {
				Usuario usu = new Usuario(nombre,apellidos,usuario,contrasena,mail,telefono);
				
				sesionEJB.registerUsuario(usu);
			} else {
				//si por el contrario no coinciden reenviara de nuevo al jsp con un error
				request.setAttribute("errorRegistro", "contrasena");
				RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
				rs.forward(request, response);
			}
		} else {
			//si el usuario ya existe reenviara de nuevo al jsp con un error
			request.setAttribute("errorRegistro", "usuario");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}
		
		
	}

}
