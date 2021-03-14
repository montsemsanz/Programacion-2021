/**
 * La clase Articulo representa un artículo multimedia.
 * La información sobre el artículo se almacena y 
 * puede ser extraída.
 * Esta clase sirve como superclase para articulos más
 * específicos.
 */
public class Articulo
{
    private String titulo;
    private int duracionTotal;
    private boolean hayCopia;
    private String comentario;

    /**
     * Inicializar los atributos del artículo
     */
    public Articulo(String elTitulo, int duracion)
    {
        titulo = elTitulo;
        duracionTotal = duracion;
        hayCopia = false;
        comentario = "";
    }

    /**
     * Introducir un comentario del artículo
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * Devolver el comentario del artículo
     */
    public String getComentario()
    {
        return comentario;
    }

    /**
     * Establecer el flag que indica si se tiene una copia o no
     */
    public void setHayCopia(boolean hay)
    {
        hayCopia = hay;
    }

    /**
     * Devolver el flag que indica si se tiene una copia o no
     */
    public boolean getHayCopia()
    {
        return hayCopia;
    }

    /**
     * accesor para la duración del artículo
     */
    public int getDuracion()
    {
        return duracionTotal;
    }

    /**
     * Escribir detalles sobre el artículo
     */
    public void print()
    {
        System.out.println("--------------------------");
        System.out.println("Título: " + titulo + " (" + duracionTotal + " mins)");
        if(hayCopia) 
        {
            System.out.print(" * ");
        }        
        if (!comentario.isEmpty())
            System.out.println("\t" + comentario);
    }
}
