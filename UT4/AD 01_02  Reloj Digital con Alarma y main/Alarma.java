
/**
 * Representa  a un  objeto que guarda la 
 * hora de alarma
 * 
 * @author 
 * @version 
 */
public class Alarma
{
    private int hora;
    private int minutos;
    
    /**
     * Constructor de la clase Alarma
     */
    public Alarma()
    {
        hora = 7;
        minutos = 0;
    }

    /**
     * Cambiar la hora de alarma
     * @param  nuevaHora la nueva hora de alarma
     * @param nuevoMinutos los minutos de la hora de alarma
     */
    public void  setHoraAlarma(int nuevaHora, int nuevoMinutos)
    {
        hora = nuevaHora;
        minutos = nuevoMinutos;
    }

    /**
     * devuelve la hora de alarma
     * @return     un string representando la hora de alarma
     */
    public String getHoraAlarma()
    {
        String str = "";
        if (hora < 10) {
            str =  "0" + hora ;
        }
        else {
            str = str + hora ;
        }
        return str + ":" + minutos;
    }

}
