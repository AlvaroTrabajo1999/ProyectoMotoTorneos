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
import modelo.ejb.AnadirEjb;
import modelo.ejb.BaseEjb;
import modelo.pojo.Carrera;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

/**
 * Servlet implementation class Participantes
 */
@WebServlet("/Participantes")
public class Participantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//creamos el logger
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Participantes.class);
	
	@EJB
	BaseEjb baseEjb;
	@EJB
	AnadirEjb anadirEjb;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		try {
			ArrayList<Motocicleta> motos = baseEjb.getMotocicletas();
			ArrayList<Piloto> pilotos = baseEjb.getPilotos();
			if (request.getParameter("id") != null) {
				id = Integer.parseInt(request.getParameter("id"));
				Torneo torneo = baseEjb.getTorneoById(id);
				request.setAttribute("torneo", torneo);
			}
			request.setAttribute("motos", motos);
			request.setAttribute("pilotos", pilotos);
		} catch (Exception e) {
			logger.error("error en el controlador do get de Participantes al tratar de tomar los datos del torneo, causa: " + e.getCause());
		} finally {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Participantes.jsp");
			rs.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int nombreTorneo = Integer.parseInt(request.getParameter("torneo"));
			Torneo torneo = baseEjb.getTorneoById(nombreTorneo);
			int participantes = torneo.getParticipantes();
			
			if (participantes == 4) {
				
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}
				
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);
				
				anadirEjb.insertCarrera(carreraSemi1);
				anadirEjb.insertCarrera(carreraSemi2);
				anadirEjb.insertCarrera(carreraFinal);

				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				for (int i = 0; i < carreras.size(); i++) {
					if (carreras.get(i).getNivel() == 2 && carreras.get(i).getRonda() == 2) {
						participaciones.get(0).setId_carrera(carreras.get(i).getID());
						participaciones.get(1).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 1 && carreras.get(i).getRonda() == 2) {
						participaciones.get(2).setId_carrera(carreras.get(i).getID());
						participaciones.get(3).setId_carrera(carreras.get(i).getID());
					}
				}
				
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			} else if (participantes == 8) {
				
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}
				
				Carrera carreraCuart1 = new Carrera(torneo.getID(), 1, 3);
				Carrera carreraCuart2 = new Carrera(torneo.getID(), 2, 3);
				Carrera carreraCuart3 = new Carrera(torneo.getID(), 3, 3);
				Carrera carreraCuart4 = new Carrera(torneo.getID(), 4, 3);
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);

				anadirEjb.insertCarrera(carreraCuart1);
				anadirEjb.insertCarrera(carreraCuart2);
				anadirEjb.insertCarrera(carreraCuart3);
				anadirEjb.insertCarrera(carreraCuart4);
				anadirEjb.insertCarrera(carreraSemi1);
				anadirEjb.insertCarrera(carreraSemi2);
				anadirEjb.insertCarrera(carreraFinal);

				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				for (int i = 0; i < carreras.size(); i++) {
					if (carreras.get(i).getNivel() == 4 && carreras.get(i).getRonda() == 3) {
						participaciones.get(0).setId_carrera(carreras.get(i).getID());
						participaciones.get(1).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 3 && carreras.get(i).getRonda() == 3) {
						participaciones.get(2).setId_carrera(carreras.get(i).getID());
						participaciones.get(3).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 2 && carreras.get(i).getRonda() == 3) {
						participaciones.get(4).setId_carrera(carreras.get(i).getID());
						participaciones.get(5).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 1 && carreras.get(i).getRonda() == 3) {
						participaciones.get(6).setId_carrera(carreras.get(i).getID());
						participaciones.get(7).setId_carrera(carreras.get(i).getID());
					}
				}
				
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			} else {
				
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}

				Carrera carreraOcta1 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta2 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta3 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta4 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta5 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta6 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta7 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta8 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraCuart1 = new Carrera(torneo.getID(), 1, 3);
				Carrera carreraCuart2 = new Carrera(torneo.getID(), 2, 3);
				Carrera carreraCuart3 = new Carrera(torneo.getID(), 3, 3);
				Carrera carreraCuart4 = new Carrera(torneo.getID(), 4, 3);
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);

				anadirEjb.insertCarrera(carreraOcta1);
				anadirEjb.insertCarrera(carreraOcta2);
				anadirEjb.insertCarrera(carreraOcta3);
				anadirEjb.insertCarrera(carreraOcta4);
				anadirEjb.insertCarrera(carreraOcta5);
				anadirEjb.insertCarrera(carreraOcta6);
				anadirEjb.insertCarrera(carreraOcta7);
				anadirEjb.insertCarrera(carreraOcta8);
				anadirEjb.insertCarrera(carreraCuart1);
				anadirEjb.insertCarrera(carreraCuart2);
				anadirEjb.insertCarrera(carreraCuart3);
				anadirEjb.insertCarrera(carreraCuart4);
				anadirEjb.insertCarrera(carreraSemi1);
				anadirEjb.insertCarrera(carreraSemi2);
				anadirEjb.insertCarrera(carreraFinal);

				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				for (int i = 0; i < carreras.size(); i++) {
					if (carreras.get(i).getNivel() == 8 && carreras.get(i).getRonda() == 4) {
						participaciones.get(0).setId_carrera(carreras.get(i).getID());
						participaciones.get(1).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 7 && carreras.get(i).getRonda() == 4) {
						participaciones.get(2).setId_carrera(carreras.get(i).getID());
						participaciones.get(3).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 6 && carreras.get(i).getRonda() == 4) {
						participaciones.get(4).setId_carrera(carreras.get(i).getID());
						participaciones.get(5).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 5 && carreras.get(i).getRonda() == 4) {
						participaciones.get(6).setId_carrera(carreras.get(i).getID());
						participaciones.get(7).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 4 && carreras.get(i).getRonda() == 4) {
						participaciones.get(0).setId_carrera(carreras.get(i).getID());
						participaciones.get(1).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 3 && carreras.get(i).getRonda() == 4) {
						participaciones.get(2).setId_carrera(carreras.get(i).getID());
						participaciones.get(3).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 2 && carreras.get(i).getRonda() == 4) {
						participaciones.get(4).setId_carrera(carreras.get(i).getID());
						participaciones.get(5).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 1 && carreras.get(i).getRonda() == 4) {
						participaciones.get(6).setId_carrera(carreras.get(i).getID());
						participaciones.get(7).setId_carrera(carreras.get(i).getID());
					}
				}
				
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			}
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de participantes, causa: " + e.getCause());
		} finally {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/FichaTorneo");
			rs.forward(request, response);
		}
		
		
		
		
		
	}

}
