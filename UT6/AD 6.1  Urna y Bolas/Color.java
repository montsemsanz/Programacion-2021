import java.util.Random;

/**
 * Tipo enumerado
 * 
 */
public enum Color
{
    BLANCO, NEGRO;
    
     public static Color getRandomColor() {
        Random random = new Random();        
        return Color.values()[random.nextInt(Color.values().length)];
    }
}
