import java.util.Arrays;

/**
 *  
 * Representa a un CD 
 */
public class CD
{
    private String titulo;
    private String artista;
    private Cancion[] canciones;
    private int pos; // total canciones en el CD

    /**
     * Constructor  
     */
    public CD(int n, String titulo, String artista)
    {
        this.titulo = titulo;
        this.artista = artista;
        canciones = new Cancion[n];
        pos = 0;
    }

    /**
     *  añade una canción al CD  solo si no está completo
     * 
     * @param  c la canción a añadir 
     * 
     */
    public void addCancion(Cancion c)
    {
        if (!estaCompleto())   {
            canciones[pos] = c;
            pos++;
        }
    }

    /**
     *  añade una canción al CD  solo si no está completo
     * 
     * @param  titulo el título de  la canción a añadir 
     * @param  duracion la duración de  la canción a añadir 
     * 
     */
    public void addCancion(String titulo, double duracion)
    {
        Cancion cancion = new Cancion(titulo, duracion);
        this.addCancion(cancion);
    }

    /**
     * devuelve true si el cd está lleno
     */
    public  boolean estaCompleto()
    {
        return pos == canciones.length;
    }

    /**
     * devuelve el total de canciones en el CD
     */
    public  int totalCanciones()
    {
        return  pos;
    }

    /**
     * Duración total del CD
     */
    public  double duracionTotal()
    {
        double total = 0.0;
        for (int i = 0; i < pos; i++)  {
            total += canciones[i].getDuracion();
        }
        return total;
    }

    /**
     * Devuelve una canción aleatoria del CD
     */
    public  Cancion getAleatoria()
    {
        int posAleatoria = (int) (Math.random() * pos);
        return canciones[posAleatoria];
    }

    /**
     * Devuelve un  array con los títulos de las canciones en mayúsculas
     */
    public  String[] getTitulos()
    {
        String[] titulos = new String[pos];
        for (int i = 0; i < pos; i++)   {
            titulos[i] = canciones[i].getTitulo().toUpperCase();
        }
        return titulos;

    }

    /**
     * Devuelve cuántas canciones contienen en el título una cadena
     */
    public  int cancionesQueContienen(String str)
    {
        int cuantas = 0;
        for (int i = 0; i < pos; i++) {
            int pos = canciones[i].getTitulo().toLowerCase().indexOf(str.toLowerCase());
            if (pos != -1) {
                cuantas++;
            }
        }
        return cuantas;

    }

    /**
     * Borra las canciones que empiezan por una cadena devolviendo los títulos
     * que se han borrado. Si no hay ninguna se devuelve null
     */
    public  String[] borrarCancionesQueEmpiezan(String str)
    {
        String[] borrados = new String[pos];
        int j = 0;
        int i = 0;
        while (i < pos)   {
            String titulo = canciones[i].getTitulo();
            if (titulo.toLowerCase().startsWith(str.toLowerCase()) ) {
                borrarCancion(i);
                borrados[j] = titulo;
                j++;
            }
            else   {
                i++;
            }
        }
        if (j == 0) { // no se ha borrado ninguna
            return null;
        }
        return Arrays.copyOf(borrados, j);

    }

    /**
     * Borra una canción, la que está en la posición p
     */
    private  void borrarCancion(int p)
    {
        for (int i = p + 1; i < pos; i++)   {
            canciones[i - 1] = canciones[i];
        }
        pos--;

        // System.arraycopy(canciones, p + 1, canciones, p, pos - p - 1);  // otra posibilidad
    }

    /**
     * Obtener un array con las canciones ordenadas por título
     * Método de selección directa
     */
    public  Cancion[] cancionesOrdenadasPorTitulo()
    {
        Cancion[] ordenadas = new Cancion[pos];
        System.arraycopy(this.canciones, 0, ordenadas, 0 , pos);

        for (int i = 0; i < ordenadas.length - 1; i++)   {
            int posMin = i;
            for (int j = i + 1; j < ordenadas.length; j++)     {                
                if (ordenadas[j].getTitulo().compareToIgnoreCase(ordenadas[posMin].getTitulo()) < 0) {
                    posMin= j;
                }

            }   
            Cancion aux = ordenadas[posMin];
            ordenadas[posMin] = ordenadas[i];
            ordenadas[i] = aux;
        }
        return ordenadas;

    }

    /**
     *  Crea  y devuelve un nuevo CD con las canciones ordenadas por título
     *
     */
    public CD crearNuevoCD()
    {
        CD nuevo = new CD(this.pos, this.titulo, this.artista);
        Cancion[] ordenadas = cancionesOrdenadasPorTitulo();
        for (int i = 0; i < ordenadas.length; i++)  {
            nuevo.addCancion(ordenadas[i]);
        }
        return nuevo;
    }
 
    /**
     * Representación textual del CD
     */
    public  String toString()
    {
        StringBuilder sb = new StringBuilder("\nTítulo CD: " + this.titulo +
                "\nArtista: " + this.artista.toUpperCase());
        sb.append("\nCanciones\n");
        for (int i = 0; i < pos; i++)  {
            sb.append(canciones[i].toString());
        }
        return sb.toString();
    }
}
