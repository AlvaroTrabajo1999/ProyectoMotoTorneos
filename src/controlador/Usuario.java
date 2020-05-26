package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ejb.BaseEjb;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BaseEjb baseEjb;
	
	/**
	 * do get, reenviamos al servlet deseado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenvia al jsp deseado
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Usuario.jsp");
		rs.forward(request, response);
		
	}

}
