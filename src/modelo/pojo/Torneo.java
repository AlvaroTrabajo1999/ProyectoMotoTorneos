package modelo.pojo;

public class Torneo {

	private int ID;
	private int participantes;
	private int id_circuito;
	private String nombre;
	
	//CONSTRUCTORES
	
	public Torneo() {
		
	}
	
	public Torneo(int participantes, int id_circuito, String nombre) {
		super();
		this.participantes = participantes;
		this.id_circuito = id_circuito;
		this.nombre = nombre;
	}

	//GETTERS
	
	public int getID() {
		return ID;
	}

	public int getParticipantes() {
		return participantes;
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

	public void setParticipantes(int rondas) {
		this.participantes = rondas;
	}

	public void setId_circuito(int id_circuito) {
		this.id_circuito = id_circuito;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
