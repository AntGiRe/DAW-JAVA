/*
 * Nombre: Antonio Jes�s Gil
 * Fecha: 26/05
 * El objetivo es crear una clase abstracta Empleado que contenga los atributos y m�todos comunes a todos.
 */
package version1;

public abstract class Empleado {

	//	Atributos
	private String dni, nombre;
	private double sueldo;
	
	//	Constructor de Empleado
	public Empleado(String dni, String nombre, double sueldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	
	//	M�todo toString
	public String toString() {
		return "DNI = " + dni + " - Nombre: " + nombre + " - Sueldo: " + sueldo;
	}
	
	//	Setters & getters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}
