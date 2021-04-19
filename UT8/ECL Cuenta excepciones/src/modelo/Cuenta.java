
package modelo;

/**
 * Representa a una cuenta bancaria
 * Incluye la clase Cuenta en el paquete modelo
 */
public class Cuenta
{

	private double importe;

	/**
	 * Si el importe es <= 0 se lanza y se avisa de la excepción
	 * IllegalArgumentException
	 */
	public Cuenta(double importe) throws IllegalArgumentException {

		if (importe < 0) {
			throw new IllegalArgumentException(
			                "Error al crear la cuenta, importe negativo");
		}
		this.importe = importe;
	}

	/**
	 * Accesor para el importe
	 */
	public double getImporte() {

		return importe;
	}

	/**
	 * Añadir una cantidad 
	 * Si la cantidad es <= 0 se lanza y se avisa de la
	 * excepción IllegalArgumentException
	 * 
	 */
	public void ingresar(double cantidad) throws IllegalArgumentException {

		if (cantidad <= 0) {
			throw new IllegalArgumentException(
			                "Error al ingresar, Cantidad negativa o 0");
		}
		importe += cantidad;
	}

	/**
	 * Reintegra de la cuenta la cantidad indicada Si la cantidad es <= 0 se
	 * lanza y se avisa de la excepción IllegalArgumentException 
	 * Si se quiere sacar más cantidad de la que hay se lanza la excepción personalizada
	 * SaldoInsuficienteException
	 * 
	 * @throws SaldoInsuficienteException
	 */
	public void sacar(double cantidad)
	                throws IllegalArgumentException,
	                SaldoInsuficienteException {

		if (cantidad <= 0) {
			throw new IllegalArgumentException(
			                "Error al sacar, Cantidad negativa o 0");
		}
		if (importe < cantidad) {
			throw new SaldoInsuficienteException("No hay saldo suficiente");
		}
		importe -= cantidad;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		return "Saldo en la cuenta: " + importe;
	}

}
