package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.BaseDao;
import modelo.dao.MultimediaDao;
import modelo.pojo.Motocicleta;
import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

@Stateless
@LocalBean
public class MultimediaEjb {
	
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaCircuitos();
	}
	
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaMotocicletas();
	}
	
	public ArrayList<MultimediaPiloto> getMultimediaPilotos(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaPilotos();
	}
	
	public MultimediaPiloto getMultimediaPilotoById(String piloto){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaPilotoById(piloto);
	}
	
	public MultimediaCircuito getMultimediaCircuitoById(String circuito){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaCircuitoById(circuito);
	}
	
	public MultimediaMotocicleta getMultimediaMotocicletasById(String moto){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaMotocicletasById(moto);
	}
}
