package modelo.pojo;

public class Circuito {

	private int ID;
	private String localidad;
	private float distancia;
	private float recta;
	
	//CONSTRUCTORES
	
	public Circuito() {
		
	}
	
	public Circuito(String localidad, float distancia, float recta) {
		super();
		this.localidad = localidad;
		this.distancia = distancia;
		this.recta = recta;
	}
	
	public Circuito(int ID, String localidad, float distancia, float recta) {
		super();
		this.ID = ID;
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

	public float getDistancia() {
		return distancia;
	}

	public float getRecta() {
		return recta;
	}

	//SETTERS

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public void setRecta(float recta) {
		this.recta = recta;
	}
	
}
