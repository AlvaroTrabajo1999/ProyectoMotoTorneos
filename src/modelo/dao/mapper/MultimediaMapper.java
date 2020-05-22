package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

public interface MultimediaMapper {
	
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos();
	
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas();
	
	public ArrayList<MultimediaPiloto> getMultimediaPilotos();

	public MultimediaPiloto getMultimediaPilotoById(@Param("piloto") String piloto);

	public MultimediaMotocicleta getMultimediaMotocicletasById(@Param("moto") String moto);

	public MultimediaCircuito getMultimediaCircuitoById(@Param("circuito") int circuito);
}
