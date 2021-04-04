import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Clase ReproductorMP3 
 *  
 */
import java.util.List;

public class ReproductorMP3 {

	private List<Fichero> ficheros;
	private int capacidad; // en bytes
	private int tamActual;

	/**
	 * Constructor de la clase ReproductorMP3
	 */
	public ReproductorMP3(int bytes) {

		ficheros = new ArrayList<>();
		capacidad = bytes;

		// ficheros gratis
		ficheros.add(new FicheroMusica("Cancion 1", 3155, 166));
		ficheros.add(new FicheroMusica("Cancion 2", 2029, 187));
		tamActual = ficheros.get(0).getTamaño() + ficheros.get(1).getTamaño();
	}

	/**
	 * añade un fichero al MP3 actualizando el tamaño. Antes de añadirlo se
	 * comprueba si hay espacio en el MP3 y no hay un fichero igual.
	 */
	public void addFichero(Fichero f) {

		if (tamActual + f.getTamaño() > getCapacidad()) {
			System.out.println("Excede el tamaño del MP3");
		}
		else if (!ficheros.contains(f)) {
			ficheros.add(f);
			tamActual += f.getTamaño();

		}

	}

	/**
	 * accesor para la capacidad del MP3
	 */
	public int getCapacidad() {

		return capacidad;
	}

	/**
	 * borra todos los ficheros y pone el tamaño actual a 0
	 */
	public void reset() {

		ficheros.clear();
		tamActual = 0;
	}

	/**
	 * muestra los títulos los ficheros de música que hay en el MP3. Al
	 * final se muestra el total de horas, minutos y segundos de música que hay
	 */
	public void mostrarCanciones() {

		int totalDuracion = 0;
		for (Fichero f : ficheros) {
			if (f instanceof FicheroMusica) {
				FicheroMusica fm = (FicheroMusica) f;
				totalDuracion += fm.getDuracion();
				System.out.println(fm.getTitulo());
			}
		}

		System.out.println("Duración total de ficheros de música");
		// int horas = totalDuracion / 3600;
		// int min = (totalDuracion % 3600) / 60;
		// int seg = (totalDuracion % 3600) % 60;

		LocalTime t = LocalTime.ofSecondOfDay(totalDuracion);
		System.out.println(t.toString());
		// DateTimeFormatter formateador =
		// DateTimeFormatter.ofPattern("HH:mm:ss");
		// System.out.println(t.format(formateador));

	}

	/**
	 * dado un título, borra los ficheros de imagen con este título. Devuelve
	 * true o false dependiendo de si se ha borrado alguno o no
	 */
	public boolean borrarFicheroImagen(String titulo) {

		boolean borrado = false;
		Iterator<Fichero> it = ficheros.iterator();
		while (it.hasNext()) {
			Fichero f = it.next();
			if (f instanceof FicheroImagen) {
				if (f.getTitulo().equalsIgnoreCase(titulo)) {
					tamActual -= f.getTamaño();
					it.remove();
					borrado = true;
				}

			}
		}
		return borrado;

	}

	/**
	 * ordena aleatoriamente la lista de ficheros
	 */
	public void reordenar() {

		Collections.shuffle(ficheros);

	}

	/**
	 * ordena la lista de ficheros por título
	 */
	public void ordenarPorTitulo() {

		Collections.sort(ficheros);

	}

	/**
	 * ordena la lista de ficheros por tamaño de fichero
	 * 
	 */
	public void ordenarPorTamaño() {

		Collections.sort(ficheros, new Comparator<Fichero>() {

			@Override
			public int compare(Fichero f1, Fichero f2) {
				return Integer.compare(f1.getTamaño(), f2.getTamaño());
				// return f1.getTamaño() - f2.getTamaño();
			}
		});

//		Collections.sort(ficheros, (f1, f2) -> Integer.compare(f1.getTamaño(),
//		                    f2.getTamaño()));

	}

	/**
	 * ordena la lista de ficheros por título descendente
	 * (orden inverso al orden  natural)
	 * 
	 */
	public void ordenarPorTituloDescendente() {

		Collections.sort(ficheros, Collections.reverseOrder());
//		Collections.sort(ficheros, Comparator.reverseOrder());

	}

	/**
	 * ordena la lista de ficheros por tamaño descendente
	 * 
	 */
	public void ordenarPorTamañoDescendente() {

		Collections.sort(ficheros,
		                    Collections.reverseOrder(new Comparator<Fichero>() {

			                    @Override
			                    public int compare(Fichero f1, Fichero f2) {
				                    return Integer.compare(f1.getTamaño(),
				                                        f2.getTamaño());

			                    }
		                    }));

//		Collections.sort(ficheros, new Comparator<Fichero>() {
//
//			@Override
//			public int compare(Fichero f1, Fichero f2) {
//
//				return Integer.compare(f2.getTamaño(),
//				                    f1.getTamaño());
//			}
//		});

	}

	/**
	 * Muestra todos los ficheros del MP3
	 */
	public void mostrarReproductor() {

		for (Fichero f : ficheros) {
			f.display();
			System.out.println("________________________________ ");

		}

	}
}
