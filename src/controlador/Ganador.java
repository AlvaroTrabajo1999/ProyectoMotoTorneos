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
import modelo.ejb.BaseEjb;
import modelo.ejb.EditarEjb;
import modelo.pojo.Carrera;
import modelo.pojo.Participacion;
import modelo.pojo.Torneo;

/**
 * Servlet implementation class Ganador
 */
@WebServlet("/Ganador")
public class Ganador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	EditarEjb editarEjb;
	@EJB
	BaseEjb baseEjb;
	@EJB
	AnadirEjb anadirEjb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_carrera = Integer.parseInt(request.getParameter("carrera"));
		int id_participacion = Integer.parseInt(request.getParameter("part"));
		editarEjb.ganadorCarrera(id_participacion, id_carrera);
		
		int id_torneo = Integer.parseInt(request.getParameter("torneo"));
		
		
		Carrera carrera = baseEjb.getCarreraById(id_carrera);
		Torneo torneo = baseEjb.getTorneoById(id_torneo);
		Participacion participacion = baseEjb.getParticipacionById(id_participacion);
		
		if (carrera.getRonda() == 4) {
			
			Carrera introducir = null;
			Participacion participador =  new Participacion(participacion.getId_moto(), participacion.getId_piloto());
			switch (carrera.getNivel()) {
			case 1: case 2:
				introducir = baseEjb.getCarreraEspecifica(1, 3, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			case 3: case 4:
				introducir = baseEjb.getCarreraEspecifica(2, 3, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			case 5: case 6:
				introducir = baseEjb.getCarreraEspecifica(3, 3, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			case 7: case 8:
				introducir = baseEjb.getCarreraEspecifica(4, 3, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			}
			anadirEjb.insertParticipacion(participador);
			
		} else if (carrera.getRonda() == 3) {
			
			Carrera introducir = null;
			Participacion participador =  new Participacion(participacion.getId_moto(), participacion.getId_piloto());
			switch (carrera.getNivel()) {
			case 1: case 2:
				introducir = baseEjb.getCarreraEspecifica(1, 2, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			case 3: case 4:
				introducir = baseEjb.getCarreraEspecifica(2, 2, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			}
			anadirEjb.insertParticipacion(participador);
			
		} else if (carrera.getRonda() == 2) {
			
			Carrera introducir = null;
			Participacion participador =  new Participacion(participacion.getId_moto(), participacion.getId_piloto());
			switch (carrera.getNivel()) {
			case 1: case 2:
				introducir = baseEjb.getCarreraEspecifica(1, 1, torneo.getID());
				participador.setId_carrera(introducir.getID());
				break;
			}
			anadirEjb.insertParticipacion(participador);
			
		}
		
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/FichaTorneo?id="+id_torneo);
		rs.forward(request, response);
		
	}

}
