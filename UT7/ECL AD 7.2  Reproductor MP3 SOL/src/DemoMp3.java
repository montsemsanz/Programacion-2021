
/**
 *    
 */
public class DemoMp3 {

	private ReproductorMP3 mp3;

	/**
	 * Constructor
	 */
	public DemoMp3() {
		mp3 = new ReproductorMP3(1048576);
	}

	/**
	 *  
	 * 
	 */
	public void demoAdd() {
		mp3.addFichero(new FicheroMusica("Título 01", 4096, 468));
		mp3.addFichero(new FicheroMusica("Título 02", 5120, 378));
		mp3.addFichero(new FicheroMusica("Título 03", 4096, 336));
		mp3.addFichero(new FicheroMusica("Título 04", 5120, 510));
		mp3.addFichero(new FicheroJPG("imagen 01", 5120, Compresion.ALTA));
		mp3.addFichero(new FicheroJPG("imagen", 6000, Compresion.ALTA));
		mp3.addFichero(new FicheroJPG("imagen 02", 5100, Compresion.MEDIA));
		mp3.addFichero(new FicheroJPG("imagen 02", 5100, Compresion.MEDIA));
		mp3.addFichero(new FicheroJPG("imagen 03", 4000, Compresion.BAJA));
		mp3.addFichero(new FicheroJPG("imagen 03", 5120, Compresion.ALTA));
		mp3.addFichero(new FicheroJPG("imagen", 2000, Compresion.MEDIA));

	}

	/**
	 * 
	 */
	public void demoCapacidad() {
		System.out.println("Capacidad del MP3: " + mp3.getCapacidad()
		                    + " bytes");
	}

	/**
	 * 
	 */
	public void demoMostrarCanciones() {
		System.out.println("Canciones en el MP3 ");
		mp3.mostrarCanciones();
	}

	/**
	 * 
	 */
	public void demoMostrarReproductor() {
		System.out.println("Situación del Reproductor MP3 ");
		mp3.mostrarReproductor();
	}

	/**
	 * 
	 */
	public void demoReset() {
		mp3.reset();
	}

	/**
	 * 
	 */
	public void demoOrdenarPorTitulo() {
		System.out.println("Después de ordenar por título ascendente");
		mp3.ordenarPorTitulo();
		demoMostrarReproductor();

	}

	/**
	 * 
	 */
	public void demoOrdenarPorTamaño() {
		System.out.println("Después de ordenar por tamaño ascendente");
		mp3.ordenarPorTamaño();
		demoMostrarReproductor();

	}

	/**
	 * 
	 */
	public void demoOrdenarPorTamañoDescendente() {
		System.out.println("Después de ordenar por tamaño descendente");
		mp3.ordenarPorTamañoDescendente();
		demoMostrarReproductor();

	}

	/**
	 * 
	 */
	public void demoOrdenarPorTituloDescendente() {
		System.out.println("Después de ordenar por título descendente");
		mp3.ordenarPorTituloDescendente();
		demoMostrarReproductor();
	}

	/**
	 * 
	 */
	public void demoReordenar() {
		System.out.println("Después de reordenar aleatoriamente ");
		mp3.reordenar();
		demoMostrarReproductor();
	}

	/**
	 * 
	 */
	public void demoBorrarFicheroImagen() {
		String titulo = "imagen";
		System.out
		                    .println("Después de borrar el fichero de imagen con el título "
		                                        + titulo);
		mp3.borrarFicheroImagen(titulo);
		demoMostrarReproductor();

	}

	public static void main(String[] args) {
		DemoMp3 demo = new DemoMp3();
		demo.demoAdd();
		demo.demoMostrarReproductor();
		System.out.println();
		demo.demoMostrarCanciones();
		System.out.println();
		demo.demoCapacidad();
		System.out.println();
		demo.demoOrdenarPorTitulo();
		System.out.println();
		demo.demoOrdenarPorTamaño();
		System.out.println();
		demo.demoOrdenarPorTituloDescendente();
		System.out.println();
		demo.demoOrdenarPorTamañoDescendente();
	}

}
