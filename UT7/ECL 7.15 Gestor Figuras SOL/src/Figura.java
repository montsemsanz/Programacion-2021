
/**
 * Clase Figura 
 * 
 *  
 */
import java.awt.Color;
import java.awt.Point;

public abstract class Figura implements Movible, Comparable<Figura> {

	private Point centro;
	private Color color;

	/**
	 * Constructor de la clase Figura
	 * 
	 * @param x
	 *            la coordenada x del centro
	 * @param y
	 *            la coordenada y del centro
	 */
	public Figura(int x, int y, Color color) {

		centro = new Point(x, y);
		this.color = color;
	}

	/**
	 * 
	 * Accesor para el centro de la figura
	 * 
	 * @return el centro de la figura
	 */
	public Point getCentro() {

		return centro;
	}

	/**
	 * 
	 * Accesor para el color de la figura
	 * 
	 * @return el color de la figura
	 */
	public Color getColor() {

		return color;
	}

	/**
	 * 
	 * 
	 * @return el área de una figura
	 */
	public abstract double area();

	/**
	 * 
	 * 
	 * @return el perímetro de una figura
	 */
	public abstract double perimetro();

	/**
	 * 
	 * Representación textual de una figura
	 * 
	 */
	@Override
	public String toString() {

		return "Clase " + this.getClass().getName() + "\nCentro: "
		        + centro.toString() + "\nColor:  " + getColor().toString()
		        + "\nÁrea  " + String.format("%5.2f", area()) + "\nPerímetro  "
		        + String.format("%5.2f", perimetro());
	}

	/**
	 * La figura se desplaza horizontalmente una cantidad
	 * 
	 * @param desp
	 *            el desplazamiento horizontal de la figura
	 * 
	 */
	@Override
	public void moverHorizontal(int desp) {

		centro.move((int) centro.getX() + desp, (int) centro.getY());

	}

	/**
	 * 
	 * La figura se desplaza verticalmente una cantidad
	 * 
	 * @param desp
	 *            el desplazamiento vertical de la figura
	 */
	@Override
	public void moverVertical(int desp) {

		centro.move((int) centro.getX(), (int) centro.getY() + desp);

	}

	/**
	 * Redefinimos equals
	 * 
	 * @override
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Figura f = (Figura) obj;
		return f.getColor().equals(this.color) && this.area() == f.area();

	}

	/**
	 * 
	 * @override
	 */
	@Override
	public int hashCode() {

		return centro.hashCode() + color.hashCode();
	}

	/**
	 * 
	 * 
	 * @override
	 */
	@Override
	public int compareTo(Figura otra) {
		//		if (this.area() < otra.area()) {
		//			return -1;
		//		}
		//		if (this.area() > otra.area()) {
		//			return 1;
		//		}
		//		return 0;

		return Double.compare(this.area(), otra.area());
	}

}
