package pkgut9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Ejemplo14GridPane extends Application
{

	@Override
	public void start(Stage stage)
	{

		GridPane root = crearGui();

		Scene scene = new Scene(root, 300, 200);

		stage.setScene(scene);
		stage.setTitle("- Ejemplo GridPane -");
		stage.show();
	}

	private GridPane crearGui()
	{

		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);
		panel.setVgap(8);
		panel.setHgap(8);

		Button btn1 = new Button("1");
		btn1.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		GridPane.setHgrow(btn1, Priority.ALWAYS);
		GridPane.setVgrow(btn1, Priority.ALWAYS);
		Button btn2 = new Button("2");
		btn2.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		GridPane.setHgrow(btn2, Priority.ALWAYS);
		GridPane.setVgrow(btn2, Priority.ALWAYS);

		Button btn3 = new Button("3");
		btn3.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		GridPane.setVgrow(btn3, Priority.ALWAYS);
		GridPane.setHgrow(btn3, Priority.ALWAYS);

		Button btn4 = new Button("4");
		btn4.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		GridPane.setHgrow(btn4, Priority.ALWAYS);
		GridPane.setVgrow(btn4, Priority.ALWAYS);

		panel.add(btn1, 0, 0);
		panel.add(btn2, 1, 0);
		panel.add(btn3, 0, 1);
		panel.add(btn4, 1, 1);
		return panel;

	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
