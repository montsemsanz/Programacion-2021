
package pkgdados;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GuiDados extends Application
{

	private Dado dado1;
	private Dado dado2;
	private Label lblPuntos;
	private Label lblDado1;
	private Label lblDado2;
	private Button btnTirar;

	@Override
	public void start(Stage primaryStage) {

		dado1 = new Dado();
		dado2 = new Dado();

		BorderPane root = crearGui();
		Scene scene = new Scene(root, 400, 300);
		scene.getStylesheets().add(
		                getClass().getResource("/application.css")
		                                .toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle(" Dados ");
		primaryStage.show();

	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10));
		panel.setTop(crearPanelTop());
		panel.setCenter(crearPanelCenter());
		panel.setBottom(crearPanelBottom());
		return panel;
	}

	private HBox crearPanelTop() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5));

		lblPuntos = new Label("Puntuaci�n");
		lblPuntos.setAlignment(Pos.CENTER);
		lblPuntos.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		HBox.setHgrow(lblPuntos, Priority.ALWAYS);

		panel.getChildren().add(lblPuntos);
		panel.getStyleClass().add("hbox");
		return panel;
	}

	private GridPane crearPanelCenter() {

		GridPane panel = new GridPane();
		panel.setAlignment(Pos.CENTER);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(50);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(50);
		panel.getColumnConstraints().addAll(col1, col2);

		lblDado1 = new Label();
		lblDado1.setAlignment(Pos.CENTER);
		lblDado1.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		lblDado2 = new Label();
		lblDado2.setAlignment(Pos.CENTER);
		lblDado2.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		actualizarEtiquetas();
		GridPane.setHgrow(lblDado1, Priority.ALWAYS);
		GridPane.setHgrow(lblDado2, Priority.ALWAYS);
		GridPane.setVgrow(lblDado1, Priority.ALWAYS);
		GridPane.setVgrow(lblDado2, Priority.ALWAYS);

		panel.add(lblDado1, 0, 1);
		panel.add(lblDado2, 1, 1);
		return panel;
	}

	private void actualizarEtiquetas() {

		Image img1 = dado1.getImagen();
		ImageView imgView1 = new ImageView(img1);
		lblDado1.setGraphic(imgView1);

		Image img2 = dado2.getImagen();
		ImageView imgView2 = new ImageView(img2);
		lblDado2.setGraphic(imgView2);

		int puntos = dado1.getCara() + dado2.getCara();
		lblPuntos.setText(Integer.toString(puntos) + " puntos");

	}

	private HBox crearPanelBottom() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5));
		panel.setAlignment(Pos.CENTER);

		btnTirar = new Button("Tirar dados");
		btnTirar.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		HBox.setHgrow(btnTirar, Priority.ALWAYS);
		btnTirar.setOnAction(event -> tirarDados());

		panel.getChildren().add(btnTirar);
		panel.getStyleClass().add("hbox");
		return panel;
	}

	private void tirarDados() {

		dado1.tirarDado();
		dado2.tirarDado();
		actualizarEtiquetas();

	}

	public static void main(String[] args) {

		launch(args);
	}
}
