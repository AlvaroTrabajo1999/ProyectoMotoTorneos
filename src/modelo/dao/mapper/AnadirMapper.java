package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public interface AnadirMapper {
	
	public Integer insertParticipante(@Param("part") Participacion part);

	public Integer insertMotocicleta(@Param("moto") Motocicleta moto);
	
	public Integer insertPiloto(@Param("pilot") Piloto pilot);
	
	public Integer insertCircuito(@Param("circuito") Circuito circuito);
	
	public Integer insertTorneo(@Param("torneo") Torneo torneo);
	
	public Integer insertCarrera(@Param("carrera") Carrera carrera);
	
	public Integer insertParticipacion(@Param("part") Participacion participacion);
}
