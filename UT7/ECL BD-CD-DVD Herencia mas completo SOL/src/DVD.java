/**
 * La clase Video representa a un objeto Video. Se puede almacenar
 *  y recuperar la información sobre un vídeo.
 */
public class DVD extends Articulo  
{
    private String director;

    /**
     * Constructor de objetos de la clase Video
     */
    public DVD(String titulo, String director, int duracion)
    {
        super(titulo, duracion);
        this.director = director;
    }

    /**
     * Devolver el director del vídeo
     */
    public String getDirector()
    {
        return director;
    }

    /**
     * Escribir detalles sobre el DVD
     * Redefinir print()
     */
    public void print()
    {
        super.print();
        System.out.println("Director    " + director);

    }

}
