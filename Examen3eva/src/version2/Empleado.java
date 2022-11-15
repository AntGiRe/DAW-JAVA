/*
 * Nombre: Antonio Jesús Gil
 * Fecha: 26/05
 * El objetivo es crear una clase abstracta Empleado que contenga los atributos y métodos comunes a todos.
 */
package version2;

import java.util.Objects;

public abstract class Empleado {

	//	Atributos
	public static int numeroDeEmpleado = 0;	//Numero de empleado estático que va aumentando según vayan entrando nuevos empleados
	public String dni, nombre;
	private double sueldo;
	private int numEmpleado = numeroDeEmpleado;	//Número de empleado único y se proporcionan de manera consecutiva
	
	//	Constructor de Empleado
	public Empleado(String dni, String nombre, double sueldo) throws SueldoException {
		this.dni = dni;
		this.nombre = nombre;
		
		if(sueldo<0) {
			throw new SueldoException("El sueldo no puede ser negativo");
		}
		
		this.sueldo = sueldo;
	}
	
	//	Método toString
	public String toString() {
		return "Número de Empleado = " + numEmpleado + " - DNI = " + dni + " - Nombre: " + nombre + " - Sueldo: " + sueldo;
	}
	
	//Métodos necesarios para que HashSet compare los DNI de Gerentes y Programadores para no tener DNIs duplicados
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni);
	}
	
	/**
	 * Aumenta el número de empleados que han pasado alguna vez por la empresa
	 */
	public static void aumentarEmpleado() {
		numeroDeEmpleado++;
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
