
package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ejemplo4HBox extends Application
{

	@Override
	public void start(Stage stage) {

		HBox root = crearGui();

		Scene scene = new Scene(root, 350, 80);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Layout HBox -");
		stage.show();
	}

	private HBox crearGui() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(8);
		panel.setStyle("-fx-background-color: yellow");
		Label lblTexto = new Label("Texto");
		TextField txtTexto = new TextField();

		Button btn1 = new Button("Uno");
		Button btn2 = new Button("Dos");
		Button btn3 = new Button("Tres");

		panel.getChildren().addAll(lblTexto, txtTexto, btn1, btn2);
		panel.getChildren().add(btn3);
		return panel;
	}

	public static void main(String[] args) {

		launch(args);
	}
}
