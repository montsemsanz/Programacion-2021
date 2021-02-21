
/**
 * La clase mantiene información sobre una persona
 * y sus hobbies
 * 
 */
import java.util.HashSet;

public class Persona 
{
    private String nombre;
    private HashSet<String> hobbies;

    /**
     * constructor para los objetos de la clase Persona
     */
    public Persona(String nombre)
    {
        this.nombre = nombre;
        hobbies = new HashSet<>();
    }

    /**
     * Accesor para el nombre   
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param h añade el nuevo hobbie
     * en minúsculas
     */
    public void addHobbie(String h)
    {
        h = h.toLowerCase();
        if (!tieneHobbie(h))  {
            hobbies.add(h);
        }
    }

    /**
     * @param h el nombre del hobbie a comprobar
     * @return true si tiene ese hobbie
     */
    public boolean tieneHobbie(String h)
    {
        return hobbies.contains(h.toLowerCase());
    }

    public String hobbiesToString()
    {
        StringBuilder  sb = new StringBuilder("Hobbies: ");
        for (String h: hobbies) {
            sb.append(h + "  ");
        }
        return sb.toString();
        //return hobbies.toString();
    }

    public String toString()
    {
        return "Nombre: " + nombre  + "\n" + hobbiesToString();

    }

}
