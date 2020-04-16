package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.BaseDao;
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
	
}
