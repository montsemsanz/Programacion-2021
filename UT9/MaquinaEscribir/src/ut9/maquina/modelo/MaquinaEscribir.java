
package ut9.maquina.modelo;

/**
 * Modela una máquina de escribir
 * 
 * 
 */
public class MaquinaEscribir
{

	private String texto;

	/**
	 * Constructor
	 */
	public MaquinaEscribir() {

		texto = "";
	}

	/**
	 * Accesor para el texto
	 */
	public String getTexto() {

		return texto;
	}

	/**
	 * Mutador para el texto
	 */
	public void añadirCaracter(char car) {

		texto = texto + car;
	}

	/**
	 * Borra el texto de la máquina
	 * 
	 * 
	 */
	public void clear() {

		texto = "";
	}

	/**
	 * Borra el último car�cter del texto siempre que éste no esté vacío
	 */
	public void borrarUltimo() {

		if (texto.length() != 0) {
			texto = texto.substring(0, texto.length() - 1);
		}
	}

}
