package ut6.romanos.modelo;


/**
 * Clase ConversorRomanos representa a un
 * objeto que puede convertir un nº romano
 * a un nº arábigo
 */
import java.util.HashMap;

public class ConversorRomanos
{
    private  HashMap<Character, Integer> tabla; 
    
    /**
     * Constructor 
     */
    public ConversorRomanos()
    {
        tabla = new HashMap<>();
        inicializar();
    }

    /**
     * Da valores iniciales al map
     */
    private void inicializar()
    {
        String letras = "MDCLXVI";
        int[] numeros = {1000, 500, 100, 50, 10, 5, 1};

        for (int i = 0; i < letras.length(); i++) {
            tabla.put(letras.charAt(i), numeros[i]);
        }
    }

    /**
     * convierte el nº romano a arabigo
     * @param el nº romano a convertir
     * @return el nº arábigo
     */
    public int convertir(String romano)
    {   
        romano = romano.toUpperCase();
        int arabigo = 0;
        for (int i = 0; i < romano.length(); i++)        {
            arabigo += tabla.get(romano.charAt(i));
        }
        return arabigo;
    }
}
