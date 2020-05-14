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
}
