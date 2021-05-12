
package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Saludo;

public class ControladorPruebas
{

	private Saludo saludo;

	@FXML
	private Button btnIngles;

	@FXML
	private Label lblTexto;

	@FXML
	private TextField txtNombre;

	@FXML
	private Button btnOtroSaludo;

	@FXML
	private ToggleGroup grupo;

	@FXML
	private RadioButton rbtFrances;

	@FXML
	private RadioButton rbtIngles;

	public ControladorPruebas() {

		saludo = new Saludo();
	}

	@FXML
	void saludarFrances(ActionEvent event) {

		lblTexto.setText(saludo.saludarFrances());
	}

	@FXML
	void saludarIngles(ActionEvent event) {

		lblTexto.setText(saludo.saludarIngles());
	}

	@FXML
	void saludarPersonalizado(ActionEvent event) {

		String nombre = txtNombre.getText();
		if (nombre.isEmpty()) {
			txtNombre.setText("Teclee nombre");
		}
		else {
			if (rbtFrances.isSelected()) {
				lblTexto.setText(saludo.saludarFrancesPersonalizado(nombre));
			}
			else {
				lblTexto.setText(saludo.saludarInglesPersonalizado(nombre));
			}
		}

		cogerFoco();
	}

	private void cogerFoco() {

		txtNombre.requestFocus();
		txtNombre.selectAll();

	}

}