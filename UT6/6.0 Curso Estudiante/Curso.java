
/**
 * Un objeto de esta clase mantiene
 * una colección ArrayList de objetos Estudiante
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Iterator;

public class Curso
{

    private ArrayList<Estudiante> curso;

    /**
     * Constructor  
     */
    public Curso()
    {
        curso = new ArrayList<>();
    }

    /**
     * Añade un estudiante a la colección
     */
    public void añadirEstudiante(String nombre, int nota)
    {
        Estudiante e = new Estudiante(nombre, nota);
        curso.add(e);

    }

    /**
     * nº de alumnos en el curso
     */
    public int cuantosAlumnos()
    {
        return curso.size();
    }

    /**
     * Representación en formato texto del curso
     * 
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cuantosAlumnos(); i++)   {
            sb.append(curso.get(i).toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Calcula la media de notas del curso. Utiliza for mejorado
     */
    public double getMedia(){
        int suma = 0;
        for (Estudiante e: curso)      {
            suma += e.getNota();
        }
        return (double) suma / cuantosAlumnos();
    }

    /**
     * Nombre del alumno con nota máxima. Utiliza un iterador
     */ 
    public String alumnoNotaMaxima()
    {
        String nombreMax = "";
        int max = 0;
        Iterator<Estudiante> it = curso.iterator();
        while (it.hasNext())   {
            Estudiante e = it.next();
            int nota = e.getNota();
            if (nota > max) {
                max = nota;
                nombreMax = e.getNombre();
            }
        }
        return nombreMax;
    }

    /**
     * Borrar el primer estudiante de la colección. Esta no puede estar vacía
     */   
    public void borrarPrimero()
    {
        if (!curso.isEmpty())   {
            curso.remove(0);
        }
        // curso.remove(0);  //da error si no se comprueba que no está vacía
    }

    /**
     * Borrar los alumnos que han suspendido. Con un interador
     */
    public void borrarSuspensos()
    {
        Iterator<Estudiante> it = curso.iterator();
        while (it.hasNext())   {
            Estudiante estudiante = it.next();
            int nota = estudiante.getNota();
            if (nota < 5) {
                it.remove();
            }
        }
    }

    /**
     * 
     * Devuelve true si hay algún notable. Con for mejorado  
     */
    public boolean hayAlgunNotable()
    {
        for (Estudiante estudiante: curso)  {
            if (estudiante.getNota() == 7 || estudiante.getNota() == 8) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * cuantos estudiantes tienen un nombre que empieza por la cadena indicada
     *  
     */
    public int  empiezanPor(String str)
    {
        String inicio = str.toLowerCase();
        int cuantos = 0;
        int i = 0;
        while (i < curso.size())    {
            String nombre = curso.get(i).getNombre().toLowerCase();
            if (nombre.startsWith(inicio))    {
                cuantos++;
            }
            i++;
        }
        return cuantos;
    }

    /**
     * 
     * Devuelve el suspenso más alto del curso    
     */
    public int suspensoMasAlto()
    {
        int suspensoMasAlto = 0;
        for (Estudiante estudiante: curso)     {
            int nota = estudiante.getNota();
            if (nota < 5)    {
                if (nota > suspensoMasAlto)  {
                    suspensoMasAlto = nota;
                }
            }
        }
        return suspensoMasAlto;
    }

    /**
     * 
     * Calcula y devuelve el total de suspensos. Con un iterador.     
     */
    public int totalSuspensosIterador()
    {
        int suspensos = 0;
        Iterator<Estudiante> it = curso.iterator();
        while (it.hasNext())   {
            Estudiante estudiante = it.next();
            if (estudiante.getNota() < 5)  {
                suspensos++;
            }
        }
        return suspensos;

    }

    /**
     * 
     * Calcula y devuelve como un string las dos notas más altas del curso.
     * Con un while normal.
     */
    public String dosNotasMasAltas()
    {
        int maxAnterior = 0;
        int maxActual = 0;
        int i = 0;
        while (i < curso.size())     {
            int nota = curso.get(i).getNota();
            if (nota > maxActual)          {
                maxAnterior = maxActual;
                maxActual = nota; 

            }
            else if (nota > maxAnterior) {
                maxAnterior = nota;
            }
            i++;
        }
        if (cuantosAlumnos() == 1)   {
            return String.valueOf(maxActual);
        }
        return maxAnterior + " - " + maxActual;
    }

}
