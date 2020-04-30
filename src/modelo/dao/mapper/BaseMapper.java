package modelo.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

public interface BaseMapper {

	public ArrayList<Torneo> getTorneos();
	
	public ArrayList<Motocicleta> getMotocicletas();
	
	public Motocicleta getMotocicletaFromMatricula(@Param("matricula") String matricula);

	public ArrayList<Piloto> getPilotos();
	
	public Piloto getPilotoFromDni(@Param("dni") String dni);
	
	public Integer insertParticipante(@Param("part") Participacion part);

	public Integer insertMotocicleta(@Param("moto") Motocicleta moto);
	
	public Integer insertPiloto(@Param("piloto") Piloto pilot);
}
