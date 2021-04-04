
/**
 *  
 */
public class FicheroJPG extends FicheroImagen {

	private Compresion compresion;

	/**
	 * Constructor de la clase FicheroJPG
	 */
	public FicheroJPG(String titulo, int tamaño, Compresion compresion) {
		super(titulo, tamaño);
		this.compresion = compresion;
	}

	/**
	 *  
	 */
	public Compresion getCompresion() {
		return compresion;
	}

	/**
	 *       
	 */
	@Override
	public void display() {
		super.display();
		System.out.println("Compresión: " + compresion);
	}
}
