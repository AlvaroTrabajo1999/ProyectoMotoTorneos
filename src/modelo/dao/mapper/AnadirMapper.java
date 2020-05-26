package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public interface AnadirMapper {

	/**
	 * inserta en la base de datos el participante proporcionado
	 * @param part : participante proporcionado
	 */
	public Integer insertParticipante(@Param("part") Participacion part);

	/**
	 * inserta en la base de datos una motocicleta
	 * @param moto : motocicleta que se desea añadir a la base de datos
	 */
	public Integer insertMotocicleta(@Param("moto") Motocicleta moto);

	/**
	 * inserta en la base de datos un piloto
	 * @param pilot : piloto a insertar
	 */
	public Integer insertPiloto(@Param("pilot") Piloto pilot);

	/**
	 * inserta un circuito en la base de datos
	 * @param circuito : circuito que se desea insertar 
	 */
	public Integer insertCircuito(@Param("circuito") Circuito circuito);

	/**
	 * inserta un torneo en la base de datos
	 * @param torneo : torneo que se desea insertar
	 */
	public Integer insertTorneo(@Param("torneo") Torneo torneo);

	/**
	 * inserta en una carrera en la base de datos
	 * @param carrera : carrera que se desea insertar
	 */
	public Integer insertCarrera(@Param("carrera") Carrera carrera);

	/**
	 * inserta una participacion en la base de datos
	 * @param participacion : participacion que se desea insertar
	 */
	public Integer insertParticipacion(@Param("part") Participacion participacion);
}
