package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.BaseDao;
import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;
import modelo.pojo.Usuario;

@Stateless
@LocalBean
public class BaseEjb {

	/**
	 * saca de la base de datos un array list con todos los torneos
	 * @return
	 */
	public ArrayList<Torneo> getTorneos(){
		BaseDao dao = new BaseDao();
		return dao.getTorneos();
	}
	
	/**
	 * saca todas las motocicletas de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Motocicleta> getMotocicletas(){
		BaseDao dao = new BaseDao();
		return dao.getMotocicletas();
	}
	
	/**
	 * saca todos los pilotos de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Piloto> getPilotos(){
		BaseDao dao = new BaseDao();
		return dao.getPilotos();
	}
	
	/**
	 * saca todos los circuitos de la base de datos en forma de arraylist 
	 * @return
	 */
	public ArrayList<Circuito> getCircuitos(){
		BaseDao dao = new BaseDao();
		return dao.getCircuito();
	}
	
	/**
	 * saca la moto a la que le pertence la matricula
	 * @param matricula : matricula de la moto que se desea obtener
	 * @return
	 */
	public Motocicleta getMotocicletaFromMatricula(String matricula){
		BaseDao dao = new BaseDao();
		return dao.getMotocicletaFromMatricula(matricula);
	}
	
	/**
	 * saca al piloto al que le pertence el dni
	 * @param dni : dni del piloto que se desea obtener
	 * @return
	 */
	public Piloto getPilotoFromDni(String dni){
		BaseDao dao = new BaseDao();
		return dao.getPilotoFromDni(dni);
	}
	
	/**
	 * saca un circuito por medio de su id
	 * @param circuito : identificador del circuito
	 * @return
	 */
	public Circuito getCircuitoFromId(int circuito){
		BaseDao dao = new BaseDao();
		return dao.getCircuitoFromId(circuito);
	}
	
	/**
	 * Saca al usuario a quien le pertenezzca la id 
	 * @param id : id del usuario deseado
	 * @return
	 */
	public Usuario getUsuario(int id){
		BaseDao dao = new BaseDao();
		return dao.getUsuario(id);
	}
	
	/**
	 * Obtiene el torneo mediante el nombre de este
	 * @param nombre : nombre del torneo 
	 * @return
	 */
	public Torneo getTorneoByName(String nombre){
		BaseDao dao = new BaseDao();
		return dao.getTorneoByName(nombre);
	}
	
	/**
	 * saca el torneo mediante su identificador
	 * @param id : identificador del torneo
	 * @return
	 */
	public Torneo getTorneoById(int id){
		BaseDao dao = new BaseDao();
		return dao.getTorneoById(id);
	}
	
	/**
	 * toma todas las carreras que pertenecen a un torneo
	 * @param torneo : identificador del torneo
	 * @return
	 */
	public ArrayList<Carrera> getCarrerasByTorneo(int torneo){
		BaseDao dao = new BaseDao();
		return dao.getCarrerasByTorneo(torneo);
	}
}
