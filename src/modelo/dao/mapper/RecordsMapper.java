package modelo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.MejorVueltaCircuito;

public interface RecordsMapper {
	
	public MejorVueltaCircuito getMejorVueltaCircuitoById(@Param("id") int id);
	
}
