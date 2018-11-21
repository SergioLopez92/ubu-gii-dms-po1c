package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class kanban {

	public static void main(String[] args) {

		ArrayList<MiembroDeEquipo> miembros = new ArrayList<MiembroDeEquipo>();
		ArrayList<SprintBacklog> sprints = new ArrayList<SprintBacklog>();
		ProductBacklog prBacklog = new ProductBacklog();

		// bucle para ejecucion principal

		boolean flag = true;
		int option;

		while (flag) {
			System.out.println("Bienvenido a la aplicacion kanban");
			System.out.println(
					"Seleccione la opción que desee realizar del siguiente menu escribiendo el numero correspondiente");
			System.out.println("--------------------------");
			System.out.println("Opcion 1: Añadir miebros");
			System.out.println("Opcion 2: Añadir Sprint Backlog");
			System.out.println("Opcion 3: Añadir tarea al Product Backlog");
			System.out.println("Opcion 4: Mover tarea del Product Backlog al Spring Backlog");
			System.out.println("Opcion 5: Mover tarea entre las fases del ciclo de vida");
			System.out.println("Opcion 6: Editar tarea");
			System.out.println("Opcion 7: Salir de la aplicacion");

			Scanner reader = new Scanner(System.in);
			option = reader.nextInt();

			switch (option) {
			case 1:
				System.out.println("Introduce el nombre del miembro a añadir");
				String nombre = reader.next();
				System.out.println("Introduce la edad de " + nombre);
				int edad = reader.nextInt();
				System.out.println("Introduce el dni de " + nombre);
				String dni = reader.next();
				System.out.println("Se va a añadir el usuario con los siguientes datos:" + "Nombre: " + nombre
						+ "Edad: " + edad + "DNI: " + dni);
				System.out.println("¿Es correcto? s/n");
				String valid = reader.next();

				if (valid.equals("s")) {

					miembros.add(new MiembroDeEquipo(nombre, edad, dni));
				}
				break;
			case 2:
				boolean success = sprints.add(new SprintBacklog());
				if (success == true) {
					System.out.println("Sprint añadido correctamente");

				}
				break;
			case 3:
				System.out.println("Introduce el titulo de la tarea a añadir");
				String titulo = reader.next();
				System.out.println("Introduce la descripcion de la tarea");
				String descripcion = reader.next();
				System.out.println("Introduce el coste de la tarea");
				float coste = reader.nextFloat();
				System.out.println("Introduce el beneficio de la tarea");
				float beneficio = reader.nextFloat();
				System.out.println("Elige el miembro al que se va a asignar la tarea");
				int count = 0;
				for (MiembroDeEquipo miembro : miembros) {
					count++;
					System.out.println(count + ":" + miembro.getNombre());

				}
				int choice = reader.nextInt();
				MiembroDeEquipo miembroElegido = miembros.get(choice - 1);

				System.out.println("Se va a añadir la tarea con los siguientes datos:" + "Titulo: " + titulo
						+ "Asignada a: " + miembroElegido.getNombre());
				System.out.println("¿Es correcto? s/n");
				String valid2 = reader.next();
				if (valid2.equals("s")) {

					prBacklog.setTareaToDo(
							new Tarea(new Requisito(), miembroElegido, titulo, descripcion, coste, beneficio));
				}
				break;

			case 4:
				System.out.println("Elige la tarea que deseas mover del Product Backlog al Spring Backlog");

				count = 0;
				for (Tarea tarea : prBacklog.getToDo()) {
					count++;
					System.out.println(count + ":" + tarea.getTitulo());

				}
				choice = reader.nextInt();
				Tarea tareaElegida = prBacklog.getToDo().remove(choice - 1);

				System.out.print("Selecciona el numero de Sprint dodne deseas mover la tarea: ");

				System.out.println("[1" + "-" + sprints.size() + "]");

				choice = reader.nextInt();
				sprints.get(choice - 1).addTareaToDo(tareaElegida);
				break;

			

				
			}

		}

	}
}
