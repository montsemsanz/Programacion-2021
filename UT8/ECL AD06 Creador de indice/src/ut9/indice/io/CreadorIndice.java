
package ut9.indice.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ut9.indice.modelo.IndiceDocumento;

public class CreadorIndice
{

	private IndiceDocumento indice;

	/**
	 * Constructor de la clase CreadorIndice
	 * 
	 */
	public CreadorIndice()
	{

		indice = new IndiceDocumento();

	}

	/**
	 * lee del fichero de texto una a una las líneas y va creando el índice del
	 * documento
	 * 
	 * Se capturan las excepciones
	 * 
	 * @param f el fichero del que se va a leer
	 */
	public void leerFichero(File f)
	{

		BufferedReader entrada = null;
		try {

			entrada = new BufferedReader(new FileReader(f));
			String linea;
			int numeroLinea = 0;
			linea = entrada.readLine();
			while (linea != null) {
				numeroLinea++;
				indice.addTodasPalabras(linea, numeroLinea);
				linea = entrada.readLine();
			}

		}
		catch (IOException e) {
			System.out.println("Error leyendo el fichero " + f.getName());
		}
		finally {
			try {
				entrada.close();
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero ");
			}
		}

	}

	/**
	 * Guarda en un fichero de texto el índice del documento 
	 * Se propagan las excepciones
	 */
	public void guardarIndiceDocumento(File f) throws IOException
	{

		PrintWriter salida = new PrintWriter(
		                new BufferedWriter(new FileWriter(f)));
		salida.println(getIndice());
		salida.close();

	}

	/**
	 * Devuelve la representación textual del índice
	 */
	public String getIndice()
	{

		return indice.toString();

	}

}
