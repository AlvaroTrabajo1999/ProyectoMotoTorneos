package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.BaseDao;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;
import modelo.pojo.Torneo;

@Stateless
@LocalBean
public class BaseEjb {

	public ArrayList<Torneo> getTorneos(){
		BaseDao dao = new BaseDao();
		return dao.getTorneos();
	}
	
	public ArrayList<Motocicleta> getMotocicletas(){
		BaseDao dao = new BaseDao();
		return dao.getMotocicletas();
	}
	
	public Motocicleta getMotocicletaFromMatricula(String matricula){
		BaseDao dao = new BaseDao();
		return dao.getMotocicletaFromMatricula(matricula);
	}
	
	public ArrayList<Piloto> getPilotos(){
		BaseDao dao = new BaseDao();
		return dao.getPilotos();
	}
	
	public Piloto getPilotoFromDni(String dni){
		BaseDao dao = new BaseDao();
		return dao.getPilotoFromDni(dni);
	}
	
	public void insertParticipante(Participacion part) {
		BaseDao dao = new BaseDao();
		dao.insertParticipante(part);
	}
	
	public void insertMotocicleta(Motocicleta moto) {
		BaseDao dao = new BaseDao();
		dao.insertMotocicleta(moto);
	}
	
	public void insertPiloto(Piloto pilot) {
		BaseDao dao = new BaseDao();
		dao.insertPiloto(pilot);
	}
  
}
