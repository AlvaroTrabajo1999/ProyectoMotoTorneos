package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

public interface MultimediaMapper {

	/**
	 * obtiene toda la multimedia de los circuitos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos();

	/**
	 * obtiene toda la multimedia de las motocicletas y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas();

	/**
	 * obtiene toda la multimedia de los pilotos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaPiloto> getMultimediaPilotos();

	/**
	 * obtiene toda la multimedia de los pilotos filtrando por id de piloto
	 * @return
	 */
	public MultimediaPiloto getMultimediaPilotoById(@Param("piloto") String piloto);

	/**
	 * obtiene toda la multimedia de los circuitos filtrando por id del circuito
	 * @return
	 */
	public MultimediaMotocicleta getMultimediaMotocicletasById(@Param("moto") String moto);

	/**
	 * obtiene toda la multimedia de las moto filtrando por id de piloto
	 * @return
	 */
	public MultimediaCircuito getMultimediaCircuitoById(@Param("circuito") int circuito);
}
