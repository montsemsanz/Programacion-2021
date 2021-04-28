package pkgut9;

import java.util.Arrays;
import java.util.List;

/**
 * Un objeto de esta clase emite saludos aleatorios
 *  
 */
public class Saludo
{
     private List<String> saludos;
      
     
    /**
     * Constructor de objetos de la clase Saludo
     */
    public Saludo()
    {
         saludos = Arrays.asList("Bienvenvido/a a JAVAFX", "Hola",
    		 	"Saludos, empezamos con JavaFX");
        
    }

    
	/**
     * devuelve un saludo aleatorio
     *  
     */
    public String getSaludo()
    {
        return saludos.get((int)(Math.random() * saludos.size()));
    }
    
     
}
