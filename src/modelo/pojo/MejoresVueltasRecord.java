package modelo.pojo;

public class MejoresVueltasRecord {

	private int id_participacion;
	private float mejorVuelta;
	private String localidad;
	private int id_circuito;
	
	//CONSTUCTORES
	
	public MejoresVueltasRecord() {
		
	}

	public MejoresVueltasRecord(int id_participacion, float mejorVuelta, String localidad, int id_circuito) {
		super();
		this.id_participacion = id_participacion;
		this.mejorVuelta = mejorVuelta;
		this.localidad = localidad;
		this.id_circuito = id_circuito;
	}

	//GETTERS
	
	public int getId_participacion() {
		return id_participacion;
	}

	public float getMejorVuelta() {
		return mejorVuelta;
	}

	public String getLocalidad() {
		return localidad;
	}

	public int getId_circuito() {
		return id_circuito;
	}
	
	//SETTERS

	public void setId_participacion(int id_participacion) {
		this.id_participacion = id_participacion;
	}

	public void setMejorVuelta(float mejorVuelta) {
		this.mejorVuelta = mejorVuelta;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setId_circuito(int id_circuito) {
		this.id_circuito = id_circuito;
	}
	
}
