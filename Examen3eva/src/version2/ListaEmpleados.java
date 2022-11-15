/*
 * Nombre: Antonio Jesús Gil
 * Fecha: 26/05
 * El objetivo es crear una clase ListaEmpleados que contengan los empleados de la empresa y puedan ser gestionados.
 */
package version2;

import java.util.HashSet;

public class ListaEmpleados {

	//	Atributos
	private static HashSet<Empleado> lista = new HashSet<Empleado>();
	
	/**
	 * Introduce un Empleado en la lista
	 * @param emple Objeto Empleado a introducir
	 */
	public static void addEmpleado(Empleado emple) {
		if(lista.add(emple)) {
			Empleado.aumentarEmpleado();
			System.out.println("Se ha introducido correctamente el Empleado.");
		} else {
			System.out.println("No se pudo introducir, revisa que no se repita el DNI: " + emple.getDni());
		}	
	}
	
	/**
	 * Elimina un Empleado de la lista
	 * @param dni DNI del Empleado a eliminar
	 * @return Devuelve true en caso de que se haya eliminado, false en caso de que no exista.
	 */
	public static boolean delEmpleado(String dni) {
		return lista.remove(buscaEmpleado(dni));
	}
	
	/**
	 * Muestra un listado de Empleados
	 */
	public static String listarEmpleados() {
		String listado = "";
		
		for(Empleado emple : lista) {
			
			if(emple instanceof Gerente) {
				Gerente infoGerent = (Gerente)emple;
				listado += infoGerent.toString();
			} else {
				Programador infoProg = (Programador)emple;
				listado += infoProg.toString();
			}
			
			listado += "\n";
		}
		
		return listado;
	}
	
	/**
	 * Busca un Empleado en la lista
	 * @param dni DNI del Empleado a buscar
	 * @return Devuelve el objeto Empleado que se busca o null en caso de que no exista
	 */
	public static Empleado buscaEmpleado(String dni) {
		for(Empleado emple : lista) {
			if(emple.getDni().equalsIgnoreCase(dni)) {
				return emple;
			}
		}
		
		return null;
	}
}
