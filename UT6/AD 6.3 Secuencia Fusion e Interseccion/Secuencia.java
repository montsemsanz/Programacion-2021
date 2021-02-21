import java.util.Arrays;
import java.util.HashSet;

/**
 * La clase Secuencia almacena un serie de 
 * números ordenados.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Secuencia
{
    private ArrayList<Integer> lista;

    /**
     * Construye una secuencia a partir de la colección 
     * recibida
     */        
    public Secuencia(ArrayList<Integer> otra)
    {
        if (otra == null)     {
            throw new IllegalArgumentException("Colección vacía");
        }
        lista = new ArrayList<>();
        lista.addAll(otra); 
        Collections.sort(lista); //se puede porque Integer implementa el interfaz Comparable
    }

    /**
     * accesor para la secuencia ArrayList almacenada
     */

    public ArrayList<Integer> getSecuencia()
    {
        ArrayList<Integer> copia = new ArrayList<>();
        copia.addAll(lista);
        return copia;
    }

    /**
     * Obtiene la fusión (la unión) de dos listas 
     * de números ordenadas, la representada por el atributo lista y 
     * la representada por el parámetro otra
     * 
     */
    public ArrayList<Integer> fusionarCon(ArrayList<Integer> otra)
    {
        if (otra == null)    {
            throw new IllegalArgumentException("Colección nula");
        }
        ArrayList<Integer> copia = getSecuencia(); 
        copia.addAll(otra);         
        Collections.sort(copia);
        return copia;
    }

    /**
     * Obtiene la intersección de lista y el parámetro otra. La  intersección 
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public  ArrayList<Integer> interseccionCon( ArrayList<Integer> otra)
    {
        if (otra == null)   {
            throw new IllegalArgumentException("Colección nula");
        }
        ArrayList<Integer> interseccion = new ArrayList<>();
        interseccion.addAll(lista);
        interseccion.retainAll(otra);
        return eliminarDuplicados(interseccion);

    }

    /**
     *  Elimina los duplicados de una lista
     *
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista)
    {
        HashSet<Integer> conjunto =  new HashSet<>(lista);
        lista.clear();
        lista.addAll(conjunto);
        return lista;

    }

    /**
     * Representación textual de la secuencia guardada
     * por el objeto actual
     */
    public String toString()
    {
        return lista.toString();
    }

    /**
     *  Pruea de la clase
     */
    public static void main(String[] args)
    {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.addAll(Arrays.asList(3, 4, 4, 5, 7, 8, 9, 9, 14));
        Secuencia secuencia1 = new Secuencia(l1);
        System.out.println(secuencia1.toString());

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.addAll(Arrays.asList(1, 3, 3, 4, 12));
        Secuencia secuencia2 = new Secuencia(l2);
        System.out.println(secuencia2.toString());

        ArrayList<Integer> fusion = secuencia1.fusionarCon(secuencia2.getSecuencia());
        System.out.println(fusion.toString());

        ArrayList<Integer> interseccion = secuencia1.interseccionCon(secuencia2.getSecuencia());
        System.out.println(interseccion.toString());

    }

}
