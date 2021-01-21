import java.util.Arrays;
/**
 * 
 * Clase de prueba de Curso
 */
public class DemoCurso
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 2)   {
            System.out.println("Error en argumentos\nSintaxis: >java DemoCurso <nombre_del_curso> <tam>" );
        }
        else {
            String nombre = args[0];
            int tam = Integer.parseInt(args[1]);       
            Curso curso = new Curso(nombre, tam);
            // añadir varios alumnos al  curso
            curso.addAlumno("Ana", 3);
            curso.addAlumno("Luis", 5);
            curso.addAlumno("Alberto", 7);
            curso.addAlumno("Juan", 3);
            curso.addAlumno("Miguel ", 8);
            curso.addAlumno("Elena ", 4);
            curso.addAlumno(new Alumno("Francisco ", 6));
            //          // Mostar el curso
            System.out.println(curso.toString());

            System.out.println("---------------------------------------------");
            //Alumnos con todo aprobado
            System.out.println("\nTotal alumnos que han aprobado " + curso.totalAprobados());
            String[] alumnos = curso.alumnosConTodoAprobado();
            for (int i = 0; i < alumnos.length; i++)     {
                System.out.println(alumnos[i]);
            }

            System.out.println("---------------------------------------------");
            // borrar  los de nota igual a 3 
            System.out.println("Se han borrado " + curso.borrarLosDeNota3() + " alumnos con nota 3\n");
            System.out.println("Después de borrar el curso queda:\n" + curso.toString());

            System.out.println("---------------------------------------------");
            // ordenar
            curso.ordenarPorSeleccionDirecta();
            System.out.println("Después de ordenar el curso \nde mayor a menor nota por selección directa queda:");
            System.out.println(curso.toString());

            // ordenar de manor a maayor nota por selección directa
            Alumno[] ordenadoPorNota = curso.ordenarPorInsercionDirecta();
            System.out.println("Después de ordenar de \nmenor a mayor nota por inserción directa el curso queda:");
            for (int i = 0; i < ordenadoPorNota.length; i++)      {
                System.out.print(ordenadoPorNota[i].toString());
            }
            System.out.println();

            // ordenar aprobados por nombre con clase Arrays
            String[] ordenadoPorNombre = curso.ordenarPorNombreAprobados();
            System.out.println("Después de ordenar por nombre los aprobados:");
            System.out.println(Arrays.toString(ordenadoPorNombre));
            
            int p = 3;
            Alumno alumno = new Alumno("Pablo", 8);
            System.out.println("Insertar en posición " + p);
            curso.insertarEnPosicion(p, alumno);
            System.out.println("Después de insertar el curso queda:");
            System.out.println(curso.toString());
        }
    }
}