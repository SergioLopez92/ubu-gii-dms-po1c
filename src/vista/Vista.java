package vista;

public class Vista {

	public static void presentarOpciones() {
		System.out.println("\nBienvenido a la aplicacion kanban");
		System.out.println(
				"Seleccione la opción que desee realizar del siguiente menu escribiendo el numero correspondiente");
		System.out.println("--------------------------");
		System.out.println("Opcion 0: Cargar datos");
		System.out.println("Opcion 1: Añadir miebros");
		System.out.println("Opcion 2: Añadir Sprint Backlog");
		System.out.println("Opcion 3: Añadir tarea al Product Backlog");
		System.out.println("Opcion 4: Mover tarea del Product Backlog al Spring Backlog");
		System.out.println("Opcion 5: Mover tarea entre las fases del ciclo de vida");
		System.out.println("Opcion 6: Editar tarea");
		System.out.println("Opcion 7: Mostrar los datos de las tareas");
		System.out.println("Opcion 8: Salir de la aplicacion guardando los cambios");
		System.out.println("Opcion 9: Salir de la aplicacion sin guardar");
	}

}
