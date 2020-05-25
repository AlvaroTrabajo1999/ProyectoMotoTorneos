package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

public interface EditarMapper {
	
	public Integer updateMoto(@Param("moto") Motocicleta moto);

	public Integer updatePiloto(@Param("piloto") Piloto piloto);

	public Integer updateCircuito(@Param("circuito") Circuito circuito);

	public Integer borrarTorneo(@Param("torneo") int torneo);
}
