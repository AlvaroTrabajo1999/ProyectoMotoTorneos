package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;
import modelo.pojo.Usuario;

public interface BaseMapper {

	/**
	 * saca de la base de datos un array list con todos los torneos
	 * @return
	 */
	public ArrayList<Torneo> getTorneos();

	/**
	 * saca todas las motocicletas de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Motocicleta> getMotocicletas();

	/**
	 * saca todos los pilotos de la base de datos en forma de array list
	 * @return
	 */
	public ArrayList<Piloto> getPilotos();

	/**
	 * saca todos los circuitos de la base de datos en forma de arraylist 
	 * @return
	 */
	public ArrayList<Circuito> getCircuito();

	/**
	 * saca la moto a la que le pertence la matricula
	 * @param matricula : matricula de la moto que se desea obtener
	 * @return
	 */
	public Motocicleta getMotocicletaFromMatricula(@Param("matricula") String matricula);

	/**
	 * saca al piloto al que le pertence el dni
	 * @param dni : dni del piloto que se desea obtener
	 * @return
	 */
	public Piloto getPilotoFromDni(@Param("dni") String dni);

	/**
	 * saca un circuito por medio de su id
	 * @param circuito : identificador del circuito
	 * @return
	 */
	public Circuito getCircuitoFromId(@Param("circuito") int circuito);

	/**
	 * Saca al usuario a quien le pertenezzca la id 
	 * @param id : id del usuario deseado
	 * @return
	 */
	public Usuario getUsuario(@Param("id") int id);

	/**
	 * Obtiene el torneo mediante el nombre de este
	 * @param nombre : nombre del torneo 
	 * @return
	 */
	public Torneo getTorneoByName(@Param("nombre") String nombre);

	/**
	 * saca el torneo mediante su identificador
	 * @param id : identificador del torneo
	 * @return
	 */
	public Torneo getTorneoById(@Param("id") int id);

	/**
	 * toma todas las carreras que pertenecen a un torneo
	 * @param torneo : identificador del torneo
	 * @return
	 */
	public ArrayList<Carrera> getCarrerasByTorneo(@Param("torneo") int torneo);
}
