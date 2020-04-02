package modelo.pojo;

public class Participacion {

	private int ID;
	private String id_moto;
	private String id_piloto;
	private int id_carrera;
	private float mejorVuelta;
	
	//CONSTRUCTORES
	
	public Participacion() {
		
	}
	
	public Participacion(int iD, String id_moto, String id_piloto, int id_carrera, float mejorVuelta) {
		super();
		ID = iD;
		this.id_moto = id_moto;
		this.id_piloto = id_piloto;
		this.id_carrera = id_carrera;
		this.mejorVuelta = mejorVuelta;
	}

	//GETTERS
	
	public int getID() {
		return ID;
	}

	public String getId_moto() {
		return id_moto;
	}

	public String getId_piloto() {
		return id_piloto;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public float getMejorVuelta() {
		return mejorVuelta;
	}

	//SETTERS
	
	public void setID(int iD) {
		ID = iD;
	}

	public void setId_moto(String id_moto) {
		this.id_moto = id_moto;
	}

	public void setId_piloto(String id_piloto) {
		this.id_piloto = id_piloto;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public void setMejorVuelta(float mejorVuelta) {
		this.mejorVuelta = mejorVuelta;
	}
	
}
