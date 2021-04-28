
package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ejemplo10EstilosCSS extends Application
{

	@Override
	public void start(Stage stage) {

		HBox root = crearGui();
		Scene scene = new Scene(root, 600, 100);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo JavaFX CSS -");
		scene.getStylesheets()
		                .add(getClass().getResource("estilo2.css")
		                                .toExternalForm());
		stage.show();
	}

	private HBox crearGui() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5, 5, 5, 5));
		panel.setSpacing(8);

		panel.setStyle("-fx-background-color: #d1e0e0"); // estilo en l�nea
		panel.setId("paneluno");

		Label lblTexto1 = new Label("Etiqueta 1");
		lblTexto1.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
		lblTexto1.setTextFill(Color.ROYALBLUE);
		Border borde1 = new Border(
		                new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,
		                                CornerRadii.EMPTY, new BorderWidths(3),
		                                new Insets(0)));
		lblTexto1.setBorder(borde1);

		Label lblTexto2 = new Label("Etiqueta 2");
		lblTexto2.setStyle(
		                "-fx-font-family: 'Arial Narrow'; -fx-font-size:16px;-fx-text-fill: red;");
		// a�adir al estilo actual de la etiqueta m�s estilos
		lblTexto2.setStyle(lblTexto2.getStyle()
		                + " -fx-background-color: WHITE; -fx-padding: 20;");


		Button btn1 = new Button("Bot�n Uno");

		Button btn2 = new Button("Bot�n Dos");
		btn2.setId("btndos");

		Button btn3 = new Button("Bot�n Tres");
		btn3.setStyle(" -fx-background-color: WHITE;-fx-text-fill: red;");
		//	btn3.setStyle("-fx-padding: 20;");
		panel.getChildren().addAll(lblTexto1, lblTexto2, btn1, btn2, btn3);

		return panel;

	}

	public static void main(String[] args) {

		launch(args);
	}

}
