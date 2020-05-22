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
import modelo.pojo.Motocicleta;
import modelo.pojo.MultimediaMotocicleta;

/**
 * Servlet implementation class AñadirMoto
 */
@WebServlet("/EditarMoto")
public class EditarMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EditarMoto.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	MultimediaEjb multimediaEjb;
	@EJB
	EditarEjb editarEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String matricula = request.getParameter("id");
			Motocicleta moto = baseEjb.getMotocicletaFromMatricula(matricula);
			MultimediaMotocicleta multimedia = multimediaEjb.getMultimediaMotocicletasById(matricula);
			request.setAttribute("moto", moto);
			request.setAttribute("multimedia", multimedia);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador Multimedia General");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarMoto.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String escape = request.getParameter("escape");
		
		if (Matricula == null || marca == null || escape == null) {
			request.setAttribute("error", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarMoto.jsp");
			rs.forward(request, response);
		}
		
		Motocicleta moto = new Motocicleta(Matricula, marca, escape);
		
		editarEjb.updateMoto(moto);
		
		//FALTA LA POSIBILIDAD DE EDITAR MULTIMEDIA
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=motos");
		rs.forward(request, response);
		
	}

}
