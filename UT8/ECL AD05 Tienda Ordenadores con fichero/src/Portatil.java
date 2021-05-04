
public class Portatil extends Ordenador
{
    private static final double DESCUENTO = 2;
    private double peso;


    public Portatil(String codigo, double precio,
                    double peso)
    {
         super(codigo, precio);
         this.peso = peso;
    }


    public double getPeso()
    {
         return peso;
    }
    

    public  void setPeso(double peso)
    {
        this.peso = peso;
    }
    

    @Override
	public String getSlogan()
    {
         return "Ideal para viajes";
    }

    @Override
	public double calcularDescuento()
    {
        return getPrecio() * DESCUENTO / 100;
    }

    

    @Override
	public  String toString()
    {
        return super.toString() + 
              "Peso: " + peso + "\n\n";
    }
}
