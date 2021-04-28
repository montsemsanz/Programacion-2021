
package pkgmodelo;

/**
 * Clase ComandoType 
 *  
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ComandoType
{

	/**
	 * Muestra el contenido de un fichero de texto con las líneas numeradas
	 * 
	 */
	public void mostrarFicheroV1(String nombre) throws IOException
	{

		int numeroLinea = 0;
		BufferedReader br = new BufferedReader(
		                new FileReader(new File(nombre)));
		String linea = br.readLine();
		while (linea != null) {
			numeroLinea++;
			System.out.println(numeroLinea + ": " + linea);
			linea = br.readLine();
		}
		br.close();
	}

	/**
	 * Muestra el contenido de un fichero de texto con las líneas numeradas
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	public void mostrarFicheroV2(String nombre) throws FileNotFoundException
	{

		int numeroLinea = 0;
		Scanner entrada = new Scanner(new File(nombre));
		while (entrada.hasNextLine()) {
			String linea = entrada.nextLine();
			numeroLinea++;
			System.out.println(numeroLinea + ": " + linea);

		}
		entrada.close();
	}
}
