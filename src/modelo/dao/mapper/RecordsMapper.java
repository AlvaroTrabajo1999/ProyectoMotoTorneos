package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.MejorVueltaCircuito;

public interface RecordsMapper {
	
	/**
	 * obtenemos la mejor vuelta de un circuito mediante su identificador
	 * @param id : identificador del circuito
	 * @return
	 */
	public MejorVueltaCircuito getMejorVueltaCircuitoById(@Param("id") int id);
	
}
