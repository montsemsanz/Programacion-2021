/**
 * La clase modela objetos Personaje en un hipotético
 * juego. Los personajes pueden avanzar y girar en diferentes 
 * direcciones
 *  
 */
public class Personaje
{

    private String nombre;
    private int x;
    private int y;
    private Direccion orientacion;

    /**
     * Constructor de la clase Personaje
     * @paran queNombre elnombre del personaje
     */
    public Personaje(String nombre)
    {
        this.nombre = nombre;
        x = 0;
        y = 0;
        orientacion = Direccion.NORTE;
    }

    /**
     * Cambia la orientación del personaje que
     * siempre gira en el sentido de las
     * agujas del reloj
     */
    public void girar()
    {
        if (orientacion == Direccion.NORTE) {
            orientacion = Direccion.ESTE;
        }
        else if (orientacion == Direccion.ESTE) {
            orientacion = Direccion.SUR;
        }
        else if (orientacion == Direccion.SUR) {
            orientacion = Direccion.OESTE;
        }
        else {
            orientacion = Direccion.NORTE;
        }
    }

    /**
     * Avanzar una determinada distancia según
     * la orientacón del personaje
     *
     * @param  distancia unidades de avance   
     */
    public void  avanzar(int distancia)
    {
        switch (orientacion) {
            case NORTE: y += distancia;
            break;
            case SUR: y -= distancia;
            break;
            case ESTE: x += distancia;
            break;
            case OESTE:x -= distancia;
            break;
        }

    }

    /**
     * Devuelve una representación textual del personaje
     *
     * @return el string que representa el personaje 
     */
    public String toString()
    {
        return "Personaje " + nombre + "\n" +
            "Orientacion = " + orientacion.toString() + "\n" +
            "Posicion = " + "[ " + x + " , " + y + " ] ";
         
    }    

}
