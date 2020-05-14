package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al login 
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
		rs.forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los parametros del formulario
		String usuario = request.getParameter("user");
		String contrasena = request.getParameter("contrasena");
		
		Usuario usu = sesionEjb.existsUsuario(usuario, contrasena);
		
		if (usu == null) {
			request.setAttribute("errorLogin", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		} else {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
			rs.forward(request, response);
		}
		
	}

}
