
/**
 * Enumera el conjunto de valores posibles para un objeto ControlConEnumerado
 * http://tutorials.jenkov.com/java/enums.html
 */
public enum Nivel
{
    BAJO (10), 
    MEDIO (25), 
    ALTO (50);

    private int nivel;
    private Nivel(int nivel)
    {
        this.nivel = nivel;
    }

    public int getValorNivel()
    {
        return  nivel;
    }
    
    /**
     *  
     */
    public String toString()
    {
        return "Valor del nivel: " + nivel;

    }

}
