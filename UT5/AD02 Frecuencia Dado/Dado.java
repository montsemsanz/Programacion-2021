
/**
 * Modela un dado de 6 caras
 */
import java.util.Random;
public class Dado
{
    public static final int NUMERO_CARAS = 6;
    private int cara;
    private Random generador;

    /**
     * Constructor de la clase Dado
     */
    public Dado()
    {
        generador = new Random();
        cara = 1;
    }

    /**
     *    accesor para la cara
     */
    public int getCara()
    {

        return cara;
    }

    /**
     *   simula el lanzamiento de un dado
     */
    public void tirarDado()
    {

        cara = generador.nextInt(NUMERO_CARAS ) + 1;
    }
}
