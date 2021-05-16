
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Seleccion1 {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";
	private Connection conexion;

	public Seleccion1() {

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
		}   catch (SQLException e) {
			System.out.println("Error estableciendo conexión JDBC: " + e.toString());
		}

	}

	/**
	 * Ejecutar la consulta de selección: obtener nombre,apellido, edad de todas
	 * las personas
	 * 
	 */
	public void ejecutarConsultaSeleccion() {

		Statement st = null;
		ResultSet rs = null;
		try {
			// preparar consulta SQL como String
			String sql = "SELECT nombre, apellido, edad FROM personas";

			// Preparar una sentencia Statement desde la conexión para enviar y
			// ejecutar sentencias SQL
			st = conexion.createStatement();
			// Ejecutar la consulta y obtener el conjunto de resultados
			rs = st.executeQuery(sql);

			// Utilizamos metadatos para mostrar los nombres de las columnas de
			// la tabla y escribir la cabecera del listado
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(String.format("%-20s %-20s %7s\n", md.getColumnName(1).toUpperCase(),
					md.getColumnName(2).toUpperCase(), md.getColumnName(3).toUpperCase()));

			// Iterar sobre el conjunto de resultados
			while (rs.next()) {
				String nombre = rs.getString(1); // aquí a partir del nº de
				// columna
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				// System.out.println(id + "\t" + nombre + "\t\t\t" + apellido +
				// "\t\t\t" + edad + "\t" + estado + "\t" + genero) ;
				System.out.println(String.format("%-20s %-20s %7d", nombre, apellido, edad));

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

		Seleccion1 demo = new Seleccion1();
		demo.conectar();
		demo.ejecutarConsultaSeleccion();
		demo.cerrarConexion();

	}

}
