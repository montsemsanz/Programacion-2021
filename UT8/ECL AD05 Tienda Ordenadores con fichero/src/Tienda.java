import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tienda
{

	private static final String NOMBRE = "tienda.txt";
	private String nombre;
	private List<Ordenador> ordenadores;

	/**
	 * Constructor  
	 */
	public Tienda(String nombre)
	{
		this.nombre = nombre;
		ordenadores = new ArrayList<>();
	}

	/**
	 *  añade un ordenador si no está
	 */
	public void addOrdenador(Ordenador ord)
	{
		if (!ordenadores.contains(ord)) {
			ordenadores.add(ord);
		}
	}

	public int cuantosPortatiles()
	{
		int cuantos = 0;
		for (Ordenador ord : ordenadores) {
			if (ord instanceof Portatil) {
				cuantos++;
			}
		}
		return cuantos;
	}

	public void ordenarPorCodigo()
	{
		Collections.sort(ordenadores);
	}

	public List<Portatil> ordenarPorPrecioLosPortatiles()
	{
		List<Portatil> portatiles = new ArrayList<Portatil>();
		for (Ordenador ord : ordenadores) {
			if (ord instanceof Portatil) {
				portatiles.add((Portatil) ord);
			}
		}
		Collections.sort(portatiles,
		                (p1, p2) -> Double.compare(p1.getPrecio(),
		                                p2.getPrecio()));
		return portatiles;

	}

	/**
	 * Guardar los datos de los ordenadores en el fichero de texto Aquí
	 * propagamos las excepciones
	 */
	public void salvarEnFichero() throws IOException
	{
		PrintWriter salida = null;
		try {
			File f = new File(NOMBRE);
			salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Ordenador ord : ordenadores) {
				guardarOrdenador(ord, salida);
			}
		}
		finally {
			salida.close();
		}

	}

	/**
	 * Escribe los datos de un objeto Ordenador en una línea de texto añadiendo una P
	 * en la línea si portátil y una S si sobremesa. El separador de los campos
	 * en la línea es el carácter :
	 */
	private void guardarOrdenador(Ordenador ord, PrintWriter salida)
	{

		salida.print(ord.getCodigo() + ":");
		salida.print(ord.getPrecio() + ":");
		if (ord instanceof Portatil) {
			Portatil p = (Portatil) ord;
			salida.print(p.getPeso() + ":");
			salida.println("P");
		}
		else {
			SobreMesa s = (SobreMesa) ord;
			salida.print(s.getDescripcion() + ":");
			salida.println("S");
		}
	}

	/**
	 * Leer el fichero de texto, parsear la línea y guardar cada objeto
	 * Ordenador en la lista
	 * 
	 * Si hay alguna línea errónea se ignora la línea y continúa la ejecución
	 * 
	 * El método devuelve al final el nº de líneas erróneas que había en el
	 * fichero
	 * 
	 * Aquí capturamos las excepciones
	 */
	public int leerDeFichero()
	{

		int errores = 0;
		BufferedReader entrada = null;
		try {
			File f = new File(NOMBRE);
			entrada = new BufferedReader(new FileReader(f));
			String linea = entrada.readLine();
			while (linea != null) {
				try {
					Ordenador ord = procesarLinea(linea);
					this.addOrdenador(ord);

				}
				catch (Exception e) {
					System.out.println("Error de conversión de formato: "
					                + e.getMessage());
					errores++;
				}
				linea = entrada.readLine();
			}

		}
		catch (IOException ex) {
			System.out.println("Error al leer del fichero");

		}
		finally {
			if (entrada != null) {
				try {
					entrada.close();
				}
				catch (IOException ex) {
					System.out.println("Error al cerrar el fichero");
				}

			}
		}
		return errores;

	}

	/**
	 * Extrae de una línea de texto los datos de un ordenador formato de la
	 * línea codigo:precio:peso:P si portátil codigo:precio:descripción:S si
	 * sobremesa
	 * 
	 * Se propagan las excepciones de conversión de formato
	 */
	private Ordenador procesarLinea(String linea) throws NumberFormatException
	{
		String[] datos = linea.split(":");
		if (datos[datos.length - 1].equalsIgnoreCase("P")) // se trata de un ordenador portátil
		{
			// crear un Portátil
			return new Portatil(datos[0], Double.parseDouble(datos[1]),
			                Double.parseDouble(datos[2]));
		}
		// devolver un SobreMesa
		return new SobreMesa(datos[0], Double.parseDouble(datos[1]), datos[2]);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Tienda: " + nombre + "\n");
		for (Ordenador ord : ordenadores) {
			sb.append(ord.toString());
		}
		return sb.toString();
	}

	public void printTienda()
	{
		System.out.println(this.toString());
	}

}
