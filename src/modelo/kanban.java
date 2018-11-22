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
					"Seleccione la opci�n que desee realizar del siguiente menu escribiendo el numero correspondiente");
			System.out.println("--------------------------");
			System.out.println("Opcion 1: A�adir miebros");
			System.out.println("Opcion 2: A�adir Sprint Backlog");
			System.out.println("Opcion 3: A�adir tarea al Product Backlog");
			System.out.println("Opcion 4: Mover tarea del Product Backlog al Spring Backlog");
			System.out.println("Opcion 5: Mover tarea entre las fases del ciclo de vida");
			System.out.println("Opcion 6: Editar tarea");
			System.out.println("Opcion 7: Salir de la aplicacion");

			Scanner reader = new Scanner(System.in);
			option = reader.nextInt();

			switch (option) {
			case 1:
				System.out.println("Introduce el nombre del miembro a a�adir");
				String nombre = reader.next();
				System.out.println("Introduce la edad de " + nombre);
				int edad = reader.nextInt();
				System.out.println("Introduce el dni de " + nombre);
				String dni = reader.next();
				System.out.println("Se va a a�adir el usuario con los siguientes datos:" + "Nombre: " + nombre
						+ "Edad: " + edad + "DNI: " + dni);
				System.out.println("�Es correcto? s/n");
				String valid = reader.next();

				if (valid.equals("s")) {

					miembros.add(new MiembroDeEquipo(nombre, edad, dni));
				}
				break;
			case 2:
				boolean success = sprints.add(new SprintBacklog());
				if (success == true) {
					System.out.println("Sprint a�adido correctamente");

				}
				break;
			case 3:
				System.out.println("Introduce el titulo de la tarea a a�adir");
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

				System.out.println("Se va a a�adir la tarea con los siguientes datos:" + "Titulo: " + titulo
						+ "Asignada a: " + miembroElegido.getNombre());
				System.out.println("�Es correcto? s/n");
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

			case 5:
				System.out.print("Elige el srpint en el que est� la tarea que quieres mover: ");
				System.out.println("[1" + "-" + sprints.size() + "]");
				int numSprint;
				numSprint = reader.nextInt();
				sprints.get(numSprint - 1).printear();

				System.out.println(
						"Elige en numero de la lista donde se encuentra la tarea (1-Todo, 2-Doing, 3-Test, 4-Finished)");
				int numList;
				numList = reader.nextInt();

				System.out.println("Escribe el numero de la posici�n dentro de la lista de la tarea a mover");
				int numTarea;
				numTarea = reader.nextInt();

				System.out.println(
						"Escribe el numero de la lista donde quieras mover la tarea(1-Todo, 2-Doing, 3-Test, 4-Finished)");
				int numList2;
				numList2 = reader.nextInt();

				Tarea t = sprints.get(numSprint - 1).getListas().get(numList - 1).remove(numTarea - 1);

				sprints.get(numSprint - 1).getListas().get(numList2 - 1).add(t);
				break;

			case 6:
				System.out.println("Escribe el titulo de la tarea a editar");
				for (SprintBacklog spr : sprints) {
					spr.printear();
				}
				String tar;
				tar = reader.next();
				Tarea tareaEditar = null;

				for (Tarea e : prBacklog.getToDo()) {
					if (e.getTitulo().equals(tar)) {
						tareaEditar = e;
					}
				}
				if (tareaEditar == null) {
					for (SprintBacklog spr : sprints) {
						for (int i = 0; i < spr.getListas().size(); i++) {
							for (Tarea tare : spr.getListas().get(i)) {
								if (tare.getTitulo().equals(tar)) {
									tareaEditar = tare;
								}
							}
						}
					}
				}

				System.out.println("Introduce el nuevo titulo de la tarea");
				String titulo2 = reader.next();
				System.out.println("Introduce la descripcion de la tarea");
				String descripcion2 = reader.next();
				System.out.println("Introduce el coste de la tarea");
				float coste2 = reader.nextFloat();
				System.out.println("Introduce el beneficio de la tarea");
				float beneficio2 = reader.nextFloat();
				System.out.println("Elige el miembro al que se va a asignar la tarea");
				int count2 = 0;
				for (MiembroDeEquipo miembro : miembros) {
					count2++;
					System.out.println(count2 + ":" + miembro.getNombre());

				}
				int choice2 = reader.nextInt();
				MiembroDeEquipo miembroElegido2 = miembros.get(choice2 - 1);

				System.out.println("Se va a a�adir la tarea con los siguientes datos:" + "Titulo: " + titulo2
						+ "Asignada a: " + miembroElegido2.getNombre());
				System.out.println("�Es correcto? s/n");
				String valid3 = reader.next();
				if (valid3.equals("s")) {

					if (tareaEditar != null) {

						tareaEditar.setTitulo(titulo2);
						tareaEditar.setDescripcion(descripcion2);
						tareaEditar.setCoste(coste2);
						tareaEditar.setBeneficio(beneficio2);
						tareaEditar.asignarMiembro(miembroElegido2);

					} else {
						System.out.println("Error no se encuentra una tarea con ese titulo");
					}
					break;

				}
			case 7:
				flag=false;
				break;
			}

		}
	}
}