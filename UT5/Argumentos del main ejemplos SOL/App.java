
/**
 *  
 */
public class App
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 3)    {
            System.out.println("Error, Sintaxis: java App <n1> <operador> <n2>");
            return;
        }
        int n1 = Integer.parseInt(args[0]);
        char op = args[1].charAt(0);
        int n2 = Integer.parseInt(args[2]);
        int resul = 0;
        switch (op)   {
            case '+': resul = n1 + n2;
            break;
            case '-': resul = n1 - n2;
            break;
            case '*': resul = n1 * n2;
            break;
            case '/': resul = n1 / n2;
            break;
        }
        System.out.println("Resultado " + resul);

    }
}
