
/**
 * Modela un semáforo
 * http://javarevisited.blogspot.com.es/2011/08/enum-in-java-example-tutorial.html
 */
public class Semaforo
{
   private ColorSemaforo estado;  

    /**
     * Constructor de la clase Semaforo
     */
    public Semaforo()
    {
        estado = ColorSemaforo.VERDE;
    }

    /**
     * accesor 
     */
    public   ColorSemaforo getEstado()
    {
        return estado;
    }

    /**
     * mutador, cambia el estado del semáforo
     */
    public  void  cambiarEstado() 
    {
        switch (estado)
        {
            case VERDE: estado = ColorSemaforo.AMARILLO;
                        break;
            case ROJO:  estado = ColorSemaforo.VERDE;
                        break;
            case AMARILLO:  estado = ColorSemaforo.ROJO;
                        break; 
        }
         
    }

    /**
     * Devuelve los colores del semáforo en formato String
     */
    public String getColoresSemaforo() 
    {
        String str = "";
        ColorSemaforo[]  colores = ColorSemaforo.values();
        for (int i = 0; i < colores.length; i++) {
			str = str + colores[i].toString() + "\t" + colores[i].getSegundos() + " sg.";
		}
            
        return str;
    }

    /**
     * Representación textual del color del semáforo    
     */
    public String toString()
    {

        return estado.toString();
    }
}
