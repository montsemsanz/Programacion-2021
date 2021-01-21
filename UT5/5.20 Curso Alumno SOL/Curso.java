
/**
 *  Modela un grupo de alumnos de un curso
 */

import java.util.Arrays;
public class Curso 
{
    //     private static final int MAX_ALUMNOS = 10;
    private String nombreCurso;
    private Alumno[] alumnos;
    private int total;

    /**
     * Constructor de la clase CursoDai
     */
    public Curso(String nombreCurso, int n)
    {
        this.nombreCurso = nombreCurso;
        //         alumnos = new Alumno[MAX_ALUMNOS];
        alumnos = new Alumno[n];
        total = 0;
    }

    /**
     *   Añade un alumno al curso - al final   
     */
    public void addAlumno(String nombre, int nota)
    {
        if (total < alumnos.length)  {  
            alumnos[total] = new Alumno(nombre, nota);
            total++;
        }
        else    {
            System.out.println("Curso completo, no se puede añadir un nuevo alumno");  
        }

        //    addAlumno(new Alumno(nombre, nota));
    }

    /**
     *   Añade un alumno al curso - al final   
     */
    public void addAlumno(Alumno alumno)
    {
        if (total < alumnos.length)    {
            alumnos[total] = alumno;
            total++;
        }
        else  {
            System.out.println("Curso completo, no se puede añadir un nuevo alumno");         
        }
    }

    /**
     * devuelve la cantidad de aprobados en el curso
     */ 
    public int totalAprobados()
    {
        int cuantos = 0;
        for (int i = 0; i < total; i++)   {
            if (alumnos[i].getNota() >= 5)  {
                cuantos++;
            }
        }
        return cuantos;
    }

    /**
     * devuelve un array de String con los nombres de los alumnos que han aprobado todo
     */ 
    public String[] alumnosConTodoAprobado()
    {
        int cuantos = totalAprobados();
        String[] resul = new String[cuantos];
        int j = 0;
        for (int i = 0; i < total; i++)  {
            if (alumnos[i].getNota() >= 5)   {
                resul[j] = alumnos[i].getNombre();
                j++;
            }
        }

        return resul;
    }

    /**
     * Ordenar de mayor a menor nota por el método de selección directa
     */
    public  void ordenarPorSeleccionDirecta()
    {
        for (int i = 0; i < total - 1; i++) {
            int posMax = i;
            for (int j = i + 1; j < total; j++)       {                
                if (alumnos[j].getNota() > alumnos[posMax].getNota())    {
                    posMax= j;
                }

            }   
            Alumno aux = alumnos[posMax];
            alumnos[posMax] = alumnos[i];
            alumnos[i] = aux;
        }
    }

    /**
     * Borrar los alumnos que han obtenido un 3 devolviendo la cantidad de alumnos borrados
     */
    public  int borrarLosDeNota3()
    {
        int borrados = 0;
        int i = 0;
        while (i < total)   {
            if (alumnos[i].getNota() == 3) {
                // borrar el alumno
                for (int j = i + 1; j < total;j++)   {
                    alumnos[j - 1] = alumnos[j];
                }
                total --;
                borrados++;
            }
            else   {
                i++;
            }
        }
        return borrados;   
    }

    /**
     * Representación textual del curso
     */
    public String toString()
    {
        String str = "Nombre curso: " + this.nombreCurso + "\n";
        for (int i = 0; i < total; i++)  {
            str = str + alumnos[i].toString();
        }
        return str;
    }

    /**
     *  crea una copia del array alumnos
     *  Ordena la copia de menor a mayor nota por el método de inserción directa y lo devuelve.
     */
    public Alumno[] ordenarPorInsercionDirecta()
    {
        Alumno[] copia = Arrays.copyOf(alumnos, total);
        //  System.out.println("Copia " + Arrays.toString(copia));
        for (int i = 1; i < copia.length; i++)   {
            // buscar hueco y desplazar para el elemento de posición i
            Alumno alumno = copia[i];
            int j = i - 1;
            while (j >= 0 && copia[j].getNota() > alumno.getNota())  {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = alumno;
        }

        return copia;
    }

    /**
     *  obtiene un array con los nombres de los alumnos que han aprobado todo
     *  Ordena alfabéticamente ese  array usando un método de la clase Arrays
     */
    public String[] ordenarPorNombreAprobados()
    {
        String[] todoAprobado = alumnosConTodoAprobado();
        Arrays.sort(todoAprobado);
        return todoAprobado;
    }

    /**
     *  Inserta un alumno en la posición p
     *  Si la posición es incorrecta se lanza la excepción IllegalArgumentException
     *  con el mensaje "Posición no correcta"
     */
    public void insertarEnPosicion(int p, Alumno alumno)
    {
        if (p < 0 || p > total) {
            throw new IllegalArgumentException("Posición " + p + " incorrecta");
        }
        System.arraycopy(alumnos, p, alumnos, p + 1, total - p);
        alumnos[p] = alumno;
        total++;
    }

    

}
