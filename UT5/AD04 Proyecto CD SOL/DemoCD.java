
/**
 * 
 * Clase de prueba del CD
 */
public class DemoCD
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 3)  {
            System.out.println("Error en nº argumentos\nSintaxis: java DemoCD <n> <titulo> <artista>");

        }
        else {
            CD cd = new CD(Integer.parseInt(args[0]), args[1], args[2]);
            // añadir varias canciones al CD (al final del CD
            cd.addCancion("Ave María", 3.45);
            cd.addCancion("Lloraré tus penas", 2.34);
            cd.addCancion("Lucía", 4.55);
            cd.addCancion("Ella", 4.21);
            cd.addCancion("Esclavo de tus besos ", 4.23);
            cd.addCancion("Bulería Bulería ", 3.72);
            //          // Mostar el CD
            System.out.println(cd.toString());
            System.out.println("---------------------------------------------");
            // Mostar la duración del CD
            System.out.println("Duración total. " + cd.duracionTotal() + "'");
            System.out.println("---------------------------------------------");
            // Mostar canción aleatoria del CD
            System.out.println("Canción aleatoria " + cd.getAleatoria().toString());
            System.out.println("---------------------------------------------");
            // mostar títulos de las canciones
            System.out.println("Títulos de las canciones");
            String[] titulos = cd.getTitulos();
            for (int i = 0; i < titulos.length; i++)  {
                System.out.println(titulos[i]);
            }
            System.out.println("---------------------------------------------");
            // canciones que contienen 
            String str = "av";
            System.out.println("Canciones que contienen \"" + str  + "\" - " + cd.cancionesQueContienen(str));
            System.out.println("---------------------------------------------");
            // borrar las que empiezan por una cadena
            str = "av";
            String[] borradas = cd.borrarCancionesQueEmpiezan(str);
            if (borradas == null)     {
                System.out.println("No había ninguna canción que empezase por " + str);
            }
            else    {
                System.out.println("Se han borrado los títulos");
                for (int i = 0; i < borradas.length; i++)   {
                    System.out.println(borradas[i]);
                }
                System.out.println("Después de borrar las que empiezan por \"" + str  + "\" el CD ha quedado \n " + cd.toString());
            }

            System.out.println("---------------------------------------------");
            System.out.println("Total canciones en el CD  " + cd.totalCanciones());  
            // listado de canciones ordenadas por título
            Cancion[] ordenadas = cd.cancionesOrdenadasPorTitulo();
            System.out.println("Canciones ordenadas por título ");
            for (int i = 0; i < ordenadas.length; i++)  {
                System.out.print(ordenadas[i].toString());
            }
            System.out.println();
            System.out.println("---------------------------------------------");

            CD nuevo = cd.crearNuevoCD();
            System.out.println("\nNuevo CD  " + nuevo.toString());
        }

       
    }
}
