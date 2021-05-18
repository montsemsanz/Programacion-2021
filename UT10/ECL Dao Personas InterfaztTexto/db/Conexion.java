package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Representa una conexión a una BD a través de JDBC. La modelamos como una
 * clase con métodos estáticos Sigue el patrón Singleton
 */
public class Conexion {

	private static final String BD = "bdpersonas";
	private static final String USUARIO = "pepe";
	private static final String PASSWORD = "pepa";
	private static Connection conexion = null;

	/**
	 * Constructor privado para evitar crear objetos de esta clase
	 */
	private Conexion() {

	}

	public static Connection getConexion() {
		if (conexion == null) {
			try {
				// Obtener conexión a la BD
				conexion = DriverManager.getConnection(
				                    "jdbc:mysql://localhost/" + BD, USUARIO,
				                    PASSWORD);
			}
			catch (SQLException exc) {
				System.out.println("Error estableciendo conexión JDBC: "
				                    + exc.toString());
			}
		}
		return conexion;

	}

	/**
	 * 
	 */
	public static void closeConexion(Connection con) {
		try {
			if (!con.isClosed()) {
				con.close();
			}
		}
		catch (SQLException exc) {
			System.out.println("Error cerrando conexión  JDBC  : "
			                    + exc.toString());
		}
	}

}