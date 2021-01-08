
/**
 *  
 */
public class DemoAlumno
{

    /**
     *  
     *  Aceptar como argumentos del main el nombre y la nota de un alumno
     *  crear un objeto Alumno y mostrar su representación
     */
    public static void main(String[] args)
    {
        if (args.length != 2)  {
            System.out.println("Error en nº de argumentos\nSintaxis: java DemoAlumno <nombre> <nota>");
        }
		else {
			String nombre = args[0];
			int nota = Integer.parseInt(args[1]);
			Alumno al = new Alumno(nombre, nota);
			System.out.println(al.toString());
		}
    }
}
