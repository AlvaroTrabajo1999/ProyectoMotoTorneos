package modelo.dao.mapper;

import java.util.ArrayList;

import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

public interface MultimediaMapper {
	
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos();
	
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas();
	
	public ArrayList<MultimediaPiloto> getMultimediaPilotos();
}
