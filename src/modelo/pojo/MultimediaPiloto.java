package modelo.pojo;

public class MultimediaPiloto {

	private String piloto;
	private String fotoPerfil;
	private String fotoGeneral;
	
	//CONSTRUCTORES
	
	public MultimediaPiloto(String piloto, String fotoPerfil, String fotoGeneral) {
		super();
		this.piloto = piloto;
		this.fotoPerfil = fotoPerfil;
		this.fotoGeneral = fotoGeneral;
	}
	
	public MultimediaPiloto() {
		
	}
	
	//GETTERS
	
	public String getPiloto() {
		return piloto;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public String getFotoGeneral() {
		return fotoGeneral;
	}
	
	//SETTERS
	
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public void setFotoGeneral(String fotoGeneral) {
		this.fotoGeneral = fotoGeneral;
	}
	
	
	
}
