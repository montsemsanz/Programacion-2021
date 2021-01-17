
/**
 * Descripción de la clase DemoStringBuilder  
 * 
 * @author  
 * @version  
 */
public class DemoStringBuilder
{
    private static final char ASTERISCO = '*';
    private static final char ESPACIO = ' ';
    private String cadena;

    /**
     * Constructor de la clase DemoStringBuilder
     */
    public DemoStringBuilder(String cadena)
    {
        this.cadena = cadena;
    }

    /**
     *  
     * Devuelve una cadena con posición del carácter:carácter     
     */
    public String toString()
    {

        StringBuilder  sb = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++)    {
            sb.append(i).append(":");
            sb.append(cadena.charAt(i))  ;
            sb.append("\n");
        }  

        return sb.toString();
    }

    /**
     *  
     * Borra de cadena   los caracteres e  
     */
    public void borrarLaE()
    {
        StringBuilder  sb = new StringBuilder(this.cadena);
        int i = 0;
        while (i < sb.length())    {
            if (sb.charAt(i) == 'e') {
                sb.deleteCharAt(i);
            }
            else {
                i++;
            }
        }  

        this.cadena = sb.toString();
    }

    /**
     *  
     * Borra de cadena los caracteres e  
     */
    public void borrarLaEV2()
    {
        this.cadena = this.cadena.replaceAll("e", "");
       // this.cadena = this.cadena.replace('e', '\u0000'); // otra opción
    }

    /**
     *  
     * Sustituye en cadena   los caracteres 'e'   por '*'      
     */
    public void sustituirPorAsterisco()
    {
        StringBuilder  sb = new StringBuilder(this.cadena);
        int i = 0;
        while (i < sb.length())     {
            if (sb.charAt(i) == 'e') {
                sb.setCharAt(i, ASTERISCO);
            }
            i++;
        }  
        this.cadena = sb.toString();
    }

    /**
     * Borra de cadena   los espacios  
     */
    public void borrarEspacios( )
    {
        StringBuilder sb = new StringBuilder(this.cadena);
        int i = 0;
        while (i < sb.length())    {
            if (sb.charAt(i) == ESPACIO) {
                sb.deleteCharAt(i);
            }
            else {
                i++;
            }
        }
        this.cadena = sb.toString();
    }

    /**
     *    Si la cadena contiene casa devuelve   c-a-s-a
     */
    public String insertarGuion( ) 
    {

        StringBuilder sb = new StringBuilder(cadena);
        int i = 1;
        while (i < sb.length())    {
            sb.insert(i, '-');
            i = i + 2;
        }
        return sb.toString();
    }

    /**
     *  
     * devuelve una cadena invertida      
     */
    public String invertir()
    {
        StringBuilder  sb = new StringBuilder(this.cadena);
        return sb.reverse().toString();
    }

    /**
     * 
     */
    public void print()
    {
        System.out.println(this.toString());
    }

}
