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
		
		ArrayList<Participacion> participantesTotales = (ArrayList<Participacion>) request.getAttribute("participantesTotales");
		if (participantesTotales == null) {
			participantesTotales = new ArrayList<Participacion>();
		}
		
		//Creamos las variables que seran el piloto y su moto definitivas
		Piloto pilotoFinal = new Piloto();
		Motocicleta motoFinal = new Motocicleta();

		Participacion part = new Participacion();
		
		//tomamos los datos que deseamos
		String PilotoFormulario = request.getParameter("PilotoFormulario");
		String MotoFormulario = request.getParameter("MotoFormulario");
		
		//Comprobamos si quiere un piloto ya existente o uno nuevo
		if (PilotoFormulario.equals("crearPiloto")) {
			
			pilotoFinal.setDNI(request.getParameter("dni"));
			pilotoFinal.setNombre(request.getParameter("nom"));
			pilotoFinal.setApellido(request.getParameter("apellido"));
			pilotoFinal.setEdad(Integer.parseInt(request.getParameter("edad")));
			pilotoFinal.setPeso(Float.parseFloat(request.getParameter("peso")));
			pilotoFinal.setSexo(request.getParameter("sexo"));
			pilotoFinal.setAltura(Float.parseFloat(request.getParameter("altura")));
			
			baseEjb.insertPiloto(pilotoFinal);
			
		} else {
			try {
				pilotoFinal = baseEjb.getPilotoFromDni(PilotoFormulario);
			} catch (Exception e) {
				logger.error("error en el controlador ParticipadorNuevo, en el post al tomar un piloto por su dni");
			}
		}
		
		
		
		//Comprobamos si quiere una moto ya existente o una nueva
		if (MotoFormulario.equals("crearMoto")) {
			
			String MotoMatricula = request.getParameter("Matriculs");
			String MotoMarca = request.getParameter("Marcs");
			String MotoEscape = request.getParameter("Escaps");
			
			motoFinal.setMATRICULA(MotoMatricula);
			motoFinal.setMarca(MotoMarca);
			motoFinal.setTuboEscape(MotoEscape);
			
			baseEjb.insertMotocicleta(motoFinal);
			
		} else {
			motoFinal = baseEjb.getMotocicletaFromMatricula(MotoFormulario);
		}
		
		
		
		if (motoFinal != null && pilotoFinal != null) {
			part.setId_moto(motoFinal.getMATRICULA());
			part.setId_piloto(pilotoFinal.getDNI());
			
//			baseEjb.insertParticipante(part);
			participantesTotales.add(part);
			request.setAttribute("participantesTotales", participantesTotales);
			
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/CrearTorneo.jsp");
			rs.forward(request, response);
		}
		
	}

}
