package ordenadores.modelo;

/**
 *   
 */
public abstract class Ordenador {

	private String codigo;
	private double precio;
	// private String slogan;

	/**
	 * Constructor
	 */
	public Ordenador(String codigo, double precio) {

		this.codigo = codigo;
		this.precio = precio;
		// this.slogan = slogan;
	}

	/**
	 *  
	 * 
	 */
	public String getCodigo() {

		return codigo;
	}

	/**
	 *  
	 * 
	 */
	public double getPrecio() {

		return precio;
	}

	/**
	 *  
	 * 
	 */
	public abstract String getSlogan();

	/**
	 * 
	 */
	public void setCodigo(String codigo) {

		this.codigo = codigo;
	}

	/**
	 * 
	 */
	public void setPrecio(double precio) {

		this.precio = precio;
	}

	/**
	 * Aplicar un descuento a todos los ordenadores, variará dependiendo del
	 * tipo
	 */
	public abstract double calcularDescuento();

	/**
	 * 
	 */
	@Override
	public String toString() {

		return this.getClass().toString() + "\nCódigo: " + codigo + "\n"
				+ "Precio: " + precio + "€\n" + "Slogan: " + getSlogan() + "\n"
				+ "Descuento aplicado " + calcularDescuento() + "€\n";
	}

}
