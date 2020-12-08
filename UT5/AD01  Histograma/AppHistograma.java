import java.util.Arrays;

/**
 *   
 */
public class AppHistograma
{

    /**
     *  
     */
    public static void main(String[] args)
    {
        Histograma histograma = new Histograma();
        histograma.escribirHistograma();

        System.out.println();
        System.out.println("Valores del array V1 " + Arrays.toString(histograma.getValoresV1()));
        System.out.println("Valores del array V2 " + Arrays.toString(histograma.getValoresV2()));
    }
}
