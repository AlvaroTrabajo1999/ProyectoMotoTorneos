package modelo.pojo;

public class MejorVueltaCircuito {

	private float mejorVuelta;
	private int id_circuito;
	
	//CONSTUCTORES
	
	public MejorVueltaCircuito() {
		
	}

	public MejorVueltaCircuito(float mejorVuelta, int id_circuito) {
		super();
		this.mejorVuelta = mejorVuelta;
		this.id_circuito = id_circuito;
	}

	//GETTERS

	public float getMejorVuelta() {
		return mejorVuelta;
	}

	public int getId_circuito() {
		return id_circuito;
	}
	
	//SETTERS

	public void setMejorVuelta(float mejorVuelta) {
		this.mejorVuelta = mejorVuelta;
	}

	public void setId_circuito(int id_circuito) {
		this.id_circuito = id_circuito;
	}
	
}
