
/**
 * Representa a un cuadrado
 * 
 *  
 */

import java.awt.Color;

public class Cuadrado extends Figura
{
	private double lado;

	/**
	 * Constructor de la clase Cuadrado
	 * 
	 * @param x
	 *            la coordenada x del centro del cuadrado
	 * @param y
	 *            la coordenada y del centro del cuadrado
	 * @param l
	 *            el lado del cuadrado
	 * 
	 */
	public Cuadrado(int x, int y, Color color, double lado)
	{
		super(x, y, color);
		this.lado = lado;
	}

	/**
	 * 
	 * @return el lado del cuadrado
	 */
	public double getLado()
	{
		return lado;
	}

	/**
	 * @return el área del cuadrado
	 * @override
	 */
	public double area()
	{
		return lado * lado;
	}

	/**
	 * @return el perímetro del cuadrado
	 * @override
	 */
	public double perimetro()
	{
		return 4 * lado;
	}

	/**
	 * 
	 * Representación en formato texto del cuadrado
	 */
	public String toString()
	{
		String s = super.toString();
		return s + "\nLado: " + getLado();

	}

}
