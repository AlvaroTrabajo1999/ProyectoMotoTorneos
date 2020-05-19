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
		
		if (usuario.equals("") || contrasena.equals("")) {
			request.setAttribute("errorEmpty", "algo");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		}

		HttpSession session = request.getSession(false);
		session = request.getSession(true);
		Usuario usu = sesionEjb.existsUsuario(usuario, contrasena);
		
		if (usu == null) {
			request.setAttribute("errorEmpty", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Register.jsp");
			rs.forward(request, response);
		} else {
			sesionEjb.loginUsuario(session, usu);
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Principal.jsp");
			rs.forward(request, response);
		}
		
	}

}
