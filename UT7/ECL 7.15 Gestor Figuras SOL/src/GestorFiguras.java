
/**
 * Clase GestorFiguras 
 * 
 *  
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GestorFiguras {

	private List<Figura> figuras; // la colección de figuras

	/**
	 * Constructor de la clase GestorFiguras
	 */
	public GestorFiguras() {

		figuras = new ArrayList<>();
	}

	/**
	 * 
	 * @param f  una nueva figura a añadir
	 * 
	 */
	public void addFigura(Figura f) {

		if (!figuras.contains(f)) {
			figuras.add(f);
		}
	}

	/**
	 * 
	 * Mostrar todas las figuras
	 */
	public void listarFiguras() {

		listarFiguras(figuras);

	}

	/**
	 * 
	 */
	private void listarFiguras(List<Figura> figuras) {

		for (Figura f : figuras) {
			System.out.println(f.toString() + "\n\n");
		}
	}

	/**
	 * 
	 * 
	 * @return la figura de mayor área
	 */
	public Figura mayorArea() {

		Figura mayor = null;
		double maxArea = Double.MIN_VALUE;
		for (Figura figura : figuras) {
			double area = figura.area();
			if (area > maxArea) {
				mayor = figura;
				maxArea = area;
			}

		}
		return mayor;
	}

	/**
	 * 
	 * @param color el color de la figura a borrar
	 * 
	 */
	public void borrarDeColor(Color color) {

		Iterator<Figura> it = figuras.iterator();
		while (it.hasNext()) {
			Figura f = it.next();
			if (f.getColor().equals(color)) {
				it.remove();
			}
		}
	}

	/**
	 * 
	 * @param f la figura con la que comparar, se borrar las que son iguales a
	 *            ella
	 * 
	 */
	public void borrarIguales(Figura f) {

		Iterator<Figura> it = figuras.iterator();
		while (it.hasNext()) {
			Figura fig = it.next();
			if (fig.equals(f)) {
				it.remove();
			}
		}
	}

	/**
	 * Creamos un array de elementos movibles y los desplazamos
	 */
	public void testMovibles() {

		Movible[] figMovibles = new Movible[5];
		figMovibles[0] = new Circulo(3, 5, Color.green, 7);
		figMovibles[1] = new Cuadrado(0, 0, Color.blue, 5);
		figMovibles[1].moverHorizontal(10);
		System.out.println(figMovibles[1].toString());

	}

	/**
	 * 
	 * Ordenar las figuras de menor a mayor área
	 * 
	 */
	public void ordenarPorArea() {

		List<Figura> tmp = new ArrayList<Figura>(figuras);
		Collections.sort(tmp);
		// tmp.sort(Comparator.naturalOrder());
		listarFiguras(tmp);
	}

	/**
	 * 
	 * Ordenar las figuras de menor a mayor perímetro
	 * 
	 */
	public void ordenarPorPerimetro() {

		List<Figura> tmp = new ArrayList<Figura>(figuras);
		Collections.sort(tmp, new Comparator<Figura>() {

			@Override
			public int compare(Figura f1, Figura f2) {

				return Double.compare(f1.perimetro(), f2.perimetro());
			}
		});
		listarFiguras(tmp);

	}

	/**
	 * 
	 * Ordenar las figuras de menor a mayor perímetro
	 * 
	 */
	public void ordenarPorPerimetroLambda() {

		List<Figura> tmp = new ArrayList<Figura>(figuras);
		tmp.sort((f1, f2) -> Double.compare(f1.perimetro(), f2.perimetro()));

		listarFiguras(tmp);
	}

}
