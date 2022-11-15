/*
 * Nombre: Antonio Jes�s Gil
 * Fecha: 26/05
 * El objetivo es crear una clase Programador que hereda de Empleado.
 */
package version2;

public class Programador extends Empleado {

	//	Atributos
	private String lenguaje;

	//	Constructor de Programador
	public Programador(String dni, String nombre, double sueldo, String lenguaje) throws SueldoException {
		super(dni, nombre, sueldo);
		this.lenguaje = lenguaje;
	}
	
	//	M�todo toString
	public String toString() {
		return super.toString() + " - Lenguaje de programaci�n: " + getLenguaje();
	}
	
	//	Setters & getters
	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
}
