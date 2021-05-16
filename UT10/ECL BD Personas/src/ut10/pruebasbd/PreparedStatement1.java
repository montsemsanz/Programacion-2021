
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement1 {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";
	private Connection conexion;

	public PreparedStatement1() {

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
	 * Mostrar mujeres cuyo nombre empieza por E
	 */
	public void ejecutarConsultaSeleccion1() {

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// consulta sin parámetros
			String sql = "SELECT nombre, apellido  FROM personas WHERE nombre LIKE 'E%' AND genero = 'm'";
			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println(String.format("%-20s %-20s ",
			                    rs.getMetaData().getColumnName(1).toUpperCase(),
			                    rs.getMetaData().getColumnName(2)
			                                        .toUpperCase()));
			while (rs.next()) {

				String nombre = rs.getString(1);
				String apellido = rs.getString("apellido");
				System.out.println(String.format("%-20s %-20s ", nombre,
				                    apellido));
			}

		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				pst.close();
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

	/**
	 * Ejecutar consulta de selección con parámetros (mostrar hombres o mujeres
	 * [parámetro] cuyo nombre contenga [parámetro])
	 */
	public void ejecutarConsultaSeleccion2() {

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// consulta con parámetros
			String sql = "SELECT nombre, apellido FROM personas WHERE nombre LIKE ? AND genero = ?";

			pst = conexion.prepareStatement(sql);
			// antes de ejecutar la consulta establecemos los valores de los
			// parámetros
			pst.setString(1, "%a%");
			pst.setString(2, "m");
			rs = pst.executeQuery();

			// Utilizamos metadatos para mostrar los nombres de las columnas de
			// la tabla y escribir la cabecera dewl listado
			System.out.println(String.format("%-20s %-20s",
			                    rs.getMetaData().getColumnName(1).toUpperCase(),
			                    rs.getMetaData().getColumnName(2)
			                                        .toUpperCase()));

			// Iterar sobre el conjunto de resultados
			while (rs.next()) {
				String nombre = rs.getString(1); // aquí a partir del nº de
				                                // columna
				String apellido = rs.getString("apellido");
				System.out.println(String.format(" %-20s %-20s", nombre,
				                    apellido));
			}

		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
		finally {
			try {
				pst.close();
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

		PreparedStatement1 demo = new PreparedStatement1();
		demo.conectar();

		demo.ejecutarConsultaSeleccion1();

		demo.ejecutarConsultaSeleccion2();

		demo.cerrarConexion();

	}

}
