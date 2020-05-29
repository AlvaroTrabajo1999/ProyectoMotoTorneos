package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Usuario;

public interface EditarMapper {

	/**
	 * Modifica la moto que se le pasa en la base de datos
	 * @param moto : moto a modificar
	 */
	public Integer updateMoto(@Param("moto") Motocicleta moto);

	/**
	 * Modifica el piloto que se le pasa
	 * @param piloto : piloto a modificar
	 */
	public Integer updatePiloto(@Param("piloto") Piloto piloto);

	/**
	 * Modifica el circuito que se le pasa
	 * @param circuito : circuito a modificar
	 */
	public Integer updateCircuito(@Param("circuito") Circuito circuito);

	/**
	 * Borra un torneo mediante su identificador
	 * @param torneo : identificador del torneo
	 */
	public Integer borrarTorneo(@Param("torneo") int torneo);

	public Integer updateUsuario(@Param("usuario") Usuario usuario);

	public Integer ganadorCarrera(@Param("participacion") int participacion, @Param("carrera") int carrera);
}
