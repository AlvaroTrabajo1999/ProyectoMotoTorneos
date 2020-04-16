package modelo.dao.mapper;

import java.util.ArrayList;

import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public interface BaseMapper {

	public ArrayList<Torneo> getTorneos();
	
	public ArrayList<Motocicleta> getMotocicletas();

	public ArrayList<Piloto> getPilotos();
}
