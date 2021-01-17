
/**
 *  Pruebas con la  clase  Scanner.
 *  Se incluye algun ejemplo con el método split() de la clase String
 *  
 */ 
import java.util.Scanner;
public class DemoScanner
{

    private String cadena;

    /**
     * Constructor  
     */
    public DemoScanner()
    {

        cadena = "Pepe:23:::Pamplona:Navarra";
    }
    
     /**
     * Constructor  
     */
    public DemoScanner(String cadena)
    {

        this.cadena = cadena;
    }
    
    /**
     * Prueba del método split() de la clase String
     */
    public  int totalPalabras()
    {
        String[] palabras = this.cadena.split(":");
        
        int pal = 0;
        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].equals("")) {
                pal++;
            }
        }
        return pal;
      //  return this.cadena.split(":+").length;
    }

 
    /**
     *  
     * 
     * escribe cada uno de los tokens de la cadena
     * 
     */
    public void mostrarTokensConScanner()
    {
        Scanner sc = new Scanner(this.cadena);
        sc.useDelimiter(":+");
        while (sc.hasNext()) {
            String token = sc.next();
            System.out.println(token);
        }
    }

    /**
     * 
     */
    public static void ejemplo01Scanner()
    {
        String s = "Ejemplo de Java";
        Scanner sc = new Scanner(s);
        sc = sc.useDelimiter("de");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }

      /**
     * 
     */
    public void ejemplo02Scanner()
    {
        String s = "1   2    3   4    5    6    7";
        Scanner sc = new Scanner(s); //por defecto el delimitador es el espacio
        int suma = 0;
        while (sc.hasNextInt()) {
            suma += sc.nextInt();
        }
        System.out.println("La suma es " + suma);
    }
    
    
     /**
     * 
     */
    public static void ejemplo03Scanner()
    {
        String s = "Ejemplo\n\n\nde\n\n\n\nJava\t\tpepe";
        Scanner sc = new Scanner(s);
        sc = sc.useDelimiter(" ");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }

     /**
     * Devuelve la cantidad de palabras en una frase. Separador el " "
     */
    public int palabrasEnFraseConScanner()
    {
        int total = 0;
        Scanner sc = new Scanner(this.cadena);
        while (sc.hasNext())  {
            String palabra = sc.next();
            total++;
        }
        return total;
    }
  

    /**
     * Devuelve el nº de vocales de una palabra
     */
    private  int totalVocales(String palabra)
    {
        String vocales = "AEIOUaeiou";
        int total = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (vocales.indexOf(String.valueOf(palabra.charAt(i))) != -1) {
                total ++;
            }
        }
        return total;
        
    }

     /**
     * Muestra cada palabra y su nº de vocales
     * Separador el blanco - Con Scanner
     */
    public  void mostrarVocalesDePalabras()
    {
        Scanner sc  = new Scanner(this.cadena);
        while (sc.hasNext())   {
            String palabra = sc.next();
            System.out.println(palabra + " - " + totalVocales(palabra));
        }
    }
}
