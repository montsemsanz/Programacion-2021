
package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ejemplo6BorderPane extends Application
{

	@Override
	public void start(Stage stage) {

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Layout BorderPane -");
		stage.show();
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10, 10, 10, 10));

		panel.setStyle("-fx-background-color: yellow");

		Label lblTexto = new Label("Texto");
		BorderPane.setMargin(lblTexto, new Insets(5));
		TextField txtTexto = new TextField();
		BorderPane.setMargin(txtTexto, new Insets(5));
		lblTexto.setStyle("-fx-background-color: green");
		lblTexto.setAlignment(Pos.CENTER);
		lblTexto.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		Button btn1 = new Button("Uno");
		btn1.setPrefWidth(90);
		BorderPane.setAlignment(btn1, Pos.CENTER);
		BorderPane.setMargin(btn1, new Insets(5));

		Button btn2 = new Button("Dos");
		btn2.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		BorderPane.setMargin(btn2, new Insets(5));

		Button btn3 = new Button("Tres");
		btn3.setMaxWidth(Integer.MAX_VALUE);
		BorderPane.setMargin(btn3, new Insets(5));

		BorderPane.setAlignment(btn3, Pos.CENTER);

		panel.setTop(btn1);
		panel.setLeft(btn2);
		panel.setRight(btn3);
		panel.setCenter(lblTexto);
		panel.setBottom(txtTexto);
		return panel;
	}

	public static void main(String[] args) {

		launch(args);
	}
}
