package ut6.romanos.modelo;
/**
 * La clase GestorRomanos genera una lista
 * de nºs arábigos con sus correspondientes
 * nºs romanos.
 * La lista está ordenada por nº arábigo
 * Para modelar la lista se utiliza un TreeMap
 */
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
 


public class GestorRomanos
{
    
    private TreeMap<Integer, String> listaArabigos;
    private ConversorRomanos conversor;

    /**
     * Constructor 
     */
    public GestorRomanos(ConversorRomanos conversor)
    {
        listaArabigos = new TreeMap<>();
        this.conversor = conversor;
    }

    /**
     * Añadir un romano. Se añade la clave que es 
     * su valor arábigo y el valor asociado que es
     * el nº romano
     * 
     * @param  romano el nº romano se añade como 
     *          valor asociado.
     * 
     */
    public void añadirRomano(String romano)
    {
        romano = romano.toUpperCase();
        int arabigo = conversor.convertir(romano);
        listaArabigos.put(arabigo , romano);
    }
    
    /**
     * Añadir varios romanos.  
     * 
     * @param  el array con los nºs romanos
     * 
     */
    public void añadirRomanos(String[] romanos)
    {
        for (String s: romanos)  {
            añadirRomano(s);
        }
    }
    /**
     * representación  textual del map
     *
     */
    public String toString()
    {
       StringBuilder sb = new StringBuilder(String.format("%20s%20s\n", "Arábigos", "Romanos"));
       Set<Map.Entry<Integer, String>> entradas = listaArabigos.entrySet();
       for (Map.Entry<Integer, String> e: entradas)   {
            sb.append(String.format("%20s%20s\n", e.getKey(),  e.getValue()) );
        }
       return sb.toString();
    }
    
    /**
     * Mostrar la lista de arábigos   
     *  
     */
    public void escribirListaArabigos()
    {
         
        System.out.println(this.toString());
        
                            
        
    }
    
   
}
