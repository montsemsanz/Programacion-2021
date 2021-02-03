
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class AppColeccionEnteros
{

    public static void main(String[] args)
    {
        ColeccionEnteros coleccion = new ColeccionEnteros();
        System.out.println(coleccion.toString());
        ArrayList<Integer> ordenada = coleccion.ordenar();
        System.out.println("Lista ordenada: \t " + ordenada.toString());

        ArrayList<Integer> otra =  new ArrayList<>();
        otra.addAll(Arrays.asList(5, 8, 8, 10, 12, 18));
        coleccion.elementosComunes(otra);
        System.out.println("Elementos comunes \t " + coleccion.toString());

        coleccion.elementosDiferentes(otra);
        System.out.println("Elementos diferentes \t " + coleccion.toString());
    }

}
