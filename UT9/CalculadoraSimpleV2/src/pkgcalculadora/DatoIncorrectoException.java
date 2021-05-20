
package pkgcalculadora;

public class DatoIncorrectoException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public DatoIncorrectoException(String mensaje) {

		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {

		return mensaje;
	}

}
