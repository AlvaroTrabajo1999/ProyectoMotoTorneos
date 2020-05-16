package modelo.pojo;

public class MultimediaMotocicleta {

	private String motocicleta;
	private String foto1;
	private String foto2;
	private String foto3;
	private String foto4;
	private String foto5;
	
	//CONSTRUCTORES
	
	public MultimediaMotocicleta(String motocicleta, String foto1, String foto2, String foto3, String foto4,
			String foto5) {
		super();
		this.motocicleta = motocicleta;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
		this.foto5 = foto5;
	}
	
	public MultimediaMotocicleta() {
		
	}
	
	//GETTERS

	public String getMotocicleta() {
		return motocicleta;
	}
	public String getFoto1() {
		return foto1;
	}
	public String getFoto2() {
		return foto2;
	}
	public String getFoto3() {
		return foto3;
	}
	public String getFoto4() {
		return foto4;
	}
	public String getFoto5() {
		return foto5;
	}
	
	//SETTERS

	public void setMotocicleta(String motocicleta) {
		this.motocicleta = motocicleta;
	}
	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}
	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}
	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}
	public void setFoto4(String foto4) {
		this.foto4 = foto4;
	}
	public void setFoto5(String foto5) {
		this.foto5 = foto5;
	}
	
}
