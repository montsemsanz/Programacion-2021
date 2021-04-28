
package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo16VBoxAnchorPane extends Application
{

	@Override
	public void start(Stage stage) {

		VBox root = crearGui();

		Scene scene = new Scene(root, 600, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo VBox y AnchorPane -");
		scene.getStylesheets()
		                .add(getClass().getResource("estilo.css")
		                                .toExternalForm());
		stage.show();
	}

	private VBox crearGui() {

		VBox panel = new VBox();
		panel.setPadding(new Insets(10, 10, 10, 10));

		panel.getChildren().add(crearPanelArriba());
		VBox panelCentro = crearPanelCentro();
		panel.getChildren().add(panelCentro);
		VBox.setVgrow(panelCentro, Priority.ALWAYS);
		panel.getChildren().add(crearPanelAbajo());
		return panel;
	}

	private AnchorPane crearPanelAbajo() {

		AnchorPane panel = new AnchorPane();
		Button btnExit = new Button("Exit");
		btnExit.setPrefWidth(80);
		AnchorPane.setRightAnchor(btnExit, 40.0);
		AnchorPane.setBottomAnchor(btnExit, 10.0);
		btnExit.getStyleClass().add("button-anchor");
		panel.getChildren().addAll(btnExit);
		return panel;
	}

	private VBox crearPanelCentro() {

		VBox panel = new VBox();
		panel.setId("panel-centro");
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(10);
		Label lblTitulo = new Label("Ejemplo de AnchorPane");
		panel.getChildren().add(lblTitulo);
		Label lbl1 = new Label(
		                "Botones anclados a izquiera y arriba en panel superior");
		lbl1.getStyleClass().add("label-centro");
		panel.getChildren()
		                .add(lbl1);

		Label lbl2 = new Label(
		                "Botón anclado  a derecha y abajo en panel inferior");
		lbl2.getStyleClass().add("label-centro");
		panel.getChildren()
		                .add(lbl2);
		return panel;
	}

	private AnchorPane crearPanelArriba() {

		AnchorPane panel = new AnchorPane();
		Button btnAdd = new Button("Add");
		btnAdd.setPrefWidth(80);
		AnchorPane.setLeftAnchor(btnAdd, 10.0);
		AnchorPane.setTopAnchor(btnAdd, 10.0);
		btnAdd.getStyleClass().add("button-anchor");

		Button btnDelete = new Button("Delete");
		AnchorPane.setLeftAnchor(btnDelete, 100.0);
		AnchorPane.setTopAnchor(btnDelete, 10.0);
		btnDelete.setPrefWidth(80);

		btnDelete.getStyleClass().add("button-anchor");
		Button btnHelp = new Button("Help");
		btnHelp.getStyleClass().add("button-anchor");
		btnHelp.setPrefWidth(80);
		AnchorPane.setRightAnchor(btnHelp, 10.0);
		AnchorPane.setTopAnchor(btnHelp, 10.0);

		panel.getChildren().addAll(btnAdd, btnDelete, btnHelp);

		return panel;
	}

	public static void main(String[] args) {

		launch(args);
	}
}
