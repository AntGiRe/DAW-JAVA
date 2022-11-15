/*
 * Nombre: Antonio Gil
 * Fecha: 05/05
 * El objetivo es crear una calculadora simple con JavaFX
 */
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {

	public void start(Stage primaryStage) {
	    try {
	      
	      var fxml = new FXMLLoader(getClass().getResource("calculadora.fxml"));
	      var rootCambio = fxml.<Pane>load();
	      
	      var sceneCambio = new Scene(rootCambio);
	      
	      var stageCambio = new Stage();
	      stageCambio.setScene(sceneCambio);
	      stageCambio.setTitle("Calculadora");
	      stageCambio.showAndWait();
	      
	    } catch (IOException e) {
	      System.out.println("Error al cargar el fxml.");
	      e.printStackTrace();
	    }
	  }
	
	public static void main (String[] args) {
		launch(args);
	}
}
