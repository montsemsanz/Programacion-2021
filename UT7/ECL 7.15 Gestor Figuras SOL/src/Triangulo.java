
/**
 * Modela un  triángulo
 *  
 */
import java.awt.Color;

public class Triangulo extends Figura {
	private double lado1;
	private double lado2;
	private double lado3;

	/**
	 * Constructor de la clase triángulo
	 * 
	 * @param x
	 *            la coordenada x del centro del triángulo
	 * @param y
	 *            la coordenada y del centro del triángulo
	 * @param l1
	 *            un lado del triángulo
	 * @param l2
	 *            un lado del triángulo
	 * @param l2
	 *            un lado del triángulo
	 */
	public Triangulo(int x, int y, Color color, double l1, double l2,
	        double l3) {
		super(x, y, color);
		lado1 = l1;
		lado2 = l2;
		lado3 = l3;
	}

	/**
	 * 
	 * @return el primer lado
	 */
	public double getLado1() {
		return lado1;
	}

	/**
	 * 
	 * @return el lado2
	 */

	public double getLado2() {
		return lado2;
	}

	/**
	 * 
	 * @return el tercer lado
	 */

	public double getLado3() {
		return lado3;
	}

	/**
	 * @return el área del triángulo
	 * @override
	 */
	@Override
	public double area() {
		double semiPer = perimetro() / 2;
		double area = Math.sqrt(semiPer * (semiPer - lado1) * (semiPer - lado2)
		        * (semiPer - lado3));
		return area;
	}

	/**
	 * @return el perímetro del triángulo
	 * @override
	 */
	@Override
	public double perimetro() {
		return lado1 + lado2 + lado3;
	}

	/**
	 *       
	 */
	@Override
	public String toString() {
		String s = super.toString();
		return s + "\nLado1: " + getLado1() + "\nLado2: " + getLado2()
		        + "\nLado3: " + getLado3();

	}

	/**
	 * Redefinimos equals 
	 * @override
	 */
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			Triangulo t = (Triangulo) obj;
			return this.lado1 == t.getLado1() && this.lado2 == t.getLado2()
			        && this.lado3 == t.getLado3();
		}
		return false;

	}

}
