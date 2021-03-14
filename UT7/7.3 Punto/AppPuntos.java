import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


public class AppPuntos
{

  
    public static void main(String[] args)
    {
        Punto p = new Punto(8, 9);
        //         Punto3D pd1 = new Punto3D(1, 2, 3);       
        // //         p = pd1;        
        // //         pd1 = p;
        // 
        //         Punto p2 = new Punto3D(18, 19, 20);
        //         pd1 = (Punto3D) p2;
        // 
        //         pd1 = (Punto3D) p;

        Punto r = new Punto(8, 9);
        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(p);
        if (!puntos.contains(r))  {
            puntos.add(r);
        }
        System.out.println(puntos.toString());

        int pos = puntos.indexOf(new Punto(8, 9));
        System.out.println(pos);

        HashSet<Punto> set = new HashSet<>();
        set.add(new Punto(8, 8));
        set.add(new Punto(8, 8));
        System.out.println(set.toString());
        
        HashMap<Punto, String> map = new HashMap<>();
        map.put(new Punto(8, 9), "a");
        map.put(new Punto(8, 9), "b");
        System.out.println(map.toString());
        
        
        
    }
}
