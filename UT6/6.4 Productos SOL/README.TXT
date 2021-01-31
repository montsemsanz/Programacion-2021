BlueJ proyecto productos
Authors:  David J. Barnes and Michael Kolling

Capítulo 4.

Propósito del proyecto
=======================

Manejo de colecciones, uso de bucles, iteradores y casting.


Ej ejercicio
=============
 Una compañía registra los niveles de stock de los productos 
 que vende. Un objeto GestorStock mantiene una lista con un nº
 arbitrario de objetos Producto. 
 Se trata de completar la implementación de la clase GestosStock.

La clase GestorStock se proporciona para ayudar a demostrar de qué
formas objetos GestorStock y Producto pueden usarse. Se puede crear
 un objeto GestorStock en el object bench y llamar a sus métodos.
 A medida que se desarrolle la clase GestorStock aumentará su funcionalidad.

La clase GestorStck
======================

Esta clase utiliza un objeto ArrayList para almacenar 0 o más productos.
Su método aniadirProducto añade un nuevo producto a la colección. 
Los siguientes métodos necesitan ser completados: recibir, encontrarProducto,
escribirDetallesProducto,nuemroEnStock. 

+ El método recibir localiza un producto con un ID dado en la lista de
productos y llama al método incrementarCantidad 

+ El método encontrarProdcuto busca en la colección un producto cuyo ID 
coincida con el del argumento del método. Si se encuentra el producto, este
producto se devuelve como valor de retorno del método. Si no se encuentra 
se devuelve null.

+ escribirDetallesProducto itera sobre la lista de productos y escribe
 el resultado de llamar al método toStrinf de cada producto.
 
+  Método nuemroEnStock - localiza un producto en la colección con un ID dado y 
devuelve la cantidad actual  de ese producto en stock. Si no se encuentra
el producto se devuelve 0.

La clase Producto
=================

No hay que hacer modificaciones en esta clase

Cada producto vendido por la compañia se representa por una instancia de
la clase Producto, que registra el ID del producto, nombre y cuanto de ese
producto hay en stock. La clase define el método incrementarCantidad  para
registrar incrementos en el nivel de stock del producto. El método venderUno 
indica que un artículo de  ese producto se ha vendido reduciendo la cantidad en uno.


Implementación por etapas
==========================

1. Implementar el método escribirDetallesProducto para asegurarnos que se puede iterar
sobre la colleción de productos. Escribe cada producto utilizando System.out. Utilizar
un Iterator es la solución más adecuada pero usa un índice integer si te resulta más
fácil de entender.
 
2. Implementa el método encontrarProducto. Aquí no es necesario examinar cada producto de la 
colección. Si el producto se encuentra en primer lugar la iteración debe terminar y devolver
el producto. Si no se encuentra la colección se habrá recorrido entera sin encontrar el
producto, en este caso se devolverá null.

Cuando se busca unproducto por su ID habrá que llamar al método getID de un producto.
Esto quiere decir que hay que realizar un cast cuando se obtiene un producto de la lista.  

3. Implementa el método numeroEnStock. Es relativamente fácil cuando se ha implementado el método
encontrarProducto. numeroEnStock puede llamar al método encontrarProducto para que haga la búsqueda
y entonces llamar a getCantidad para saber el resultado.

4. Implementa el método repartir utilizando una estrategia similar a la usada en numeroEnStock.

Ejercicios avanzados
============================

+ Implementa un método en GestorStock para escribir los detalles de todos los productos con niveles 
de stock por debajo de un valor dado (pasado como parámetro al método).

+  Modifica el método aniadirProducto para que un nuevo producto no pueda ser añadido si ya 
está en la lista un producto con ese ID.

+ Añade un método a GEstorStock que localice un producto a partir de su nombre en vez de su ID:

    public Producto encontrarProducto(String nombre)

Para hacer esto necesitas saber que dos objetos STring s1 y s2 pueden ser testeados para ver si son
iguales con la expresión booleana:   s1.equals(s2)

More detail on this can be found in Chapter 5, page 115.
