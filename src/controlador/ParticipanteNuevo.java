package controlador;

import java.io.IOException;
import java.util.ArrayList;

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
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;

/**
 * Servlet implementation class ParticipanteNuevo
 */
@WebServlet("/ParticipanteNuevo")
public class ParticipanteNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ParticipanteNuevo.class);
	
	@EJB
	BaseEjb baseEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//guardamos en un array todas las motos disponibles y pilotos:
			ArrayList<Motocicleta> motos = baseEjb.getMotocicletas();
			ArrayList<Piloto> pilotos = baseEjb.getPilotos();
			
			//ponemos las motos guardadas como un Atributo de la sesion:
			request.setAttribute("motociletas", motos);
			request.setAttribute("pilotos", pilotos);
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador ParticipadorNuevo, al tomar los datos de motos o pilotos");
		} finally {
			//reenviamos al servlet deseado
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/ParticipanteNuevo.jsp");
			rs.forward(request, response);
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creamos las variables que seran el piloto y su moto definitivas
		Piloto pilotoFinal = null;
		Motocicleta motoFinal = null;

		Participacion part = null;
		
		//tomamos los datos que deseamos
		String PilotoFormulario = request.getParameter("PilotoFormulario");
		String MotoFormulario = request.getParameter("MotoFormulario");
		
		//Comprobamos si quiere un piloto ya existente o uno nuevo
		if (PilotoFormulario == "crearPiloto") {
			
		} else {
			try {
				pilotoFinal = baseEjb.getPilotoFromDni(PilotoFormulario);
			} catch (Exception e) {
				logger.error("error en el controlador ParticipadorNuevo, en el post al tomar un piloto por su dni");
			}
		}
		
		
		
		//Comprobamos si quiere una moto ya existente o una nueva
		if (MotoFormulario == "MotoFormulario") {
			
		} else {
			motoFinal = baseEjb.getMotocicletaFromMatricula(MotoFormulario);
		}
		
		
		
		if (motoFinal != null && pilotoFinal != null) {
			part.setId_moto(motoFinal.getMATRICULA());
			part.setId_piloto(pilotoFinal.getDNI());
			
			baseEjb.insertParticipante(part);
		}
		
	}

}
