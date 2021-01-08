
/**
 * 
 */
public class AppCalculadora
{

    /**
     *  si no se pasan argumentos al main mostrar error,
     *  sino aceptar los argumentos, crear un array de enteros con ellos
     *  crear la calculadora a partir de los valores de ese array y mostrar la calculadora
     *  
     *  
     */
    public static void main(String[] args)
    {
        if (args.length == 0)  {
            System.out.println("Error en no de argumentos\nSintaxis: java AppCalculadora <n1> <n2> <n3> .....");
            return;
        }
        int[] numeros = new int[args.length];
        for (int i = 0; i < args.length; i++)     {
            numeros[i] = Integer.parseInt(args[i]);
        }
        
        Calculadora calc = new Calculadora(numeros);
        calc.escribirNumeros();
        
    }
}
