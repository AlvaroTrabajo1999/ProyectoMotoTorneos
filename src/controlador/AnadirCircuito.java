package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ejb.AnadirEjb;
import modelo.pojo.Circuito;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/AnadirCircuito")
public class AnadirCircuito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reenviamos al servlet de anadir circuito
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/AnadirCircuito.jsp");
		rs.forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos necesarios para crear un circuito del formulario de la vista
		String localidad = request.getParameter("localidad");
		float distancia = Float.parseFloat(request.getParameter("distancia"));
		float recta = Float.parseFloat(request.getParameter("recta"));
		
		//creamos un circuito con dichos datos
		Circuito circuito = new Circuito(localidad, distancia, recta);
		
		//y con el ejb lo añadimos a la base de datos
		anadirEjb.insertCircuito(circuito);
		
		//finalizamos enviando a la vista de multimedia para que pueda ver que si lo ha añadido
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=circuitos");
		rs.forward(request, response);
		
	}

}
