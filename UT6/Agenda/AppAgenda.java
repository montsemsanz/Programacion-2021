import java.util.ArrayList;

/**
 *  
 * 
 * @author  
 * @version  
 */
public class AppAgenda
{

    /**
     *  
     */
    public static void main(String[] args)
    {
        Agenda agenda = new Agenda();
        agenda.apuntarNota("comprar pan");
        agenda.apuntarNota("comprar leche");
        agenda.apuntarNota("ir dentista");
        agenda.apuntarNota("recargar móvil");
        agenda.listarNotas();

        System.out.println("Total notas: " + agenda.numeroNotas());
        System.out.println("Nota tercera: ");
        agenda.mostrarNota(2);
        agenda.borrarNota(2);

        agenda.listarNotas();
        System.out.println("Notas que contienene 'ar': " +  agenda.notasQueContienen("AR"));

        System.out.println("-------------");
        agenda.borrarNotasQueEmpiezanPor("co");
        agenda.listarNotas();

        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir fruteria");       

        System.out.println("-------------");
        ArrayList<String> resul = agenda.acabanEn("ria");
        System.out.println(resul.toString());

        System.out.println("-------------");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("ir pescaderia");
        agenda.apuntarNota("comprar leche");
        agenda.borrarRepetidasV3();
        System.out.println("------ Con Iterator -------");
        agenda.listarNotasConIterador();
        System.out.println("------ Con ListIterator -------");
        agenda.listarNotasConIteradorV2();

        System.out.println("------ Primera al final -------");
        agenda.primeraAlFinal();
        agenda.listarNotas(); 

        System.out.println("------ Última al principio -------");
        agenda.ultimaAlPrincipio();
        agenda.listarNotas(); 

        System.out.println("-------------");
        agenda.invertirV2();
        agenda.listarNotas(); 

        System.out.println("-------------");
        agenda.borrarNotasAcabanEn("a");  // da error
        agenda.listarNotas(); 

    }
}
