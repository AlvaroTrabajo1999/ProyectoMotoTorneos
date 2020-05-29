package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.AnadirDao;
import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

@Stateless
@LocalBean
public class AnadirEjb {

	/**
	 * inserta en la base de datos el participante proporcionado
	 * @param part : participante proporcionado
	 */
	public void insertParticipante(Participacion part) {
		AnadirDao dao = new AnadirDao();
		dao.insertParticipante(part);
	}
	
	/**
	 * inserta en la base de datos una motocicleta
	 * @param moto : motocicleta que se desea añadir a la base de datos
	 */
	public void insertMotocicleta(Motocicleta moto) {
		AnadirDao dao = new AnadirDao();
		dao.insertMotocicleta(moto);
	}
	
	/**
	 * inserta en la base de datos un piloto
	 * @param pilot : piloto a insertar
	 */
	public void insertPiloto(Piloto pilot) {
		AnadirDao dao = new AnadirDao();
		dao.insertPiloto(pilot);
	}
	
	/**
	 * inserta un circuito en la base de datos
	 * @param circuito : circuito que se desea insertar 
	 */
	public void insertCircuito(Circuito circuito) {
		AnadirDao dao = new AnadirDao();
		dao.insertCircuito(circuito);
	}
	
	/**
	 * inserta un torneo en la base de datos
	 * @param torneo : torneo que se desea insertar
	 */
	public void insertTorneo(Torneo torneo) {
		AnadirDao dao = new AnadirDao();
		dao.insertTorneo(torneo);
	}
	
	/**
	 * inserta en una carrera en la base de datos
	 * @param carrera : carrera que se desea insertar
	 */
	public void insertCarrera(Carrera carrera) {
		AnadirDao dao = new AnadirDao();
		dao.insertCarrera(carrera);
	}
	
	/**
	 * inserta una participacion en la base de datos
	 * @param participacion : participacion que se desea insertar
	 */
	public void insertParticipacion(Participacion participacion) {
		AnadirDao dao = new AnadirDao();
		dao.insertParticipacion(participacion);
	}

	/**
	 * inserta en la base de datos una imagen de una moto
	 * @param moto : moto a la que se le inserta la imagen
	 * @param foto : foto a insertar
	 */
	public void insertMultimediaMoto(String moto , String foto) {
		AnadirDao dao = new AnadirDao();
		dao.insertMultimediaMoto(moto, foto);
	}

	/**
	 * inserta en la base de datos una imagen de un circuito
	 * @param circuito : circuito a la que se le inserta la imagen
	 * @param foto : foto a insertar
	 */
	public void insertMultimediaCircuito(int circuito , String foto) {
		AnadirDao dao = new AnadirDao();
		dao.insertMultimediaCircuito(circuito, foto);
	}

	/**
	 * inserta en la base de datos una imagen de una moto
	 * @param moto : moto a la que se le inserta la imagen
	 * @param foto : foto a insertar
	 */
	public void insertMultimediaPiloto(String piloto , String foto) {
		AnadirDao dao = new AnadirDao();
		dao.insertMultimediaPiloto(piloto, foto);
	}

}
