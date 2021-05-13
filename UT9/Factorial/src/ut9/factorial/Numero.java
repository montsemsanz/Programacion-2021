
package ut9.factorial;

public class Numero
{

	private int numero;

	public Numero() {

		this.numero = 0;
	}

	/** 
	 *
	 */
	public Numero(int numero) {

		this.numero = numero;
	}

	public int getNumero() {

		return numero;
	}

	/**
	 * Mutador para el n�mero
	 * 
	 */
	public void setNumero(int numero) {

		this.numero = numero;
	}

	/**
	 * Calcula y devuelve el factorial de numero
	 */
	public int factorial() {

		int facto = 1;
		for (int i = 2; i <= numero; i++) {
			facto *= i;
		}
		return facto;
	}

	/**
	 * devuelve true si numero es primo, false en otro caso
	 */
	public boolean esPrimo() {

		int divis = 2;
		while (divis <= (numero / 2)) {
			if (numero % divis == 0) {
				return false;
			}
			divis++;
		}
		return true;
	}

}
