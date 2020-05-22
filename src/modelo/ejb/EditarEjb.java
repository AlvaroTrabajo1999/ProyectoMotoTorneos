package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.EditarDao;
import modelo.pojo.Circuito;
import modelo.pojo.Motocicleta;
import modelo.pojo.Piloto;

@Stateless
@LocalBean
public class EditarEjb {
	
	public void updateMoto(Motocicleta moto) {
		EditarDao dao = new EditarDao();
		dao.updateMoto(moto);
	}
	
	public void updatePiloto(Piloto piloto) {
		EditarDao dao = new EditarDao();
		dao.updatePiloto(piloto);
	}
	
	public void updateCircuito(Circuito circuito) {
		EditarDao dao = new EditarDao();
		dao.updateCircuito(circuito);
	}
}
