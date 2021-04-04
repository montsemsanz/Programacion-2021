
package pkgconcesionario.modelo;

/**
 * Modela un coche
 */
import java.awt.Point;

public abstract class Coche {

	private String conductor;
	private String modelo;
	private String color;
	private Point posicion;

	/**
	 * Constructor
	 */

	public Coche(String conductor, String modelo, String color,
	        Point posicion) {

		this.conductor = conductor;
		this.modelo = modelo;
		this.color = color;
		this.posicion = posicion;
	}

	/**
	 * accesor para el conductor
	 */
	public String getConductor() {

		return conductor;
	}

	/**
	 * accesor para el modelo de coche
	 */
	public String getModelo() {

		return modelo;
	}

	/**
	 * accesor para el color del coche
	 */
	public String getColor() {

		return color;
	}

	/**
	 * accesor para la posición
	 */
	public Point getPosicion() {

		return posicion;
	}

	/**
	 * mutador para el conductor
	 */
	public void setConductor(String conductor) {

		this.conductor = conductor;
	}

	/**
	 * mutador para el modelo
	 */
	public void setModelo(String modelo) {

		this.modelo = modelo;
	}

	/**
	 * mutador para el color
	 */
	public void setColor(String color) {

		this.color = color;
	}

	/**
	 * mutador para la posición
	 */
	public void setPosicion(Point posicion) {

		this.posicion = posicion;
	}

	/**
	 * Representación textual de un coche
	 */
	@Override
	public String toString() {

		return this.getClass().getName() + "\nConductor: " + conductor
		        + "\nModelo: " + modelo + "\nColor: " + color + "\nPosicion: "
		        + posicion.toString();
	}

	/**
	 * redefinición de equals()
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Coche c = (Coche) obj;
		return c.getConductor().equalsIgnoreCase(this.conductor)
		        && c.getColor().equalsIgnoreCase(this.color)
		        && c.getModelo().equalsIgnoreCase(this.modelo);

	}

	@Override
	public int hashCode() {

		return conductor.hashCode() + color.hashCode() + modelo.hashCode();
	}

	public abstract void avanza();
}
