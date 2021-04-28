package pkgut9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ejemplo2 extends Application
{

	@Override
	public void start(Stage stage)
	{
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 400, 150);// crear la escena
		stage.setScene(scene);
		stage.setTitle("- Ejemplo sencillo de aplicación JavaFX -");
		stage.show();
	}

	private BorderPane crearGui()
	{
		BorderPane panel = new BorderPane();
		Button btnSaludo = new Button("Saludar");
		panel.setCenter(btnSaludo);

		return panel;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
