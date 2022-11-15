/*
 * Nombre: Antonio Jesús Gil
 * Fecha: 26/05
 * El objetivo es crear un programa principal donde poder probar todas las clases hechas con anterioridad.
 */
package version2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
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
			System.out.println("6. Exportar a un fichero");
			opcion = pideInt("¿Que opción quiere realizar?: ");
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo del programa.");
				salida = true;
				break;
			case 1:
				try {
					nuevoEmpleado("Gerente");
				} catch (SueldoException e) {
					System.out.println("[" + e + "] - Intentalo de nuevo.");
				}
				break;
			case 2:
				try {
					nuevoEmpleado("Programador");
				} catch (SueldoException e) {
					System.out.println("Intentalo de nuevo.");
				}
				break;
			case 3:
				System.out.println(ListaEmpleados.listarEmpleados());
				break;
			case 4:
				eliminarEmpleado();
				break;
			case 5:
				muestraEmpleado();
				break;
			case 6:
				exportarFichero();
				break;
			default:
				System.out.println("Vuelve a intentarlo con un número válido.");
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
		while(true) {
            try {
                System.out.print(mensaje);
                int valor = input.nextInt();
                return valor;
            } catch (InputMismatchException e) {
            	input.nextLine();
                System.out.println("No has introducido un valor numerico. Vuelve a intentarlo.");
            }
        }
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
		while(true) {
            try {
                System.out.print(mensaje);
                double valor = input.nextDouble();
                return valor;
            } catch (InputMismatchException e) {
            	input.nextLine();
                System.out.println("No has introducido un valor numerico. Vuelve a intentarlo.");
            }
        }
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
	 * @throws SueldoException Lanza Excepción si sueldo es negativo.
	 */
	public static void nuevoEmpleado(String tipoEmpleado) throws SueldoException {
		boolean resultado;
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
			ListaEmpleados.addEmpleado((Empleado)new Gerente(dni, nombre, sueldo, delegacion));
		} else {
			String lenguaje = pideLinea("Introduce el lenguaje de programación: ");
			ListaEmpleados.addEmpleado((Empleado)new Programador(dni, nombre, sueldo, lenguaje));
		}
		
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
	
	/**
	 * Exporta el listado de Empleados a un fichero
	 */
	public static void exportarFichero() {
		File fichero = new File(pideLinea("Ruta donde exportar fichero: "));
		try {
			fichero.createNewFile();
			
			FileWriter writer = new FileWriter(fichero);
			
			writer.write("Listado de Empleados\n");
			writer.write(ListaEmpleados.listarEmpleados());
			
			writer.close();
			
			System.out.println("Se ha exportado a un fichero satisfactoriamente.");
		} catch (IOException e) {
			System.out.println("Esa ruta introducida no existe, vuelve a intentarlo.");
		}
	}
	
	/**
	 * Crea empleados por defecto
	 * @param cantidad de empleados por defecto
	 */
	public static void empleadosPorDefecto(int cantidad) {
		
		for(int i=0; i < cantidad; i++) {
			//Sueldo y dni aleatorio para las pruebas
			double sueldo = Math.random()*5000;
			String nombre = "Nombre " + i;
			String dni = (int)(Math.random()*40) + "";
			
			//Aleatoriamente pone el sueldo negativo o lo deja positivo
			if((int)(Math.random()*11)<5) {
				sueldo = sueldo * -1;
			}
			
			//Aleatoriamente elige Gerente o Programador
			try {
				if((int)(Math.random()*11)<5) {
					ListaEmpleados.addEmpleado(new Gerente(dni,nombre,sueldo,"sur"));
				} else {
					ListaEmpleados.addEmpleado(new Programador(dni,nombre,sueldo,"Pascal"));
				}
			} catch (SueldoException e1) {
				System.out.println("[" + e1 + "]");
			}
			
		}
	}
	
}
