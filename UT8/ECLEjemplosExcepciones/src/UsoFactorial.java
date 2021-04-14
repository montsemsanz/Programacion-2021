
/**
 *  
 */
public class UsoFactorial
{

    private MasEjemplosFactorial ej;

    /**
     * Constructor de la clase UsoEjemploExcepciones
     */
    public UsoFactorial()
    {
        ej = new MasEjemplosFactorial(-6, 9, null);
    }

    /**
     *  
     */
    public void demoFactorial()
    {
        try    {
            ej.factorial1();
        }
        catch (FactorialNegativoExcepcion e)    {
            System.out.println(e.getMessage());
           
        }

    }
}