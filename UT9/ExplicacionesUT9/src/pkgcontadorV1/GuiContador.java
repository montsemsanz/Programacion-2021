
package pkgcontadorV1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GuiContador extends Application
{

	private Label lblContador;
	private Button btnIncremento;
	private Button btnDecremento;
	private Contador contador; // el modelo

	@Override
	public void start(Stage stage) {

		contador = new Contador();

		BorderPane root = crearGui(); // devuelve la ra�z del grafo de escena

		Scene scene = new Scene(root, 300, 200); // crear la escena
		stage.setScene(scene);
		stage.setTitle("Contador en JavaFX - V1"); // establecer t�tulo de la
		                                           // aplicaci�n
		scene.getStylesheets().add(getClass(). // asociar hoja de estilo
		                getResource("application.css").toExternalForm());
		stage.show(); // mostrar la ventana principal de la aplicaci�n, el
		              // escenarios
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(5));

		lblContador = new Label();
		lblContador.setText(Integer.toString(contador.getValor()));
		lblContador.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		lblContador.setAlignment(Pos.CENTER);
		panel.setCenter(lblContador);


		btnIncremento = new Button("+");
		// btnIncremento.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnIncremento.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				actualizarContador(arg0);

			}


		});
		btnDecremento = new Button("-");
		btnDecremento.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnDecremento.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				actualizarContador(arg0);

			}


		});


		HBox pnlBotones = new HBox();
		HBox.setHgrow(btnIncremento, Priority.ALWAYS);
		HBox.setHgrow(btnDecremento, Priority.ALWAYS);
		pnlBotones.setSpacing(5);
		pnlBotones.setPadding(new Insets(5));
		pnlBotones.getChildren().addAll(btnIncremento, btnDecremento);
		panel.setBottom(pnlBotones);
		return panel;
	}

	private void actualizarContador(ActionEvent arg0) {

		if (arg0.getSource() == btnIncremento) {
			contador.incrementar();
		}
		else {
			contador.decrementar();
		}
		lblContador.setText(Integer.toString(contador.getValor()));

	}



	public static void main(String[] args) {

		launch(args);
	}
}
