
package pkgconcesionario.modelo;

/**
 *  clase CocheDeportivo aqu�.
 *  
 */
import java.awt.Point;

public class CocheDeportivo extends Coche
{
	//sin atributos, solo los heredados

	public CocheDeportivo(String conductor, String modelo, String color) {

		super(conductor, modelo, color, new Point(0, 200));
	}

	/**
	 * redefinimos avanza()
	 */
	@Override
	public void avanza() {

		Point p = getPosicion();
		if (Math.random() >= 0.7) {
			p.translate(50, 0);
		}
		else {
			p.translate(30, 0);
		}
		setPosicion(p);
	}

}
