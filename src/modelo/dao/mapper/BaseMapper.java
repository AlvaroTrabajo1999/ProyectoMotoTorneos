package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Carrera;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;
import modelo.pojo.Usuario;

public interface BaseMapper {

	public ArrayList<Torneo> getTorneos();
	
	public ArrayList<Motocicleta> getMotocicletas();

	public ArrayList<Piloto> getPilotos();
	
	public ArrayList<Circuito> getCircuito();
	
	public Motocicleta getMotocicletaFromMatricula(@Param("matricula") String matricula);
	
	public Piloto getPilotoFromDni(@Param("dni") String dni);
	
	public Circuito getCircuitoFromId(@Param("circuito") int circuito);
	
	public Usuario getUsuario(@Param("id") int id);
	
	public Torneo getTorneoByName(@Param("nombre") String nombre);
	
	public Torneo getTorneoById(@Param("id") int id);
	
	public ArrayList<Carrera> getCarrerasByTorneo(@Param("torneo") int torneo);
}
