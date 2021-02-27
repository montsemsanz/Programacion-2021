import java.util.Scanner;
import pkgotroconversor.romanos.ConversorRomanos;
/**
 * 
 * 
 * @author  
 * @version  
 */
public class AppOtroConversor
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        ConversorRomanos conversor = new ConversorRomanos();
        Scanner teclado = new Scanner(System.in);
        for (int i = 1; i <= 4; i++)   {
            System.out.print("Dame nº arábigo: ");
            int numero = teclado.nextInt();
            System.out.println("Su romano es: " + conversor.aRomano(numero));
        }
        System.out.println("-----------------------");
        teclado.nextLine();
        for (int i = 1; i <= 4; i++)     {
            System.out.print("Dame nº romano: ");
            String romano = teclado.nextLine();
            System.out.println("Su arábigo es: " + conversor.aArabigo(romano));
        }
    }
}
