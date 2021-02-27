package ut6.romanos.demo;
import ut6.romanos.modelo.GestorRomanos;
import ut6.romanos.modelo.ConversorRomanos;
/**
 * La clase que inicia el gestor de romanos
 * 
 * 
 * Desde línea de comandos para crear el jar: 
 *  jar cvfe romanos.jar ut6.romanos.demo.AppRomanos ut6\romanos\modelo\*.class ut6\romanos\demo\*.class
 * y para ejecutarlo java -jar romanos.jar I  V XII M II MMM D
 */
public class AppRomanos
{
    public static void main (String[] args)
    {
        if (args.length == 0)    {
            System.out.println("Error, Sintaxis: java AppRomanos <romano1> <romano2> <romano3> ....");

        }
        else {       
            GestorRomanos gestor = new GestorRomanos(new ConversorRomanos());
            gestor.añadirRomanos(args);
            gestor.escribirListaArabigos();
        }

    }

        
}
