import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import  pkgpruebas.utilidades.UtilsString;

/**
 * Para ejecutar el ejemplo desde BlueJ hay que incluir la librería utils.jar
 *      Herramientas / Preferencias / Librerías / Add libreria de usuario
 * 
 * Para ejecutar el ejemplo desde la CLI hay que incluir en el claspath la librería
 *      C:......\Para practicar el classpath>java -cp .;C:/MisLibrerias/utils.jar  UsandoClassPath
 *   
 */
public class UsandoClassPath
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
         Scanner teclado = new Scanner(System.in);
         System.out.print("Dame cadena ");
         String cadena = teclado.nextLine();
         UtilsString generador = new UtilsString();
         System.out.println("Conjunto de caracteres: " + generador.getConjuntoCaracteres(cadena).toString());
         System.out.println("Conjunto de dígitos: " + generador.getConjuntoDigitos(cadena).toString());
         System.out.println("Conjunto de mayúsculas: " + generador.getConjuntoMayusculas(cadena).toString());
    }
}
