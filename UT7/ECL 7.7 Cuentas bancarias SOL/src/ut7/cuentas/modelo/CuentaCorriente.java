package ut7.cuentas.modelo;
/**
 * Una cuenta corriente es una cuenta bancaria a la que se le aplica un recargo
 * si el importe es menor que el importe mínimo exigido
 *
 */
public class CuentaCorriente extends Cuenta {

	private static final double RECARGO = 20;
	private double minimo;

	/**
	 * 
	 */
	public CuentaCorriente(String cliente, double importe, double minimo) {

		super(cliente, importe);
		this.minimo = minimo;

	}

	/**
	 * @return the recargo
	 */
	public double getRecargo() {

		return RECARGO;
	}

	/**
	 *  
	 */
	public double getMinimo() {

		return minimo;
	}

	/**
	 * @return el recargo a aplicar
	 */
	public double calcularRecargo() {

		if (getImporte() < minimo) {
			return RECARGO;
		}
		return 0;
	}

//	/**
//	 * 
//	 */
//	public String toString()
//	{
//
//		return super.toString() + "\nImporte mínimo: " + getMinimo()
//		        + "\nRecargo: " + calcularRecargo();
//	}

	public void print() {
		System.out.println(toString());
		System.out.println("\nImporte mínimo: " + getMinimo() + "\nRecargo: "
		        + calcularRecargo());

	}

}
