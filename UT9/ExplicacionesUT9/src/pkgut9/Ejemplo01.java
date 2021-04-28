
package pkgut9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ejemplo01 extends Application
{

	private Saludo saludo;
	private Button btnSaludo;
	private Button btnAdios;
	private Label lblSaludo;

	@Override
	public void start(Stage stage) {

		saludo = new Saludo(); // el modelo
		VBox root = crearGui(); // crear la ventana principal, el nodo ra�z de la escena

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setMinWidth(500);
		stage.setMinHeight(200);
		stage.setTitle("- Ejemplo 1 JavaFX, Hola y Adi�s -");
		scene.getStylesheets().add(getClass().getResource("application.css")
		                .toExternalForm());
		stage.show();
	}

	private VBox crearGui() {

		HBox panelBotones = new HBox(10);
		panelBotones.setPadding(new Insets(10));
		panelBotones.setAlignment(Pos.CENTER);
		btnSaludo = new Button("Saludar");
		btnSaludo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				saludar();

			}
		});
		btnAdios = new Button("Adi�s");
		btnAdios.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				salir();

			}
		});

		panelBotones.getChildren().addAll(btnSaludo, btnAdios);

		VBox panel = new VBox(10);
		panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(10));

		lblSaludo = new Label("Aqu� va el saludo");
		lblSaludo.setFont(Font.font("Georgia", FontWeight.BOLD, 26));
		lblSaludo.setContentDisplay(ContentDisplay.CENTER);
		lblSaludo.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		VBox.setVgrow(lblSaludo, Priority.ALWAYS);
		panel.getChildren().add(panelBotones);
		panel.getChildren().add(lblSaludo);

		return panel;
	}

	private void salir() {

		Platform.exit();

	}

	private void saludar() {

		lblSaludo.setText(saludo.getSaludo());

	}

	public static void main(String[] args) {

		launch(args);
	}
}
