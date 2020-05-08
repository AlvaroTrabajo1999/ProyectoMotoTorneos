package modelo.pojo;

public class Motocicleta {

	private String matricula;
	private String marca;
	private String tuboEscape;
	
	//CONSTUCTORES
	
	public Motocicleta() {
		
	}
	
	public Motocicleta(String matricula, String marca, String tuboEscape) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.tuboEscape = tuboEscape;
	}

	//GETTERS
	
	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getTuboEscape() {
		return tuboEscape;
	}

	//SETTERS
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setTuboEscape(String tuboEscape) {
		this.tuboEscape = tuboEscape;
	}
	
}
