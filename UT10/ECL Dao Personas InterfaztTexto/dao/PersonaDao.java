package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import modelo.Persona;

/**
 * 
 * 
 * @author
 * @version
 */
public class PersonaDao {

	/**
	 * Constructor
	 */
	public PersonaDao() {

	}

	/**
	 * 
	 * devuelve la relación de personas en la BD
	 * 
	 */
	public List<Persona> getPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		try {
			Connection con = Conexion.getConexion();
			String sql = "SELECT * FROM personas";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personas.add(aPersona(rs));
			}
			rs.close();
			pst.close();
		}
		catch (SQLException e) {
			System.out.println("SQL Excepción:" + e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personas;
	}

	/**
	 * 
	 */
	private Persona aPersona(ResultSet rs) {
		Persona p = null;
		try {
			p = new Persona(rs.getInt("idPersona"), rs.getString(2),
			                    rs.getString("apellido"), rs.getInt("edad"),
			                    rs.getString("eCivil").charAt(0),
			                    rs.getString(6).charAt(0));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}

	/**
	 * 
	 * devuelve la relación de personas con edad menor que la indicada
	 * 
	 */
	public List<Persona> personasMenoresDe(int edad) {
		List<Persona> personas = new ArrayList<Persona>();
		try {
			Connection con = Conexion.getConexion();
			String sql = "SELECT * FROM personas WHERE edad < ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, edad);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personas.add(aPersona(rs));
			}
			rs.close();
			pst.close();
		}
		catch (SQLException e) {
			System.out.println("SQL Exception:" + e.getMessage());

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personas;
	}

	/**
	 * 
	 * añade una nueva persona a la BD
	 * 
	 */
	public void guardarPersona(Persona p) {
		try {
			Connection con = Conexion.getConexion();
			String sql = "INSERT INTO personas (nombre, apellido, edad, eCivil, genero) "
			                    + " VALUES (?, ?, ?, ?, ?)";

			// Statement.RETURN_GENERATED_KEYS nos devuelve el id de la Persona que la BD
			// generará y asignará a la nueva fila de persona
			PreparedStatement pst = con.prepareStatement(sql,
			                    Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido());
			pst.setInt(3, p.getEdad());
			pst.setString(4, p.getEstadoCivil() + "");
			pst.setString(5, p.getGenero() + "");
			pst.executeUpdate();

			pst.close();
		}
		catch (SQLException e) {
			System.out.println("SQL Exception:" + e.getMessage());

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * borrar la persona con un determinado apellido
	 * 
	 */
	public void borrarPersonaPorApellido(String apellido) {
		try {
			Connection con = Conexion.getConexion();
			String sql = "DELETE FROM personas WHERE UPPER(apellido) LIKE ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + apellido.toUpperCase() + "%");
//			System.out.println(pst.toString());
			pst.executeUpdate();

			pst.close();
		}
		catch (SQLException e) {
			System.out.println("SQL Exception:" + e.getMessage());

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * borrar la persona con un determinado id
	 * 
	 */
	public void borrarPersonaPorId(int id) {
		try {
			Connection con = Conexion.getConexion();
			String sql = "DELETE FROM personas WHERE idPersona = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
//			System.out.println(pst.toString());
			pst.executeUpdate();

			pst.close();
		}
		catch (SQLException e) {
			System.out.println("SQL Exception:" + e.getMessage());

		}
		catch (Exception e) {
			System.out.println("SQL Exception:" + e.getMessage());
		}
	}

}
