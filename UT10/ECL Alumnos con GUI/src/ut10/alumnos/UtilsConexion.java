
package ut10.alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Clase de utilidades La modelamos como una clase con métodos estáticos
 * 
 */
public class UtilsConexion {

	private static final String BD = "bdalumnado";
	private static final String USUARIO = "pepe";
	private static final String PASSWORD = "pepa";

	/**
	 * 
	 */
	public static Connection getConexion() {

		Connection conexion = null;

		try {
			  
			// Obtener conexión a la BD
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + BD, USUARIO, PASSWORD);
			// System.out
			// .println("Conexión establecida con la Base de datos " + BD);
		} catch (SQLException exc) {
			System.out.println("Error estableciendo conexión JDBC: " + exc.toString());
		} 

		return conexion;

	}

	/**
	 * 
	 */
	public static void closeConexion(Connection conexion) {

		try {
			if (!conexion.isClosed()) {
				conexion.close();

			}
		} catch (SQLException exc) {
			System.out.println("Error cerrando conexión  JDBC  : " + exc.toString());
		}

	}

	/**
	* 
	*/
	public static void closeStatement(Statement statement) {

		try {
			if (statement != null) {
				statement.close();

			}
		} catch (SQLException exc) {
			System.out.println("Error cerrando statement  : " + exc.toString());
		}

	}

	/**
	* 
	*/
	public static void closeResultSet(ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();

			}
		} catch (SQLException exc) {
			System.out.println("Error cerrando resultSet  : " + exc.toString());
		}
	}

}