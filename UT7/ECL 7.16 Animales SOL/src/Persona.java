
/**
 * Representa una persona
 */
public class Persona {

	private String nombre;
	private int edad;

	/**
	 * Constructor de la clase Persona
	 */
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;

	}

	/**
	 * accesor para el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	* accesor para la edad
	*/
	public int getEdad() {
		return edad;
	}

	/**
	 * @override
	 */
	@Override
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
		        && this.edad == p.getEdad();
	}

	/**
	 * @override
	 */
	@Override
	public int hashCode() {
		return nombre.hashCode() * 11 + edad;
	}

	/**
	 * @override
	 */
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nEdad: " + getEdad();
	}
}
