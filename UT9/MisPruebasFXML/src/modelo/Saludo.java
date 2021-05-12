
package modelo;

public class Saludo
{

	public String saludarFrances() {

		return "Bonjour!!";

	}

	public String saludarIngles() {

		return "Good Morning!!";

	}

	public String saludarFrancesPersonalizado(String nombre) {

		return saludarFrances() + " " + nombre;

	}

	public String saludarInglesPersonalizado(String nombre) {

		return saludarIngles() + " " + nombre;

	}
}
