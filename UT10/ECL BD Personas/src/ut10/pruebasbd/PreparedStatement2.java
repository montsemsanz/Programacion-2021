
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement2 {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";
	private Connection conexion;

	public PreparedStatement2() {

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
	 * actualizar las personas con un apellido determinado a un ecivil determinado
	 */
	public void ejecutarConsultaActualizacion() {

		PreparedStatement pst = null;

		try {
			String sql = "UPDATE personas SET eCivil = ? WHERE apellido = ?";
			pst = conexion.prepareStatement(sql);
			pst.setString(1, "c");
			pst.setString(2, "Redrado");

			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				pst.close();

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

		PreparedStatement2 demo = new PreparedStatement2();
		demo.conectar();
		demo.ejecutarConsultaActualizacion();
		demo.cerrarConexion();

	}

}
