
package pkgut9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Ejemplo10Controles extends Application
{

	@Override
	public void start(Stage stage) {

		VBox root = crearGui();
		Scene scene = new Scene(root, 1020, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo Controles -");
		scene.getStylesheets()
		                .add(getClass().getResource("estilo.css")
		                                .toExternalForm());
		stage.show();
	}

	private VBox crearGui() {

		VBox panel = new VBox();
		panel.getChildren().addAll(crearPanelUno(), crearPanelDos(),
		                crearPanelTres());
		return panel;
	}

	private HBox crearPanelUno() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(10);
		panel.setMinHeight(70);

		panel.setStyle("-fx-background-color: #d1e0e0"); // estilo en l�nea
		panel.setId("paneluno");

		Label lblTexto = new Label("Etiqueta");
		lblTexto.setFont(Font.font("Georgia", FontWeight.BOLD, 20));

		TextField txtTexto = new TextField();
		txtTexto.setPrefColumnCount(20);

		txtTexto.setText("Caja de texto");
		txtTexto.selectAll();
		txtTexto.setEditable(false);
		String texto = txtTexto.getText();


		Button btn1 = new Button("Bot�n Uno");
		btn1.setDefaultButton(true); // bot�n por defecto
		btn1.setStyle(
		                "-fx-font-family: 'Arial'; -fx-font-size:16px;-fx-background-color: #ffe6ff;");
		btn1.setStyle(btn1.getStyle() + "-fx-font-weight: bold;");

		Button btn2 = new Button("Bot�n Dos");
		Image img1 = new Image(
		                getClass().getResourceAsStream("/images/globo.png"));
		btn2.setGraphic(new ImageView(img1));

		RadioButton rbt1 = new RadioButton("Bot�n de radio 1");
		rbt1.setSelected(true);
		RadioButton rbt2 = new RadioButton("Bot�n de radio 2");
		ToggleGroup grupo = new ToggleGroup();
		rbt1.setToggleGroup(grupo);
		rbt2.setToggleGroup(grupo);

		CheckBox cbxCasilla = new CheckBox("Casilla de\nverificaci�n");

		panel.getChildren().addAll(lblTexto, txtTexto, btn1, btn2, rbt1, rbt2,
		                cbxCasilla);

		return panel;

	}

	private HBox crearPanelDos() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(8);
		TextArea areaTexto = new TextArea();
		areaTexto.setText("Ejemplo de control\n");
		areaTexto.appendText("Esto es un �rea de texto");
		areaTexto.setMaxWidth(Integer.MAX_VALUE);
		areaTexto.setPrefHeight(Integer.MAX_VALUE);
		panel.setHgrow(areaTexto, Priority.ALWAYS);

		panel.getChildren().add(areaTexto);
		return panel;
	}

	private HBox crearPanelTres() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(10, 10, 10, 10));
		panel.setSpacing(8);

		Label lblTexto = new Label("Elija mes del ComboBox");

		lblTexto.setPrefWidth(150);
		lblTexto.setAlignment(Pos.CENTER_RIGHT);

		ObservableList<String> meses = FXCollections.observableArrayList(
		                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
		                "Julio",
		                "Agosto", "Septiembre", "Octubre", "Noviembre",
		                "Diciembre");
		ComboBox<String> cmbMeses = new ComboBox<>(meses);
		cmbMeses.setPromptText("Seleccione mes ...");
		cmbMeses.setMaxWidth(Integer.MAX_VALUE);
		HBox.setHgrow(cmbMeses, Priority.ALWAYS);

		panel.getChildren().addAll(lblTexto, cmbMeses);


		ComboBox<String> cmbOpciones = new ComboBox<>();
		cmbOpciones.getItems().addAll("Opci�n 1", "Opci�n 2", "Opci�n 3",
		                "Opci�n 4");
		String opcion = cmbOpciones.getValue(); // obtener el valor seleccionado

		Image image = new Image(
		                getClass().getResourceAsStream("/images/globo.png"));
		ImageView imageView = new ImageView(image);
		Button btn1 = new Button();
		btn1.setGraphic(imageView);

		Button btn2 = new Button("Bot�n", new ImageView(image));

		return panel;
	}

	public static void main(String[] args) {

		launch(args);
	}
}
