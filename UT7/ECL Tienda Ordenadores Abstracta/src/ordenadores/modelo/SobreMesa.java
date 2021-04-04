package ordenadores.modelo;

/**
 *    
 */
public class SobreMesa extends Ordenador
{

	private static final double DESCUENTO = 5;
	private String descripcion;

	/**
	 * Constructor
	 */
	public SobreMesa(String codigo, double precio,
	                String descripcion)
	{

		super(codigo, precio);
		this.descripcion = descripcion;
	}

	/**
	 *  
	 * 
	 */
	public String getDescripcion()
	{

		return descripcion;
	}

	/**
	 *  
	 * 
	 */
	@Override
	public String getSlogan()
	{

		return "El que más pesa pero el que menos cuesta";
	}

	/**
	 * 
	 */
	public void setDescripcion(String descripcion)
	{

		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	@Override
	public double calcularDescuento()
	{

		return getPrecio() * DESCUENTO / 100;
	}

	/**
	 * 
	 */
	@Override
	public String toString()
	{

		return super.toString() +
		                "Descripción: " + descripcion
		                + "\n\n";
	}
}
