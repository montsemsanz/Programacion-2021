
package pkglista.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representa una lista de números enteros
 * 
 */
public class Lista
{

	private List<Integer> lista;

	/**
	 * Constructor
	 */
	public Lista() {

		lista = new ArrayList<>();

	}

	/**
	 * Añadir un nº a la lista en la posición adecuada. Utiliza el método
	 * privado buscarPosicion()
	 */

	public void addNumero(int n) {

		int pos = buscarPosicion(n);
		lista.add(pos, n);

	}

	/**
	 * Dado un nº devuelve la posición de la lista en la que hay que insertarlo
	 */
	private int buscarPosicion(int n) {

		int i = lista.size() - 1;
		while (i >= 0 && lista.get(i) > n) {
			i--;
		}
		return i + 1;
	}

	/**
	 * Borra de la lista todos los elementos repetidos
	 */
	public void borrarRepetidos() {

		Set<Integer> tmp = new TreeSet<>(lista);
		lista.clear();
		lista.addAll(tmp);

	}

	/**
	 * Borra un nº de la lista dada la posición
	 */
	public void borrarDePosicion(int pos) {

		if (!estaVacia()) {
			if (pos >= 0 && pos < lista.size()) {
				lista.remove(pos);
			}
		}
	}

	/**
	 * Detecta si está o no la lista vacía
	 */
	public boolean estaVacia() {

		return lista.size() == 0;
	}

	/**
	 * Cargar la lista desde un fichero numeros.txt. Cada línea del fichero
	 * contiene un nº. Lee los nºs con Scanner. Propaga las posibles excepciones
	 */
	public void cargarDeFichero() throws IOException {

		Scanner entrada = null;
		try {
			// Scanner sc = new Scanner(new File("numeros.txt"));
			entrada = new Scanner(
			                getClass().getResourceAsStream("/numeros.txt"));
			while (entrada.hasNextLine()) {
				addNumero(Integer.parseInt(entrada.nextLine()));
			}

		}
		finally {
			if (entrada != null) {
				entrada.close();
			}
		}
	}

	/**
	 * Salvar la lista en un fichero de texto resultado.txt. En cada línea del
	 * fichero un nº - Se propagan las posibles excepciones
	 */
	public void salvarEnFichero() throws IOException {

		PrintWriter salida = new PrintWriter(
		                new BufferedWriter(new FileWriter("resultado.txt")));
		for (Integer i : lista) {
			salida.println(i + "");
		}
		salida.close();
	}

	/**
	 * Representación textual de la lista
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (Integer i : lista) {
			sb.append(i + "\n");
		}
		return sb.toString();
	}
}
