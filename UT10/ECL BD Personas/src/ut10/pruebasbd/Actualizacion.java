
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actualizacion {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";
	private Scanner teclado;
	private Connection conexion;

	public Actualizacion() {

		teclado = new Scanner(System.in);
	}

	/**
	 * carga del driver y conexión con la BD
	 */
	public void conectar() {

		try {

			// Obtener conexión a la BD
			conexion = DriverManager.getConnection(
			                    "jdbc:mysql://localhost/" + BD, USUARIO,
			                    PASSWORD);
			System.out.println("Conexión establecida con la BD " + BD);
			System.out.println();
		}
		catch (SQLException e) {
			System.out.println("Error estableciendo conexión JDBC: "
			                    + e.toString());
		}

	}

	/**
	 * insertar un nuevo registro en la BD
	 */
	public void ejecutarConsultaActualizacion1() {

		Statement st = null;

		try {
			// Insertar una nueva persona Santiago Segura 42 c h
			String sql = "INSERT INTO personas  VALUES (null, 'Santiago', 'Segura', 42, 'c', 'h')";
			System.out.println(sql);
			// Preparar una sentencia Statement desde la conexión para enviar y
			// ejecutar sentencias SQL
			st = conexion.createStatement();
			// Ejecutar la consulta
			st.executeUpdate(sql); // devuelve el nº de filas afectadas, si no
			// nos interesa ignoramos este valor
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				st.close();

			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
			catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	/**
	 * actualizar la edad de la persona anterior (localizar dando el apellido)
	 */
	public void ejecutarConsultaActualizacion2() {

		Statement st = null;

		try {
			// preparar consulta de modificación SQL como String
			String sql = "UPDATE personas  SET edad = 45 WHERE apellido = 'Segura' ";
			st = conexion.createStatement();
			st.executeUpdate(sql); // devuelve el nº de filas afectada, si no
			// nos interesa ignoramos este valor
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				st.close();

			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
			catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	/**
	 * borrar la persona con el apellido anterior
	 */
	public void ejecutarConsultaActualizacion3() {

		Statement st = null;

		try {
			// preparar consulta de borrado
			String sql = "DELETE FROM personas  WHERE apellido = 'Segura' ";
			st = conexion.createStatement();
			st.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				st.close();

			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
			catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	/**
	 * Contar el total de personas en la BD
	 */
	public void ejecutarConsultaSeleccion() {

		Statement st = null;
		ResultSet rs = null;
		try {

			st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			                    ResultSet.CONCUR_UPDATABLE);
			// preparar consulta para listar todas las personas en la BD
			String sql = "SELECT * FROM personas";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(String.format("%-20s %-20s",
				                    rs.getString("apellido"),
				                    rs.getString("nombre")));
			}

			// muestro ahora solo la primera persona del conjunto de resultados
			System.out.println("Primera persona");
			rs.first();
			System.out.println(String.format("%-20s %-20s",
			                    rs.getString("apellido"),
			                    rs.getString("nombre")));
			// preparar consulta para contar el total de personas en la BD
			sql = "SELECT COUNT(*) AS 'Total_Personas' FROM personas";
			rs = st.executeQuery(sql);
			rs.next();
			int totalPersonas = rs.getInt("Total_Personas");
			System.out.println("\nTotal personas en la BD "
			                    + totalPersonas);

		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				st.close();
				rs.close();
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
			catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	public void cerrarConexion() {

		try {
			conexion.close();
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

	public static void main(String[] args) {

		Actualizacion demo = new Actualizacion();
		demo.conectar();
		demo.ejecutarConsultaSeleccion();

//		demo.ejecutarConsultaActualizacion1();
//		demo.ejecutarConsultaSeleccion();

//		demo.ejecutarConsultaActualizacion2();
//		demo.ejecutarConsultaSeleccion();

		demo.ejecutarConsultaActualizacion3();
		demo.ejecutarConsultaSeleccion();

		demo.cerrarConexion();

	}

}
