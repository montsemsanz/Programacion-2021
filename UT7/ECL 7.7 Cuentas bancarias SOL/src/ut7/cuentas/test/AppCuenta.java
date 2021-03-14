package ut7.cuentas.test;

import ut7.cuentas.modelo.CuentaAhorro;
import ut7.cuentas.modelo.CuentaCorriente;

/**
 * 
 *
 */
public class AppCuenta {

	/**
	 * 
	 */
	public static void main(String[] args) {
		CuentaAhorro miCuenta = new CuentaAhorro("Elena", 1200, 2);
		System.out.println("Situación inicial de la cuenta de ahorro...\n");
		miCuenta.print();
		System.out.println("\nIngresando 2000€ a la cuenta de ahorro ...");
		miCuenta.ingresar(2000);
		System.out.println("\nReintegrando 150€ de la cuenta de ahorro ...");
		miCuenta.reintegrar(150);

		System.out.println("\nSituación final de la cuenta de ahorro...\n");
		miCuenta.print();
		System.out.println("\n--------------------------------------------\n");

		CuentaCorriente tuCuenta = new CuentaCorriente("Juan", 1000, 600);
		System.out.println("\nSituación inicial de la cuenta corriente. ..\n");
		tuCuenta.print();
		System.out.println("\nReintegrando 500 € de la cuenta corriente ...");
		tuCuenta.reintegrar(500);

		System.out.println("Recargo a aplicar " + tuCuenta.calcularRecargo());
		System.out.println("\nSituación final de la cuenta corriente. ..\n");
		tuCuenta.print();
		System.out.println("\nIngresando 2000€ a la cuenta corriente ...");
		tuCuenta.ingresar(2000);
		System.out.println("\nSituación final de la cuenta corriente ...\n");
		tuCuenta.print();

		/* ---------------------------------------- */

// 		
// 		Cuenta c = new CuentaAhorro("Elena", 1200, 2); 
// 		CuentaAhorro ca = (CuentaAhorro) c; // engaño al compilador
// 		
// 		Cuenta c2 = new CuentaCorriente("Juan", 1000, 600);
// 		CuentaAhorro ca2 = (CuentaAhorro) c2; // error en ejecución, no en compilación
// 	    //System.out.println(ca2.toString());
// 
// 	    // CuentaAhorro ca3 = new Cuenta(); // no permitida
	}

}
