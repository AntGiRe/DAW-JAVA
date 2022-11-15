/*
 * Nombre: Antonio Gil
 * Fecha: 05/05
 * El objetivo es crear una calculadora simple con JavaFX, en esta clase estan los métodos necesarios para su funcionamiento
 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controlador {
	
	public TextField visor;
	Double n1 = 0.0;
	Double n2 = 0.0;
	String operacion = "suma";
	
	
	//Método que recoge el numero que se ha escrito en el visor. O lanza un error en caso de valor no esperado.
	public void recogen1() {
		
		try {
			n1 = Double.parseDouble(visor.getText());
			visor.setText("");
			visor.setPromptText("0");
		} catch (NumberFormatException e) {
			visor.setText("");
			visor.setPromptText("Introduce número válido");
			Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Error en los datos");
		    alert.setHeaderText("El formato de los datos no es numérico");
		    alert.showAndWait();
		}
	}
	
	//Método que comprueba si el numero es decimal o entero, si es entero quita la parte decimal.
	public String compruebaDecimal(Double numero) {
		int IntValue = (int) Math.round(numero);
		if(numero % 1 == 0) {
			return Integer.toString(IntValue);
		} else {
			return Double.toString(numero);
		}
	}
	
	//Método que muestra el resultado de una suma, multiplicacion, resta o division. O lanza mensaje si esta vacio el visor.
	public void igual(ActionEvent event) {
		reproducirSonido();
		if(visor.getText() != "") {
			
			Double cuenta;
			n2 = Double.parseDouble(visor.getText());
			
			if (operacion=="suma") {
				cuenta = (n1 + n2);
				visor.setText(compruebaDecimal(cuenta));
			} else if (operacion=="resta") {
				cuenta = (n1 - n2);
				visor.setText(compruebaDecimal(cuenta));
			} else if (operacion=="multiplica") {
				cuenta = (n1 * n2);
				visor.setText(compruebaDecimal(cuenta));
			} else {
				cuenta = (n1 / n2);
				visor.setText(compruebaDecimal(cuenta));
			}
			
		} else {
			visor.setText("");
			visor.setPromptText("Introduce un valor");
		}
		
	}
	
	//Botones de suma, resta, multiplicacion y division, recogen numero y el string operacion es cambiado al tipo de operacion
	public void suma(ActionEvent event) {
		reproducirSonido();
		recogen1();
		operacion = "suma";
	}
	
	public void resta(ActionEvent event) {
		reproducirSonido();
		recogen1();
		operacion = "resta";
	}
	
	public void multiplica(ActionEvent event) {
		reproducirSonido();
		recogen1();
		operacion = "multiplica";
	}
	
	public void divide(ActionEvent event) {
		reproducirSonido();
		recogen1();
		operacion = "divide";
	}
	
	//Más botones de la calculadora.
	public void punto(ActionEvent event) {
		reproducirSonido();
		visor.setText(visor.getText() + ".");
	 }
	
	public void del(ActionEvent event) {
		reproducirSonido();
		visor.setText("");
	    visor.setPromptText("0");
	 }

	public void b1(ActionEvent event) {
	    visor.setText(visor.getText() + "1");
	    reproducirSonido();
	}
	
	public void b2(ActionEvent event) {
	    visor.setText(visor.getText() + "2");
	    reproducirSonido();
	 }
	
	public void b3(ActionEvent event) {
	    visor.setText(visor.getText() + "3");
	    reproducirSonido();
	 }
	
	public void b4(ActionEvent event) {
	    visor.setText(visor.getText() + "4");
	    reproducirSonido();
	 }
	
	public void b5(ActionEvent event) {
	    visor.setText(visor.getText() + "5");
	    reproducirSonido();
	 }
	
	public void b6(ActionEvent event) { 
	    visor.setText(visor.getText() + "6");
	    reproducirSonido();
	 }
	
	public void b7(ActionEvent event) {
	    visor.setText(visor.getText() + "7");
	    reproducirSonido();
	 }
	
	public void b8(ActionEvent event) {
	    visor.setText(visor.getText() + "8");
	    reproducirSonido();
	 }
	
	public void b9(ActionEvent event) {
	    visor.setText(visor.getText() + "9");
	    reproducirSonido();
	 }
	
	public void b0(ActionEvent event) {
	    visor.setText(visor.getText() + "0");
	    reproducirSonido();
	 }
	
	public void reproducirSonido(){
	       try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("calc.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido.");
	       }
	}
	
	/* Método que revisa lo que se introduce en el visor por teclado. Cuando se introduce +,-,/ o * se guarda el numero 1 y se espera un segundo numero
	* al introducir '=' y pulsar enter se realiza la operación.
	*/
	public void teclaTeclado() {
		reproducirSonido();
		String numeros = visor.getText();
		if(numeros.length()>1 && numeros.substring(numeros.length()-1).equals("+")) {
			operacion = "suma";
			visor.setText(numeros.substring(0,numeros.length()-1));
			recogen1();
		}
		
		if(numeros.length()>1 && numeros.substring(numeros.length()-1).equals("-")) {
			operacion = "resta";
			visor.setText(numeros.substring(0,numeros.length()-1));
			recogen1();
		}
		
		if(numeros.length()>1 && numeros.substring(numeros.length()-1).equals("*")) {
			operacion = "multiplica";
			visor.setText(numeros.substring(0,numeros.length()-1));
			recogen1();
		}
		
		if(numeros.length()>1 && numeros.substring(numeros.length()-1).equals("/")) {
			operacion = "divide";
			visor.setText(numeros.substring(0,numeros.length()-1));
			recogen1();
		}
		
		if(numeros.length()>1 && numeros.substring(numeros.length()-1).equals("=")) {
			visor.setText(numeros.substring(0,numeros.length()-1));
			igual(new ActionEvent());
		}

	}
}
