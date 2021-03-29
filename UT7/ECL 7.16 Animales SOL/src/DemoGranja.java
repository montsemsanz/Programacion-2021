
/**
 * Clase DemoGranja 
 * 
 */
public class DemoGranja
{

	private Granja granja;

	/**
	 * Constructor de la clase DemoGranja
	 */
	public DemoGranja() {

		granja = new Granja(10);
	}

	/**
	 *  
	 */
	public void testGranja() {

		granja.addAnimal(new Perro("toby", 4, new Persona("pepe", 44), "sof�"));
		Animal a = new Gato("caty", 4, new Persona("juan", 12), "pelota");
		granja.addAnimal(a);
		granja.addAnimal(new Perro("churri", 4, new Persona("agust�n", 46),
		                "suelo"));
		granja.addAnimal(new Gato("pepi", 4, new Persona("luis", 23), "trapo"));
		granja.addAnimal(new Vaca("manola", 4, new Persona("Federico", 55)));
		granja.addAnimal(new Gato("max", 4, new Persona("ana", 15), "zapato"));
		granja.addAnimal(new Gato("max", 4, new Persona("ana", 15), "zapato"));
		granja.addAnimal(new Gato("max", 4, new Persona("ana", 15), "zapato"));
		granja.addAnimal(new Vaca("manola", 4, new Persona("Federico", 55)));

		granja.mostrarAnimales();
		System.out.println(
		                "Total perros en la granja " + granja.cuantosPerros());
	}

	/**
	 *  
	 */
	public void testBorrarGatos() {

		granja.borrarGatos();
		granja.mostrarAnimales();
	}

	/**
	 *  
	 */
	public void testVacasIguales() {

		Vaca v = new Vaca("manola", 4, new Persona("Federico", 55));
		System.out.println("Vacas iguales a\n" + v.toString() + "\n"
		                + granja.vacasIgualesA(v));

	}

	public static void main(String[] args) {

		DemoGranja demo = new DemoGranja();
		demo.testGranja();
		demo.testBorrarGatos();
		demo.testVacasIguales();
	}

}
