import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

/**
 * Un map que asocia nombres de paises con el conjunto de  idiomas que se hablan en ellos
 * Se quiere recuperar los nombres de los paises ordenados alfabéticamente
 * Se quiere recuperar los nombres de los idiomas ordenados alfabéticamente
 * 
 * Define el atributo mapPaises de forma adecuada
 */
public class MapPaises
{
    private TreeMap<String, TreeSet<String> > paises;

    /**
     * Constructor  
     */
    public MapPaises()
    {
        paises = new TreeMap<>();

    }

    /**
     *  añade un país (siempre en mayúsculas) y el idioma asociado
     *  Si la clave ya existe se añade el idioma al conjunto de idiomas del país
     *  Si la clave no existe se añade una nueva entrada con el pais y el conjunto
     *  formado por idioma
     */
    public void add(String pais, String idioma)
    {
        pais = pais.toUpperCase();
        if (!paises.containsKey(pais))    {
            TreeSet<String> idiomas = new TreeSet<>();
            idiomas.add(idioma);
            paises.put(pais, idiomas);
        }
        else    {
            paises.get(pais).add(idioma);
        }
    }

    /**
     *  Devuelve el conjunto de idiomas que hablan en el pais indicado
     *  
     *
     */
    public TreeSet<String> idiomasQueHablanEn(String pais)
    {
        return paises.get(pais.toUpperCase());
    }

    /**
     *  Devuelve cuántos idiomas hablan en el pais indicado
     *  0 si el pais no existe 
     *
     */
    public int totalIdiomasQueHablanEn(String pais)
    {
        pais = pais.toUpperCase();
        TreeSet<String> idiomas = paises.get(pais);
        if (idiomas != null)    {
            return idiomas.size();
        }
        return 0;
    }

    /**
     *  Representación textual del map de la forma
     *  Pais = {idioma1, idioma2, ....}
     *  Usa StringBuilder para las concatenaciones
     *  Para iterar sobre el map usa el conjunto de entradas y un for mejorado
     */
    public String  toString()  {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, TreeSet<String>>>  entradas = paises.entrySet();
        for (Map.Entry<String, TreeSet<String>> entrada: entradas)     {
            sb.append(entrada.getKey() + " { ");
            for (String idioma: entrada.getValue())    {
                sb.append(idioma + "  ");
            }
            sb.append(" }").append("\n");
        }
        return sb.toString();
    }

    /**
     *  Conjunto de paises en los que se habla el idioma indicado
     *  Importa el orden en el conjunto devuelto
     *  Usa el conjunto de claves y un iterador
     */
    public TreeSet<String> paisesQueHablanIdioma(String idioma)
    {
        TreeSet<String> resul = new  TreeSet<>();
        Set<String> claves = paises.keySet();
        Iterator<String> it = claves.iterator();
        while (it.hasNext())    {
            String pais = it.next();
            if (paises.get(pais).contains(idioma))    {
                resul.add(pais);
            }
        }
        return resul;
    }

    /**
     *  Dados dos países devuelve el conjunto de idioma/s comunes que se hablan en ellos
     *  Si no hay devuelve el conjunto vacío. Si los países no existen también se devuelve 
     *  conjunto vacío
     *
     */
    public TreeSet<String>  idiomasComunes(String pais1, String pais2)
    {
        pais1 = pais1.toUpperCase();
        pais2 = pais2.toUpperCase();
        TreeSet<String> resul = new  TreeSet<String>();
        if (!paises.containsKey(pais1) || !paises.containsKey(pais2))    {
            return resul;
        }
        resul.addAll(paises.get(pais1));
        resul.retainAll(paises.get(pais2));
        return resul;
    }

    /**
     *  
     *
     */
    public void printPaises()
    {
        System.out.println(this.toString());
    }

}
