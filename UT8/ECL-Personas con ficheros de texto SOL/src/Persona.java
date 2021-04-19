
/**
 * Representa a una persona
 */
public class Persona 
{
    private String nombre;
    private int edad;
    private char estadoCivil;
    
    /**
     * constructor
     */
    public Persona(String nombre,  int edad, char estado)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.estadoCivil = estado;
    }

    /**
     * accesor para el nombre
     */
    public String getNombre()
    {
        return nombre;
    }
    
   /**
     * mutador para el nombre
     */
    public  void setNombre()
    {
        this.nombre = nombre;
    }
    
    /**
     * accesor para la edad
     */
    public int getEdad()
    {
        return edad;
    }
    
   /**
     * mutador para la edad
     */
    public  void setNombre(int edad)
    {
        this.edad = edad;
    }
    /**
     * accesor para el estado civil
     */
    public char getEstadoCivil()
    {
        return estadoCivil;
    }
    
  /**
     * mutador para el estado civil
        */
    public  void setEstadoCivil(char estado)
    {
        this.estadoCivil = estado;
    }
    
    /**
     *  
     */
    public boolean estaSoltera()
    {
        return Character.toLowerCase(estadoCivil) == 's';
    }

    /**
     * Representación textual de una persona
     */
    public String toString()
    {
        return  "\nNombre " + nombre + " \nEdad " + edad + " años \n" + 
                "Estado civil: " + Character.toUpperCase(estadoCivil);
    }

    
}
