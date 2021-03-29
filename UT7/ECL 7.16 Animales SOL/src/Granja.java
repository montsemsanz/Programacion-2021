
/**
 * Clase Granja
 * 
 */
public class Granja {

	private Animal[] animales;
	private int total; // nº real de animales en la granja

	/**
	 * Constructor de la clase Granja
	 * 
	 * @param cuantos máximo nº de animales en la granja
	 */
	public Granja(int cuantos) {
		animales = new Animal[cuantos];
		total = 0;
	}

	/**
	 * 
	 * Si el array está completo lanzar la excepción RuntimeException
	 */
	public void addAnimal(Animal a) throws RuntimeException {
		if (total == animales.length) {
			throw new RuntimeException("Granja completa");
		}
		animales[total] = a;
		total++;
	}

	/**
	 * 
	 * devuelve el animal de la posición i Si i es incorrecto lanzar la
	 * excepción IllegalArgumentException
	 */
	public Animal getAnimal(int i) {
		if (i < 0 || i >= total) {
			throw new IllegalArgumentException("Argumento incorrecto");
		}
		return animales[i];
	}

	/**
	 * Contar cuántos perros hay en la granja
	 */
	public int cuantosPerros() {
		int perros = 0;
		for (int i = 0; i < total; i++) {
			if (animales[i] instanceof Perro) {
				perros++;
			}
		}
		return perros;
	}

	/**
	 * Borrar los gatos de la granja
	 */
	public void borrarGatos() {
		int i = 0;
		while (i < total) {
			if (animales[i] instanceof Gato) {
				// borrar un gato
				for (int j = i + 1; j < total; j++) {
					animales[j - 1] = animales[j];
				}
				total--;
			}
			else {
				i++;
			}
		}
	}

	/**
	 * Cuántas vacas iguales a v hay en la granja
	 */
	public int vacasIgualesA(Vaca v) {
		int cuantas = 0;
		for (int i = 0; i < total; i++) {
			if (animales[i].equals(v)) {
				cuantas++;
			}
		}
		return cuantas;
	}

	/**
	 * 
	 * mostrar la granja
	 */
	public void mostrarAnimales() {
		for (int i = 0; i < total; i++) {
			System.out.println(animales[i].toString());
		}
	}
}
