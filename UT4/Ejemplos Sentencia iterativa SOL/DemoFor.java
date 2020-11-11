import java.util.Random;

/**
 * 
 */
public class DemoFor
{
    private final char PUNTO = '.';
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Moneda moneda;
    private Random generador;

    /**
     * Constructor  
     */
    public DemoFor()
    {
        moneda = new Moneda();
        generador = new Random();
    }

    /**
     * Saludar 10 veces con for
     */
    public  void ejemploFor01()
    {
        for (int veces = 1; veces <= 10; veces++)    {
            System.out.println("Saludo " + veces);
        }

    }

    /**
     * Tirar una moneda 10 veces con for
     */
    public  void ejemploFor02()
    {
        for (int tiradas = 1; tiradas <= 30; tiradas++)  {
            moneda.tirar();
        }
    }

    /**
     * Tirar una moneda 30 veces
     * contando las veces que ha salido cara y las que ha salido cruz
     */
    public  void ejemploFor03()
    {
        int caras = 0;
        int cruces = 0;
        for (int tiradas = 1; tiradas <= 30; tiradas++)   {
            moneda.tirar();
            if  (moneda.esCara()) {
                caras++;
            }
            else {
                cruces++;
            }
        }
    }

    /**
     *  Impares entre 1 y 19
     *  1, 3, 5, 7, 9, 11, 13, 15, 17, 19
     *  
     */
    public void imparesEntre1y20()
    {
        int impar;
        for (impar = 1; impar <= 17; impar += 2)  {
            System.out.print(impar + " , ");
        }
        System.out.print(impar);

    }

    /**
     * Ejer 4.15 a) de la UT4
     */
    public  void escribirFiguraA(int n)
    {
        for (int fila = 1; fila <= n; fila++)   {
            for (int col = 1; col <= n; col++)  {
                System.out.print(fila + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Ejer 4.15 b) de la UT4
     */
    public  void escribirFiguraB(int n)
    {
        for (int fila = 1; fila <= n; fila++)    {
            for (int col = 1; col <= fila; col++)   {
                System.out.print(fila + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Ejer 4.15 c) de la UT4
     */
    public  void escribirFiguraC(int n)
    {
        for (int fila = 1; fila <= n; fila++)    {
            for (int col = 1; col <= fila; col++)   {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    /**
     *  Ejer 4.15 d) de la UT4
     */
    public  void   escribirTablasMultiplicar(int  numero) 
    {
        for (int n = 1; n <= numero; n++)   {
            System.out.println("Tabla de multiplicar del " + n);

            int conta = 1;
            while (conta <= 10)  {
                System.out.println(conta + " * " + n + " = " + (conta * n));
                conta++;
            }

            System.out.println();
            if (n % 2 == 0) {
                esperar(4000); 
            }
        }
    }

    /**
     *  Ejer 4.15 d) de la UT4
     */
    public  void   escribirTablasMultiplicarV2(int  numero) 
    {

        System.out.print("\t");
        for (int conta = 1; conta <= 10; conta ++)   {
            System.out.print(conta  + "\t");
        }
        System.out.println("\n");
        for (int n = 1; n <= numero; n++)   {

            System.out.print(n + "\t");
            for (int conta = 1; conta <= 10; conta ++)       {
                System.out.print((conta * n) + "\t");
            }

            System.out.println();

        }
    }

    /**
     *  Generar n aleatorios entre 10 y 50 y calcular el máximo
     *
     *  
     */
    public int maximoV0(int n)
    {
        // int max = Integer.MIN_VALUE;
        // System.out.println(max);
        int max = 0;
        for (int contador = 1; contador <= n; contador++)     {
            int aleatorio =  (int) (Math.random() * 41) + 10;
            if (aleatorio > max)     {
                max = aleatorio;
            }
        }
        return max;
    }

    /**
     *  Generar n aleatorios entre -10 y 50 y calcular y escribir el máximo y cuántas veces aparece
     *
     *  
     */
    public void maximo(int n)
    {
        int totalMaximos = 0;
        int max = Integer.MIN_VALUE;
        for (int contador = 1; contador <= n; contador++)     {
            int aleatorio =  (int) (Math.random() * 61) - 10;
            if (aleatorio > max)      {
                max = aleatorio;
                totalMaximos = 1;
            }
            else if (aleatorio == max)     {
                totalMaximos ++;
            }
        }
        System.out.println("Máximo: " + max + " aparece " + totalMaximos + " veces");
    }

    /**
     *  Escribir los n primeros  nºs triangulares
     *
     *  
     */
    public void triangulares(int n)
    {
        for (int contador = 1; contador <= n; contador++)    {
            int suma = 0;
            for (int conta = 1; conta <= contador; conta++)   {
                suma += conta;
            }
            System.out.println(contador + "\t" + suma);
        }
    }

    /**
     * El programa hace una pausa de los milisegundos especificados
     */
    public void esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (Exception e)
        {
            // ignorar la excepción
        }
    }

    /**
     *  Mostrar figura para N filas
     *  A
     *  BB
     *  CCC
     *  DDDD
     *  EEEEE
     *  FFFFFF
     *  GGGGGGG
     *  .........
     *  MMMMMMMMMMMM
     *
     *  
     */
    public void trianguloLetras(int n)
    {
        char letra = 'A';
        for (int fila = 1; fila <= n; fila++)     {
            for (int col = 1; col <= fila; col++)  {
                System.out.print(letra);
            }
            System.out.println();
            letra++;
        }

    }

    /**
     *  Mostrar la siguiente figura 
     *  ABCD...................Z
     *  BCD...................Z
     *  CDEF.................Z
     *   ..........
     *
     *  Z
     */
    public void trianguloLetrasOtro()
    {
        for (char fila = 'A'; fila <= 'Z'; fila++)     {
            for (char col = fila; col <= 'Z'; col++)     {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }

    /**
     *  ....1
     *  ...2.
     *  ..3..
     *  .4...
     *  5....
     *
     *  
     */
    public void cuadroConPuntos(int n)
    {
        for (int fila = 1; fila <= n; fila++)     {
            escribirPuntos(n - fila);
            System.out.print(fila);
            escribirPuntos(fila - 1);    
            System.out.println();
        }
    }

    /**
     *  A
     *  ABA
     *  ABCBA
     *  ABCDCBA
     *  ABCDEDCBA
     *  ABCDEFEDCBA
     *  ABCDEFGFEDCBA
     *
     *  
     */
    public void trianguloLetrasDos(int n)
    {
        for (int fila = 1; fila <= n; fila++)     {
            char letra = 'A';
            for (int col = 1; col <= 2 * fila - 1; col++)       {
                System.out.print(letra);
                if (col < fila)              {
                    letra++;
                }
                else    {
                    letra--;
                }

            }
            System.out.println();
        }
    }

    /**
     *  Escribe n puntos en la misma línea
     *  
     */
    public void escribirPuntos(int n)
    {
        for (int col = 1; col <= n; col++)    {
            System.out.print(PUNTO);
        }
    }

    /**
     *  1
     *  122
     *  122333
     *  1223334444
     *  1223334444555555
     *  Figura para las 9 primeras filas
     *  Cada nº formateado en 2 espacios a la derecha
     */
    public void masDeFiguras()
    {
        for (int fila = 1; fila <= 9; fila++)  {
            System.out.print(String.format("%2d", 1));
            for (int col = 2; col <= fila; col++)  {
                for (int colum = 1; colum <= col; colum++)   {
                    System.out.print(String.format("%2d", col));
                }

            }
            System.out.println();
        }

    }

    /**
     *  Calcula y escribe la siguiente serie
     *  1 + 2 elevado a 2 + 3 elevado a 2 + 4 elevado a 2 +   .... + n elevado a 2
     *
     */
    public void serieCuadrados(int n)
    {
        int suma = 0;
        for (int contador = 1; contador <= n; contador ++)  {
            suma += contador * contador;
        }
        System.out.println("Suma = " + suma);
    }

    /**
     *  Muestra los años bisiestos entre 2001 y 2250
     *  haciendo uso del método esBisiesto(int año)
     *  En filas de 8
     *
     */
    public void mostrarAñosBisiestos()
    {
        int col = 0;
        for (int año = 2001; año <= 2250; año ++)  {
            if (esBisiesto(año))  {
                System.out.print(año + "\t");
                col ++;
                if (col % 8 == 0)   {
                    System.out.println();
                }
            }
        }

    }

    /**
     *  Detecta si un año es  o no bisiesto
     *  Un año bisiesto es múltilo de 4 pero no de 100 o bien de 400
     *
     */
    public boolean esBisiesto(int año)
    {
        return (año % 4 == 0 &&  año % 100 != 0) || (año % 400 == 0);
    }

    /**
     *  Genera n pares de números entre 5 y 20 y calcula su producto mediante sumas
     *
     */
    public void productoMedianteSumas(int n)
    {
        for (int par = 1; par <= n; par++)  {
            int numero1 = generador.nextInt(16) + 5;
            int numero2 = generador.nextInt(16) + 5;
            int producto = 0;
            for (int contador = 1; contador <= numero2; contador ++)  {
                producto += numero1;

            }
            System.out.printf("Producto de %4d y %4d = %6d\n", numero1, numero2, producto);
        }

    }

    /**
     *  Dibujar n   rectángulos de alto y ancho especificados
     *  Ejemplo: n = 4 rectángulos de ancho = 5 y alto = 3
     *  
     *     * * * * *    * * * * *     * * * * *    * * * * *    
     *     * * * * *    * * * * *     * * * * *     * * * * *    
     *     * * * * *    * * * * *     * * * * *     * * * * *    
     *
     */
    public void dibujarRectangulos(int n, int alto, int ancho)
    {
        for (int fila = 1; fila <= alto; fila ++)    {
            for (int rectangulo = 1; rectangulo <= n; rectangulo ++)    {
                for (int aster = 1; aster <= ancho; aster ++)  {
                    System.out.print(ASTERISCO);
                }
                System.out.print(ESPACIO);
                System.out.print(ESPACIO);
            }
            System.out.println();
        }

    }
}
