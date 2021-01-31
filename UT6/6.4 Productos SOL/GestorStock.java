
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona el stock del negocio
 * El stock es descrito por 0 o mas productos
 * 
 * 
 */
public class GestorStock
{
 
    private ArrayList<Producto> listaProductos;

    /**
     * Inicializar el gestor de stock
     */
    public GestorStock()
    {
        listaProductos = new ArrayList<>();
    }

    /**
     * Añadir un producto a la lista
     * @param producto El producto a añadir
     */
    public void añadirProducto(Producto producto)
    {
        Producto p = localizarProducto(producto.getID());
        if (p == null )   {
            listaProductos.add(producto);
        }
        else   {
            System.out.println("El producto " + producto.getID() + " ya existe");
        }
    }

    /**
     * Recibir una entrega de un producto particular
     * Incrementar la cantidad del producto en la cantidad indicada.
     * @param id El id del producto
     * @param cuanto La cantidad en que se incrementará el producto
     */
    public void recibirProducto(int id, int cuanto)
    {
        Producto producto = localizarProducto(id);
        if (producto != null)     {
            producto.incrementarCantidad(cuanto);
        }
        else    {
            System.out.println("No se ha encontrado un producto con identificador "
                + id);                        
        }
    }

    /**
     * Intenta encontrar el producto con el id dado
     * @param id  El identificador del producto a buscar
     * @return   El productos si se encuentra, o null 
     *          si no se encuentra
     */
    public Producto localizarProducto(int id)
    {     
        int i = 0;
        while (i < listaProductos.size())      {
            Producto p =  listaProductos.get(i);
            if (p.getID() == id)     {
                return p;
            }
            i++;
        }
        return null;
    }

    /**
     * Intenta encontrar el producto a partir de su nombre
     * @param nombre  El nombre del producto a buscar
     * @return   El producto si se encuentra, o null 
     *          si no se encuentra
     */
    public Producto localizarProducto(String nombre)
    {

        for (Producto p: listaProductos)     {
            if (p.getNombre().equalsIgnoreCase(nombre))   {
                return  p;
            }

        }
        return null;
    }

    /**
     * Localiza un producto de id dado, y devuelve cuanto hay en stock. 
     * Si el id no existe devuelve -1
     * @param id El id del producto
     * @return La cantidad en stock del producto localizado
     */
    public int cantidadEnStock(int id)
    {
        int cuanto = -1;
        Producto producto = localizarProducto(id);
        if (producto != null)  {
            cuanto = producto.getCantidad();
        }
        return cuanto;
    }

    /**
     * Escribir detalles del producto con iterador
     */
    public void escribirDetallesProductosV1()
    {
        System.out.println("Productos en stock");
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext())     {
            Producto producto = it.next();
            System.out.println(producto.toString());
        }
    }

    /**
     * Escribir detalles del producto con for mejorado 
     */
    public void escribirDetallesProductosV2()
    {
        System.out.println("Productos en stock");
        for (Producto producto: listaProductos)    {
            System.out.println(producto.toString());
        }
    }

    /**
     * Escribir detalles del producto
     */
    public void escribirDetallesProductosV3()
    {
        System.out.println("Productos en stock");
        for (int i = 0; i < listaProductos.size(); i++)    {
            System.out.println(listaProductos.get(i).toString());
        }
    }

    /**
     * Escribir productos cuyo stock está
     * por debajo de un cierto nivel que se 
     * pasa como parámetro
     */
    public void escribirMenorQue(int valor)
    {
        System.out.println("Productos en stock con stock por debajo de "
            + valor);
        int tam = listaProductos.size();
        for (int i = 0; i < tam; i++)    {
            Producto producto = listaProductos.get(i);
            if (producto.getCantidad() < valor)    {
                System.out.println(producto.toString());
            }
        }
    }

}
