
/**
 * La clase mantiene una lista de nombres
 * en orden léxicográfico  
 * 
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ListaNombres
{
    private String[]  lista;
    private int pos;

    /**
     * Constructor de la clase ListaNombres
     * n es el tamaño máximo de la lista
     */
    public ListaNombres(int n) 
    {              
        lista = new String[n];  
        pos = 0;
    }

    /**
     * @return  true si la lista está vacía   
     */
    public boolean  listaVacia()
    {
        return pos == 0;
    }

    /**
     * 
     * @return  true si la lista está llena   
     */
    public boolean  listaLlena()
    {
        return pos == lista.length;
    }

    /**
     * Inserta un nombre en la lista únicamente
     * si no está y la lista no está llena. La inserción se hace de tal
     * manera que el nombre queda colocado en el 
     * lugar que le corresponde manteniendo el orden 
     * de la lista (no se utiliza ningún algoritmo de ordenación)
     * Importan mayúsculas  y minúsculas
     * 
     * @param nombre el nombre a insertar
     * @return  true si la inserción se hace con éxito   
     *
     */
    public boolean insertarNombre(String nombre)
    {
        boolean insertado = false;
        if (!listaLlena())     {
            if (!estaNombre(nombre))   {
                //insertamos el nombre
                int j = pos - 1;
                while (j >= 0 && lista[j].compareTo(nombre) > 0) {
                    lista[j + 1] = lista[j];
                    j--;
                }
                lista[j + 1] = nombre;
                pos++;
                insertado = true;
            }
        }

        return insertado;
    }

    /**
     *  Busca un nomnbre en la lista
     *  Puesto que la lista está en todo momento ordenada
     *  se hace una búsqueda binaria
     *  @param  nombre el nombre a buscar
     *  @return   true si ya existe el nombre en la lista  
     *   
     */
    private boolean estaNombre(String nombre)
    {
        int izq = 0;
        int dcha = pos - 1;
        while (izq <= dcha)  {
            int mitad = (izq + dcha) / 2;
            int resul = lista[mitad].compareTo(nombre);
            if (resul == 0)    {
                return true;
            }
            else if (resul < 0)  {
                izq = mitad + 1;
            }
            else  {
                dcha = mitad - 1;  
            }
        }
        return false;
        //     return Arrays.binarySearch(lista, 0, pos, nombre) >= 0;  // otra posibilidad más cómoda
    }

    /**
     *  Busca y devuelve el nombre de mayor longitud
     *  en la lista. Si hay varios devuelve el
     *  primero encontrado
     *  Si la lista está vacía devuelve null
     *  
     *  @return   el nombre más largo  
     *  
     */
    public String nombreMasLargo()
    {
        if (listaVacia())  {
            return null;
        }
        String masLargo = lista[0];
        for (int i = 1; i < pos; i++)  {
            if (lista[i].length() > masLargo.length())  {
                masLargo = lista[i];
            }
        }
        return masLargo;
    }

    /**
     * Borra de la lista los nombres que empiezan por 
     * una letra determinada (sí importan mayúsculas y minúsculas)
     * No es lo mismo borrarLetra('A') que borrarLetra('a')
     *
     * @param letra la letra por la que han de empezar los nombres 
     *    
     */
    public void borrarLetra(char letra)
    {
        int i = 0;
        while (i < pos)  {
            if (lista[i].charAt(0) == letra)  {
                borrarDePosicion(i);
            }
            else {
                i++;     
            }
        }
    }

    /**
     * Borra un nombre de la posición indicada
     * 
     *
     * @param  p posición del nombre a borrar
     *  
     */
    private void borrarDePosicion(int p)
    {
        // for (int i = p + 1; i < pos; i++) {
        // lista[i - 1] = lista[i]; 
        // }
        // pos--;                

        System.arraycopy(lista, p + 1, lista, p, pos - p - 1);
        pos--;
    }

    /**
     *  devuelve un  array con los elementos de lista pero en orden inverso
     *  el primero ahora es el ultimo de lista, el segundo el antepenúltimo,..... y además cada
     *  nombre en el nuevo array se invierte también
     *  
     */
    public String[] invertir()
    {
        String[] invertido = new String[pos];
        for (int i =  pos - 1; i >= 0; i--)  {
            invertido[pos - i - 1] = invertir(lista[i]);
        }
        return invertido;
    }

    /**
     *  Dado un nombre lo devuelve invertido.
     *  Usar StringBuilder
     */
    public static String invertir(String nombre)
    {
        return new StringBuilder(nombre).reverse().toString();
    }

    /**
     * Lee de un fichero de texto una serie 
     * de nombres con ayuda de un objeto de la 
     * clase Scanner y los almacena en la lista
     */
    public void cargarDeFichero() 
    {
        Scanner sc = null;
        try   {
            sc = new Scanner(new File("nombres.txt"));
            while (sc.hasNextLine() && !listaLlena())     {
                insertarNombre(sc.nextLine());
            }            
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
    }

    /**
     * Cuenta cuántos nombres empiezan por una determinada 
     * cadena sin importar si es mayúscula o minúscula
     *
     * @param  la cadena de comienzo
     * @return  la cantidad de nombres calculados   
     */
    public int empiezanPor(String inicio)
    {
        String ini = inicio.toUpperCase();
        int cuantos = 0;
        for (int i = 0; i < pos; i++)   {
            String n = lista[i].toUpperCase();
            if (n.startsWith(ini))  {
                cuantos++;
            }
        }
        return cuantos;

    }

    /** 
     * 
     * Devuelve un array con los nombres que empiezan por una determinada 
     * letra sin importar si es mayúscula o minúscula
     * 
     * @param  la letra de comienzo
     * @return  la cantidad de nombres encontrados
     *          con esa letra   
     */ 
    public String[] empiezanPorLetra(char letra)
    {
        String ini = String.valueOf(letra).toUpperCase();
        String[] resul = new String[empiezanPor(ini)];
        int j = 0;
        for (int i = 0; i < pos; i++)    {
            String n = lista[i].toUpperCase();
            if (n.startsWith(ini))    {
                resul[j] = lista[i];
                j++;
            }
        }

        return resul;

    }

    /**
     * Representación textual de la cadena
     * 
     * @return la cadena resultante    
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++)  {
            sb.append(lista[i] + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }

}
