import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
//import java.util.LinkedList;

/**
 * 
 * 
 * Boxing / Unboxing (envolver - desenvolver) se hace cuando se asigna, 
 * en la correspondencia de parámetros, en valores de retorno pero NO al comparar
 * 
 * if (lista1.get(0) == lista2.get(0)) // aquí se comparan referencias
 * 
 * Integer x = new Integer(7);
 * Integer y = new Integer(7);
 * System.out.println(x == y);  // devuelve false
 * 
 * 
 * Integer x = 7;
 * Integer y = 7;
 * System.out.println(x == y);  // devuelve true, Java aquí guarda en realidad un solo objeto en la caché

 */
public class ColeccionEnteros
{
    private  ArrayList<Integer> miLista;

    /**
     * Constructor  
     * llamamos a inicializarColeccion()
     */
    public ColeccionEnteros()
    {
        miLista = new ArrayList<>();       
        // inicializarColeccion();
        miLista.addAll(Arrays.asList(3, 4, 5, 6));
               
    }

    /**
     *  Usar Arrays.asList() para convertir el array
     *   en una colección y usar luego addAll
     *
     */
    public ColeccionEnteros(Integer[] valores) 
    {
        miLista = new ArrayList<>();
        miLista.addAll(Arrays.asList(valores));
    }

    
    /**
     *  inicializa la colección con valores aleatorios  entre 0 y 20 (inclusive)
     *   Parar cuando sale el 0 o se han generado 10 valores
     */
    private void inicializarColeccion()
    {
        int total = 0;
        int aleatorio = (int) (Math.random() * 21);
        while (aleatorio != 0 && total < 10)  {
            total ++;
            miLista.add(aleatorio);            
            aleatorio = (int) (Math.random() * 21);
        }

    }

    /**
     *  Añade el valor siempre al principio
     */
    public void add(int valor)
    {
        miLista.add(0, valor);
    }

    /**
     * Suma los elementos de la colección
     * Con iterador
     */
    public int sumar()
    {
        int suma = 0;
        Iterator<Integer> it = miLista.iterator();
        while (it.hasNext()) {
            int valor = it.next();
            suma += valor;
        }
        return suma;
    }

    /**
     * 
     * Suma los elementos de la colección
     * Con for mejorado
     */
    public int sumarV2()
    {
        int suma = 0;
        for (int valor: miLista) {
            suma += valor;
        }
        return suma;
    }

    /**
     * 
     * Suma los elementos de la colección
     * Con for con índices
     */
    public int sumarV3()
    {
        int suma = 0;
        int tam = miLista.size();         
        for (int i = 0; i < tam; i++)  {
            suma += miLista.get(i);
        }
        return suma;
    }

    /**
     * Ordenar la colección, no se modifica el original
     * Utilizaremos utilidades de la clase Collections
     */
    public ArrayList<Integer> ordenar()
    {
        ArrayList<Integer> resul = new ArrayList<>();
        resul.addAll(miLista);
        Collections.sort(resul);
        return resul;

        // ArrayList<Integer> resul = new ArrayList<>(miLista);
        // Collections.sort(resul);
        // return resul;

    }

    /**
     * Muestra la lista ordenada
     */
    public void escribir()
    {
        System.out.println(ordenar().toString());
    }

    /**
     *  probando retainAll()
     *
     */
    public void elementosComunes(ArrayList<Integer> otra)
    {
        miLista.retainAll(otra);
    }

    /**
     *  probando removeAll()
     *
     */
    public void elementosDiferentes(ArrayList<Integer> otra)
    {
        miLista.removeAll(otra);
    }

    /**
     * Representación textual de la colección
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < miLista.size())  {
            sb.append(miLista.get(i) + "  ");
            i++;
        }
        return sb.toString();

    }


}
