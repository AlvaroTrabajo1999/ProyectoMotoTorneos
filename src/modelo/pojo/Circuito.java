package modelo.pojo;

public class Circuito {

	private int ID;
	private String localidad;
	private int distancia;
	private int recta;
	
	//CONSTRUCTORES
	
	public Circuito() {
		
	}
	
	public Circuito(int iD, String localidad, int distancia, int recta) {
		super();
		ID = iD;
		this.localidad = localidad;
		this.distancia = distancia;
		this.recta = recta;
	}

	//GETTERS
	
	public int getID() {
		return ID;
	}

	public String getLocalidad() {
		return localidad;
	}

	public int getDistancia() {
		return distancia;
	}

	public int getRecta() {
		return recta;
	}

	//SETTERS
	
	public void setID(int iD) {
		ID = iD;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void setRecta(int recta) {
		this.recta = recta;
	}
	
}
