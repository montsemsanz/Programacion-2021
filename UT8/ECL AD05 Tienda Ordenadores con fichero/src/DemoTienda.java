import java.io.IOException;

public class DemoTienda
{


    public static void main(String[] args) throws IOException
	{

		Tienda tienda = new Tienda("PeCeOrdenador");
		int errores = tienda.leerDeFichero();
		System.out.println("Había " + errores
		        + " líneas erróneas en el fichero de entrada");
		tienda.printTienda();

		tienda.salvarEnFichero();

	}
   
 
}
