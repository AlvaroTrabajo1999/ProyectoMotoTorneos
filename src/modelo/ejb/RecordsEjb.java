package modelo.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.RecordsDao;
import modelo.pojo.MejorVueltaCircuito;

@Stateless
@LocalBean
public class RecordsEjb {
	
	public MejorVueltaCircuito getMejorVueltaCircuitoById(int id){
		RecordsDao dao = new RecordsDao();
		return dao.getMejorVueltaCircuitoById(id);
	}
	
}
