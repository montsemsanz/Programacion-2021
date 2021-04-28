
package pkgut9;


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ejemplo9GridPane extends Application
{

	@Override
	public void start(Stage stage) {

		GridPane root = crearGui();
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("-  GridPane diferente tama�o componentes -");
		stage.sizeToScene();
		stage.show();
	}

	private GridPane crearGui() {

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		// panel.setGridLinesVisible(true);
		panel.setVgap(12);
		panel.setHgap(12);
		Label lblTitulo = new Label("JavaFX Course Login");
		lblTitulo.setFont(Font.font("georgia", FontWeight.BOLD, 22));
		GridPane.setHalignment(lblTitulo, HPos.CENTER);
		GridPane.setMargin(lblTitulo, new Insets(6));
		Label lblNombre = new Label("Username or email");
		TextField txtNombre = new TextField();
		Label lblPassword = new Label("Password");
		TextField txtPassword = new TextField();

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);

		col1.setHalignment(HPos.RIGHT);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		panel.getColumnConstraints().addAll(col1, col2);

		panel.add(lblTitulo, 0, 0, 2, 1);
		panel.add(lblNombre, 0, 1);
		panel.add(txtNombre, 1, 1);
		panel.add(lblPassword, 0, 2);
		panel.add(txtPassword, 1, 2);
		return panel;


	}



	public static void main(String[] args) {

		launch(args);
	}
}
