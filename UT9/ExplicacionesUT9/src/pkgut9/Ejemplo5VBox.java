package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo5VBox extends Application
{

	@Override
	public void start(Stage stage)
	{
		VBox root = crearGui();

		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Layout VBox -");
		stage.show();
	}

	private VBox crearGui()
	{
		VBox panel = new VBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(8);
		panel.setAlignment(Pos.CENTER);
		panel.setStyle("-fx-background-color: yellow");
		Label lblTexto = new Label("Texto");
		TextField txtTexto = new TextField();

		Button btn1 = new Button("Uno");
		btn1.setMaxHeight(Integer.MAX_VALUE);
		VBox.setVgrow(btn1, Priority.ALWAYS);
		Button btn2 = new Button("Dos");
		Button btn3 = new Button("Tres");


		panel.getChildren().addAll(lblTexto, txtTexto, btn1, btn2);
		panel.getChildren().add(btn3);

		return panel;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
