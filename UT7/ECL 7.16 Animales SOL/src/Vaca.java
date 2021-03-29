
/**
 *  
 */
public class Vaca extends Animal
{

	/**
	 * Constructor
	 */
	public Vaca(String nombre, int patas, Persona persona)
	{
		super(nombre, patas, persona);

	}

	/**
	 * 
	 * @override
	 */
	public String emitirSonido()
	{
		return "MUUUUUUU";
	}

	/**
	 * 
	 * @override
	 */
	public String comer()
	{
		return "Hierba";
	}

}
