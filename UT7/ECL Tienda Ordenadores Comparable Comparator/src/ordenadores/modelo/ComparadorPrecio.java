package ordenadores.modelo;
import java.util.Comparator;

/**
 *  
 * 
 *  Esta clase encapsula un nuevo criterio de ordenación de los ordenadores, el precio
 */
public class ComparadorPrecio implements Comparator<Ordenador> {

	/**
	 *   
	 * 
	 */
	@Override
	public int compare(Ordenador ord1, Ordenador ord2) {
		//         if (ord1.getPrecio() < ord2.getPrecio())

		//         {
		//             return -1;
		//         }
		//         if (ord1.getPrecio() > ord2.getPrecio())
		//         {
		//             return 1;
		//         }
		//         return 0;

		return Double.compare(ord1.getPrecio(), ord2.getPrecio());
	}
}
