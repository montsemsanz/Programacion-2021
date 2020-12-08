import java.util.Arrays;

/**
 * La clase contiene un array que se inicializa 
 * con una serie de valores y se utiliza para dibujar
 * un histograma
 */

public class Histograma
{
    private static final int MAX = 10;
    public static final char ASTERISCO = '*';
    private int[] valores ;
    
    /**
     * Constructor
     */
    public Histograma()
    {
        valores = new int[MAX];
        inicializar();

    }

    /**
     * inicializa el array con valores aleatorios
     */
    private void inicializar()
    {
        for (int i = 0; i < valores.length; i++)    {
            valores[i] = generarAleatorio();
        }
    }

    /**
     * genera y devuelve un aleatorio entre 5 y 50 inclusive
     */
    private int generarAleatorio()
    {
        return (int) (Math.random() * 46) + 5;
    }

    /**
     *  muestra el histograma
     */
    public void escribirHistograma()
    {
        for (int i = 0; i < valores.length; i++)     {
            for (int j = 1; j <= valores[i]; j++)  {
                System.out.print("" + ASTERISCO);
            }
            System.out.println();
        }
    }

 
    /**
     * 
     * devuelve una copia del array 
     */
    public int[] getValoresV1()
    {
        int[] copia = new int[valores.length];
        System.arraycopy(valores, 0, copia, 0, valores.length);
        return copia;
    }

     /**
     * 
     * devuelve una copia del array 
     */
    public int[] getValoresV2()
    {
        int[] copia = Arrays.copyOf(valores, valores.length);        
        return copia;
    }
       
}
