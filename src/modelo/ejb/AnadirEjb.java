package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.AnadirDao;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Participacion;
import modelo.pojo.Piloto;

@Stateless
@LocalBean
public class AnadirEjb {

	public void insertParticipante(Participacion part) {
		AnadirDao dao = new AnadirDao();
		dao.insertParticipante(part);
	}
	
	public void insertMotocicleta(Motocicleta moto) {
		AnadirDao dao = new AnadirDao();
		dao.insertMotocicleta(moto);
	}
	
	public void insertPiloto(Piloto pilot) {
		AnadirDao dao = new AnadirDao();
		dao.insertPiloto(pilot);
	}
	
	public void insertCircuito(Circuito circuito) {
		AnadirDao dao = new AnadirDao();
		dao.insertCircuito(circuito);
	}
}
