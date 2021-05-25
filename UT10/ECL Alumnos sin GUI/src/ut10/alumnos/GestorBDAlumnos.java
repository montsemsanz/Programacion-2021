
package ut10.alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBDAlumnos {

	public GestorBDAlumnos() {

	}

	/**
	 * 
	 * Listar todos los datos de los alumnos (salvo el identificador) en orden
	 * ascendente de apellido y nombre Se muestra el listado con los nombres de las
	 * columnas etiquetadas en mayúsculas
	 * 
	 * Propaga las excepciones
	 * 
	 * @throws SQLException
	 */
	public void listarAlumnos() throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT nombre, apellido, nota, pendiente FROM alumnos ORDER BY apellido, nombre";
			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.printf("%-25s%-25s%8s%15s\n\n",
			                    rs.getMetaData().getColumnName(2).toUpperCase(),
			                    rs.getMetaData().getColumnName(1).toUpperCase(),
			                    rs.getMetaData().getColumnName(3).toUpperCase(),
			                    rs.getMetaData().getColumnName(4)
			                                        .toUpperCase());
			while (rs.next()) {
				System.out.printf("%-25s%-25s%5d%15s\n", rs.getString(2),
				                    rs.getString("nombre"), rs.getInt(3),
				                    rs.getString(4));

			}
		}
		finally {
			rs.close();
			pst.close();
			conexion.close();
		}

	}

	/**
	 * Muestra la cantidad de aprobados
	 * 
	 * Propaga las excepciones
	 */
	public void mostrarAprobados() throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT count(idAlumno) AS 'aprobados' FROM alumnos WHERE nota >= 5";
			pst = conexion.prepareStatement(sql,
			                    ResultSet.TYPE_SCROLL_INSENSITIVE,
			                    ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			rs.first();
			int aprobados = rs.getInt("aprobados");
			System.out.printf("%s: %4d\n",
			                    rs.getMetaData().getColumnName(1).toUpperCase(),
			                    aprobados);

		}
		finally {
			rs.close();
			pst.close();
			conexion.close();
		}
	}

	/**
	 * Muestra la nota media del curso
	 * 
	 * Propaga las excepciones
	 */
	public void mostrarMediaDelCurso() throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT ROUND(AVG(nota), 2)  AS 'Media curso' FROM alumnos";
			pst = conexion.prepareStatement(sql,
			                    ResultSet.TYPE_SCROLL_INSENSITIVE,
			                    ResultSet.CONCUR_UPDATABLE);
			rs = pst.executeQuery();
			rs.first();
			double media = rs.getDouble(1);
			System.out.printf("%10s: %6.2f\n",
			                    rs.getMetaData().getColumnName(1).toUpperCase(),
			                    media);

		}
		finally {
			rs.close();
			pst.close();
			conexion.close();
		}

	}

	/**
	 * Borra el alumno del apellido indicado. Si no existe se muestra un mensaje
	 * Propaga las excepciones
	 */
	public void bajaAlumno(String apellido) throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;

		try {
			String sql = "DELETE FROM alumnos WHERE apellido LIKE ?";
			pst = conexion.prepareStatement(sql);
			pst.setString(1, apellido);
			int borrados = pst.executeUpdate();
			if (borrados == 0) {
				System.out.println("No existe en la BD el apellido "
				                    + apellido);
			}

		}
		finally {

			pst.close();
			conexion.close();
		}

	}

	/**
	 * Da de alta a un alumno en la BD. Los datos del alumnos se reciben como
	 * argumentos. Observa que el dato de pendiente se recibe como boolean pero en
	 * la BD se guarda con String (SI o NO)
	 * 
	 * Propaga las excepciones
	 */
	public void altaAlumno(String nombre, String apellido, int nota,
	                    boolean pendiente) throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;

		try {
			String sql = "INSERT INTO alumnos VALUES (null, ?, ?, ?, ?)";
			pst = conexion.prepareStatement(sql);
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setInt(3, nota);
			String strPendiente = "no";
			if (pendiente) {
				strPendiente = "si";
			}
			pst.setString(4, strPendiente);
			pst.executeUpdate();

		}
		finally {

			pst.close();
			conexion.close();
		}

	}

	public static void main(String[] args) throws SQLException {

		GestorBDAlumnos gestor = new GestorBDAlumnos();
		gestor.listarAlumnos();
		gestor.mostrarAprobados();
		gestor.mostrarMediaDelCurso();
		gestor.bajaAlumno("santoyo");
		gestor.altaAlumno("Elena", "Santoyo", 3, true);
		gestor.listarAlumnos();

	}

}
