package modelo.pojo;

public class Piloto {

	private String DNI;
	private String nombre;
	private String apellido;
	private int edad;
	private float peso;
	private float altura;
	
	//CONSTUCTORES
	
	public Piloto() {
		
	}
	
	public Piloto(String dNI, String nombre, String apellido, int edad, float peso, float altura) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
	}

	//GETTERS
	
	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public float getPeso() {
		return peso;
	}

	public float getAltura() {
		return altura;
	}

	//SETTERS
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
}
