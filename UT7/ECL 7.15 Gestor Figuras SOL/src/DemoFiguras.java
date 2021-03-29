
/**
 *   clase DemoFiguras 
 * 
 * 
 */
import java.awt.Color;

public class DemoFiguras
{
	private GestorFiguras gestor;

	/**
	 * Constructor de objetos de la clase DemoFiguras
	 */
	public DemoFiguras()
	{
		gestor = new GestorFiguras();
	}

	/**
	 * 
	 */
	public void testAdd()
	{
		gestor.addFigura(new Circulo(4, 4, Color.RED, 5.2));
		gestor.addFigura(new Circulo(4, 4, Color.RED, 5.2));
		gestor.addFigura(new Circulo(1, 6, Color.YELLOW, 2));
		gestor.addFigura(new Cuadrado(0, 0, Color.GREEN, 2));
		gestor.addFigura(new Cuadrado(0, 0, Color.GREEN, 2));
		gestor.addFigura(new Cuadrado(14, 14, Color.PINK, 12));
		gestor.addFigura(new Triangulo(4, 4, Color.GREEN, 7, 7, 7));
		gestor.addFigura(new Triangulo(14, 14, Color.BLUE, 3, 11, 10));
	}

	/**
	 * 
	 */
	public void testEscribir()
	{
		gestor.listarFiguras();

	}

	/**
	 * 
	 */
	public void testMayorArea()
	{
		Figura f = gestor.mayorArea();
		System.out.println("\nFigura de mayor área : " + f.getClass().getName()
		        + "\n" + String.format("%6.2f", f.area()));

	}

	/**
	 * 
	 */
	public void testOrdenarPorArea()
	{

		gestor.ordenarPorArea();

	}

	/**
	 * 
	 */
	public void testBorrarDeColor(Color c)
	{
		gestor.borrarDeColor(c);

	}

	/**
	 * 
	 */
	public void testBorrarIgualesA(Figura f)
	{
		gestor.borrarIguales(f);

	}

	/**
	 * 
	 */
	public void testOrdenarPorPerimetro()
	{

		gestor.ordenarPorPerimetro();

	}

	/**
	 * 
	 */
	public void testOrdenarPorPerimetroLambda()
	{

		gestor.ordenarPorPerimetroLambda();

	}

	/**
	 *  
	 */
	public static void main(String[] args)
	{
		DemoFiguras demo = new DemoFiguras();
		demo.testAdd();
		demo.testEscribir();
		demo.testMayorArea();
		System.out.println("\n------------------------");
		System.out.println("\nDespués de ordenar por área");
		demo.testOrdenarPorArea();
		System.out.println("\n------------------------");
		System.out.println("\nDespués de ordenar por perímetro");
		demo.testOrdenarPorPerimetro();
		System.out.println("\nDespués de ordenar por perímetro con Lambda");
		demo.testOrdenarPorPerimetroLambda();

		System.out.println("\n------------------------");
		Color c = Color.GREEN;
		demo.testBorrarDeColor(c);
		System.out.println("\nDespués de borrar las de color " + c);

		demo.testEscribir();
		System.out.println("\n------------------------");
		Figura f = new Circulo(4, 4, Color.RED, 5.2);
		demo.testBorrarIgualesA(f);
		System.out.println(
		        "\nDespués de borrar la figura " + f.toString() + "\n");
		demo.testEscribir();

	}

}
