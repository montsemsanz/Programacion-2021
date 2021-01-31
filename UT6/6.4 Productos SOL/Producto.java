/**
 * Modela algunos detalles de un producto que vende una compañía
 */

public class Producto
{
    private int id;
    private String nombre;
    private int cantidad;

    /**
     * Constructor
     * El stock inicial es 0
     * @param id  nº que identifica al producto
     * @param nombre  Nombre del producto
     */
    public Producto(int id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
        cantidad = 0;
    }

    /**
     * @return El id del producto
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return El nombre del producto
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return La cantidad en stock
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * @return Id, nombre y cantidad como String
     */
    public String toString()
    {
        return id + ": " +
               nombre +
               " nivel de stock: " + cantidad;
    }

    /**
     * Modificar el stock con la cantidad dada
     * @param cantidad Cantidad de nuevos artículos que se añaden al stock
     *               La cantidad actual se incrementa en cantidad.
     */
    public void incrementarCantidad(int cuanto)
    {
        if(cuanto > 0)     {
            cantidad += cuanto;
        }
        else    {
            System.out.println("Intento de reponer " +
                               nombre +
                               " con una cantidad no positiva: " +
                               cuanto);
        }
    }

    /**
     * Vender uno de los productos
     * Se genera un error si no hay stock
     */
    public void venderUno()
    {
        if(cantidad > 0)      {
            cantidad--;
        }
        else    {
            System.out.println("Intento de vender un artículo sin stock: " + nombre);
        }
    }
}
