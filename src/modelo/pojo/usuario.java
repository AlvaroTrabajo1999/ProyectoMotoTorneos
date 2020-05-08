package modelo.pojo;

public class usuario {

	private int ID;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasena;
	private String piloto;
	
	//CONSTRUCTORES
	
	public usuario() {
		
	}
	
	public usuario(int iD, String nombre, String apellidos, String usuario, String contrasena, String piloto) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.piloto = piloto;
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

	//SETTERS
	
	public void setID(int iD) {
		ID = iD;
	}

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
	
	
	
}
