/**
 * http://stackoverflow.com/questions/3664077/why-cant-enum-constructors-be-protected-or-public-in-java
 */
public enum ColorSemaforo
{
    ROJO(90), 
    AMARILLO(10), 
    VERDE(50);

    private int segundos;

    private ColorSemaforo(int segundos)
    {
        this.segundos = segundos;
    }
    
    /**
     *  
     */
    public int getSegundos()
    {
        return segundos;
    }

}