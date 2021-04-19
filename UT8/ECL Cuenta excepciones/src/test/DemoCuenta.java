
package test;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Cuenta;
import modelo.SaldoInsuficienteException;

/**
 * Incluye la clase DemoCuenta en el paquete test
 *
 */
public class DemoCuenta
{

	/**
	 *  La clase acepta a través de argumentos del main
	 *  el importe de la cuenta. Si el valor del importe es correcto se crea 
	 *  la cuenta
	 *  A continuación de pide (con Scanner) al usuario la cantidad a ingresar
	 *  y se añade y después la cantidad a sacar y se reintegra.
	 *  
	 *  Hay que capturar todas las posibles excepciones que se puedan dar
	 *  indicando mensajes de error adecuados en cada caso  
	 *  Incluye un bloque finally en el que se muestre el estado de la cuenta (toString() de Cuenta)
	 *  Puede que tengas que tratar otra excepción dentro de finally
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Cuenta c = null;
		try {

			double importe = Double.parseDouble(args[0]);
			c = new Cuenta(importe);
			System.out.println("Cantidad a ingresar: ");
			double cantidad = sc.nextDouble();
			c.ingresar(cantidad);
			System.out.println("Cantidad a sacar: ");
			cantidad = sc.nextDouble();
			c.sacar(cantidad);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Error  en nº argumentos del main "
			                + ex.getMessage());
		}
		catch (NumberFormatException ex) {
			System.out.println("Error conversión importe" + ex.getMessage());
		}
		catch (IllegalArgumentException ex) {
			System.out.println("Error al crear / ingresar / sacar , "
			                + ex.getMessage());
		}
		catch (InputMismatchException ex) {
			System.out.println("Error al convertir el ingreso / reintegro");
		}
		catch (SaldoInsuficienteException ex) {
			System.out.println("Error al sacar , " + ex.toString());
		}
		finally {
			if (c != null) {
				System.out.println(c.toString());
			}
		}

		//--------------------- Otra forma
		//		Scanner teclado = new Scanner(System.in);
		//		Cuenta cuenta = null;
		//		try {
		//			double importe = Double.parseDouble(args[0]);
		//			cuenta = new Cuenta(importe);
		//			try {
		//
		//				System.out.println("Introduzca valor a ingresar ");
		//				double valor = teclado.nextDouble();
		//				cuenta.ingresar(valor);
		//				System.out.println("Introduzca valor a reintegrar ");
		//				valor = teclado.nextDouble();
		//				cuenta.sacar(valor);
		//			}
		//			catch (IllegalArgumentException e) {
		//				System.out.println(e.getMessage());
		//			}
		//			catch (InputMismatchException e) {
		//				System.out.println("Error al convertir en ingreso / reintegro");
		//			}
		//			catch (SaldoInsuficienteException e) {
		//				System.out.println(e.getMessage());
		//			}
		//
		//		}
		//		catch (ArrayIndexOutOfBoundsException ex) {
		//			System.out.println("Error en nº de argumentos del main()");
		//		}
		//		catch (NumberFormatException e) {
		//			System.out.println("Error al convertir argumento del main()");
		//		}
		//		catch (IllegalArgumentException e) {
		//			System.out.println(e.toString());
		//		}
		//		finally {
		//			try {
		//				System.out.println(cuenta.toString());
		//			}
		//			catch (NullPointerException ex) {
		//				System.out.println(ex.toString());
		//				//ex.printStackTrace();
		//			}
		//		}
		//
	}
}
