package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.RecordsDao;
import modelo.pojo.Circuito;
import modelo.pojo.MejoresVueltasRecord;
import modelo.pojo.MultimediaCircuito;

@Stateless
@LocalBean
public class RecordsEjb {

	public MultimediaCircuito getMultimediaCircuitoById(int idCircuito){
		RecordsDao dao = new RecordsDao();
		return dao.getMultimediaCircuitoById(idCircuito);
	}
	
	public Circuito getCircuitoById(int idCircuito){
		RecordsDao dao = new RecordsDao();
		return dao.getCircuitoById(idCircuito);
	}
	
	public ArrayList<MejoresVueltasRecord> getMejoresVueltasRecords(){
		RecordsDao dao = new RecordsDao();
		return dao.getMejoresVueltasRecords();
	}
	
}
