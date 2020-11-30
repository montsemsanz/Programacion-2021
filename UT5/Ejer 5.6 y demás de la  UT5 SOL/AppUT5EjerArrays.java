import java.util.Arrays;

/**
 *  
 */
public class AppUT5EjerArrays
{

     /**
     *  
     *  
     */
    public static void main(String[] args)
    {

        UT5EjerArrays ejer = new UT5EjerArrays();
        System.out.println("--------- escribirArray() -----------------");
        ejer.escribirArray();

        System.out.println("--------- calcularMedia() -----------------");
        double[] valores = {2, 5, 6, 8, 9, 22, 13};        
        System.out.println("Valor inicial del array " + Arrays.toString(valores));
        System.out.println("La media es " + String.format("%10.2f", ejer.calcularMedia(valores)));

        System.out.println("\n--------- calcularMaximo() -----------------");
        int[] numeros = {2, 5, 6, 8, 9, 22, 13};
        System.out.println("Valor inicial del array " + Arrays.toString(numeros));
        System.out.println("El máximo es es " + ejer.maximo(numeros));

        System.out.println("\n--------- paresV1() -----------------");
        int[] resul = ejer.paresV1(numeros);
        System.out.println(Arrays.toString(resul));

        System.out.println("\n---------  paresV2() -----------------");
        resul = ejer.paresV2(numeros);
        System.out.println(Arrays.toString(resul));

        System.out.println("\n---------- rotarDerecha() ----------------");
        ejer.rotarDerecha(numeros);
        System.out.println(Arrays.toString(numeros));

        System.out.println("\n-------- rotarDerechaV2() ------------------");
        resul =  ejer.rotarDerechaV2(numeros);
        System.out.println(Arrays.toString(resul));

        System.out.println("\n---------- rotarDerechaV3() ----------------");
        ejer.rotarDerechaV3(numeros);
        System.out.println(Arrays.toString(numeros));

        System.out.println("\n----------- expandir() ---------------");
        resul = ejer.expandir(numeros); 
        System.out.println(Arrays.toString(resul));

        System.out.println("\n--------- calcularFrecuencias() -----------------");
        resul = ejer.calcularFrecuencias(); 
        System.out.println(Arrays.toString(resul));

        System.out.println("\n----------- puente01() ---------------");
        numeros = new int[]{2034, 12, 223, 5432, 9999};
        System.out.println(Arrays.toString(numeros));
        ejer.puente01(numeros);

        System.out.println("\n----------- puente02() ---------------");
        numeros = new int[]{2, 5, 7, 12, 9, 3};        
        ejer.puente02(numeros);

        System.out.println("\n----------- puente03() ---------------");
        numeros = new int[]{2, 5, 7, 12, 9};     
        System.out.println(Arrays.toString(numeros));
        System.out.println("Coipa con System.arraycopyof() " +
            Arrays.toString(ejer.puente03(numeros)));

        System.out.println("\n----------- puente04() ---------------");
        numeros = new int[]{2, 5, 7, 12, 9, 3};     
        System.out.println(Arrays.toString(numeros));
        System.out.println("Coipa con Arrays.copyOf() " +
            Arrays.toString(ejer.puente03(numeros)));
    }
}
