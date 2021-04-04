
package pkgconcesionario.modelo;

/**
 *  
 */
import java.awt.Point;

public class Taxi extends Coche
{

	private int plazas;

	public Taxi(String conductor, String modelo, String color, Point posicion,
	                int plazas) {

		super(conductor, modelo, color, posicion);
		this.plazas = plazas;
	}

	/**
	 * accesor para el nº de plazas
	 */
	public int getPlazas() {

		return plazas;
	}

	/**
	 * mutador para el nº plazas
	 */
	public void setPlazas(int plazas) {

		this.plazas = plazas;
	}

	/**
	 * Redefinición de avanza()
	 */
	@Override
	public void avanza() {

		Point p = getPosicion();
		if (Math.random() >= 0.33) {
			p.translate(15, 0);
		}
		else {
			p.translate(35, 0);
		}
		setPosicion(p);
	}

	/**
	 * Representación textual del taxi
	 */
	@Override
	public String toString() {

		return super.toString() + "\nPlazas " + plazas;
	}
}
