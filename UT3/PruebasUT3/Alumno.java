
/**
 * 
 */
public class Alumno
{
    private String nombre;
    private int nota;

    /**
     * Constructor  
     */
    public Alumno(String queNombre, int queNota)
    {
        nombre = queNombre;
        nota = queNota;
    }

    /**
     *  Accesor para el nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     *  Accesor para la nota
     *
     */
    public int getNota()
    {
        return nota;
    }

    /**
     *  Devuelve true si ha aprobado, false en otro caso
     *
     */
    public boolean haAprobado()
    {
        return nota >= 5;
    }

    /**
     *  Muestra en pantalla los datos del alumno
     *
     */
    public void mostrarAlumno()
    {
        System.out.println("Nombre : " + nombre +
            "\nNota : " + nota +
            "\nHa aprobado? : " +  (nota >= 5));
    }

     


}
