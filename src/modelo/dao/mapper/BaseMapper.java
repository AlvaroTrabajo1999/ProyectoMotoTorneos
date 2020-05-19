package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public interface BaseMapper {

	public ArrayList<Torneo> getTorneos();
	
	public ArrayList<Motocicleta> getMotocicletas();

	public ArrayList<Piloto> getPilotos();
	
	public ArrayList<Circuito> getCircuito();
	
	public Motocicleta getMotocicletaFromMatricula(@Param("matricula") String matricula);
	
	public Piloto getPilotoFromDni(@Param("dni") String dni);
	
	public Circuito getCircuitoFromId(@Param("circuito") String circuito);
}
