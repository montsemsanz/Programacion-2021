package modelo;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private int edad;
	private char eCivil;
	private char genero;

	public Persona(Integer id, String nombre, String apellido, int edad,
	                    char eCivil, char genero) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.eCivil = eCivil;
		this.genero = genero;
	}

	public Persona(String nombre, String apellido, int edad, char eCivil,
	                    char genero) {
		this.id = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.eCivil = eCivil;
		this.genero = genero;
	}

	public int getId() {
		return id;
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

	public char getEstadoCivil() {
		return eCivil;
	}

	public char getGenero() {
		return genero;
	}

	public void setEstadoCivil(char eCivil) {
		this.eCivil = eCivil;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Persona p = (Persona) obj;
		return this.nombre.equalsIgnoreCase(p.getNombre())
		                    && this.apellido.equalsIgnoreCase(p.getApellido())
		                    && this.edad == p.getEdad()
		                    && this.eCivil == p.getEstadoCivil()
		                    && this.genero == p.getGenero();
	}

	public String toString() {
		return String.format("%5s %-20s %-20s %7s %10s %10s \n", id, nombre,
		                    apellido, edad, eCivil, genero);

	}

}
