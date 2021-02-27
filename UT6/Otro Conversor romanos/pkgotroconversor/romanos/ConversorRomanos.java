package pkgotroconversor.romanos;
import java.util.Set;

/**
 * Clase ConversorRomanos representa a un
 * objeto que puede convertir un nº romano
 * a un nº arábigo y viceversa
 * 
 * .....>jar cvf otroconversor.jar pkgotroconversor\romanos\ConversorRomanos.class
 * (si quiero solo exportar esa clase)
 */
import java.util.LinkedHashMap;

public class ConversorRomanos
{
    private  LinkedHashMap<Character, Integer> map; 

    /**
     * Constructor 
     */
    public ConversorRomanos()
    {
        map = new LinkedHashMap<Character, Integer>();
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
            map.put(letras.charAt(i), numeros[i]);
        }
    }

    /**
     * convierte el nº romano a arábigo
     * @param el nº romano a convertir
     * @return el nº arábigo
     */
    public int aArabigo(String romano)
    {   
        romano = romano.toUpperCase();
        int arabigo = 0;
        for (int i = 0; i < romano.length(); i++) {
            arabigo += map.get(romano.charAt(i));
        }
        return arabigo;
    }

    /**
     * convierte el nº   arábigo (menor o igual a 4000, asumimos esto)
     * a romano en notación antigua
     * @param el nº arábigo  a convertir
     * @return el nº romano
     * 
     * 
     */
    public String aRomano(int arabigo)
    {   
        int aux = arabigo;
        StringBuilder sb = new StringBuilder();
        Set<Character> claves = map.keySet();
        for (Character c: claves)   {
            int valor = map.get(c);
            if (aux >= valor)     {
                int coc = aux / valor;
                for (int i = 1; i <= coc; i++)   {
                    sb.append(c);
                }
                aux = aux % valor;
            }

        }
        return sb.toString();
    }

}
