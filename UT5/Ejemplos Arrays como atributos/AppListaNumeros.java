
/**
 *  
 * 
 * @author  
 * @version  
 */
public class AppListaNumeros
{

    /**
     *  
     */
    public static void main(String[] args)
    {
        ListaNumeros lista = new ListaNumeros(10);
        System.out.println(lista.toString());

        lista.addNumero(10);
        lista.addNumero(20);
        lista.addNumero(30);
        lista.addNumero(40);
        System.out.println(lista.toString());
    }
}
