package modelo.pojo;

public class Carrera {
	
	private int ID;
	private int id_torneo;
	private int nivel;
	private int ronda;
	private int posicion;
	private int ganador;
	
	//CONSTRUCTORES

	public Carrera(int id_torneo, int nivel, int ronda) {
		super();
		this.id_torneo = id_torneo;
		this.nivel = nivel;
		this.ronda = ronda;
	}
	
	public Carrera() {
		
	}
	
	//GETTERS

	public int getGanador() {
		return ganador;
	}

	public int getID() {
		return ID;
	}

	public int getId_torneo() {
		return id_torneo;
	}

	public int getNivel() {
		return nivel;
	}

	public int getRonda() {
		return ronda;
	}

	public int getPosicion() {
		return posicion;
	}
	
	//SETTERS

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public void setId_torneo(int id_torneo) {
		this.id_torneo = id_torneo;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
