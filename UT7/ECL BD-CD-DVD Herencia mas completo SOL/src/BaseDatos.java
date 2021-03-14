
/**
 * La clase BaseDatos almacena objetos CD y Videos. 
 * Se puede imprimir una lista de CD y Videos.
 *  
 */
import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {
	private ArrayList<Articulo> articulos;

	/**
	 * Construir una base de datos vac�a
	 */
	public BaseDatos() {
		articulos = new ArrayList<>();
	}

	/**
	 * A�adir un art�culo a la base da datos
	 */
	public void addArticulo(Articulo elArticulo) {
		articulos.add(elArticulo);
	}

	/**
	 * Imprimir una lista de tods los articulos almacenados, CD y Videos
	 */
	public void listar() {
		for (Articulo articulo : articulos) {
			articulo.print();
		}
	}

	/**
	 * devuelve la cantidad de DVD en la base de datos
	 *
	 */
	public int totalDVD() {
		int cuantos = 0;
		for (Articulo articulo : articulos) {
			if (articulo instanceof DVD) {
				cuantos++;
			}
		}
		return cuantos;
	}

	/**
	 * devuelve la duración total entre todos los cd's Con iterador
	 *
	 */
	public int totalDuracionCD() {
		int duracion = 0;
		Iterator<Articulo> it = articulos.iterator();
		while (it.hasNext()) {
			Articulo articulo = it.next();
			if (articulo instanceof CD) {
				duracion += articulo.getDuracion();
			}
		}
		return duracion;

	}

	/**
	 * borrar todos los cd's
	 * 
	 *
	 */
	public void borrarCD() {
		Iterator<Articulo> it = articulos.iterator();
		while (it.hasNext()) {
			Articulo articulo = it.next();
			if (articulo instanceof CD) {
				it.remove();
			}
		}

	}

	/**
	 * cuenta los vídeos que hay con el formato indicado
	 *
	 */
	public int videosConFormato(String formato) {
		int cuantos = 0;
		for (Articulo articulo : articulos) {
			if (articulo instanceof Video) {
				Video video = (Video) articulo;
				if (video.getFormato().equalsIgnoreCase(formato)) {
					cuantos++;
				}
			}
		}
		return cuantos;

	}

}
