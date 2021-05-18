
package controlador;

import java.util.HashSet;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Genero;
import modelo.ListaPersonas;
import modelo.Persona;

public class ControladorPersonas
{

	private ListaPersonas lista; // añadimos el modelo

	@FXML
	private Label lblTitulo;

	@FXML
	private Button btnAdd;

	@FXML
	private Label lblNombre;

	@FXML
	private TextField txtNombre;

	@FXML
	private Label lblEdad;

	@FXML
	private TextField txtEdad;

	@FXML
	private RadioButton rbtHombre;

	@FXML
	private ToggleGroup genero;

	@FXML
	private RadioButton rbtMujer;

	@FXML
	private CheckBox cbxLectura;

	@FXML
	private CheckBox cbxBaile;

	@FXML
	private CheckBox cbxMonte;

	@FXML
	private CheckBox cbxCine;

	public ControladorPersonas() {

		super();
		lista = new ListaPersonas();


	}

	@FXML
	void addPersona(ActionEvent event) {

		TextField txt = txtNombre;
		String nombre = txtNombre.getText();
		if (nombre.isEmpty()) {
			mostrarMensaje("Teclee nombre", AlertType.WARNING);

		}
		else {
			String strEdad = txtEdad.getText();
			if (strEdad.isEmpty()) {
				mostrarMensaje("Teclee edad", AlertType.WARNING);
				txt = txtEdad;
			}
			else {
				try {
					int edad = Integer.parseInt(strEdad);
					Genero genero;
					if (rbtHombre.isSelected()) {
						genero = Genero
						                .valueOf(rbtHombre.getText()
						                                .toUpperCase());
					}
					else {
						genero = Genero
						                .valueOf(rbtMujer.getText()
						                                .toUpperCase());
					}
					Persona p = new Persona(nombre, edad, genero);
					Set<String> hobbies = obtenerHobbies();
					p.addHobbies(hobbies);
					lista.addPersona(p);
					mostrarMensaje("Se ha añadido una persona",
					                AlertType.INFORMATION);
					mostrarMensaje("Lista personas\n" + lista.toString(),
					                AlertType.INFORMATION);

				}
				catch (NumberFormatException e) {
					mostrarMensaje("Teclee edad numérica", AlertType.WARNING);
					txt = txtEdad;
				}

			}
		}
		cogerFoco(txt);

	}

	private Set<String> obtenerHobbies() {

		Set<String> hobbies = new HashSet<>();
		if (cbxLectura.isSelected()) {
			hobbies.add(cbxLectura.getText().toUpperCase());
		}
		if (cbxBaile.isSelected()) {
			hobbies.add(cbxBaile.getText().toUpperCase());
		}
		if (cbxMonte.isSelected()) {
			hobbies.add(cbxMonte.getText().toUpperCase());
		}
		if (cbxCine.isSelected()) {
			hobbies.add(cbxCine.getText().toUpperCase());
		}
		return hobbies;
	}

	private void mostrarMensaje(String mensaje, AlertType tipo) {

		Alert alerta = new Alert(tipo);
		alerta.setTitle("Aviso al usuario/a");
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);
		alerta.showAndWait();

	}

	private void cogerFoco(TextField txt) {

		txt.requestFocus();
		txt.selectAll();

	}

}

