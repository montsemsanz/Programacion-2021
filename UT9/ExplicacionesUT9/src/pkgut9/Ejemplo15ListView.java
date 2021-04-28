package pkgut9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ejemplo15ListView extends Application
{

	@Override
	public void start(Stage stage)
	{
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("- Ejemplo ListView -");
		stage.show();
	}

	private BorderPane crearGui()
	{
		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10, 10, 10, 10));

		panel.setStyle("-fx-background-color: #ffb3b3");

		Label lblTexto = new Label("Elija sus hobbies");
		BorderPane.setMargin(lblTexto, new Insets(5));
		lblTexto.setStyle(
		        "-fx-background-color: white; -fx-text-fill: black; -fx-font-size:20px;");
		lblTexto.setAlignment(Pos.CENTER);
		lblTexto.setPadding(new Insets(7));
		lblTexto.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

		ObservableList<String> hobbies = FXCollections
		        .observableArrayList("Cine", "Lectura", "Baile", "Deporte");
		ListView<String> lstHobbies = new ListView<String>(hobbies);
		BorderPane.setMargin(lstHobbies, new Insets(5));
		lstHobbies.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstHobbies.setOnMouseClicked(event -> {
			mostrarSeleccionado(lstHobbies);
		});

		panel.setTop(lblTexto);
		panel.setCenter(lstHobbies);

		return panel;
	}

	private void mostrarSeleccionado(ListView<String> lstHobbies)
	{
		System.out.println("Valor seleccionado"
		        + lstHobbies.getSelectionModel().getSelectedItems());
		System.out.println("Posición seleccionada "
		        + lstHobbies.getSelectionModel().getSelectedIndex());
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
