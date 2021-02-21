
/**
 * Multimap - Un objeto de esta clase guarda
 * en un map claves String que representan números
 * y múltiplos asociados a esas claves
 * 
 * Ejer. AD07
 * 
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class SerieMultiplos
{

    private Map<String, ArrayList<Integer>> mapMultiplos;

    /**
     * Constructor de la clase SeriePotencias
     */
    public SerieMultiplos()
    {
        mapMultiplos = new HashMap<>();

    }

    /**
     * 
     * @param  num el nº que será la clave
     *  
     */
    public void añadirEntrada(int num) 
    {
        String clave = String.valueOf(num);
        if (!mapMultiplos.containsKey(clave))        {
            ArrayList<Integer> valor = generarMultiplos(num);           
            mapMultiplos.put(clave, valor);
        }
    }

    /**
     * 
     * @param  num el nº del que se generearán los múltiplos
     * @return una colección ArrayLIst con los múltiplos generados
     */
    private ArrayList<Integer> generarMultiplos(int num)
    {
        ArrayList<Integer> multi = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++)   {
            multi.add(num * i);
        }
        return multi;
    }

    /**
     * 
     * @param  num el nº del que se obtendrán los múltiplos
     * @return  la colección asociada en el map   
     */
    public ArrayList<Integer> obtenerMultiplosDe(int num)
    {

        String clave = String.valueOf(num);
        return mapMultiplos.get(clave);

    }

    /**
     * Visualiza el map (claves y valores asociados)
     *    
     */
    public void escribirMap()
    {
        Set<String> claves = mapMultiplos.keySet();  
        for (String clave: claves)   {
            System.out.print("Nº (clave): " + clave);
            ArrayList<Integer> valores = mapMultiplos.get(clave);
            escribirValor(valores);
            System.out.println();
            System.out.println("----------------------------\n");
        }

    }

    /**
     * Método privado de ayuda que visualiza aun ArrayList
     *    
     */
    private void escribirValor(ArrayList<Integer> lista)
    {
        System.out.print("\tMúltiplos: ");
        for (int i: lista)   {
            System.out.print(i + " ");
        }
    }

    /**
     * borrar del map (de todas las entradas) el múltiplo indicado
     * Con Map.Entry y un iterador
     */
    public  int borrarMultiplo(int multi)
    {
        int total = 0;
        Set<Map.Entry<String, ArrayList<Integer>>> conjuntoEntradas = mapMultiplos.entrySet(); 
        Iterator<Map.Entry<String, ArrayList<Integer>>> it = conjuntoEntradas.iterator();
        while (it.hasNext())    {
            Map.Entry<String, ArrayList<Integer>> entrada = it.next();
            ArrayList<Integer> lista = entrada.getValue();
            // si paso a remove() multi lo toma como posición del ArrayList y no
            // como un objeto Integer
            if (lista.remove(new Integer(multi))) {
                total ++;
            }
        }
        return total;
    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        SerieMultiplos serie = new SerieMultiplos();
        serie.añadirEntrada(5);
        serie.añadirEntrada(3);
        serie.añadirEntrada(5);
        serie.añadirEntrada(2);
        serie.añadirEntrada(6);
        serie.escribirMap();

        int num = 7;
        ArrayList<Integer> multiplos = serie.obtenerMultiplosDe(num);
        if (multiplos != null)    {
            System.out.println("Múltiplos de " + num + " = " + 
                multiplos.toString());
        }
        System.out.println();
        num = 5;
        multiplos = serie.obtenerMultiplosDe(num);
        if (multiplos != null)     {
            System.out.println("Múltiplos de " + num + " = " + 
                multiplos.toString());
        }
        System.out.println();
        num = 12;
        int borrados = serie.borrarMultiplo(num);
        System.out.println("Después de borrar el múltiplo " + num);
        serie.escribirMap();
        System.out.println("Se han borrado " + borrados);
    }

}
