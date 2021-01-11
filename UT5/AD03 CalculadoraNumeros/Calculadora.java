import java.util.Arrays;
/**
 * clase Calculadora
 * 
 */
public class Calculadora
{
    public static final int MAX = 15;
    private int[] numeros;
    private int total;

    /**
     * Constructor de la clase Calculadora
     */
    public Calculadora()
    {
        numeros = new int[MAX]; 
        total = 0;
    }

    /**
     * Constructor de la clase Calculadora
     */
    public Calculadora(int[] numeros)
    {
        int tam = Math.min(numeros.length, MAX);         
        this.numeros = Arrays.copyOf(numeros, tam);
        total = tam;

    }

    /**
     * Añadir un nº al final (si es posible, es decir, 
     * la calculadora no está completa)
     *     
     */
    public void introducirNumero(int numero)
    {
        if (!estaLlena())    {
            numeros[total] = numero;
            total++;
        }
    }

    /**
     *  devuelve true si la calculadora está completa
     *
     */
    public boolean estaLlena()
    {
        return total == numeros.length;
    }

    /**
     * Acessor para la cantidad de números en la calculadora
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Contar los números  mayores que uno dado
     */
    public int contarMayoresQue(int numero)
    {
        int mayores = 0;
        for (int i = 0; i < total; i++)    {
            if (numeros[i] > numero)    {
                mayores++;
            }
        }
        return mayores;
    }

    /**
     * Intercambiar el valor de dos elementos del array
     * @param i posición de un nº a intercambiar
     *        j posición del segundo nº a intercambiar
     */
    public void intercambiar(int i, int j)
    {
        if (posicionCorrecta(i) && posicionCorrecta(j))  {
            int aux = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = aux;
        }
    }

    /**
     * @param pos la posición a comprobar
     * @return true si es correcta
     */
    private boolean posicionCorrecta(int pos)
    {
        return pos >= 0 && pos < total;
    }

    /**
     * 
     * @return true si la calculadora tiene algún número
     */
    private boolean hayNumeros()
    {
        return total != 0;
    }

    /**
     *  devuelve un array con los números de la calculadora 
     *  con todos sus dígitos en orden decreciente
     *  Usa el método privado   enOrdenDecreciente() 
     *  Si numeros = {45, 6, 965, 123, 93, 489, 321}  devuelve {6, 965, 93, 321 }
     */
    public int[] todoDigitosDecreciente() 
    {
        int[] resul = new int[total];
        int j = 0;
        for (int i = 0; i < total; i++)    {
            if (enOrdenDecrecienteRecursiva(numeros[i]))   {
                resul[j] = numeros[i];
                j++;
            }
        }
        return Arrays.copyOf(resul, j);         

    }

    /**
     *  Dado un nº n indica si todos sus dígitos están en orden decreciente
     *  Haz una versión iterativa para este método
     */
    public static boolean enOrdenDecrecienteIterativa(int n)
    {
        int aux = n;
        while (aux >= 10)    {
            int ultima = aux % 10;
            aux = aux / 10;
            if (ultima > aux % 10 )   {
                return false;
            }
            
        }
        return true;

    }

    /**
     *  Dado un nº n indica si todos sus dígitos están en roden decreciente
     *  Haz una versión recursiva para este método
     */
    public static boolean enOrdenDecrecienteRecursiva(int n)
    {
        if (n < 10)    {
            return true;
        }
        int aux = n / 10;
        if (n % 10 > aux % 10) {
            return false;
        }
        return enOrdenDecrecienteRecursiva(aux);

    }

    /**
     * 
     * Borra el último elemento del atributo numeros
     */
    public void borrarUltimoElemento()
    {
        if (hayNumeros())  {
            total--;
        }
    }  

    /**
     *  Vacía la calculadora
     *
     */
    public void vaciar()
    {
        total = 0;
    }

    /**
     * 
     * Muestra los números guardados en la calculadora
     */
    public void escribirNumeros()
    {
        System.out.println("Posicion" + "\t" + "Valor");
        for (int i = 0; i < total; i++)   {
            System.out.println(i + " - \t\t" + numeros[i]);
        }
    }

    /**
     * @param n el nº a comprobar
     * @return true si n es par
     */
    private static boolean esPar(int n)
    {
        return n % 2 == 0;
    }

    /**
     * Borra los números de valor par
     */
    public void borrarPares()
    {
        int i = 0;
        while (i < total)   {
            if (esPar(numeros[i]))  {
                borrarUnPar(i);
            }
            else      {
                i++;
            }
        }
    }

    /**
     * Borra el valor de una determinada posición
     * @param pos la posición del valor a borrar
     * 
     */
    private void borrarUnPar(int pos)
    {
        for (int i = pos + 1; i < total; i++)   {
            numeros[i - 1] = numeros[i];
        }
        total--; 
    }

    /**
     * Insaerta un nº en la posición indicada
     * @param numero el nº a insertar
     * @param pos la posción en la que se insertará
     */
    public  void insertarEnPosicion(int numero, int pos)
    {
        if (pos < 0 || pos > total)    {
            throw new IllegalArgumentException("Posición incorrecta");
        }
        if (!estaLlena())    {
            // insertar, hacer hueco para el nuevo número
            for (int j = total; j > pos; j--)    {
                numeros[j] = numeros[j - 1];
            }
            // insertar el nº
            numeros[pos] = numero;
            total++;
        }

    }

}
