
/**
 * Un objeto de esta clase modela una urna 
 * que guarda una serie de bolas blancs y/o negras
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Urna
{

    private ArrayList<Bola> urna;

    /**
     * Constructor for objects of class Urna
     */
    public Urna()
    {
        urna = new ArrayList<>();
    }

    /**
     * Añade una nueva bola a la urna
     * @param b la bola a añadir
     */
    public void meterBola(Bola b)
    {
        urna.add(b);
    }

    /**
     * Saca una bola de la urna
     * @return la bola sacada
     * @throws RuntimeException si la urna está vacía
     */
    public Bola sacarBola()
    {
        if (urna.isEmpty())   {
            throw new RuntimeException("Urna vacía");
        }
        int pos = obtenerPosicionAleatoria(urna.size());
        Bola aux = urna.remove(pos);      
        return aux;              
    }

    /**
     * @return un valor que representa una posición
     *          en la urna
     * @param hasta el límite hasta el que generar valores
     *              aleatorios
     */
    private int obtenerPosicionAleatoria(int hasta)
    {
        return (int)(Math.random() * hasta);
    }

    /**
     *  
     * @return   cantidad de bolas blancas en la urna  
     */
    public int cuantasBlancas()
    {
        int blancas = 0;
        for (Bola bola: urna) {
            if (bola.esBlanca()) {
                blancas++;
            }
        }
        return blancas;

    }

    /**
     *  
     * @return   cantidad de bolas negras en la urna  
     */
    public int cuantasNegras()
    {
        int negras = 0;
        for (int i = 0; i < urna.size(); i++)  {
            if (urna.get(i).esNegra()) {
                negras++;
            }
        }
        return negras;

    }

    /**
     * Muestra la urna
     *    
     */
    public void mostrarUrna()
    {
        Iterator<Bola> it = urna.iterator();
        while (it.hasNext())    {
            Bola bola = it.next();
            System.out.println(bola.toString());
        }

    }

    /**
     * Borra las bolas de color blanco
     *      
     */
    public void borrarBlancas()
    {
        Iterator<Bola> it = urna.iterator();
        while (it.hasNext())  {
            Bola bola = it.next();
            if (bola.esBlanca()) {
                it.remove();
            }
        }

    }

}
