
/**
 * La clase mantiene un map en el
 * que se registran las veces que 
 * aparece cada uno de los números
 * de un fichero de texto
 * 
 * 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FrecuenciaNumeros
{
    private HashMap<String, Contador> frecuencias;

    /**
     * Constructor de la clase FrecuenciaNumeros
     */
    public FrecuenciaNumeros()
    {
        frecuencias = new HashMap<>();
    }

    /**
     * 
     *
     * @param  el nº a añadir    
     */
    public void añadirNumero(int numero)
    {
        String clave = String.valueOf(numero);
        if (frecuencias.containsKey(clave))  {
            frecuencias.get(clave).incrementar();
        }
        else   {
            frecuencias.put(clave, new Contador(1));
        }
    }


    /**
     * lee los números de un fichero de texto 
     *      
     */
    public void cargarDeFichero() 
    {
        try   {
            Scanner sc = new Scanner(new File("numeros.txt"));
            while (sc.hasNext() )     {
                añadirNumero(sc.nextInt());
            }
            sc.close();
        }
        catch (IOException e)     {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Listar cada número aparecido y su frecuencia
     * Se utiliza Map.Entry (conjunto de entradas)
     */
    public void listarFrecuencias()
    {
        Set<Map.Entry<String, Contador>> entradas = frecuencias.entrySet();
        Iterator<Map.Entry<String, Contador>> it = entradas.iterator();
        while (it.hasNext())  {
            Map.Entry<String, Contador> entrada = it.next();
            System.out.println("Nº " + entrada.getKey() + "\tFrecuencia " +    
                entrada.getValue().getContador());
        }

    }

    /**
     * 
     * Muestra cuántos números diferentes han aparecido
     * y la relación de todos ellos
     * 
     * Se utiliza la "vista" sobre las claves
     * y un for mejorado
     */
    public void listarNumeros()
    {
        Set<String> claves = frecuencias.keySet();
        System.out.println("Números aparecidos " + claves.size());

        for (String c: claves)     {
            System.out.print(c + "\t");
        }
        System.out.println();
    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        FrecuenciaNumeros demo = new FrecuenciaNumeros();
        demo.cargarDeFichero();
        demo.listarFrecuencias();
        demo.listarNumeros();
    }

}
