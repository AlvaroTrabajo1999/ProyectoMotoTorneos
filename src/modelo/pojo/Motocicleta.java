package modelo.pojo;

public class Motocicleta {

	private String MATRICULA;
	private String marca;
	private String tuboEscape;
	
	//CONSTUCTORES
	
	public Motocicleta() {
		
	}
	
	public Motocicleta(String mATRICULA, String marca, String tuboEscape) {
		super();
		MATRICULA = mATRICULA;
		this.marca = marca;
		this.tuboEscape = tuboEscape;
	}

	//GETTERS
	
	public String getMATRICULA() {
		return MATRICULA;
	}

	public String getMarca() {
		return marca;
	}

	public String getTuboEscape() {
		return tuboEscape;
	}

	//SETTERS
	
	public void setMATRICULA(String mATRICULA) {
		MATRICULA = mATRICULA;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setTuboEscape(String tuboEscape) {
		this.tuboEscape = tuboEscape;
	}
	
}
