
/**
 * La clase modela una lista de personas
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPersonas
{

	private static final String NOMBRE_FICHERO = "personas.txt";
	private List<Persona> personas;

	public ListaPersonas() {

		personas = new ArrayList<>();

	}

	/**
	 * añade una persona a la lista
	 */
	public void add(Persona p) {

		personas.add(p);

	}

	/**
	 * vacía la lista
	 */
	public void clear() {

		personas.clear();
	}

	/**
	 * guarda en un fichero de texto los datos de cada persona
	 * Recorreremos la lista y guardaremos por cada persona sus 
	 * datos en el fichero. Escribirimeos una línea
	 * de texto por cada persona con formato nombre:edad:estado
	 * 
	 * 
	 * Usa las clases PrintWriter, BufferedWriter, FileWriter  
	 * 
	 * Hay que propagar las excepciones, no capturarlas
	 * @throws IOException 
	 */
	public void guardarEnFicheroDeTexto() throws IOException {

		File f = new File(NOMBRE_FICHERO);
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new BufferedWriter(
			                new FileWriter(f)));
			for (Persona persona : personas) {
				salida.println(persona.getNombre() + ":" + persona.getEdad()
				                + ":"
				                + persona.getEstadoCivil());

			}
		}
		finally {
			try {
				salida.close();
			}
			catch (NullPointerException e) {
				System.out.println("Error el cerrar " + e.getMessage());
			}

		}

	}

	/**
	 * Lee del fichero de texto  una a una las líneas de datos que 
	 * contienen los datos de cada persona. Cada línea se parsea
	 * (según el separador utilizado, en nuestro caso los :) y 
	 * se crea un objeto Persona que añadiremos a la lista
	 * Usa las clases  BuffererReader, FileReader  
	 * 
	 * Hay que capturar las excepciones generadas
	 */
	public void leerDeFicheroDeTexto() {

		File f = new File(NOMBRE_FICHERO);
		BufferedReader entrada = null;
		try {
			entrada = new BufferedReader(new FileReader(f));
			String linea = entrada.readLine();
			while (linea != null) {
				try {
					Persona persona = parsearLinea(linea);
					this.add(persona);
				}
				catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				linea = entrada.readLine();

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error al abrir fichero " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error al leer");
		}
		finally {
			try {
				entrada.close();
			}
			catch (IOException e) {
				System.out.println("Error al cerrar");
			}
			catch (NullPointerException e) {
				System.out.println("Error al cerrar " + e.toString());
			}
		}

	}

	/**
	 * Lee del fichero de texto  una a una las líneas de datos que 
	 * contienen los datos de cada persona. Cada línea se parsea
	 * (según el separador utilizado, en nuestro caso los :) y 
	 * se crea un objeto Persona que añadiremos a la lista
	 * Usa la clase  Scanner
	 * 
	 * Hay que capturar las excepciones generadas
	 */
	public void leerDeFicheroDeTextoConScanner() {

		File f = new File(NOMBRE_FICHERO);
		Scanner entrada = null;
		try {
			entrada = new Scanner(f);
			while (entrada.hasNextLine()) {
				try {
					String linea = entrada.nextLine();
					Persona persona = parsearLinea(linea);
					this.add(persona);
				}
				catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error al abrir fichero " + e.getMessage());
		}
		finally {
			if (entrada != null) {
				entrada.close();
			}
		}

	}

	/**
	 *  Parsea la línea, es decir, extrae de la línea la información
	 *  de una persona
	 */
	private Persona parsearLinea(String linea) throws NumberFormatException {

		String[] datos = linea.split(":");
		return new Persona(datos[0].trim(), Integer.parseInt(datos[1].trim()),
		                datos[2].trim().charAt(0));
	}

	/**
	 *  Guarda en el fichero "estadis.txt" la relación de personas solteras
	 *  y el nº total de ellas
	 *
	 *  Se propagan (se avisa)  las excepciones que puedan ocurrir
	 * @throws IOException 
	 */
	public void guardarEstadisticas() throws IOException {

		File f = new File("estadis.txt");
		PrintWriter salida = null;
		try {
			salida =
			                new PrintWriter(new BufferedWriter(
			                                new FileWriter(f)));
			salida.println("Personas solteras");
			int solteras = 0;
			for (Persona persona : personas) {
				if (persona.estaSoltera()) {
					salida.println(persona);
					solteras++;
				}

			}
			salida.printf("Personas solteras: %4d", solteras);
		}
		finally {
			try {
				salida.close();
			}
			catch (NullPointerException e) {
				System.out.println("Error el cerrar " + e.getMessage());
			}

		}

	}

	/**
	 * representación textual de la lista de personas
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("Lista de personas\n");
		for (Persona p : personas) {
			sb.append(p.toString() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Mostrar la lista
	 */
	public void mostrar() {

		System.out.println(this.toString());
	}

}
