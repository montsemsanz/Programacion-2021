
package pkgbombilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GuiBombilla extends Application
{

	private Bombilla bombilla; // el modelo 
	private Button btnEncender;
	private Button btnApagar;
	private Label lblImagen;

	@Override
	public void start(Stage primaryStage) {

		this.bombilla = new Bombilla();
		BorderPane root = crearGui();
		Scene scene = new Scene(root, 400, 300);
		scene.getStylesheets()
		                .add(getClass().getResource(
		                                "/resources/css/application.css")
		                                .toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ejercicio  Bombilla JAVAFX");
		primaryStage.show();

	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10));
		lblImagen = new Label();
		lblImagen.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		lblImagen.setAlignment(Pos.CENTER);
		ponerImagenEtiqueta();
		lblImagen.getStyleClass().add("bg-black-style");
		panel.setCenter(lblImagen);

		panel.setBottom(crearPanelBotones());
		return panel;
	}

	private HBox crearPanelBotones() {

		HBox pnlBotones = new HBox();
		pnlBotones.setPadding(new Insets(10));
		pnlBotones.setAlignment(Pos.CENTER);
		pnlBotones.setSpacing(7);

		btnEncender = new Button("Encender");
		btnEncender.setPrefWidth(100);
		btnEncender.setOnAction(event -> encender());

		btnApagar = new Button("Apagar");
		btnApagar.setPrefWidth(100);
		btnApagar.setDisable(true);
		btnApagar.setOnAction(event -> apagar());

		pnlBotones.getChildren().addAll(btnEncender, btnApagar);
		return pnlBotones;
	}

	private void apagar() {

		bombilla.apagar();
		mostrarImagen();
	}

	private void encender() {

		bombilla.encender();
		mostrarImagen();

	}

	private void mostrarImagen() {

		ponerImagenEtiqueta();

		if (bombilla.estaEncendida()) {
			btnApagar.setDisable(false);
			btnEncender.setDisable(true);
		}
		else {
			btnEncender.setDisable(false);
			btnApagar.setDisable(true);
		}

	}

	private void ponerImagenEtiqueta() {

		Image img = bombilla.getImagen();
		ImageView imgView = new ImageView(img);
		lblImagen.setGraphic(imgView);
	}

	public static void main(String[] args) {

		launch(args);
	}
}
