package modelo.pojo;

public class Usuario {

	private int ID;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasena;
	private String piloto;
	private String mail;
	
	//CONSTRUCTORES
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellidos, String usuario, String contrasena, String mail) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.mail = mail;
	}

	//GETTERS
	
	public int getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getPiloto() {
		return piloto;
	}
	
	public String getMail() {
		return mail;
	}

	//SETTERS

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
