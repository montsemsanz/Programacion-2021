
/**
 *  Representa a una canción 
 */
public class Cancion
{
     
    private String titulo;
    private double duracion;

    /**
     * Constructor  
     */
    public Cancion(String titulo, double duracion)
    {
         this.titulo = titulo;
         this.duracion = duracion;
    }

    /**
     *   Accesor para el título
     * 
     */
    public String getTitulo()
    {
         return titulo;
    }
    
     /**
     *   Accesor para la duracion
     * 
     */
    public double getDuracion()
    {
         return duracion;
    }
    
      /**
     *   Mutadorr para el título
     * 
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
     /**
     *   Mutador para la duracion
     * 
     */
    public void setDuracion(double duracion)
    {
        this.duracion = duracion;
    }
    
    /**
     * 
     */
    public  String toString()
    {
        return this.titulo + "  " + this.duracion  + "'\n";
    }

}
