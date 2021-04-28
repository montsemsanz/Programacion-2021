
package pkgut9;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejemplo13BorderPaneGridPane extends Application
{

	@Override
	public void start(Stage stage) {

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 400, 200);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Layout BorderPane con GridPane -");
		stage.show();
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setStyle("-fx-background-color: #3D9970 ");

		GridPane pnlCentro = crearPanelDatos();
		panel.setCenter(pnlCentro);

		Button btnEnviar = new Button("Enviar");
		btnEnviar.setMaxWidth(Integer.MAX_VALUE);

		panel.setBottom(btnEnviar);

		BorderPane.setMargin(pnlCentro, new Insets(10, 10, 20, 10));
		return panel;
	}

	private GridPane crearPanelDatos() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setVgap(10);
		panel.setHgap(10);
		panel.setStyle("-fx-background-color: #CFDBC5 ");
		panel.setGridLinesVisible(true);
		panel.setAlignment(Pos.CENTER);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(40);
		col1.setHalignment(HPos.RIGHT);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(60);
		col2.setHalignment(HPos.LEFT);

		panel.getColumnConstraints().addAll(col1, col2);

		Label lblNombre = new Label("Nombre");
		TextField txtNombre = new TextField();
		Label lblNota = new Label("Nota");
		TextField txtNota = new TextField();

		panel.add(lblNombre, 0, 0);
		panel.add(txtNombre, 1, 0);
		panel.add(lblNota, 0, 1);
		panel.add(txtNota, 1, 1);

		return panel;
	}

	public static void main(String[] args) {

		launch(args);
	}
}
