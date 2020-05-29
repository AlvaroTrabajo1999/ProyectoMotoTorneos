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

	/**
	 * inserta en la base de datos la foto de una moto
	 * @param moto : moto a la que se le inserta la imagen
	 * @param foto : foto a insertar
	 * @return
	 */
	public Integer insertMultimediaMoto(@Param("moto") String moto, @Param("foto") String foto);

	/**
	 * inserta en la base de datos la foto de un circuito
	 * @param circuito : circuito al que se le inserta la imagen
	 * @param foto : foto a insertar
	 * @return
	 */
	public Integer insertMultimediaCircuito(@Param("circuito") int circuito, @Param("foto") String foto);

	/**
	 * inserta en la base de datos la foto de un piloto
	 * @param piloto : piloto al que se le inserta la imagen
	 * @param foto : foto a insertar
	 * @return
	 */
	public Integer insertMultimediaPiloto(@Param("piloto") String piloto, @Param("foto") String foto);
}
