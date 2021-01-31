/**
 * Demo para las clases GestorStock y Producto
 */

public class StockDemo
{
     
    private GestorStock gestor;

    /**
     * Crea el gestor y añade algunos productos
     */
    public StockDemo()
    {
        gestor = new GestorStock();
        gestor.añadirProducto(new Producto(132, "Clock Radio"));
        gestor.añadirProducto(new Producto(37, "Mobile Phone"));
        gestor.añadirProducto(new Producto(23, "Microwave Oven"));
        gestor.añadirProducto(new Producto(23, "Microwave Oven"));
        gestor.escribirDetallesProductosV1();
    }
    
    /**
     *  
     */
    public void recibirProducto()
    {
        // Muestra detalles de todos los productos
        gestor.escribirDetallesProductosV1();
        // Llegada de  artículos de varios producto
        gestor.recibirProducto(132, 5);
        gestor.recibirProducto(132, 15);
        gestor.recibirProducto(23, 35);
        gestor.recibirProducto(37, 6);
        gestor.escribirDetallesProductosV2();
    }
    
    /**
     * Mostrar detalles de un producto. 
     * @param id -id  del producto a buscar
     */
    public void mostrarDetalles(int id)
    {
        Producto producto = getProducto(id);
        if(producto != null)
        {
            System.out.println(producto.toString());
        }
    }
    
    /**
     * Vender un artículo de un producto
     * Mostra el estado del producto antes y después de la venta
     * @param id El id del producto vendido
     */
    public void venderProducto(int id)
    {
        Producto producto = getProducto(id);        
        if(producto != null) 
        {
            mostrarDetalles(id);
            producto.venderUno();
            mostrarDetalles(id);
        }
    }
    
     /**
     * Mostrar productos del almacén con nivel
     * de stock por debajo de cantidad
     */
    public void menorQue(int cantidad)
    {
         gestor.escribirMenorQue(cantidad);
    }
    
    /**
     * Obtener el producto de id dado desde el gestor.
     *
     * @param id El ID del producto
     * @return El producto o null si no se encuentra
     */
    public Producto getProducto(int id)
    {
        Producto producto = gestor.localizarProducto(id);
        if(producto == null)
        {
            System.out.println("Producto con ID: " + id +
                               " no se reconoce.");
        }
        return producto;
    }

    /**
     * @return El gestor de stock
     */
    public GestorStock getGestor()
    {
        return gestor;
    }
}
