package ordenadores.modelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *  
 *  
 */
public class Tienda
{

	private String nombre;
	private ArrayList<Ordenador> ordenadores;

	/**
	 * Constructor
	 */
	public Tienda(String nombre)
	{

		this.nombre = nombre;
		ordenadores = new ArrayList<>();
	}

	public void addOrdenador(Ordenador ord)
	{

		ordenadores.add(ord);
	}

	public int cuantosPortatiles()
	{

		int cuantos = 0;
		for (Ordenador ord : ordenadores) {
			if (ord instanceof Portatil) {
				cuantos++;
			}
		}
		return cuantos;
	}

	public HashSet<String> masBaratos()
	{

		double precioMenor = Integer.MAX_VALUE;
		HashSet<String> menores = new HashSet<>();
		int i = 0;
		while (i < ordenadores.size()) {
			Ordenador ord = ordenadores.get(i);
			double precio = ord.getPrecio();
			String cod = ord.getCodigo();
			if (precio < precioMenor) {
				precioMenor = precio;
				menores.clear();
				menores.add(cod);
			}
			else if (precio == precioMenor) {
				menores.add(cod);
			}
			i++;
		}
		return menores;

	}

	public void borrarMasBaratos()
	{

		HashSet<String> menores = masBaratos();
		Iterator<Ordenador> it = ordenadores.iterator();
		while (it.hasNext()) {
			Ordenador ord = it.next();
			if (menores.contains(ord.getCodigo())) {
				it.remove();

			}

		}
	}

	public String toString()
	{

		StringBuilder sb = new StringBuilder("Tienda: " + nombre + "\n");
		for (Ordenador ord : ordenadores) {
			sb.append(ord.toString());
		}
		return sb.toString();
	}

}
