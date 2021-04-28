
package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejemplo8GridPane extends Application
{

	private static final int TAM = 4;

	@Override
	public void start(Stage stage) {

		GridPane root = crearGui();

		Scene scene = new Scene(root, 400, 400);

		stage.setScene(scene);
		stage.setTitle("- Ejemplo GridPane -");
		scene.getStylesheets().add(getClass(). // asociar hoja de estilo
		                getResource("application.css").toExternalForm());
		stage.show();
	}

	private GridPane crearGui() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		//panel.setGridLinesVisible(true);
		panel.setVgap(8);
		panel.setHgap(8);
		panel.setAlignment(Pos.CENTER);
		for (int fila = 0; fila < TAM; fila++) {
			for (int col = 0; col < TAM; col++) {
				Button btn = new Button(
				                Integer.toString((fila * TAM) + col + 1));
				btn.setId("botongrid");
				btn.setPrefWidth(200);
				btn.setPrefHeight(200);
				//GridPane.setMargin(btn, new Insets(30));
				panel.add(btn, col, fila);
			}
		}
		return panel;


	}



	public static void main(String[] args) {

		launch(args);
	}
}
