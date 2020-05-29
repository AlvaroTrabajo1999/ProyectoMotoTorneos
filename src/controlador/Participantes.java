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
	
	/**
	 * do get, toma los pilotos y las motos de la base de datos y las planta como atributos ademas del torneo al que perteneceran los participantes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//creamos arraylists con todos los pilotos y motos de la base de datos
			ArrayList<Motocicleta> motos = baseEjb.getMotocicletas();
			ArrayList<Piloto> pilotos = baseEjb.getPilotos();
			
			//si el parametro de la id no es nulo tomaremos su valor y con este el torneo al que corresponde en la base de datos
			if (request.getParameter("id") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				Torneo torneo = baseEjb.getTorneoById(id);
				request.setAttribute("torneo", torneo);
			}
			
			//finalmente creamos los atributos para los anteriores arraylists
			request.setAttribute("motos", motos);
			request.setAttribute("pilotos", pilotos);
		} catch (Exception e) {
			//guardamos el error en el loguer en caso de que este ocurra
			logger.error("error en el controlador do get de Participantes al tratar de tomar los datos del torneo, causa: " + e.getCause());
		} finally {
			//finalmente reenviamos al servlet que toque
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/Vista/Participantes.jsp");
			rs.forward(request, response);
		}
		
	}

	/**
	 * do post, dependiedo de los participante del torneo toma mas o menos participantes, crea las carreras para estos y vincula los participantes con las carreras
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nombreTorneo = Integer.parseInt(request.getParameter("torneo"));
		
		try {
			//tomamos el nombre del torneo, con este sacamos el torneo completo y tras sacar el torneo sacamos sus participantes
			Torneo torneo = baseEjb.getTorneoById(nombreTorneo);
			int participantes = torneo.getParticipantes();
			
			//mediante ifs comprobaremos cuantos participantes tiene el torneo
			if (participantes == 4) {
				
				//primero tomaremos todos los pilotos y los guardaremos en un arraylist
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				//continuamos tomando todas las motos y metiendolas igualmente en un arraylist
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				//por ultimo creamos las participaciones juntando las motos con los pilotos
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}
				
				//creamos las carreras necesarias para dicho torneo y las asociamos con este
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);
				
				try {
					//insertamos en la base de datos las carreras
					anadirEjb.insertCarrera(carreraSemi1);
					anadirEjb.insertCarrera(carreraSemi2);
					anadirEjb.insertCarrera(carreraFinal);
				} catch (Exception e) {
					//guardamos el error en el loguer en caso de que este ocurra
					logger.error("error en el controlador do post de Participantes al tratar de insertar las carreras, causa: " + e.getCause());
				}
				
				//tras insertarlas en la base de datos las volvemos a sacar para poder tomar asi el ID que se les ha asigando
				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				//les asignamos a las participaciones la id de la carrera que les toque
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
				
				//insertamos en la base de datos los participantes
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			} else if (participantes == 8) {
				
				//primero tomaremos todos los pilotos y los guardaremos en un arraylist
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				//continuamos tomando todas las motos y metiendolas igualmente en un arraylist
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				//por ultimo creamos las participaciones juntando las motos con los pilotos
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}
				
				//creamos las carreras necesarias para dicho torneo y las asociamos con este
				Carrera carreraCuart1 = new Carrera(torneo.getID(), 1, 3);
				Carrera carreraCuart2 = new Carrera(torneo.getID(), 2, 3);
				Carrera carreraCuart3 = new Carrera(torneo.getID(), 3, 3);
				Carrera carreraCuart4 = new Carrera(torneo.getID(), 4, 3);
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);

				try {
					//insertamos en la base de datos las carreras
					anadirEjb.insertCarrera(carreraCuart1);
					anadirEjb.insertCarrera(carreraCuart2);
					anadirEjb.insertCarrera(carreraCuart3);
					anadirEjb.insertCarrera(carreraCuart4);
					anadirEjb.insertCarrera(carreraSemi1);
					anadirEjb.insertCarrera(carreraSemi2);
					anadirEjb.insertCarrera(carreraFinal);
				} catch (Exception e) {
					//guardamos el error en el loguer en caso de que este ocurra
					logger.error("error en el controlador do post de Participantes al tratar de insertar las carreras, causa: " + e.getCause());
				}
				
				//tras insertarlas en la base de datos las volvemos a sacar para poder tomar asi el ID que se les ha asigando
				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				//les asignamos a las participaciones la id de la carrera que les toque
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
				
				//insertamos en la base de datos los participantes
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			} else {
				
				//primero tomaremos todos los pilotos y los guardaremos en un arraylist
				ArrayList<String> pilotos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					pilotos.add(request.getParameter("pilotos_"+i));
				}
				
				//continuamos tomando todas las motos y metiendolas igualmente en un arraylist
				ArrayList<String> motos = new ArrayList<String>();
				for (int i = 0; i < participantes; i++) {
					motos.add(request.getParameter("motos_"+i));
				}
				
				//por ultimo creamos las participaciones juntando las motos con los pilotos
				ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
				for (int i = 0; i < participantes; i++) {
					participaciones.add(new Participacion(motos.get(i), pilotos.get(i)));
				}

				//creamos las carreras necesarias para dicho torneo y las asociamos con este
				Carrera carreraOcta1 = new Carrera(torneo.getID(), 1, 4);
				Carrera carreraOcta2 = new Carrera(torneo.getID(), 2, 4);
				Carrera carreraOcta3 = new Carrera(torneo.getID(), 3, 4);
				Carrera carreraOcta4 = new Carrera(torneo.getID(), 4, 4);
				Carrera carreraOcta5 = new Carrera(torneo.getID(), 5, 4);
				Carrera carreraOcta6 = new Carrera(torneo.getID(), 6, 4);
				Carrera carreraOcta7 = new Carrera(torneo.getID(), 7, 4);
				Carrera carreraOcta8 = new Carrera(torneo.getID(), 8, 4);
				Carrera carreraCuart1 = new Carrera(torneo.getID(), 1, 3);
				Carrera carreraCuart2 = new Carrera(torneo.getID(), 2, 3);
				Carrera carreraCuart3 = new Carrera(torneo.getID(), 3, 3);
				Carrera carreraCuart4 = new Carrera(torneo.getID(), 4, 3);
				Carrera carreraSemi1 = new Carrera(torneo.getID(), 1, 2);
				Carrera carreraSemi2 = new Carrera(torneo.getID(), 2, 2);
				Carrera carreraFinal = new Carrera(torneo.getID(), 1, 1);

				try {
					//insertamos en la base de datos las carreras
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
				} catch (Exception e) {
					//guardamos el error en el loguer en caso de que este ocurra
					logger.error("error en el controlador do post de Participantes al tratar de insertar las carreras, causa: " + e.getCause());
				}
				
				//tras insertarlas en la base de datos las volvemos a sacar para poder tomar asi el ID que se les ha asigando
				ArrayList<Carrera> carreras = baseEjb.getCarrerasByTorneo(torneo.getID());
				
				//les asignamos a las participaciones la id de la carrera que les toque
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
						participaciones.get(8).setId_carrera(carreras.get(i).getID());
						participaciones.get(9).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 3 && carreras.get(i).getRonda() == 4) {
						participaciones.get(10).setId_carrera(carreras.get(i).getID());
						participaciones.get(11).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 2 && carreras.get(i).getRonda() == 4) {
						participaciones.get(12).setId_carrera(carreras.get(i).getID());
						participaciones.get(13).setId_carrera(carreras.get(i).getID());
					}
					if (carreras.get(i).getNivel() == 1 && carreras.get(i).getRonda() == 4) {
						participaciones.get(14).setId_carrera(carreras.get(i).getID());
						participaciones.get(15).setId_carrera(carreras.get(i).getID());
					}
				}
				
				//insertamos en la base de datos los participantes
				for (int i = 0; i < participantes; i++) {
					anadirEjb.insertParticipacion(participaciones.get(i));			
				}
				
			}
			
		} catch (Exception e) {
			//en caso de que salte algun error lo guardaremos en el logger:
			logger.error("error en el controlador do post de participantes al crear todos los participantes y carreras, causa: " + e.getCause());
		} finally {
			response.sendRedirect("/MotoServidorRest/Torneo");
		}
		
	}

}
