package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.BaseDao;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
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
	
	public ArrayList<Piloto> getPilotos(){
		BaseDao dao = new BaseDao();
		return dao.getPilotos();
	}
	
	public ArrayList<Circuito> getCircuito(){
		BaseDao dao = new BaseDao();
		return dao.getCircuito();
	}
	
	public Motocicleta getMotocicletaFromMatricula(String matricula){
		BaseDao dao = new BaseDao();
		return dao.getMotocicletaFromMatricula(matricula);
	}
	
	public Piloto getPilotoFromDni(String dni){
		BaseDao dao = new BaseDao();
		return dao.getPilotoFromDni(dni);
	}
	
	public Circuito getCircuitoFromId(String circuito){
		BaseDao dao = new BaseDao();
		return dao.getCircuitoFromId(circuito);
	}
  
}
