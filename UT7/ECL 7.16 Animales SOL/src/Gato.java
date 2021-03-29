
public class Gato extends Animal {
	private String juguete;

	/**
	 * Constructor
	 */
	public Gato(String nombre, int patas, Persona persona, String juguete) {
		super(nombre, patas, persona);
		this.juguete = juguete;
	}

	/**
	 * @accesor para el juguete
	 */
	public String getJuguete() {
		return juguete;
	}

	/**
	 * m
	 * 
	 * @override
	 */
	@Override
	public String emitirSonido() {
		return "Maullar";
	}

	/**
	 * 
	 * @override
	 */
	@Override
	public String comer() {
		return "Raspas";
	}

	/**
	 * @override
	 */
	@Override
	public String toString() {
		String s = super.toString();
		return s + "\nJuguete favorito: " + getJuguete() + "\n";

	}

}
