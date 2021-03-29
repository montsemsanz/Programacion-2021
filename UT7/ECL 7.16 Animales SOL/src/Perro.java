
public class Perro extends Animal {
	private String lugarFavorito;

	/**
	 * Constructor
	 */
	public Perro(String nombre, int patas, Persona persona,
	        String lugarFavorito) {
		super(nombre, patas, persona);
		this.lugarFavorito = lugarFavorito;
	}

	/**
	 * accesor para el lugar
	 */
	public String getLugar() {
		return lugarFavorito;
	}

	/**
	 * @override
	 */
	@Override
	public String emitirSonido() {
		return "Ladrar";
	}

	/**
	 * @override
	 */
	@Override
	public String comer() {
		return "Huesos";
	}

	/**
	 * @override
	 */
	@Override
	public String toString() {
		String s = super.toString();
		return s + "\nLugar favorito: " + getLugar() + "\n";

	}

}
