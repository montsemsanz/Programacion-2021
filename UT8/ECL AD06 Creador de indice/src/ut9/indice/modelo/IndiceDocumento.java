
package ut9.indice.modelo;

/**
 * Clase IndiceDocumento 
 * 
 */
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndiceDocumento
{

	private Map<String, Set<Integer>> indice; // representa el índice del
	                                          // documento

	/**
	 * Constructor de la clase IndiceDocumento
	 */
	public IndiceDocumento()
	{

		indice = new TreeMap<>();
	}

	/**
	 * Añade una palabra al índice junto con la línea en la que aparece
	 * Si la palabra aparece por primera vez se creará una nueva entrada en el índice
	 * en caso contario, se añade el nº de línea a la palabra ya existente (solo
	 * si no está) Siempre se añade en mayúsculas
	 * 
	 * @param palabra
	 *            la palabra a añadir
	 * @param num
	 *            el nº de línea donde aparece la palabra
	 * 
	 */
	public void addPalabra(String palabra, int num)
	{

		palabra = palabra.toUpperCase();
		if (!indice.containsKey(palabra)) {
			Set<Integer> numerosLinea = new TreeSet<Integer>();
			numerosLinea.add(num);
			indice.put(palabra, numerosLinea);
		}
		else {
			indice.get(palabra).add(num);
		}
	}

	/**
	 * Añade múltiples palabras (separadas por blancos) al índice, todas ellas
	 * en el nº de línea indicada por num 
	 * Utiliza Scanner y un bucle para
	 * extraer los tokens de la línea
	 * 
	 */
	public void addTodasPalabras(String linea, int num)
	{

		linea = linea.toUpperCase();
		Scanner sc = new Scanner(linea);

		while (sc.hasNext()) {
			String palabra = sc.next();
			addPalabra(palabra, num);
		}
		sc.close();

	}

	/**
	 * Representación textual del índice 
	 * Usa el conjunto de entradas y
	 * StringBuilder
	 */

	@Override
	public String toString()
	{

		StringBuilder sb = new StringBuilder("Indice del documento\n\n");
		Set<Map.Entry<String, Set<Integer>>> entradas = indice.entrySet();
		for (Map.Entry<String, Set<Integer>> entrada : entradas) {
			sb.append(entrada.getKey() + "  ");
			Set<Integer> numeros = entrada.getValue();
			for (Integer n : numeros) {
				sb.append(n + ",");
			}
			int pos = sb.lastIndexOf(",");
			sb.deleteCharAt(pos);
			sb.append("\n");

		}
		return sb.toString();

	}

}
