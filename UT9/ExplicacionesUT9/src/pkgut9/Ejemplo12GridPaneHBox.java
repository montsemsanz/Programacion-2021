package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Ejemplo12GridPaneHBox extends Application
{

	@Override
	public void start(Stage stage)
	{
		GridPane root = crearGui();

		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo GridPane con HBox -");
		stage.show();
	}

	private GridPane crearGui()
	{
		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setStyle("-fx-background-color: #3D9970 ");

		RowConstraints fila1 = new RowConstraints();
		fila1.setPercentHeight(40);
		RowConstraints fila2 = new RowConstraints();
		fila2.setPercentHeight(20);
		RowConstraints fila3 = new RowConstraints();
		fila3.setPercentHeight(40);
		panel.getRowConstraints().addAll(fila1, fila2, fila3);

		Button btnC = new Button("C");
		btnC.setMaxWidth(Integer.MAX_VALUE);
		GridPane.setHgrow(btnC, Priority.ALWAYS);

		panel.add(crearPanelAyB(), 0, 0);
		panel.add(btnC, 0, 1);
		panel.add(crearPanelDyF(), 0, 2);
		return panel;
	}

	private HBox crearPanelAyB()
	{
		HBox panel = new HBox();
		panel.setSpacing(7);
		panel.setPadding(new Insets(5, 5, 5, 5));
		panel.setAlignment(Pos.CENTER);
		panel.setStyle(
		        "-fx-background-color: #4A777A; -fx-border-color: black; ");

		Button btnA = new Button("A");
		btnA.setPrefWidth(100);
		Button btnB = new Button("B");
		btnB.setPrefWidth(100);
		panel.getChildren().addAll(btnA, btnB);
		return panel;
	}

	private HBox crearPanelDyF()
	{
		HBox panel = new HBox();
		panel.setSpacing(17);
		panel.setPadding(new Insets(5, 5, 5, 5));
		panel.setAlignment(Pos.CENTER_RIGHT);
		panel.setStyle(
		        "-fx-background-color: #CCCCFF; -fx-border-color: black; -fx-border-width: 2px; ");

		RadioButton rbtA = new RadioButton("A");
		rbtA.setSelected(true);
		RadioButton rbtB = new RadioButton("B");
		ToggleGroup grupo = new ToggleGroup();
		rbtA.setToggleGroup(grupo);
		rbtB.setToggleGroup(grupo);
		panel.getChildren().addAll(rbtA, rbtB);
		return panel;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
