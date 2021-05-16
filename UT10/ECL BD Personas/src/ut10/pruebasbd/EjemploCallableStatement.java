
package ut10.pruebasbd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `sumarEdades`(in gen varchar(1),
 * out suma integer) BEGIN
 * 
 * set suma = 0; select sum(edad) from personas where genero = gen into suma;
 * 
 * END
 * 
 * CREATE DEFINER=`root`@`localhost` FUNCTION `sumarEdadesFun`(gen varchar(1))
 * RETURNS int(11) DETERMINISTIC
 * BEGIN declare suma integer default 0; select sum(edad) from
 * personas where genero = gen into suma; RETURN suma; END
 * 
 * 
 */
public class EjemploCallableStatement {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "root";
	private final static String PASSWORD = "root";
	private Connection conexion;

	public EjemploCallableStatement() {

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

	public void ejecutarProcedimientoAlmacenado() throws SQLException {

		CallableStatement cst = null;
		try {
			String sql = "{ CALL sumarEdades(?, ?) }";
			cst = conexion.prepareCall(sql);
			cst.setString(1, "h");
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
			int suma = cst.getInt(2);
			System.out.println("La suma es: " + suma);
		}
		finally {
			cst.close();
		}

	}

	public void ejecutarFuncion() throws SQLException {

		CallableStatement cst = null;
		try {
			String sql = "{ ? = CALL sumarEdadesFun(?) }";
			cst = conexion.prepareCall(sql);
			cst.setString(2, "h");
			cst.registerOutParameter(1, Types.INTEGER);
			cst.execute();
			int suma = cst.getInt(1);
			System.out.println("La suma es: " + suma);
		}
		finally {
			cst.close();
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

	public static void main(String[] args) throws SQLException {

		EjemploCallableStatement demo = new EjemploCallableStatement();
		demo.conectar();
		demo.ejecutarProcedimientoAlmacenado();
		demo.ejecutarFuncion();
		demo.cerrarConexion();

	}

}
