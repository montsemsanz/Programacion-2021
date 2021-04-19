
package modelo;

/**
 *   Incluye la clase SaldoInsuficienteException en el paquete modelo
 */
public class SaldoInsuficienteException extends Exception
{

	private String mensaje;

	/**
	 * Constructor  
	 */
	public SaldoInsuficienteException(String mensaje) {

		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {

		return mensaje;
	}

	/**
	 *  
	 * 
	 */
	@Override
	public String toString() {

		return mensaje;
	}
}
