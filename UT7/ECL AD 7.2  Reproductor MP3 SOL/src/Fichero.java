
public abstract class Fichero implements Comparable<Fichero> {

	private String titulo;
	private int tamaño;

	/**
	 * 
	 */
	public Fichero(String titulo, int tamaño) {

		this.titulo = titulo.toUpperCase();
		this.tamaño = tamaño;
	}

	public int getTamaño() {

		return tamaño;
	}

	public String getTitulo() {

		return titulo;
	}

	public void display() {

		System.out.println(
		                    this.getClass().getSimpleName() + "\nTítulo: "
		                                        + getTitulo() + "\nTamaño:"
		                                        + getTamaño() + " bytes");
	}

	@Override
	public int compareTo(Fichero otro) {

		int r = this.titulo.compareTo(otro.getTitulo());
		if (r == 0) {
			return this.tamaño - otro.getTamaño();

		}

		return r;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Fichero f = (Fichero) obj;
		return titulo.equalsIgnoreCase(f.getTitulo())
		                    && tamaño == f.getTamaño();

	}

	/**
	 *  
	 */
	@Override
	public int hashCode() {

		return titulo.hashCode() + tamaño;
	}

}
