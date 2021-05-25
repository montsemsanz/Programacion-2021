
package ut10.alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiAlumnos extends Application {

	private TextArea area;
	private TextField txtNombre;
	private TextField txtApellido;
	private Button btnBuscar;
	private RadioButton rbtAscendente;
	private RadioButton rbtDescendente;
	private CheckBox cbxPendiente;
	private Button btnListar;

	@Override
	public void start(Stage stage) {

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 600, 550);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo BD Alumnos GUI JavaFX -");
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		stage.show();
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setTop(crearPanelBusqueda());

		area = new TextArea();
		panel.setCenter(area);

		panel.setBottom(crearPanelListados());
		return panel;
	}

	private VBox crearPanelBusqueda() {

		VBox panel = new VBox();
		panel.getStyleClass().add("vbox");
		panel.setPadding(new Insets(7));
		Label lblTitulo = new Label("Panel de búsqueda");
		lblTitulo.setMaxWidth(Integer.MAX_VALUE);
		lblTitulo.getStyleClass().add("titulo");
		panel.getChildren().add(lblTitulo);
		panel.getChildren().add(crearGridBusqueda());

		return panel;
	}

	private GridPane crearGridBusqueda() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		panel.setHgap(10);
		panel.setVgap(10);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(40);
		col1.setHalignment(HPos.RIGHT);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(60);
		panel.getColumnConstraints().addAll(col1, col2);

		panel.add(new Label("Nombre"), 0, 0);
		txtNombre = new TextField();
		panel.add(txtNombre, 1, 0);
		panel.add(new Label("Apellido"), 0, 1);
		txtApellido = new TextField();
		panel.add(txtApellido, 1, 1);
		btnBuscar = new Button("Buscar");
		btnBuscar.setDefaultButton(true);
		btnBuscar.setMaxWidth(Integer.MAX_VALUE);
		btnBuscar.setOnAction(event -> buscar());
		panel.add(btnBuscar, 1, 2);
		return panel;
	}

	private void buscar() {

		String nombre = txtNombre.getText();
		TextField txtFoco = txtNombre;
		if (nombre.isEmpty()) {
			mostrarMensaje("Teclee nombre");

		} else {
			String apellido = txtApellido.getText();
			if (apellido.isEmpty()) {
				mostrarMensaje("Teclee apellido");
				txtFoco = txtApellido;
			} else {
				mostrarDatos(nombre, apellido);
			}
		}
		cogerFoco(txtFoco);
	}

	private void mostrarDatos(String nombre, String apellido) {

		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM alumnos WHERE nombre = ? AND apellido = ?";
		try {
			pst = conexion.prepareStatement(sql);
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			rs = pst.executeQuery();

			if (rs.isBeforeFirst()) {
				ResultSetMetaData rsm = rs.getMetaData();
				String strCabecera = String.format("%-20s%-20s%-20s%20s", rsm.getColumnName(3).toUpperCase(),
						rsm.getColumnName(2).toUpperCase(), rsm.getColumnName(4).toUpperCase(),
						rsm.getColumnName(5).toUpperCase());
				area.setText(strCabecera + "\n");
				while (rs.next()) {
					String strFormateada = String.format("%-25s%-25s%-25d%25s", rs.getString(3), rs.getString(2),
							rs.getInt(4), rs.getString(5));
					area.appendText(strFormateada);
				}

			} else {
				area.setText("No hay coincidencias");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		UtilsConexion.closeConexion(conexion);
		UtilsConexion.closeStatement(pst);
		UtilsConexion.closeResultSet(rs);

	}

	private void mostrarMensaje(String mensaje) {

		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);
		alerta.showAndWait();

	}

	public void cogerFoco(TextField txt) {

		txt.requestFocus();
		txt.selectAll();
	}

	private VBox crearPanelListados() {

		VBox panel = new VBox();
		panel.setPadding(new Insets(7));
		panel.getStyleClass().add("vbox");
		Label lblTitulo = new Label("Panel Listados");
		lblTitulo.setMaxWidth(Integer.MAX_VALUE);
		lblTitulo.getStyleClass().add("titulo");
		panel.getChildren().add(lblTitulo);
		panel.getChildren().add(crearGridListados());

		return panel;
	}

	private GridPane crearGridListados() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		panel.setHgap(10);
		panel.setVgap(10);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(50);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(50);
		panel.getColumnConstraints().addAll(col1, col2);

		rbtAscendente = new RadioButton("Ascendente");
		rbtAscendente.setSelected(true);
		rbtDescendente = new RadioButton("Descendente");
		ToggleGroup grupo = new ToggleGroup();
		rbtAscendente.setToggleGroup(grupo);
		rbtDescendente.setToggleGroup(grupo);

		cbxPendiente = new CheckBox("Pendiente");
		btnListar = new Button("Listar");
		btnListar.setMaxWidth(Integer.MAX_VALUE);
		btnListar.setOnAction(event -> listar());

		panel.add(rbtAscendente, 0, 0);
		panel.add(rbtDescendente, 1, 0);
		panel.add(cbxPendiente, 0, 1);
		panel.add(btnListar, 1, 1);

		return panel;
	}

	private void listar() {

		String cabecera = "Listado de alumnos";
		Connection conexion = UtilsConexion.getConexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT nombre, apellido, nota FROM alumnos ";
			if (cbxPendiente.isSelected()) {
				sql = sql + "WHERE pendiente = 'SI' ";
				cabecera += " con asignaturas pendientes ";
			} else {
				sql = sql + "WHERE pendiente = 'NO' ";
				cabecera += " sin asignaturas pendientes ";
			}

			sql += " ORDER BY apellido ";
			if (rbtDescendente.isSelected()) {
				sql += "DESC";
				cabecera += "\nen orden descendente de apellido";
			} else if (rbtAscendente.isSelected()) {
				cabecera += "\nen orden ascendente de apellido";
			}
			System.out.println(sql);
			area.setText(cabecera + "\n");
			area.appendText("--------------------------------------------------\n");
			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {

				area.appendText(
						rs.getString("apellido") + ",\t" + rs.getString("nombre") + "\t" + rs.getInt("nota") + "\n");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		UtilsConexion.closeConexion(conexion);
		UtilsConexion.closeStatement(pst);
		UtilsConexion.closeResultSet(rs);
	}

	public static void main(String[] args) {

		launch(args);
	}
}
