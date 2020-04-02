package modelo.pojo;

public class Torneo {

	private int ID;
	private int rondas;
	private int id_circuito;
	private String nombre;
	
	//CONSTRUCTORES
	
	public Torneo() {
		
	}
	
	public Torneo(int iD, int rondas, int id_circuito, String nombre) {
		super();
		ID = iD;
		this.rondas = rondas;
		this.id_circuito = id_circuito;
		this.nombre = nombre;
	}

	//GETTERS
	
	public int getID() {
		return ID;
	}

	public int getRondas() {
		return rondas;
	}

	public int getId_circuito() {
		return id_circuito;
	}

	public String getNombre() {
		return nombre;
	}

	//SETTERS
	
	public void setID(int iD) {
		ID = iD;
	}

	public void setRondas(int rondas) {
		this.rondas = rondas;
	}

	public void setId_circuito(int id_circuito) {
		this.id_circuito = id_circuito;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
