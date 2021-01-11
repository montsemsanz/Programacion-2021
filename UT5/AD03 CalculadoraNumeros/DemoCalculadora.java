import java.util.Arrays;
/**
 *  
 */
public class DemoCalculadora
{
    private Calculadora miCalculadora;
    private Calculadora tuCalculadora;

    /**
     * Constructor de la clase DemoCalculadora
     */
    public DemoCalculadora()
    {
        miCalculadora = new Calculadora();
        tuCalculadora = new Calculadora();
    }

    public void testUno()
    {
        int[] lista = {45, 6, 765, 123, 93, 489, 321};
        for (int i = 0; i < lista.length; i++)     { 
            miCalculadora.introducirNumero(lista[i]);
        }

        miCalculadora.escribirNumeros();
        
        int[] decrecientes = miCalculadora.todoDigitosDecreciente();
        
        System.out.println(Arrays.toString(decrecientes));
        
        miCalculadora.borrarUltimoElemento();
        miCalculadora.escribirNumeros();
        miCalculadora.borrarPares();
        miCalculadora.escribirNumeros();
        

    }

    public void testDos()
    {

        for (int valor = 1; valor <= 8; valor++)   {
            tuCalculadora.introducirNumero(valor * 2);
        }
        tuCalculadora.escribirNumeros();
        
        int mayores = tuCalculadora.contarMayoresQue(6);
        System.out.println("Hay " + mayores + " números " +
            " mayores que " + 8);
            
        tuCalculadora.escribirNumeros();
        tuCalculadora.borrarUltimoElemento();
        tuCalculadora.borrarUltimoElemento();
        tuCalculadora.borrarUltimoElemento();
        tuCalculadora.escribirNumeros();
        
        System.out.println("Hay actualmente " + tuCalculadora.getTotal() + 
            " números en la calculadora");
            
        tuCalculadora.vaciar();
        System.out.println("Hay actualmente " + tuCalculadora.getTotal() + 
            " números en la calculadora");

    }

    public void testTres()
    {

        miCalculadora.insertarEnPosicion(212, 0);
        miCalculadora.insertarEnPosicion(222, 1);
        miCalculadora.insertarEnPosicion(244, 2);
        miCalculadora.escribirNumeros();
        miCalculadora.insertarEnPosicion(212, 22); // la ejecución de esta instrucción dará error y se generará una excepción

    }
}