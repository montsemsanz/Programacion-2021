package ut7.cuentas.modelo;

/**
 * Un cuenta de ahorro es una cuenta bancaria con un tipo de interés aplicado
 *
 */
public class CuentaAhorro extends Cuenta {

	private double interes;

	/**
	 * 
	 */
	public CuentaAhorro(String cliente, double importe, double interes) {

		super(cliente, importe);
		this.interes = interes;
	}

	/**
	 * @return el interés
	 */
	public double getInteres() {

		return interes;
	}

	/**
	 * @param el nuevo interés
	 */
	public void setInteres(double interes) {

		this.interes = interes;
	}

	/**
	 * @return la cantidad que representa el interés aplicado
	 */
	public double obtenerInteres() {

		return getImporte() * interes / 100;
	}
//
//	/**
//	 * 
//	 */
//	public String toString()
//	{
//
//		return super.toString() + "\nInterés aplicado: (" + getInteres() + "%) "
//		        + obtenerInteres() + "€";
//	}

	public void print() {
		System.out.println(toString());
		System.out.println("\nInterés aplicado: (" + getInteres() + "%) "
		        + obtenerInteres() + "€");

	}

}
