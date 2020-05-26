package modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import modelo.dao.MultimediaDao;
import modelo.pojo.MultimediaCircuito;
import modelo.pojo.MultimediaMotocicleta;
import modelo.pojo.MultimediaPiloto;

@Stateless
@LocalBean
public class MultimediaEjb {
	
	/**
	 * obtiene toda la multimedia de los circuitos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaCircuito> getMultimediaCircuitos(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaCircuitos();
	}
	
	/**
	 * obtiene toda la multimedia de las motocicletas y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaMotocicleta> getMultimediaMotocicletas(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaMotocicletas();
	}
	
	/**
	 * obtiene toda la multimedia de los pilotos y lo guarda en un array list
	 * @return
	 */
	public ArrayList<MultimediaPiloto> getMultimediaPilotos(){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaPilotos();
	}
	
	/**
	 * obtiene toda la multimedia de los pilotos filtrando por id de piloto
	 * @return
	 */
	public MultimediaPiloto getMultimediaPilotoById(String piloto){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaPilotoById(piloto);
	}
	
	/**
	 * obtiene toda la multimedia de los circuitos filtrando por id del circuito
	 * @return
	 */
	public MultimediaCircuito getMultimediaCircuitoById(int circuito){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaCircuitoById(circuito);
	}
	
	/**
	 * obtiene toda la multimedia de las moto filtrando por id de piloto
	 * @return
	 */
	public MultimediaMotocicleta getMultimediaMotocicletasById(String moto){
		MultimediaDao dao = new MultimediaDao();
		return dao.getMultimediaMotocicletasById(moto);
	}
}
