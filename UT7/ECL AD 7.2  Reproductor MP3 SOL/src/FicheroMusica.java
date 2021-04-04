
/**
 * 
 */
public class FicheroMusica extends Fichero {
	private int duracion;

	/**
	 * Constructor de la clase FicheroMusica
	 */
	public FicheroMusica(String titulo, int tamaño, int duracion) {
		super(titulo, tamaño);
		this.duracion = duracion;

	}

	/**
	 * devuelve la duraciñn en segundos
	 */
	public int getDuracion() {

		return duracion;
	}

	/**
	 * Muestra los datos del fichero de mñsica 
	 * La duraciñn se muestra en formato
	 * XX:XX (minutos, segundos)
	 */
	@Override
	public void display() {
		super.display();
		int min = getDuracion() / 60;
		int seg = getDuracion() % 60;
		System.out.println("Duración: " + min + " min " + seg + " seg");

	}
}
