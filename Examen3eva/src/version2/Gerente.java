/*
 * Nombre: Antonio Jesús Gil
 * Fecha: 26/05
 * El objetivo es crear una clase Gerente que hereda de Empleado.
 */
package version2;

public class Gerente extends Empleado{
	
	//	Atributos
	private String delegacion;

	//	Constructor de Gerente
	public Gerente(String dni, String nombre, double sueldo, String delegacion) throws SueldoException {
		super(dni, nombre, sueldo);
		this.delegacion = delegacion;
	}
	
	//	Método toString
	public String toString() {
		return super.toString() + " - Delegación: " + getDelegacion();
	}

	//	Setters & getters
	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	
}
