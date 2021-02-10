
/**
 * 
 */

public class TestUrna
{
    public static void main (String[] args)
    {
        if (args.length != 1)    {
            System.out.println("Número incorrecto de parámetros");
            return;
        }
        int cuantasBolas = Integer.parseInt(args[0]);
        Urna urna = new Urna();
        for (int i = 1; i <= cuantasBolas; i++)   {
            urna.meterBola(new Bola());
        }
        System.out.println("Después de añadir " + cuantasBolas + " bolas");
        urna.mostrarUrna();
        System.out.println("Hay " + urna.cuantasBlancas() + " bolas blancas");
        System.out.println("Hay " + urna.cuantasNegras() + " bolas negras");
        
        urna.borrarBlancas();
        System.out.println("Después de borrar las bolas blancas ");       
        urna.mostrarUrna();

    }

}
