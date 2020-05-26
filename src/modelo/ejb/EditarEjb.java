package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.EditarDao;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

@Stateless
@LocalBean
public class EditarEjb {
	
	/**
	 * Modifica la moto que se le pasa en la base de datos
	 * @param moto : moto a modificar
	 */
	public void updateMoto(Motocicleta moto) {
		EditarDao dao = new EditarDao();
		dao.updateMoto(moto);
	}
	
	/**
	 * Modifica el piloto que se le pasa
	 * @param piloto : piloto a modificar
	 */
	public void updatePiloto(Piloto piloto) {
		EditarDao dao = new EditarDao();
		dao.updatePiloto(piloto);
	}
	
	/**
	 * Modifica el circuito que se le pasa
	 * @param circuito : circuito a modificar
	 */
	public void updateCircuito(Circuito circuito) {
		EditarDao dao = new EditarDao();
		dao.updateCircuito(circuito);
	}
	
	/**
	 * Borra un torneo mediante su identificador
	 * @param torneo : identificador del torneo
	 */
	public void borrarTorneo(int torneo) {
		EditarDao dao = new EditarDao();
		dao.borrarTorneo(torneo);
	}
}
