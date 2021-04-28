
package pkgcuadrosdialogo;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class EjemplosCuadrosDialogo extends Application
{

	private Button btnInformacion;
	private Button btnWarning;
	private Button btnError;
	private Button btnConfirmacion;
	private Button btnConfirmacionOpcion;
	private Button btnTextInput;
	private Button btnFileChooser;
	private Button btnChoiceDialog;
	private ColorPicker selectorColor;

	@Override
	public void start(Stage stage) {

		GridPane root = crearGui();

		Scene scene = new Scene(root, 700, 400);

		stage.setScene(scene);
		stage.setTitle(
		                "- Ejemplo Cuadros diálogo standard -  Alert y FileChooser -");
		stage.show();
	}

	private GridPane crearGui() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);
		panel.setVgap(8);
		panel.setHgap(8);

		btnInformacion = new Button("Alert Mensaje Information");
		btnInformacion.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnInformacion.setPrefWidth(175);
		GridPane.setHgrow(btnInformacion, Priority.ALWAYS);
		GridPane.setVgrow(btnInformacion, Priority.ALWAYS);
		btnInformacion.setOnAction(e -> alertInformation());

		btnWarning = new Button("Alert Mensaje Warning");
		btnWarning.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnWarning.setPrefWidth(175);
		GridPane.setHgrow(btnWarning, Priority.ALWAYS);
		GridPane.setVgrow(btnWarning, Priority.ALWAYS);
		btnWarning.setOnAction(e -> alertWarning());

		btnConfirmacion = new Button("Alert Mensaje Confirmación");
		btnConfirmacion.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnConfirmacion.setPrefWidth(175);
		GridPane.setHgrow(btnConfirmacion, Priority.ALWAYS);
		GridPane.setVgrow(btnConfirmacion, Priority.ALWAYS);
		btnConfirmacion.setOnAction(e -> alertConfirmacion());

		btnConfirmacionOpcion = new Button(
		                "Alert Mensaje Confirmación Opciones");
		btnConfirmacionOpcion.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnConfirmacionOpcion.setPrefWidth(175);
		GridPane.setHgrow(btnConfirmacionOpcion, Priority.ALWAYS);
		GridPane.setVgrow(btnConfirmacionOpcion, Priority.ALWAYS);
		btnConfirmacionOpcion.setOnAction(e -> alertConfirmacionOpcion());

		btnError = new Button("Alert Mensaje Error");
		btnError.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnError.setPrefWidth(175);
		GridPane.setVgrow(btnError, Priority.ALWAYS);
		GridPane.setHgrow(btnError, Priority.ALWAYS);
		btnError.setOnAction(e -> alertError());

		btnTextInput = new Button("TextInputDialog - Entrada de datos");
		btnTextInput.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnTextInput.setPrefWidth(175);
		GridPane.setHgrow(btnTextInput, Priority.ALWAYS);
		GridPane.setVgrow(btnTextInput, Priority.ALWAYS);
		btnTextInput.setOnAction(e -> entradaDatos());

		btnFileChooser = new Button("FileChooser");
		btnFileChooser.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnFileChooser.setPrefWidth(175);
		GridPane.setHgrow(btnFileChooser, Priority.ALWAYS);
		GridPane.setVgrow(btnFileChooser, Priority.ALWAYS);
		btnFileChooser.setOnAction(e -> usarFileChooser());

		selectorColor = new ColorPicker(Color.RED);
		selectorColor.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		selectorColor.setPrefWidth(175);
		GridPane.setHgrow(selectorColor, Priority.ALWAYS);
		GridPane.setVgrow(selectorColor, Priority.ALWAYS);
		selectorColor.setOnAction(e -> usarColorPicker(selectorColor));

		btnChoiceDialog = new Button("ChoiceDialog");
		btnChoiceDialog.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnChoiceDialog.setPrefWidth(175);
		GridPane.setHgrow(btnChoiceDialog, Priority.ALWAYS);
		GridPane.setVgrow(btnChoiceDialog, Priority.ALWAYS);
		btnChoiceDialog.setOnAction(e -> usarChoiceDialog());

		panel.add(btnInformacion, 0, 0);
		panel.add(btnWarning, 1, 0);
		panel.add(btnError, 2, 0);
		panel.add(btnConfirmacion, 0, 1);
		panel.add(btnConfirmacionOpcion, 1, 1);
		panel.add(btnTextInput, 2, 1);
		panel.add(btnFileChooser, 0, 2);
		panel.add(selectorColor, 1, 2);
		panel.add(btnChoiceDialog, 2, 2);

		return panel;

	}

	private void usarColorPicker(ColorPicker selector) {

		Color color = selector.getValue();
		String hex = "#" + Integer.toHexString(color.hashCode());
		btnInformacion.setStyle("-fx-background-color:" + hex);
		// BackgroundFill fill = new BackgroundFill(selector.getValue(), null,
		// null);
		// btnInformacion.setBackground(new Background(fill));

		System.out.println("Color elegido " + color.toString());
	}

	private void usarFileChooser() {

		FileChooser selector = new FileChooser();
		selector.setTitle("Abrir fichero de datos");
		selector.setInitialDirectory(new File("."));
		selector.getExtensionFilters()
		                .addAll(new ExtensionFilter("java", "*.java"));
		File f = selector.showOpenDialog(null);
		if (f != null) {
			System.out.println("Fichero elegido: " + f.getName());
		}

		selector.setTitle("Salvar fichero de datos");
		f = selector.showSaveDialog(null);
		if (f != null) {
			System.out.println("Fichero guardado: " + f.getName());
		}
	}

	private void entradaDatos() {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("TextInputDialog - Entrada de datos");
		dialog.setHeaderText(null);
		dialog.setContentText("Teclee nombre:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String nombre = result.get();
			if (!nombre.isEmpty()) {
				System.out.println("Su nombre es: " + nombre);
			}
			else {
				System.out.println("No ha tecleado nada");
			}
		}
		else {
			System.out.println("Ha pulsado Cancel");
		}
	}

	private void alertError() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Mensaje de error!");
		alert.setHeaderText(null);
		alert.setContentText("Fallo del programa");
		alert.showAndWait();
	}

	private void alertWarning() {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Aviso al usuario");
		alert.setHeaderText(null);
		alert.setContentText(
		                "�rea de contenido - \nWarning: Teclee un valor num�rico");
		alert.showAndWait();
	}

	private void alertInformation() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("T�tulo - Mensaje informativo al usuario");
		alert.setHeaderText("�rea de cabecera - Mensaje");
		alert.setContentText(
		                "�rea de contenido - \nAviso para el usuario: Teclee un valor correcto");
		alert.showAndWait();
	}

	private void alertConfirmacion() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Cuadro di�logo confirmaci�n");
		alert.setHeaderText(null);
		alert.setContentText("Desea continuar?");
		Optional<ButtonType> respuesta = alert.showAndWait();
		if (respuesta.get() == ButtonType.OK) {
			System.out.println("OK");
		}
		else {
			System.out.println(
			                "El usuario ha pulsado Cancelar o ha cerrado el cuadro de di�logo");
		}
	}

	private void alertConfirmacionOpcion() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(
		                "Cuadro di�logo confirmaci�n con opciones personalizadas");
		alert.setHeaderText("Le ha gustado esta p�gina?");
		ButtonType btnMucho = new ButtonType("Mucho");
		ButtonType btnBastante = new ButtonType("Bastante");
		ButtonType btnNada = new ButtonType("Nada");
		ButtonType btnCancel = new ButtonType("Cancel",
		                ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(btnMucho, btnBastante, btnNada,
		                btnCancel);
		Optional<ButtonType> respuesta = alert.showAndWait();
		if (respuesta.get() == btnMucho) {
			System.out.println("Usuario ha elegido mucho");
		}
		else if (respuesta.get() == btnBastante) {
			System.out.println("Usuario ha elegido bastante");
		}
		else if (respuesta.get() == btnNada) {
			System.out.println("Usuario ha elegido nada");
		}
		else {
			System.out.println(
			                "Usuario ha pulsado Cancel o cerrado el cuadro de di�logo");
		}
	}

	private void usarChoiceDialog() {

		List<String> opciones =
		                Arrays.asList("Mucho", "Bastante", "Poco", "Nada");
		ChoiceDialog<String> dialogo = new ChoiceDialog<>("Mucho", opciones);
		dialogo.setTitle("Ejemplo ChoiceDialog");
		dialogo.setHeaderText("Seleccione opción");
		dialogo.setContentText("Le ha gustado esta página?");
		Optional<String> resul = dialogo.showAndWait();
		if (resul.isPresent()) {
			String opcion = resul.get();
			System.out.println("Opción elegida " + opcion);
		}
		else {
			System.out.println("Se ha pulsado Cancel");
		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
