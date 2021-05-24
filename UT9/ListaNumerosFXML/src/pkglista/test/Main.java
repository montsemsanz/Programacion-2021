
package pkglista.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application
{

	@Override
	public void start(Stage primaryStage) {

		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass()
			                .getResource("/pkglista/vista/GuiLista.fxml"));

			//			FXMLLoader loader = new FXMLLoader();
			//			loader.setLocation(
			//			                this.getClass().getResource(
			//			                                "/pkglista/vista/GuiLista.fxml"));
			//			BorderPane root = loader.load();
			Scene scene = new Scene(root, 500, 600);
			scene.getStylesheets()
			                .add(getClass().getResource("/application.css")
			                                .toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lista de números FXML");
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
