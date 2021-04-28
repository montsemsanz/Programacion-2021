package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo11VBoxHBox extends Application
{

	@Override
	public void start(Stage stage)
	{
		VBox root = crearGui();

		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Layout VBox con HBox -");
		stage.show();
	}

	private VBox crearGui()
	{
		VBox panel = new VBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(12);
		panel.setStyle("-fx-background-color: #3D9970 ");

		Button btnC = new Button("C");
		btnC.setMaxWidth(Integer.MAX_VALUE);

		CheckBox cbxF = new CheckBox("F");
		cbxF.setStyle("  -fx-text-fill: blue; -fx-font-family: 'Arial';"
		        + " -fx-font-size:   14px;  -fx-font-weight: bold");

		panel.getChildren().add(crearPanelAyB());
		panel.getChildren().add(btnC);
		panel.getChildren().add(crearPanelDyF());
		panel.getChildren().add(cbxF);
		return panel;
	}

	private HBox crearPanelAyB()
	{
		HBox panel = new HBox();
		panel.setSpacing(7);
		panel.setPadding(new Insets(5, 5, 5, 5));
		panel.setAlignment(Pos.CENTER);

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
