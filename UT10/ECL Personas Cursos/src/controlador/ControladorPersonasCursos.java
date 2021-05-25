
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modelo.UtilsConexion;

public class ControladorPersonasCursos {

	@FXML
	private TextField txtApellido;

	@FXML
	private Button btnBuscar;

	@FXML
	private TextArea area;
	@FXML
	private Label lblImagen;

	@FXML
	private ImageView img;

	@FXML
	public void initialize() {
		img.fitWidthProperty().bind(lblImagen.widthProperty());
		img.fitHeightProperty().bind(lblImagen.heightProperty());

	}

	@FXML
	void buscar(ActionEvent event) throws SQLException {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String apellido = txtApellido.getText();
		if (apellido.isEmpty()) {
			mostrarMensaje("Teclee apellido");
		}
		else {

			try {
				String sql = "SELECT nombre, apellido, nombreCurso FROM personas p\r\n"
				                    + "INNER JOIN (personas_cursos pc INNER JOIN  cursos c ON pc.idCurso = c.idCurso) "
				                    + "ON p.idPersona = pc.idPersona WHERE apellido LIKE ? ";
				pst = conexion.prepareStatement(sql);
				pst.setString(1, apellido + "%");

				rs = pst.executeQuery();
				// System.out.println(pst.toString());
				if (!rs.isBeforeFirst()) {
					area.setText("No hay coincidencias");

				}
				else {
					area.setText("Personas y cursos realizados\n\n");

					while (rs.next()) {
						System.out.println("x");
						area.appendText(rs.getString(2) + ", " + rs.getString(1)
						                    + " - " + rs.getString(3) + "\n");

					}
				}
			}
			finally {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {
					pst.close();
				}
				if (rs != null) {
					conexion.close();

				}

			}
		}

		llevarFoco();
	}

	private void mostrarMensaje(String string) {

		Alert alerta = new Alert(AlertType.WARNING);
		alerta.setHeaderText(null);
		alerta.setContentText("Teclee apellido");
		alerta.showAndWait();

	}

	private void llevarFoco() {

		txtApellido.requestFocus();
		txtApellido.selectAll();

	}

}
