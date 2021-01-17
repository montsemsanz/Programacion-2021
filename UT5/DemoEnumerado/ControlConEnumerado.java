
/**
 * Los objetos de esta clase mantienen un atributo nivel
 */
public class ControlConEnumerado
{

    private Nivel nivel;

    /**
     * Constructor iniicializa nivel a BAJO 
     */
    public ControlConEnumerado()
    {
        nivel =  Nivel.BAJO;
    }

    /**
     *  devuelve el valor actual de nivel
     */
    public Nivel getNivel()
    {
        return nivel;
    }

    /**
     *  devuelve el valor actual de nivel
     */
    public void setNivel(Nivel nivel)
    {
        this.nivel = nivel;
    }

    /**
     * 
     */
    public  String toString()
    {

        return nivel.toString();
    }

    /**
     * 
     */
    public    Nivel queNivel(String strNivel)
    {
        return Nivel.valueOf(strNivel);
    }

    /**
     *  
     */
    public   Nivel[] valoresDelTipo()
    {
        return Nivel.values();
    }


}
