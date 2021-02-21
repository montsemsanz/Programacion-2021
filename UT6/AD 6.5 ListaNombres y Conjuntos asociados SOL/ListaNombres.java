
/**
 * la clase ListaNombres guarda  una lista ordenada
 * de nombres en mayúsculas
 * 
 * Ejercicio AD06
 * 
 */
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ListaNombres
{

    private ArrayList<String> lista;

    /**
     * Constructor de la clase ListaNombres
     */
    public ListaNombres()
    {
        lista = new ArrayList<>();
    }

    /**
     * Añade un nuevo nombre en la posición que
     * le corresponde.  Indiferente mayúsculas o minúsculas al ordenar
     * @param  nombre el nombre a añadir
     *
     */
    public void añadirNombre(String nombre)
    {

        int pos = buscarPosicion(nombre);
        lista.add(pos, nombre);
    }

    /**
     * @return la posición en la que hay que insertar 
     * el nombre - Importan mayúsculas / minúsculas al insertar en orden
     */
    private int buscarPosicion(String nombre)
    {
//         int j = lista.size() - 1;
//         while (j >= 0 && lista.get(j).compareTo(nombre) > 0) {          
//             j--;
// 
//         }
//         return j + 1;
        
        int pos = Collections.binarySearch(lista, nombre);
        if (pos < 0) {// el nombre no está
            pos++;
            pos = Math.abs(pos);
        }
        return pos;
    }

    /**
     * Obtiene el conjunto de caracteres del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public TreeSet<Character> obtenerConjuntoDeCaracteres(int pos)
    {
        if (pos < 0 || pos >= lista.size()) {                       
            throw new IllegalArgumentException("Error en posición");
        }
        return UtilsString.getConjuntoCaracteres(lista.get(pos));

    }

    /**
     * Obtiene el conjunto de dígitos numéricos del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public HashSet<Character> obtenerConjuntoDeDigitos(int pos)
    {
        if (pos < 0 || pos >= lista.size())    {               
            throw new IllegalArgumentException("Error en posición");
        }
        return UtilsString.getConjuntoDigitos(lista.get(pos));

    }

    /**
     * Obtiene el conjunto de letras mayúsculas del nombre de la posición indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public LinkedHashSet<Character> obtenerConjuntoMayusculas(int pos)
    {
        if (pos < 0 || pos >= lista.size())  {                      
            throw new IllegalArgumentException("Error en posición");
        }
        return UtilsString.getConjuntoMayusculas(lista.get(pos));

    }

        
    /**
     * Representación textual de la lista de nombres 
     * de la forma          Nombre - [conjunto de caracteres ]
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Nombres y sus conjunto asociados (Caracteres  Dígitos  Mayúsculas)\n");
        for (int i = 0; i < lista.size(); i++)    {
            sb.append(lista.get(i)).append("   " + 
                    obtenerConjuntoDeCaracteres(i).toString() + "   ");
            sb.append(obtenerConjuntoDeDigitos(i).toString() + "   ");
            sb.append(obtenerConjuntoMayusculas(i).toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     *  
     *
     */
    public void printLista()
    {
        System.out.println(this.toString());
    }

     /**
     * lee los nombres de un fichero de texto 
     *      
     */
    public void leerDeFichero() 
    {
        try     {
            Scanner sc = new Scanner(new File("nombres.txt"));
            while (sc.hasNextLine() )     {
                añadirNombre(sc.nextLine());
            }
            sc.close();
        }
        catch (IOException e)     {
            e.printStackTrace();
        }
    }
}
