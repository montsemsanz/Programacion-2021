
package pkgsemaforo.modelo;

import javafx.scene.paint.Color;

/**
 * Modela un Semaforo
 * 
 */
public class Semaforo
{

	private Color color;

	/**
	 * Constructor de la clase Semaforo
	 */
	public Semaforo() {

		color = Color.GREEN;
	}

	/**
	 * 
	 * Obtener el color del sem�foro
	 */
	public Color getColor() {

		return color;
	}

	/**
	 * 
	 * Actualizar color del semaforo
	 */
	public void avanzar() {

		if (color.equals(Color.GREEN)) {
			color = Color.RED;
		}
		else if (color.equals(Color.RED)) {
			color = Color.ORANGE;
		}
		else if (color.equals(Color.ORANGE)) {
			color = Color.GREEN;
		}

	}

	/**
	 * 
	 * Cambiar el color
	 */
	public void setColor(Color color) {

		this.color = color;
	}

}
