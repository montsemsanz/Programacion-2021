package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.PersonaDao;
import modelo.Persona;

/**
 *  
 * 
 */
public class Interfaz {
	private static final int LISTAR_TODAS = 1;
	private static final int MENORES_QUE = 2;
	private static final int GUARDAR_PERSONA = 3;
	private static final int BORRAR_PERSONA_POR_APELLIDO = 4;
	private static final int BORRAR_PERSONA_POR_ID = 5;
	private static final int BORRAR_PERSONA_POR_ECIVIL = 6;
	private static final int SALIR = 7;

	private Scanner teclado;
	private PersonaDao dao;

	public Interfaz() {
		dao = new PersonaDao();
		teclado = new Scanner(System.in);
	}

	public void iniciar() {
		int opcion = menu();
		while (opcion != SALIR) {
			switch (opcion) {
				case LISTAR_TODAS:
					listarTodas();
					break;
				case MENORES_QUE:
					listarMenoresDe();
					break;
				case GUARDAR_PERSONA:
					guardarPersona();
					break;
				case BORRAR_PERSONA_POR_APELLIDO:
					borrarPersonaPorApellido();
					break;
				case BORRAR_PERSONA_POR_ID:
					borrarPersonaPorId();
					break;
				case BORRAR_PERSONA_POR_ECIVIL:
					borrarPersonaPorECivil();
					break;

			}
			opcion = menu();
		}
	}

	/**
	 * Método de ayuda para presentar el menú
	 */
	private int menu() {

		System.out.println();
		System.out.println(" 1.- Listar todas las personas");
		System.out.println(" 2.- Listar personas menores de una determinada edad");
		System.out.println(" 3.- Guardar persona");
		System.out.println(" 4.- Borrar persona por apellido");
		System.out.println(" 5.- Borrar persona por id");
		System.out.println(" 6.- Borrar persona por estado civil");
		System.out.println(" 7.- Salir");
		System.out.println(" Teclea opción....");
		int opcion = teclado.nextInt();

		return opcion;
	}

	/**
	 * 
	 */
	private void listarTodas() {

		List<Persona> personas = dao.getPersonas();
		System.out.println(" ***** Personas en la BD ***");
		for (Persona p : personas) {
			System.out.println(p.toString());
		}

	}

	/**
	* 
	*/
	private void listarMenoresDe() {

		System.out.println("Introduzca edad: ");
		int edad = teclado.nextInt();
		List<Persona> personas = dao.personasMenoresDe(edad);
		System.out.println(" ***** Personas en la BD menores de " + edad
		                    + " ***");
		for (Persona p : personas) {
			System.out.println(p.toString());
		}

	}

	/**
	* 
	*/
	private void guardarPersona() {
		teclado.nextLine();
		System.out.println("Introduzca nombre: ");
		String nombre = teclado.nextLine().trim();

		System.out.println("Introduzca apellido: ");
		String apellido = teclado.nextLine().trim();

		System.out.println("Introduzca edad: ");
		int edad = teclado.nextInt();
		teclado.nextLine();

		System.out.println("Introduzca estado civil 's' 'c' 'v' 'd' : ");
		char estado = teclado.nextLine().trim().charAt(0);

		System.out.println("Introduzca género 'h' 'm': ");
		char genero = teclado.nextLine().trim().charAt(0);

		Persona p = new Persona(nombre, apellido, edad, estado, genero);
		dao.guardarPersona(p);

	}

	private void borrarPersonaPorApellido() {
		teclado.nextLine();
		System.out.println("Introduzca apellido de la persona a borrar de la BD: ");
		String apellido = teclado.nextLine().trim();
		dao.borrarPersonaPorApellido(apellido);

	}

	private void borrarPersonaPorId() {

		System.out.println("Introduzca el id de la persona a borrar de la BD: ");
		int id = teclado.nextInt();
		dao.borrarPersonaPorId(id);

	}

	private void borrarPersonaPorECivil() {
		teclado.nextLine();
		System.out.println("Introduzca el estado civil de la persona a borrar de la BD: ");
		char estado = teclado.nextLine().charAt(0);
		dao.borrarPersonasDeEstadoCivil(estado);

	}

}
