
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;
 

/**
 * Una clase que mantiene una lista
 * con un nº arbitrario de notas.
 * Las notas se numeran de forma externa 
 * por el usuario
 *  
 */
public class Agenda
{

    private ArrayList<String> notas;

    /**
     * Constructor
     */
    public Agenda()
    {
        notas = new ArrayList<>();

    }

    /**
     * Almacenar una nueva nota
     * @param nota La nota que se almacena
     */
    public void apuntarNota(String nota)
    {
        notas.add(nota);
    }

    /**
     * @return El nº de notas actualmente almacenadas
     */
    public int numeroNotas()
    {
        return notas.size();
    }

    /**
     * Mostrar una nota
     * @param numeroNota  El nº de nota a mostrar
     * Si numeroNota incorrecto mensaje de error
     */
    public void mostrarNota(int numeroNota)
    {
        if(numeroNota >= 0 && numeroNota < numeroNotas())   {
            System.out.println((numeroNota + 1) + " " + 
                notas.get(numeroNota)); 
        }
        else  {
            System.out.println("Indice incorrecto");     
        }
    }

    /**
     * Borrar una nota
     * Si numeroNota incorrecto mensaje de error
     */
    public void borrarNota(int numeroNota)
    {
        if(numeroNota >= 0 && numeroNota < numeroNotas())  {
            notas.remove(numeroNota);
        }
        else     {
            System.out.println("Indice incorrecto, " + 
                " el índice máximo es " + (notas.size() - 1));
        }
    }

    /**
     * Mostrar todas las notas
     */
    public void listarNotas()
    {

        int cuantas = notas.size();
        int i  = 0;
        while (i < cuantas)   {
            System.out.println((i + 1) + " " + notas.get(i));
            i++;
        }

    }

    /**
     * Mostar todas las notas con un for mejorado
     */
    public void listarNotasConForMejorado()
    {
        for (String nota: notas)   {
            System.out.println(nota);
        }

    }

    /**
     * Mostar todas las notas con un iterador
     */
    public void listarNotasConIterador()
    {
        Iterator<String> it =  it = notas.iterator();
        while (it.hasNext())  {
            String nota = it.next();
            System.out.println(nota);
        }

    }

    /**
     * Mostrar todas las notas con un iterador
     */
    public  void listarNotasConIteradorV2()
    {
        ListIterator<String> it =  it = notas.listIterator();
        while (it.hasNext())  {
            int p = it.nextIndex();
            String nota = it.next();
            System.out.println(p + " - " + nota);
        }

        while (it.hasPrevious())  {
            int p = it.previousIndex();
            String nota = it.previous();
            System.out.println(p + " - " + nota);
        }

    }

    /**
     * contar las notas que contienen el parámetro str
     * utilizando for mejorado
     */
    public  int notasQueContienen(String str)
    {
        int cuantas = 0;
        for (String nota: notas)  {
            if (nota.toUpperCase().contains(str.toUpperCase()))    {
                cuantas++;
            }
        }
        return cuantas;
    }

    /**
     *   
     * borrar las notas que empiezan con el parámetro
     * utilizando un iterador
     */
    public  void borrarNotasQueEmpiezanPor(String str)
    {
        Iterator<String> it = notas.iterator();
        while (it.hasNext())   {
            String nota = it.next();
            if (nota.startsWith(str)) {
                it.remove();
            }
        }

    }

    /**
     * Devolver una colección con las notas que acaban en "ria"
     * ordenadas
     * Con for mejorado
     *
     */
    public ArrayList<String> acabanEn(String str)
    {
        ArrayList<String> resul = new ArrayList<>();
        for (String nota: notas)  {
            if (nota.endsWith(str))   {
                resul.add(nota);
            }
        }
        Collections.sort(resul);
        return resul;
    }

    /**
     *  Borrar las notas que estén repetidas
     *  Ordenando la colección previamente , no siempre nos puede interesar
     */
    public void borrarRepetidasV1()
    {
        Collections.sort(notas);
        int i = 1;
        while (i < notas.size())   {
            if (notas.get(i - 1).equalsIgnoreCase(notas.get(i)))   {
                notas.remove(i);
            }
            else  {
                i++;
            }
        }

    }

    /**
     *  Borrar las notas que estén repetidas
     *  con indexOf (sin ordenar previamente)
     */
    public void borrarRepetidasV2()
    {
        int i = 0;
        while (i < notas.size()) {
            int p = notas.indexOf(notas.get(i));
            if (p != i)    {
                notas.remove(i);
            }
            else  {
                i++;
            }
        }

    }

    /**
     *  Borrar las notas que estén repetidas
     *  con indexOf empezando desde el final con for
     *  (sin ordenar previamente)
     */
    public void borrarRepetidasV3()
    {
        for (int i = notas.size() - 1; i >= 0; i--)   {
            int pos = notas.indexOf(notas.get(i));
            if (pos != i) {
                notas.remove(i);
            }

        }

    }

    /**
     *  Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     *  después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     */
    public void invertir()
    {
        int total = numeroNotas();
        int mitad = total / 2;
        for (int i = 0; i < mitad; i++)   {
            String aux = notas.get(i);
            notas.set(i, notas.get(total - i - 1));
            notas.set(total - i - 1, aux);
        }

    }

    /**
     *  Invierte la lista de notas
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     *  después de ejecutar el método contendrá  [ "ir dentista", "comprar leche", "comprar pan"]
     */
    public void invertirV2()
    {
        Collections.reverse(notas);

    }

    /**
     *  Duplica cada nota
     *  Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     *  después de ejecutar el método contendrá 
     *  ["comprar pan", "comprar pan", "comprar leche", "comprar leche", "ir dentista", "ir dentista"]
     *
     */
    public void duplicarNotas()
    {
        for (int i = 0; i < notas.size(); i = i + 2)  {
            notas.add(i + 1, notas.get(i));
        }

    }

    /**
     * Reorganiza aleatoriamenta las notas de la agenda
     * Si la lista contiene ["comprar pan", "comprar leche", "ir dentista"]
     *  después de ejecutar el método podría  contener ["comprar leche", ir dentista","comprar pan"]
     */
    public void reorganizar()
    {
        Collections.shuffle(notas);
    }

    /**
     *  Coloca la primera nota al final de la lista borrándola de la primera posición
     *
     */
    public void primeraAlFinal()
    {
        if (!notas.isEmpty()) {
            notas.add(notas.get(0));
            notas.remove(0);
        }

    }

    /**
     *  Coloca la última nota al principio de la lista borrándola de la última posición
     *
     */
    public void ultimaAlPrincipio()
    {
        if (!notas.isEmpty())  {
            notas.add(0, notas.get(numeroNotas() - 1));
            notas.remove(numeroNotas() - 1);
        }

    }

    /**
     *  Devuelve la posición de la primera ocurrencia de nota
     *
     */
    public int posicionDeLaNota(String nota)
    {
        return notas.indexOf(nota);
    }

    /**
     *   
     * borrar las notas que empiezan con el parámetro
     * utilizando un for mejorado  INCORRECTO
     */
    public  void borrarNotasAcabanEn(String str)
    {
        for (String nota: notas)    {
            if (nota.endsWith(str)) {
                notas.remove(nota);
            }
        }


    }

}
