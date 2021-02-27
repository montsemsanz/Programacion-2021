
/**
 * Modela un diccionario en el que cada palabra
 * tiene asociados una serie de sinónimos
 * 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Tesauro
{
    // a cada clave se le asocia un conjunto de sinónimos
    // los sinónimos no se repiten
    private HashMap<String, HashSet<String>> tesauro;

    /**
     * Constructor de la clase Tesauro
     */
    public Tesauro()
    {
        tesauro = new HashMap<>();
    }

    /**
     * 
     * @param  palabra la palabra a añadir
     *         sinonimo el sinónimo de la palabra
     */
    public void añadirSinonimo(String palabra, String sinonimo)
    {
        if (!tesauro.containsKey(palabra))    {
            HashSet<String> sinonimos = new HashSet<String>();
            sinonimos.add(sinonimo);
            tesauro.put(palabra, sinonimos );
        }
        else   {
            tesauro.get(palabra).add(sinonimo);    
        }

    }

    /**
     * añade una palabra junto con todos sus sinónimos 
     * @param linea contiene la palabra y sus sinónimos
     *         el separador entre palabras es el blanco
     *         la primera palabra es la clave, el resto sinónimos
     */
    public void añadirSinonimo(String linea)
    {
        String[] palabras = linea.trim().split("\\s+");
        String palabra = palabras[0].trim();
        for (int i = 1; i < palabras.length; i++)   {
            añadirSinonimo(palabra, palabras[i]);
        }


    }

    /**
     * 
     * @param  sin el sinónimo a borrar de cada conjunto
     *              de sinónimos
     * @return   el conjunto de claves en las que estaba
     *            el sinónimo borrado. Si no se borró
     *            ninguno devuelve el conjunto vacío
     */
    public HashSet<String> borrarSinonimo(String sin)
    {
        HashSet<String> resul = new HashSet<String>();
        Set<String> claves = tesauro.keySet();
        for (String clave: claves)     {
            HashSet<String> valores = tesauro.get(clave);
            if (valores.contains(sin))        {
                resul.add(clave);
                valores.remove(sin);
            }
        }
        return resul;

    }

    /**
     * 
     * @return  representación textual del map
     *     
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("TESAURO " + "\n");
        Set<String> claves = tesauro.keySet();
        for (String clave: claves)        {
            sb.append(clave + "\n" + "\tSINÓNIMOS  ");
            HashSet<String> valores = tesauro.get(clave);
            for (String valor: valores)         {
                sb.append(valor + "\t");
            }
            sb.append("\n");

        }
        return sb.toString();

    }

    /**
     * 
     * Visualiza el tesauro    
     */
    public void escribirTesauro()
    {

        System.out.println(toString());
    }

}
