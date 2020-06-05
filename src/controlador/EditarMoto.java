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
	
	/**
	 * do get, tomamos un identificador y con este tomamos la moto y su multimedia de la base de datos, finalmente reenviamos al jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tomamos el identificador de la moto
			String matricula = request.getParameter("id");
			
			//con el identificador tomamos el pojo de la moto y su multimedia
			Motocicleta moto = baseEjb.getMotocicletaFromMatricula(matricula);
			MultimediaMotocicleta multimedia = multimediaEjb.getMultimediaMotocicletasById(matricula);
			
			//lo ponemos como atributos
			request.setAttribute("moto", moto);
			request.setAttribute("multimedia", multimedia);
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do get de editar Moto al tratar de obtener la moto y su multimedia, causa: " + e.getCause());
		} finally {
			//reenviamos al jsp de editar moto
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarMoto.jsp");
			rs.forward(request, response);
		}
		
	}

	
	/**
	 * do post, toma los datos del formulario y modifica la moto de la base de datos, finalmente reenvia a otro servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//tomamos los datos del formulario
		String Matricula = request.getParameter("matricula");
		String marca = request.getParameter("marca");
		String escape = request.getParameter("escape");
		
		//si estos estan vacios mandamos de vuelta al jsp con un error
		if (Matricula == null || marca == null || escape == null) {
			request.setAttribute("error", "error");
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/EditarMoto.jsp");
			rs.forward(request, response);
		}
		
		//si por el contrario tienen datos creamos una motocicleta con estos
		Motocicleta moto = new Motocicleta(Matricula, marca, escape);
		
		try {
			//tratamos de editar la moto
			editarEjb.updateMoto(moto);
			
			// TODO: FALTA LA POSIBILIDAD DE EDITAR MULTIMEDIA
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de Editar moto al tratar de modificar una moto y su multimedia, causa: " + e.getCause());
		} finally {
			//reenviamos al servlet que toque, en este caso multimedia general
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/MultimediaGeneral?imagenes=motos");
			rs.forward(request, response);
		}
		
	}

}
