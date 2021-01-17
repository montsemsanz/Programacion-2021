
/**
 * 
 */
public class Baraja
{
    public static final int MAX_CARTAS = 40;
    private CartaBaraja[] baraja;

    /**
     * Constructor  
     */
    public Baraja()
    {
        baraja = new CartaBaraja[MAX_CARTAS];
        inicializar();
    }

    /**
     *  
     */
    private void inicializar( )
    {
        Palo[] palos = Palo.values();
        Valor[] valores = Valor.values();
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++)    {
                CartaBaraja carta = new CartaBaraja(valores[j], palos[i]);    
                baraja[i * valores.length + j] = carta;
            }
        }
    }

    /**
     *  
     *
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Baraja española\n");
        for (int i = 0; i < baraja.length; i++)    {
            sb.append(baraja[i].toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     *  
     *
     */
    public void printBaraja()
    {
        System.out.println(this.toString());
        System.out.println("Valor carta aleatoria: " + cartaAleatoria());
    }

    /**
     *  Simular que se barajan las cartas
     *  Haremos:
     *      - repetir 20 veces generar dos posiciones aleatorias distintas pos1 y pos2
     *      - intercambiar las cartas de esas posiciones
     *
     */
    public void barajar()
    {
        for (int i = 1; i <= 20; i++) {
            int pos1 = posicionAleatoria();
            int pos2 = posicionAleatoria();
            while (pos2 == pos1) {
                pos2 = posicionAleatoria();
            }
            intercambiar(pos1, pos2);
            
        }
    }

    /**
     *  Devuelve una posición aleatoria entre 0 y 40 exclusive
     *
     */
    private int posicionAleatoria()
    {
        return (int) (Math.random() * baraja.length);
    }

    /**
     *  
     * Intercambia las cartas de las posiciones pos1 y pos2
     */
    private void intercambiar(int pos1, int pos2)
    {
        CartaBaraja aux = baraja[pos1];
        baraja[pos1] = baraja[pos2];
        baraja[pos2] = aux;
    }
    
    /**
     * valor numérico de una carta aleatoria
     */
    public int cartaAleatoria() {
        return baraja[posicionAleatoria()].getValor().getValor();

    }

}
