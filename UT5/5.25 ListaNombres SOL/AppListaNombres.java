import java.util.Arrays;
/**
 * 
 * Acepta como argumento del main el tamaño máximo de la lista
 * Si no se pasan argumentos se muestra un mensaje de error, se le informa al usuario
 * de la sintaxis a utilizar y se acaba el programa
 * 
 * En otro caso se crea la lista y:
 *  - se llama al método cargarDeFichero() 
 *  - se muestra la lista
 *  - se muestra el nombre más largo
 *  - se borran los que empiezan por 'r'
 *  - se muestra la lista
 *  - se muestra cuántos empiezan por 'aL'
 *  - se muestran los nombres que empiezan por "a"
 */
public class AppListaNombres
{

    /**
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 1)     {
            System.out.println("Error en nº de argumentos\nSintaxis:java AppListaNombres <n>");
        }
        else {
            int n = Integer.parseInt(args[0]);
            ListaNombres lista = new ListaNombres(n);
            lista.cargarDeFichero();
            System.out.println("Después de insertar"); 
            System.out.println(lista.toString());

            System.out.println("El nombre más largo es " + lista.nombreMasLargo());
            lista.borrarLetra('r');
            System.out.println("\nDespués de borrar los que empiezan por \'r\' \n" + lista.toString());

            System.out.println("Empiezan por \'aL\' " + lista.empiezanPor("aL")); 

            String[] porA = lista.empiezanPorLetra('a');
            System.out.println("Empiezan por \'a\' ");
            for (int i = 0; i < porA.length; i++)     {
                System.out.print(porA[i] + "\t");
            }
            System.out.println();
            
            
            System.out.println("Antes de invertir");
            System.out.println(lista.toString());
            System.out.println("Después de invertir");         
            System.out.println(Arrays.toString(lista.invertir()));

        }
    }
}
