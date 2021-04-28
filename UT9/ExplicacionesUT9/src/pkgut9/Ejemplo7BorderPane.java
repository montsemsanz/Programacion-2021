package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo7BorderPane extends Application
{

	@Override
	public void start(Stage stage)
	{

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 450, 300);
		stage.setScene(scene);
		stage.setTitle("-  BorderPane con HBox -");
		stage.show();
	}

	private BorderPane crearGui()
	{
		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10));

		TextArea areaTexto = new TextArea();
		areaTexto.setText("\n\nEjemplo de área de texto\n\n"
		        + "Los botones en el panel derecho tienen todos\n"
		        + "la misma altura y tamaño");
		panel.setCenter(areaTexto);

		panel.setRight(crearPanelBotones());

		Label lblEstado = new Label("Similar a una barra de estado");
		lblEstado.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		lblEstado.setStyle(
		        "-fx-background-color: gray ; " + "	-fx-padding: 10; ");
		BorderPane.setMargin(lblEstado, new Insets(10, 0, 0, 0));
		panel.setBottom(lblEstado);

		return panel;
	}

	private VBox crearPanelBotones()
	{
		String[] nombres = { "New", "Open", "Save", "Compile", "Run", "Quit" };
		VBox panel = new VBox(8);
		panel.setPadding(new Insets(0, 0, 0, 10));
		for (int i = 0; i < nombres.length; i++)
		{
			Button btn = new Button(nombres[i]);
			btn.setPrefWidth(100);
			btn.setPrefHeight(30);
			panel.getChildren().add(btn);

		}
		return panel;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
