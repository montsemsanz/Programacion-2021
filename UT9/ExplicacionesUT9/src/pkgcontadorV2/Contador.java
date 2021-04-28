package pkgcontadorV2;

public class Contador
{
	private int valor;

	public Contador()
	{
		valor = 0;
	}
	 

	public Contador(int valor)
	{
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public int getValor()
	{
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(int valor)
	{
		this.valor = valor;
	}

	/**
	 * 
	 */
	public void incrementar()
	{
		valor++;
	}

	/**
	 * 
	 */
	public void decrementar()
	{
		if (valor > 0)
		{
			valor--;
		}
	}
	
	/**
	 * 
	 */
	public void reset()
	{
		valor = 0;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Contador:" + valor;
	}

}
