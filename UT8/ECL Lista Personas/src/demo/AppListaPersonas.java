
package demo;

import java.io.IOException;

import modelo.ListaPersonas;
import modelo.Persona;

public class AppListaPersonas
{

	public static void main(String[] args) throws IOException
	{

		ListaPersonas lista = new ListaPersonas();
		lista.add(new Persona("Pepe", 34, 's'));
		lista.add(new Persona("Ana", 14, 'c'));
		lista.add(new Persona("Luis", 23, 's'));
		lista.add(new Persona("Juan", 50, 'd'));
		lista.add(new Persona("Elena", 22, 's'));
		lista.guardarEnFicheroDeTexto();

		lista.clear();

		lista.leerDeFicheroDeTexto();
		lista.mostrar();
		//
		//		lista.leerDeFicheroDeTextoConScanner();
		//		lista.mostrar();
		//
		//		lista.guardarEstadisticas();

	}

}
