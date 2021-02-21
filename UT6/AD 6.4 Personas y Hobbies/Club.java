
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class Club
{

    private ArrayList<Persona> personas;

    /**
     * Constructor de la clase Club
     */
    public Club()
    {
        personas = new ArrayList<>();
    }

    /**
     * @param nombre el nombre de la persona que se añade
     * @param hob el conjunto de hobbies de la persona a añadir
     */
    public void addPersona(String nombre, HashSet<String> hob)
    {
        Persona persona = new Persona(nombre);
        for (String h: hob)  {
            persona.addHobbie(h);
        }
        personas.add(persona);
    }

    /**
     * 
     * @param  cual el hobbie a comprobar
     * @return  el nº de personas del club que tienen ese hobbie   
     */
    public int personasConHobbie(String cual)
    {
        int cuantas = 0;
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext())   {
            Persona persona = it.next();
            if (persona.tieneHobbie(cual))  {
                cuantas++;
            }
        }
        return cuantas;

    }

    /**
     * visualiza la lista de personas
     */

    public void printClub()
    {
        for (Persona persona: personas)   {
            System.out.println(persona.toString());
        }

    }

    /**
     * Borra de la lista las personas con un determinado hobbie
     * y las añade en el conjunto a devolver (añade su nombre)
     *
     * @param  cual el hobbie a comprobar
     * @return el conjunto de nombres de personas con ese hobbie
     */

    public HashSet<String> borrarPersonasConHobbie(String cual)
    {
        HashSet<String> resul = new HashSet<String>();
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext())  {
            Persona p = it.next();
            if (p.tieneHobbie(cual))  {
                resul.add(p.getNombre());
                it.remove();
            }
        }
        return resul;

    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        Club club = new Club();

        HashSet<String> hobbiesP1 = new HashSet<>(Arrays.asList("bailar", "cantar", 
                    "leer", "nadar", "caminar", "deporte"));
        club.addPersona("Juan", hobbiesP1);
        HashSet<String> hobbiesP2 = new HashSet<>(Arrays.asList("bailar", "cantar", 
                    "leer"));
        club.addPersona("Elena", hobbiesP2);
        HashSet<String> hobbiesP3 = new HashSet<>(Arrays.asList("nadar", "caminar", "deporte"));
        club.addPersona("Isabel", hobbiesP3);
        HashSet<String> hobbiesP4 = new HashSet<>(Arrays.asList("bailar", "cantar","caminar", "deporte"));
        club.addPersona("Amaia", hobbiesP4);

        System.out.println("Personas en el club y sus hobbies");
        club.printClub();
        System.out.println();

        String hobbie = "nadar";
        System.out.println("Personas con hobbie '" + hobbie + "'");
        System.out.println(club.personasConHobbie(hobbie));

        System.out.println("Borrar pesonas con hobbie '" + hobbie + "'");
        System.out.println("Se han borrado " + club.borrarPersonasConHobbie(hobbie));
    }
}
