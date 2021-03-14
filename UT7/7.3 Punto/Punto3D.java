
/**
 *    
 */
public class Punto3D extends Punto
{

    private int z;

    /**
     * Constructor  
     */
    public Punto3D(int x, int y, int z)
    {
        super(x, y);
        this.z = z;
    }

    /**
     * 
     */
    public int getZ()
    {
        return z;
    }

    /**
     *  
     * 
     * @param   
     * 
     */
    public String toString()
    {
        return super.toString() + " ," + z;  
    }

    /**
     *  
     *
     */
    public boolean equals(Object obj)
    {       
        if (super.equals(obj))    {
            Punto3D p3d = (Punto3D) obj;
            return this.z == p3d.getZ();
        }
        return false;
        // return super.equals(obj) && this.z == ((Punto3D) obj).getZ();
    }

    /**
     *  
     *
     */
    public int hashCode()
    {
        return super.hashCode() + z;
    }

    /**
     * 
     */
    public int compareTo(Punto p)
    {
        int r = super.compareTo(p);
        Punto3D otro =  (Punto3D) p;
        if (r == 0)  {
            if (this.z < otro.getZ()) {
                r = -1;
            }
            else  if (this.z > otro.getZ()) {
                r = 1;
            }
            else r = 0;
        }
        return r;

    }

}
