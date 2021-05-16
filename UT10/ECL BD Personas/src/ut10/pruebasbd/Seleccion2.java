
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Seleccion2 {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";
	private Scanner teclado;
	private Connection conexion;

	public Seleccion2() {

		teclado = new Scanner(System.in);
	}

	/**
	 * carga del driver y conexión con la BD
	 */
	public void conectar() {

		try {
			
			// Obtener conexión a la BD
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + BD, USUARIO, PASSWORD);
			System.out.println("Conexión establecida con la BD " + BD);
			System.out.println();
		}  catch (SQLException e) {
			System.out.println("Error estableciendo conexión JDBC: " + e.toString());
		}

	}

	/**
	 * Ejecutar la consulta de selección: obtener nombre apellido edad y estado
	 * civil mostrando nombres de columnas de los hombres con edad > [edad leída por
	 * teclado] ordenado por apellido
	 * 
	 * Si no hay resultados se muestra el mensaje "No hay ninguna coincidencia"
	 */
	public void ejecutarConsultaSeleccion2() {

		Statement st = null;
		ResultSet rs = null;
		try {
			System.out.println("Teclee edad");
			int edad = teclado.nextInt();
			String sql = "SELECT nombre, apellido, edad, eCivil FROM personas WHERE genero = 'h' AND edad >  " + edad
					+ " ORDER BY apellido, nombre";
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				ResultSetMetaData md = rs.getMetaData();
				System.out.println(String.format("%-20s %-20s %7s %10s\n", md.getColumnName(2).toUpperCase(),
						md.getColumnName(1).toUpperCase(), md.getColumnName(3).toUpperCase(),
						md.getColumnName(4).toUpperCase()));
				while (rs.next()) {

					String apellido = rs.getString("apellido");
					String nombre = rs.getString(1);
					int ed = rs.getInt("edad");
					char estado = rs.getString(4).charAt(0);
					System.out.println(String.format("%-20s %-20s %7d %5c ", apellido, nombre, ed, estado));
				}

			} else {
				System.out.println("No hay ninguna coincidencia");
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			} catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	/**
	 * Ejecutar la consulta de selección: mostrar el total de hombres en la BD
	 * 
	 */
	public void ejecutarConsultaSeleccion3() {

		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT count(*) as 'Total hombres' FROM personas WHERE genero = 'h'";
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println(
				                rs.getMetaData().getColumnName(1) + ": "
				                                + rs.getInt(1));
			}
			 
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			} catch (NullPointerException e) {
				System.out.println(e.toString());
			}
		}

	}

	public void cerrarConexion() {

		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

	public static void main(String[] args) {

		Seleccion2 demo = new Seleccion2();
		demo.conectar();
		demo.ejecutarConsultaSeleccion2();
		demo.ejecutarConsultaSeleccion3();
		demo.cerrarConexion();

	}

}
