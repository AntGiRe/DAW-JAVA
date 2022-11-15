/*
 * Nombre: Antonio Jesús Gil
 * Fecha: 26/05
 * El objetivo es crear un programa principal donde poder probar todas las clases hechas con anterioridad.
 */
package version1;

import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {
		boolean salida = false;
		
		System.out.println("Se están introduciendo datos por defecto.\n");
		
		//Vamos a introducir 8 Empleados por defecto
		empleadosPorDefecto(8);
		
		System.out.println("\nBienvenido al menú");
		do {
			int opcion;
			
			//Se muestra el menú
			System.out.println();
			System.out.println("0. Salir");
			System.out.println("1. Crea Gerente");
			System.out.println("2. Crea Programador");
			System.out.println("3. Listar Empleados");
			System.out.println("4. Eliminar Empleado");
			System.out.println("5. Buscar Empleado");
			opcion = pideInt("¿Que opción quiere realizar?: ");
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo del programa.");
				salida = true;
				break;
			case 1:
				nuevoEmpleado("Gerente");
				break;
			case 2:
				nuevoEmpleado("Programador");
				break;
			case 3:
				ListaEmpleados.listarEmpleados();
				break;
			case 4:
				eliminarEmpleado();
				break;
			case 5:
				muestraEmpleado();
				break;
			default:
				System.out.println("Se ha introducido un valor no correcto.");
				break;
			}
		}while(!salida);
	}
	
	/**
	 * Pide un numero entero
	 * @param mensaje Mensaje que se muestra al usuario
	 * @return Devuelve un entero
	 */
	public static int pideInt(String mensaje) {
		Scanner input = new Scanner(System.in);
		System.out.print(mensaje);
		return input.nextInt();
	}
	
	/**
	 * Pide una cadena de texto
	 * @param mensaje Mensaje que se muestra al usuario
	 * @return Devuelve una cadena de texto
	 */
	public static String pideLinea(String mensaje) {
		Scanner input = new Scanner(System.in);
		System.out.print(mensaje);
		return input.nextLine();
	}
	
	/**
	 * Pide un double
	 * @param mensaje Mensaje que se muestra al usuario
	 * @return Devuelve un double
	 */
	public static double pideDouble(String mensaje) {
		Scanner input = new Scanner(System.in);
		System.out.print(mensaje);
		return input.nextDouble();
	}
	
	/**
	 * Muestra la lista de los empleados
	 */
	public static void muestraEmpleado() {
		Empleado empleado = ListaEmpleados.buscaEmpleado(pideLinea("Introduce el DNI del empleado a buscar: "));
		
		if(empleado instanceof Gerente) {
			Gerente gerente = (Gerente) empleado;
			System.out.println(gerente.toString());
		} else {
			Programador programador = (Programador) empleado;
			System.out.println(programador.toString());
		}
	}
	
	/**
	 * Añadir un nuevo empleado
	 * @param tipoEmpleado Tipo de empleado: Gerente o Programador
	 */
	public static void nuevoEmpleado(String tipoEmpleado) {
		String dni = pideLinea("Introduce el DNI: ");
		String nombre = pideLinea("Introduce el nombre del empleado: ");
		double sueldo = pideDouble("Introduce el sueldo del empleado: ");
		
		//Se añade el empleado dependiendo del tipo: Gerente o Programador
		if(tipoEmpleado.equals("Gerente")) {
			//Comprueba que la delegación sea norte, sur, oeste o este
			String delegacion;
			do {
				delegacion = pideLinea("Introduce la delegación territorial: ");
			}while(!delegacion.equalsIgnoreCase("sur") && !delegacion.equalsIgnoreCase("norte") && !delegacion.equalsIgnoreCase("este") && !delegacion.equalsIgnoreCase("oeste"));
		} else {
			String lenguaje = pideLinea("Introduce el lenguaje de programación: ");
			ListaEmpleados.addEmpleado(new Programador(dni, nombre, sueldo, lenguaje));
		}
		System.out.println("Se ha introducido correctamente el Empleado.");
	}
	
	/**
	 * Elimina un empleado
	 */
	public static void eliminarEmpleado() {
		if(ListaEmpleados.delEmpleado(pideLinea("Introduce el DNI del empleado a eliminar: "))) {
			System.out.println("Se ha eliminado el empleado correctamente. ");
		} else {
			System.out.println("Ese empleado no existe. ");
		}
	}
	
	public static void empleadosPorDefecto(int cantidad) {
		for(int i=0; i < cantidad; i++) {
			//Sueldo y dni aleatorio para las pruebas
			double sueldo = Math.random()*5000;
			String nombre = "Nombre " + i;
			String dni = (int)(Math.random()*40) + "";
			
			//Aleatoriamente elige Gerente o Programador
			if((int)(Math.random()*11)<5) {
				ListaEmpleados.addEmpleado(new Gerente(dni,nombre,sueldo,"sur"));
			} else {
				ListaEmpleados.addEmpleado(new Programador(dni, nombre, sueldo, "Pascal"));
			}
		}
	}
}
