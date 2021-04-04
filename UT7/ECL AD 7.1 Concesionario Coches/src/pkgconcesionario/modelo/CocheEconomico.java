
package pkgconcesionario.modelo;

/**
 * Clase CocheEconomico 
 *  
 */
import java.awt.Point;

public class CocheEconomico extends Coche
{
	// sin atributos, solo los heredados

	public CocheEconomico(String conductor, String modelo, String color,
	                Point posicion) {

		super(conductor, modelo, color, posicion);
	}

	/**
	 * redefinición de avanza()
	 */
	@Override
	public void avanza() {

		Point p = getPosicion();
		if (Math.random() >= 0.5) {
			p.translate(20, 0);
		}
		else {
			p.translate(25, 0);
		}
		setPosicion(p);
	}
}
