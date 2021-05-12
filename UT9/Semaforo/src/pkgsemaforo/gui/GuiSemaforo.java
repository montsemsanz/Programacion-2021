
package pkgsemaforo.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pkgsemaforo.modelo.Semaforo;

public class GuiSemaforo extends Application
{

	private Semaforo semaforo; // el modelo
	private Button btnCambiar;
	private Label lblColor;

	@Override
	public void start(Stage primaryStage) {

		semaforo = new Semaforo();
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 400, 300);

		scene.getStylesheets().add(getClass()
		                .getResource("/resources/application.css")
		                .toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Semáforo JAVAFX");
		primaryStage.show();

	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		lblColor = new Label();
		lblColor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		ponerColorFondo();
		panel.setCenter(lblColor);

		btnCambiar = new Button("_Cambiar color semáforo");
		btnCambiar.setMnemonicParsing(true);
		btnCambiar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		//		btnCambiar.setOnAction(new EventHandler<ActionEvent>() {
		//
		//			@Override
		//			public void handle(ActionEvent event) {
		//
		//				cambiarColor();
		//
		//			}
		//		});

		btnCambiar.setOnAction(event -> cambiarColor());

		panel.setBottom(btnCambiar);
		;

		return panel;
	}

	private void cambiarColor() {

		semaforo.avanzar();
		ponerColorFondo();

	}

	private void ponerColorFondo() {

		Color color = semaforo.getColor();
		lblColor.setBackground(new Background(
		                new BackgroundFill(color, CornerRadii.EMPTY,
		                                Insets.EMPTY)));
	}

	public static void main(String[] args) {

		launch(args);
	}

}
