
/**
 * Demo para probar la clase ListaNombres
 * Ejer 5.25
 */
public class DemoListaNombres
{

    private ListaNombres lista;

    /**
     * Constructor de la clase DemoListaNombres
     */
    public DemoListaNombres()
    {
        lista = new ListaNombres(10);
        String[] nombres = {"Roberto", "Julio", "Juan", "Alejandro", "Juan"};
        for (int i = 0; i < nombres.length; i++) {
            lista.insertarNombre(nombres[i]);
        }

    }

    /**
     *  
     *       
     */
    public void testInsertar(  )
    {
        lista.insertarNombre("Julio");
        lista.insertarNombre("Ana");
        lista.insertarNombre("Ignacio");
        lista.insertarNombre("Isabel");
        System.out.println("Nombres en la lista");
        testEscribir();
    }

    /**
     *        
     */
    public void testNombreMasLargo(  )
    {

        System.out.println("El nombre más largo en la lista es " +  lista.nombreMasLargo());

    }

    /**
     *        
     */
    public void testBorrarLetra(char letra)
    {

        System.out.println("Lista antes de borrar los que empiezan por " + letra);
        testEscribir();
        lista.borrarLetra(letra);
        System.out.println("Lista después de borrar los que empiezan por " + letra);
        testEscribir();
    }

    /**
     *        
     */
    public void testEmpiezanPor(String str  )
    {

        System.out.println("Hay " + lista.empiezanPor(str) + " nombres que empiezan "+
            "por " + str);

    }

    /**
     *        
     */
    public void testEmpiezanPorLetra(char letra)
    {
        String[] nombres = lista.empiezanPorLetra(letra);
        System.out.println("Los nombres que empiezan por " + letra + " son ");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print(nombres[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 
     *
     * @param   
     * @return     
     */
    public void testEscribir()
    {
        System.out.println(lista.toString());
    }

    

}
