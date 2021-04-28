package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejemplo3 extends Application
{

	@Override
	public void start(Stage stage)
	{
		HBox root = crearGui();

		Scene scene = new Scene(root, 200, 100);
		stage.setScene(scene);
		stage.setTitle("- Margin Insets padding -");
		stage.show();
	}

	private HBox crearGui()
	{

		HBox panel = new HBox();
		Border borde = new Border(
		        new BorderStroke(Color.RED, BorderStrokeStyle.SOLID,
		                CornerRadii.EMPTY, new BorderWidths(1)));
		panel.setBorder(borde);
		panel.setPadding(new Insets(10, 20, 30, 40));
		Button btnSaludo = new Button("Saludar");
		btnSaludo.setStyle("-fx-background-color: lime;");
		btnSaludo.setMaxWidth(Integer.MAX_VALUE);
		btnSaludo.setMaxHeight(Integer.MAX_VALUE);
		HBox.setHgrow(btnSaludo, Priority.ALWAYS);

		panel.getChildren().add(btnSaludo);
		return panel;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
