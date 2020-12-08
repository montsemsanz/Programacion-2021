
/**
 *  
 */
public class DemoOrdenación
{

    /**
     * Constructor  
     */
    public DemoOrdenación()
    {

    }

    /**
     *  Ordenar en orden ascendente
     */
    public void  ordenarSeleccionDirecta(int[] array)
    {
        for  (int i = 0; i < array.length - 1; i++)   {
            int posmin = i;
            for (int j = i + 1; j < array.length; j++)  {
                if (array[j] < array[posmin])  {
                    posmin = j;
                }
            }
            int aux = array[posmin];
            array[posmin] = array[i];
            array[i] = aux;
        }
    }

    /**
     *  Ordenar en orden ascendente
     */
    public void  ordenarInsercionDirecta(int[] array)
    {
        for  (int i = 1; i < array.length; i++) {
            int aux = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > aux) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }
}
