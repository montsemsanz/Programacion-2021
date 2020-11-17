
/**
 * Representa a un nº entero
 * 
 *  
 */
public class Numero
{
    private final char ASTERISCO = '*';
    private int numero;

    /**
     * constructor para los objetos de la clase Numero
     */
    public Numero()
    {
        this.numero = 0;
    }

    /**
     * constructor para los objetos de la clase Numero
     */
    public Numero(int numero)
    {
        this.numero = numero;
    }

    /**
     * constructor para los objetos de la clase Numero
     */
    public Numero(Numero numero)
    {
        this.numero = numero.getNumero();
    }

    /**
     * @return  el número que almacena la clase   
     */
    public int getNumero()
    {
        return numero;
    }

    /**
     * @param establece un nuevo numero
     */
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
     /**
     * @param otroNumero  el numero con el que se va a comparar
     * @return true si los dos núemros son iguales, falso en otro caso
     */
    public boolean esMayorQue(Numero otroNumero)
    {
        return (numero > otroNumero.getNumero());
    }

    /**
     * calcula y devuelve el factorial de numero con for
     */
    public int factorial()
    {
        int facto = 1;
        for (int n = 2; n <= numero; n++)  {
            facto = facto * n;
        }

        return facto;
    }
    
      /**
     * detecta si un nº es primo o no
     */
    public boolean esPrimo()
    {
        if (numero == 1) {
            return false;
        }
        for (int divisor = 2; divisor <= numero / 2; divisor++)  {
           if (numero % divisor == 0) {
               return false;
            }
        }

        return true;
    }

    /**
     * Dibuja un cuadrado relleno en la pantalla
     */
    public void escribirFigura()
    {
        for (int fila = 1; fila <= numero; fila++)    {
            for (int col = 1; col <= numero; col++)    {
                System.out.print(String.format("%2c", ASTERISCO));
            }
            System.out.println();
        }
    }


    /**
     * @return la cantidad de cifras del nº
     */
    public int contarCifras()
    {
        int cuantas = 0;

        int aux = numero;
        while (aux != 0)    {
            cuantas++;
            aux = aux / 10;
        }
        return cuantas;
    }


    /**
     * @param numero el nº del que se calculará el inverso 
     * @return el inverso
     */
    private int inverso(int numero)
    {
        // lo hacemos sin contar previamente las cifras 
        int cuantas = 0;

        int invertido = 0;
        int aux = numero;
        while (aux != 0)   {
            int cifra = aux % 10;
            invertido = invertido * 10 + cifra;   
            aux = aux / 10;
        }
        return invertido;
    }

    /**
     * @return true si numero es capicúa
     */
    public boolean esCapicua()
    {
        return this.numero ==  inverso(numero);
    }

    /**
     * Convertir a base 8 
     * @return   el nº convertido
     */
    public int aBase8()
    {
        int potencia = 1;
        int enBase8 = 0;
        int aux = this.numero;
        while (aux != 0)   {
            int resto = aux % 8;
            enBase8 += potencia * resto;
            potencia = potencia * 10;
            aux = aux / 8;

        }
        return enBase8;
    }

    /**
     *  devuelve true si cifra está en numero
     */
    public boolean estaCifra(int cifra)
    {
        return estaCifra(this.numero, cifra);

    }

    /**
     * Detecta si está o no una cifra en el nº
     * @param  cifra la cifra a localizar
     * @return   true si está la cifra
     */
    private boolean estaCifra(int numero, int cifra)
    {
        int aux = numero;
        while (aux != 0)  {
            int resto = aux % 10;
            if (resto == cifra)   {
                return true;
            }
            aux = aux / 10;
        }
        return false;
    }

    
    /**
     * Detecta si el nº tiene cifras repetidas
     * @return   true si las hay
     */
    public boolean hayCifrasRepetidas()
    {
        int aux = this.numero;
        while (aux != 0)  {
            int cifra = aux % 10;
            if (estaCifra(aux / 10, cifra)) {
                return true;
            }
            aux = aux / 10;
        }

        return false;
    }


    /**
     * Convertir a base 2 
     * @return   el nº convertido
     */
    public int aBase2()
    {
        int potencia = 1;
        int enBase2 = 0;
        int aux = this.numero;
        while (aux != 0)     {
            int resto = aux % 2;
            enBase2 += potencia * resto;
            potencia = potencia * 10;
            aux = aux / 2;

        }
        return enBase2;
    }

   
}

