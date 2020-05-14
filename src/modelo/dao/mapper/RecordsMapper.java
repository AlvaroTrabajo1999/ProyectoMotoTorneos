package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Circuito;
import modelo.pojo.MejoresVueltasRecord;
import modelo.pojo.MultimediaCircuito;

public interface RecordsMapper {

	public MultimediaCircuito getMultimediaCircuitoById(@Param("idCircuito") int idCircuito);

	public Circuito getCircuitoById(@Param("idCircuito") int idCircuito);
	
	public ArrayList<MejoresVueltasRecord> getMejoresVueltasRecords();
	
}
