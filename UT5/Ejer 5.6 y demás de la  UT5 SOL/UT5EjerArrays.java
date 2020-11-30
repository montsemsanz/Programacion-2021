import java.util.Arrays;
/**
 *   
 */
public class UT5EjerArrays
{

    private static final int MAX = 5;

    /**
     * Constructor  
     */
    public UT5EjerArrays()
    {

    }

    /**
     * Ejer 5.4 
     */
    public  void escribirArray()
    {
        int[] elementos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i] + "\t");
        }

    }
    
     /**
     * Ejer 5.5 
     * diaSemana ha de ser un valor entre 1 y 7
     * devolver el nombre del día de la 
     * semana  correspondiente   al   parámetro   que  se  pasa  al   método
     * Si  el  valor  del parámetro es incorrecto se devolverá la cadena “Día incorrecto”;
     */ 
    public String  encontrarNombreDia(int diaSemana)
    {
        // declarar e inicializar un array con los nombres de los días de la semana
        String[] nombresDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        if (diaSemana < 1 || diaSemana > 7) {
            return "Día incorrecto";
        }
        return nombresDias[diaSemana - 1];
    }

    /**
     *  
     * Ejer 5.6
     *  
     */
    public double calcularMedia(double[] notas)
    {
        double suma = 0.0;
        for (int i = 0; i < notas.length; i++)  {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    /**
     *  
     * Ejer 5.7
     *  
     */
    public int maximo(int[] enteros)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < enteros.length; i++)   {
            if (enteros[i] > max)   {
                max = enteros[i];
            }
        }
        return max;
    }

    /**
     *  
     * Ejer 5.8
     *  
     */
    public int[] paresV1(int[] enteros)
    {
        int totalPares = 0;
        int i = 0;
        while (i < enteros.length)   {
            if (enteros[i] % 2 == 0) {
                totalPares++;
            }
            i++;
        }
        int[] arrayPares = new int[totalPares];
        int p = 0;
        for (i = 0; i < enteros.length; i++)  {
            if (enteros[i] % 2 == 0)  {
                arrayPares[p] = enteros[i];
                p++;
            }
        }
        return arrayPares;
    }

    /**
     *  
     * Ejer 5.8
     *  
     */
    public int[] paresV2(int[] enteros)
    {

        int[] arrayPares = new int[enteros.length];
        int p = 0;
        for (int i = 0; i < enteros.length; i++)   {
            if (enteros[i] % 2 == 0)  {
                arrayPares[p] = enteros[i];
                p++;
            }
        }
        return Arrays.copyOf(arrayPares, p);
    }

    /**
     *  
     * Ejer 5.9 - sobre el mismo array
     *  
     */
    public void rotarDerecha(int[] enteros)
    {

        int aux = enteros[enteros.length - 1];
        for (int i = enteros.length - 2; i >= 0; i--)  {
            enteros[i + 1] = enteros[i];
        }
        enteros[0] = aux;

    }

    /**
     *  
     * Ejer 5.9 - devolviendo un nuevo array
     *  
     */
    public int[] rotarDerechaV2(int[] enteros)
    {
        int[] rotado = new int[enteros.length];
        for (int i = 0; i < enteros.length - 1; i++)  {
            rotado[i + 1] = enteros[i];
        }
        rotado[0] = enteros[enteros.length - 1];
        return  rotado; 
    }

    /**
     *  
     * Ejer 5.9 - Sin array adicional empezando desde
     *  el principio (más complicado)
     *  
     */
    public void rotarDerechaV3(int[] enteros)
    {
        int ultimo = enteros[enteros.length - 1];
        for (int i = 0; i < enteros.length; i++)  {
            int aux = enteros[i];
            enteros[i] = ultimo;
            ultimo = aux;
        }

    }

    /**
     *  Ejer 5.10 
     *  crea un nuevo array con el doble de tamaño que el original
     *  guarda en el nuevo array cada elemento del original copiado dos veces
     *  Si numeros = {2, 3, 4, 5, 6} el array expandido será {2, 2, 3, 3, 4, 4, 5, 5, 6, 6} 
     *   
     */
    public int[]  expandir(int[] numeros)
    {
        int[] nuevo = new int[2 * numeros.length];
        for (int i = 0; i < numeros.length; i++)   {
            nuevo[i * 2] = numeros[i];
            nuevo[(i * 2) + 1] = numeros[i];
        }
        return nuevo;
    }

    /**
     *  
     * Ejer 5.11
     *  
     */
    public int[] calcularFrecuencias( )
    {
        int[] frecuencias = new int[9];       
        int contador = 1;
        while (contador <= 100)     {
            int aleatorio = (int) (Math.random() * 9) + 1;
            frecuencias[aleatorio - 1]++;
            contador++;
        }
        return frecuencias; 

    }

    /**
     *  Escribir un array desde el final hasta el principio
     *  (no hay que invertir el array)
     */
    public void escribirInvertido(int[] numeros)
    {
        for (int i = numeros.length - 1; i >= 0; i--)    {
            System.out.print(numeros[i] + "\t");
        }
    }

    /**
     *   Escribe el array recibido como argumento desde el final hasta el principio
     *   y en cada línea de la pantalla muestra el valor del elemento del array
     *   junto a la suma de sus cifras
     *   
     *   Si el array recibido es {2034, 12, 223, 5432, 9999}
     *   se mostrará en pantalla:
     *   
     *   9999 - 36
     *   5432 - 14
     *   223 - 7
     *   12 - 3
     *   2034 - 9
     *   
     *   Hay que usar el método sumarCifras()
     *  
     */
    public void puente01(int[] numeros)
    {
        for (int i = numeros.length - 1; i >= 0; i--)  {
            System.out.println(numeros[i]  + " - " + sumarCifras(numeros[i]));
        }

    }

    /**
     *  Dado un nº devuelve la suma de sus cifras
     */
    public int sumarCifras(int n)
    {
        int suma = 0;
        while (n != 0)  {
            suma += n % 10;
            n = n / 10;
        }

        return suma;
    }

    /**
     *   Sustituir cada elemento del array numeros por el cuadrado del que está a su derecha
     *   El último se sustituye por el cuadrado del primero
     *   
     *   Si el array recibido es {2, 5, 7, 12, 9, 3}
     *   al final queda {25, 49, 144, 81, 9, 4}
     *  
     */
    public void puente02(int[] numeros)
    {
        System.out.println(Arrays.toString(numeros));
        int primero = numeros[0];
        for (int i = 0; i < numeros.length - 1; i++)   {
            numeros[i] = numeros[i + 1] * numeros[i + 1];
        }
        numeros[numeros.length - 1] = primero * primero;
        System.out.println(Arrays.toString(numeros));
    }

    /**
     *   Devuelve una copia usando System.arraycopy()
     *   del array numeros con exactamente la primera mitad 
     *   de elementos. Asumimos el tamaño de numeros >= 2
     *   (leed previamente los apuntes y Moodle)
     *   
     *   Si el array recibido es {2, 5, 7, 12, 9, 3}
     *   se devuelve {2, 5, 7}
     *   
     *   Si el array recibido es {2, 5, 7, 12, 9}
     *   se devuelve {2, 5}
     *  
     */
    public int[] puente03(int[] numeros)
    {
        int[] resul = new int[numeros.length / 2];         
        System.arraycopy(numeros, 0, resul, 0, numeros.length / 2);
        return resul;
    }

    /**
     *   Devuelve una copia usando Arrays.copyOf()
     *   del array numeros con exactamente la primera mitad 
     *   de elementos. Asumimos el tamaño de numeros >= 2
     *   (leed previamente los apuntes y Moodle)
     *   
     *   Si el array recibido es {2, 5, 7, 12, 9, 3}
     *   se devuelve {2, 5, 7}
     *   
     *   Si el array recibido es {2, 5, 7, 12, 9}
     *   se devuelve {2, 5}
     *  
     */
    public int[] puente04(int[] numeros)
    {
        return Arrays.copyOf(numeros, numeros.length / 2);
    }

}
