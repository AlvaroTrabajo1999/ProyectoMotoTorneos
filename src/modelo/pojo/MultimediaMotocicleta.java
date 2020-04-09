package modelo.pojo;

public class MultimediaMotocicleta {

	private String motocicleta;
	private String fotoFrontal;
	private String fotoPerfil;
	private String fotoTrasera;
	
	//CONSTRUCTORES
	
	public MultimediaMotocicleta(String motocicleta, String fotoFrontal, String fotoPerfil, String fotoTrasera) {
		super();
		this.motocicleta = motocicleta;
		this.fotoFrontal = fotoFrontal;
		this.fotoPerfil = fotoPerfil;
		this.fotoTrasera = fotoTrasera;
	}
	
	public MultimediaMotocicleta() {
		
	}
	
	//GETTERS

	public String getMotocicleta() {
		return motocicleta;
	}

	public String getFotoFrontal() {
		return fotoFrontal;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public String getFotoTrasera() {
		return fotoTrasera;
	}
	
	//SETTERS

	public void setMotocicleta(String motocicleta) {
		this.motocicleta = motocicleta;
	}

	public void setFotoFrontal(String fotoFrontal) {
		this.fotoFrontal = fotoFrontal;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public void setFotoTrasera(String fotoTrasera) {
		this.fotoTrasera = fotoTrasera;
	}
	
	
}
