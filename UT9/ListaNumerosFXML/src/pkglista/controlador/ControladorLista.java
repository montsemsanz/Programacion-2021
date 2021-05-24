
package pkglista.controlador;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import pkglista.modelo.Lista;

/**
 * https://stackoverflow.com/questions/34785417/javafx-fxml-controller-constructor-vs-initialize-method
 * @author Montse
 *
 */
public class ControladorLista
{

	@FXML
	private TextField txtNumero;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnBorrardePosicion;

	@FXML
	private Button btnBorrarDePosicion;

	@FXML
	private Button btnSalvar;

	@FXML
	private TextArea areaTexto;

	private Lista lista;



	public ControladorLista() throws IOException {

		this.lista = new Lista();
		this.lista.cargarDeFichero();
		System.out.println("en constructor");

	}

	@FXML
	public void initialize() {

		//		System.out.println("en initialize");
		//		System.out.println(btnAdd.getText());
		actualizarAreaTexto();

	}

	private void actualizarAreaTexto() {

		areaTexto.setText("");
		areaTexto.appendText(lista.toString());
		cogerFoco();


	}

	@FXML
	void add(ActionEvent event) {

		try {
			String texto = txtNumero.getText();
			if (texto.length() != 0) {
				int numero = Integer.parseInt(texto);
				lista.addNumero(numero);
				actualizarAreaTexto();

			}
			else {
				mostrarError("Teclee un valor");
			}
		}
		catch (NumberFormatException e) {

			mostrarError("Error al convertir nº, teclee valor numérico");
		}
		finally {
			cogerFoco();
		}

	}

	private void mostrarError(String mensaje) {

		Alert alerta = new Alert(AlertType.WARNING);
		alerta.setTitle("Aviso al usuario/a");
		alerta.setHeaderText(null);
		alerta.setContentText(mensaje);
		alerta.showAndWait();

	}

	@FXML
	void borrarDePosicion(ActionEvent event) {

		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Entrada de datos");
		dialogo.setHeaderText(null);
		dialogo.setContentText("Teclee posición");
		Optional<String> resul = dialogo.showAndWait();
		if (resul.isPresent()) {
			String valor = resul.get();
			if (valor.isEmpty()) {
				mostrarError("Introduzca una posición");
			}
			else {
				try {
					int pos = Integer.parseInt(resul.get());
					lista.borrarDePosicion(pos);
					actualizarAreaTexto();
				}
				catch (NumberFormatException e) {

					mostrarError("Introduzca una posición correcta");
				}
			}

		}
		else {
			mostrarError("Cancelada la entrada de datos");
		}

		cogerFoco();

	}

	@FXML
	void borrarRepetidos(ActionEvent event) {

		lista.borrarRepetidos();
		actualizarAreaTexto();
		cogerFoco();

	}

	@FXML
	void salvar(ActionEvent event) {

		try {
			lista.salvarEnFichero();
			System.out.println("salvado");
			cogerFoco();
		}
		catch (IOException e) {
			System.out.println("Error al salvar en fichero");
		}

	}

	/**
	 * llevar el foco a la caja de texto y seleccionar el texto
	 */
	private void cogerFoco() {

		txtNumero.requestFocus();
		txtNumero.selectAll();
	}

}
