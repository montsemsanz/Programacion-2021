
package ut9.factorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiFactorial extends Application
{

	private TextField txtNumero;
	private Label lblResultado;
	private Button btnFactorial;
	private Button btnPrimo;
	private Button btnClear;
	private Button btnSalir;
	private MenuItem itmFactorial;
	private MenuItem itmPrimo;
	private MenuItem itmClear;
	private MenuItem itmSalir;

	private Numero numero; // el modelo

	@Override
	public void start(Stage primaryStage) {

		numero = new Numero();
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(
		                getClass().getResource("application.css")
		                                .toExternalForm());
		cogerFoco();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Numero - Factorial y primo");
		primaryStage.show();

	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setTop(crearBarraMenu());
		panel.setCenter(crearPanelPrincipal());
		return panel;
	}

	private MenuBar crearBarraMenu() {

		MenuBar barra = new MenuBar();
		barra.setId("barramenu");
		Menu menu = new Menu("Opciones");
		barra.getMenus().add(menu);

		itmFactorial = new MenuItem("Factorial");
		itmFactorial.setOnAction(event -> factorial());
		itmPrimo = new MenuItem("_Primo");
		itmPrimo.setOnAction(event -> primo());
		itmClear = new MenuItem("_Clear");
		itmClear.setOnAction(event -> clear());
		itmSalir = new MenuItem("_Salir");
		itmSalir.setOnAction(event -> salir());
		menu.getItems().addAll(itmFactorial, itmPrimo, itmClear,
		                new SeparatorMenuItem(), itmSalir);

		return barra;
	}

	private BorderPane crearPanelPrincipal() {

		BorderPane panel = new BorderPane();

		VBox pnlBotones = crearPanelBotones();
		panel.setRight(pnlBotones);

		BorderPane pnlCentral = crearPanelCentral();
		panel.setCenter(pnlCentral);
		return panel;
	}

	private BorderPane crearPanelCentral() {

		BorderPane panel = new BorderPane();

		txtNumero = new TextField();
		txtNumero.setOnAction(event -> factorial());

		panel.setTop(txtNumero);

		lblResultado = new Label("Aquí se mostrará el resultado");
		lblResultado.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		lblResultado.setId("resultado");
		panel.setCenter(lblResultado);

		return panel;
	}

	private VBox crearPanelBotones() {

		VBox panel = new VBox();
		panel.setPadding(new Insets(5, 10, 5, 10));
		panel.setSpacing(10);

		btnFactorial = new Button("_Factorial");

		btnFactorial.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnFactorial.setOnAction(event -> factorial());

		btnPrimo = new Button("_Primo");
		btnPrimo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnPrimo.setOnAction(event -> primo());

		btnClear = new Button("_Clear");
		btnClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnClear.setOnAction(event -> clear());

		btnSalir = new Button("_Salir");
		btnSalir.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnSalir.setOnAction(event -> salir());

		VBox.setVgrow(btnFactorial, Priority.ALWAYS);
		VBox.setVgrow(btnPrimo, Priority.ALWAYS);
		VBox.setVgrow(btnClear, Priority.ALWAYS);
		VBox.setVgrow(btnSalir, Priority.ALWAYS);
		panel.getChildren().addAll(btnFactorial, btnPrimo, btnClear, btnSalir);

		return panel;
	}

	private void salir() {

		Platform.exit();

	}

	private void clear() {

		lblResultado.setText("");
		cogerFoco();

	}

	private void primoV2() {

		String strNumero = txtNumero.getText();
		if (strNumero.isEmpty()) {
			lblResultado.setText("Teclee un valor");
		}
		else {
			try {
				int num = Integer.parseInt(strNumero);
				numero.setNumero(num);
				lblResultado.setText("Número primo? " + numero.esPrimo());

			}
			catch (NumberFormatException e) {
				lblResultado.setText("Teclee un valor numérico");
			}
		}
		cogerFoco();

	}

	private void factorialV2() {

		String strNumero = txtNumero.getText();
		if (strNumero.isEmpty()) {
			lblResultado.setText("Teclee un valor");
		}
		else {
			try {
				int num = Integer.parseInt(strNumero);
				numero.setNumero(num);
				lblResultado.setText("Factorial " + numero.factorial());

			}
			catch (NumberFormatException e) {
				lblResultado.setText("Teclee un valor numérico");
			}
		}
		cogerFoco();

	}

	private void primo() {

		if (esNumeroCorrecto()) {
			lblResultado.setText("Es primo? " + numero.esPrimo());
		}

		cogerFoco();

	}

	private void factorial() {

		if (esNumeroCorrecto()) {
			lblResultado.setText("Factorial " + numero.factorial());
		}
		cogerFoco();

	}

	private boolean esNumeroCorrecto() {

		boolean correcto = true;
		String strNumero = txtNumero.getText();
		if (strNumero.isEmpty()) {

			lblResultado.setText("Introduzca número");
			correcto = false;

		}
		else {
			try {

				int n = Integer.parseInt(strNumero);
				numero.setNumero(n);

			}
			catch (NumberFormatException ex) {
				lblResultado.setText("Introduzca número correcto");
				correcto = false;
			}

		}
		return correcto;
	}

	private void cogerFoco() {

		txtNumero.requestFocus();
		txtNumero.selectAll();

	}

	public static void main(String[] args) {

		launch(args);
	}
}
