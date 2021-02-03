
/**
 * Clase para probar las otras dos
 */
public class DemoCurso
{

    /**
     *   
     */
    public static void main(String[] args)
    {
        Curso dam = new Curso();
        dam.añadirEstudiante("Luisa", 9);
        dam.añadirEstudiante("Angel", 3);
        dam.añadirEstudiante("Ana", 4);
        dam.añadirEstudiante("Alberto", 8);
        System.out.println("Hay " + dam.cuantosAlumnos() +
            " alumnos");
        System.out.println(dam.toString());                      
        System.out.printf("La media es %4.2f" , dam.getMedia());  
        System.out.println("\nAlumno con nota máxima " +
            dam.alumnoNotaMaxima());       
        int suspensoMasAlto = dam.suspensoMasAlto();
        if (suspensoMasAlto == 0)    {
            System.out.println("No hay suspensos");
        }
        else    {
            System.out.println("Suspenso más alto " + suspensoMasAlto); 
        }
        System.out.println("Dos notas más altas " + dam.dosNotasMasAltas()); 

        dam.borrarPrimero();
        System.out.println(dam.toString()); 
        dam.borrarSuspensos();
        System.out.println(dam.toString()); 
    }

}
