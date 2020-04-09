package modelo.pojo;

public class MultimediaCircuito {
	
	private int circuito;
	private String fotoZenital;
	
	//CONSTUCTORES
	
	public MultimediaCircuito(int circuito, String fotoZenital) {
		super();
		this.circuito = circuito;
		this.fotoZenital = fotoZenital;
	}
	
	public MultimediaCircuito() {
		
	}
	
	//GETTERS

	public int getCircuito() {
		return circuito;
	}

	public String getFotoZenital() {
		return fotoZenital;
	}
	
	//SETTERS

	public void setCircuito(int circuito) {
		this.circuito = circuito;
	}

	public void setFotoZenital(String fotoZenital) {
		this.fotoZenital = fotoZenital;
	}
	
}
