
package ut9.maquina.interfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import ut9.maquina.modelo.MaquinaEscribir;

public class GuiMaquina extends Application
{

	private TextField txtTexto;
	private MaquinaEscribir maquina;

	@Override
	public void start(Stage stage) {

		maquina = new MaquinaEscribir(); // el modelo
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 600, 300);
		scene.getStylesheets().add(
		                getClass().getResource("/application.css")
		                                .toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Máquina de escribir");
		stage.show();
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setCenter(crearPanelBotones());
		panel.setBottom(crearPanelTexto());

		return panel;
	}

	private GridPane crearPanelBotones() {

		GridPane panel = new GridPane();
		// panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(5));

		String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int len = alfabeto.length();
		int fil = 0;
		for (int i = 0; i < len; i++) {
			char letra = alfabeto.charAt(i);
			Button btn = obtenerBoton(String.valueOf(letra));
			btn.setOnAction(event -> mostrarCaracter(letra));
			panel.add(btn, i % 8, fil);
			if ((i + 1) % 8 == 0) {
				fil++;
			}
		}

		Button btn = obtenerBoton("Esp.");
		btn.setOnAction(event -> mostrarCaracter(' '));

		panel.add(btn, len % 4, fil);
		btn = obtenerBoton("Supr");
		btn.setOnAction(event -> borrarCaracter());

		panel.add(btn, len % 4 + 1, fil);
		return panel;
	}

	private HBox crearPanelTexto() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(20, 20, 20, 20));
		panel.setSpacing(30);
		panel.setAlignment(Pos.CENTER);
		panel.getStyleClass().add("bordered-titled-title");

		txtTexto = new TextField();
		txtTexto.setPrefColumnCount(80);
		txtTexto.setEditable(false);

		panel.getChildren().add(txtTexto);

		return panel;
	}

	private void borrarCaracter() {

		maquina.borrarUltimo();
		txtTexto.setText(maquina.getTexto());

	}

	private Button obtenerBoton(String texto) {

		Button btn = new Button(texto);
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		btn.setPrefHeight(15);
		btn.setPrefWidth(15);

		GridPane.setHgrow(btn, Priority.ALWAYS);
		GridPane.setVgrow(btn, Priority.ALWAYS);
		GridPane.setMargin(btn, new Insets(2));

		return btn;
	}

	private void mostrarCaracter(char letra) {

		maquina.añadirCaracter(letra);
		txtTexto.setText(maquina.getTexto());

	}

	public static void main(String[] args) {

		launch(args);
	}
}
