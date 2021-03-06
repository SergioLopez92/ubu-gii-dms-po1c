package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import modelo.Tarea;
import modelo.Tarea.Estado;

public class EjecutorTareas extends Ejecutor {
	private Scanner reader = new Scanner(System.in);
	int flag = 0;

	public EjecutorTareas(int flag) {
		this.flag = flag;
	}

	@Override
	public void hacer(ArrayList<MiembroDeEquipo> miembros,ArrayList<SprintBacklog> sprints,ArrayList<Requisito> requisitos,ProductBacklog prBacklog) {
		if (flag == 0) {

			System.out.println("Introduce el titulo de la tarea a a�adir");
			//reader.nextLine();
			String titulo = reader.nextLine();
			System.out.println("Introduce la descripcion de la tarea");
			String descripcion = reader.nextLine();
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
			Requisito newReq = null;

			System.out.println("�Utilizar un requisito existente o crear uno nuevo? (Existente: 0 || Nuevo: 1)");
			int choiceReq = reader.nextInt();
			if (choiceReq == 0) {
				if (requisitos.size() > 0) {
					count = 0;
					System.out.println("Escoge un requisito existente ");
					for (Requisito req : requisitos) {
						count++;
						System.out.println(count + ": ID " + req.getID() + " " + req.getTexto());
					}
					choiceReq = reader.nextInt();
					newReq = requisitos.get(choiceReq - 1);
				} else {
					System.out.println("No existe ningun requisito");
				}

			} else if (choiceReq == 1) {
				System.out.println("Escribe el texto para el nuevo requisito");
				reader.nextLine();
				String texto = reader.nextLine();
				newReq = new Requisito(1, texto);

			}

			System.out.println("Se va a a�adir la tarea con los siguientes datos: " + "Titulo: " + titulo
					+ " Asignada a: " + miembroElegido.getNombre() + " con requisito: " + newReq.getTexto());
			System.out.println("�Es correcto? s/n");
			String valid2 = reader.next();
			if (valid2.equals("s")) {

				prBacklog.setTareaToDo(new Tarea(newReq, miembroElegido, titulo, descripcion, coste, beneficio));
				requisitos.add(newReq);
			}

		} else if (flag == 1) {
			System.out.println("Elige la tarea que deseas mover del Product Backlog al Spring Backlog");

			int count = 0;
			for (Tarea tarea : prBacklog.getToDo()) {
				count++;
				System.out.println(count + ":" + tarea.getTitulo());

			}
			int choice = reader.nextInt();
			Tarea tareaElegida = prBacklog.getToDo().remove(choice - 1);

			System.out.print("Selecciona el numero de Sprint dodne deseas mover la tarea: ");

			System.out.println("[1" + "-" + sprints.size() + "]");

			choice = reader.nextInt();
			sprints.get(choice - 1).addTarea(tareaElegida);

		} else if (flag == 2) {
			System.out.print("Elige el srpint en el que est� la tarea que quieres mover: ");
			System.out.println("[1" + "-" + sprints.size() + "]");
			int numSprint;
			numSprint = reader.nextInt();
			sprints.get(numSprint - 1).printear();

			System.out.println("Escribe el titulo de la tarea a mover");

			String tituloTarea = "";
			reader.nextLine();
			tituloTarea = reader.nextLine();

			System.out.println(
					"Escribe el numero de la lista donde quieras mover la tarea(1-Todo, 2-Doing, 3-Test, 4-Finished)");
			int numList;
			numList = reader.nextInt();

			Tarea t = null;
			SprintBacklog sprChoice = sprints.get(numSprint - 1);
			for (Tarea tarea : sprChoice.getLista()) {
				if (tituloTarea.equals(tarea.getTitulo())) {
					t = tarea;
					sprChoice.getLista().remove(tarea);

					break;
				}
			}
			if (t != null) {
				if (numList == 1) {
					t.setEstado(Estado.TODO);
				} else if (numList == 2) {
					t.setEstado(Estado.DOING);

				} else if (numList == 3) {
					t.setEstado(Estado.TESTING);
				} else {
					t.setEstado(Estado.FINISHED);
				}

			}
			sprints.get(numSprint - 1).getLista().add(t);
			System.out.print("Tarea movida ");
		} else if (flag == 3) {
			Tarea t = null;
			System.out.print("Elige el sprint en el que est� la tarea que quieres editar: ");
			System.out.println("[1" + "-" + sprints.size() + "]");
			int numSprint2 = reader.nextInt() - 1;

			System.out.println("Escribe el titulo de la tarea a editar");
			for (Tarea tarea : sprints.get(numSprint2).getLista()) {
				System.out.println(tarea.getTitulo());
			}

			String tar;
			reader.nextLine();
			tar = reader.nextLine();

			for (Tarea tarea : sprints.get(numSprint2).getLista()) {
				if (tar.equals(tarea.getTitulo())) {
					t = tarea;
					break;
				}
			}

			System.out.println("Introduce el nuevo titulo de la tarea");
			// reader.nextLine();
			String titulo2 = reader.nextLine();
			System.out.println("Introduce la descripcion de la tarea");
			// reader.nextLine();
			String descripcion2 = reader.nextLine();
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

				if (t != null) {

					t.setTitulo(titulo2);
					t.setDescripcion(descripcion2);
					t.setCoste(coste2);
					t.setBeneficio(beneficio2);
					t.asignarMiembro(miembroElegido2);

				} else {
					System.out.println("Error no se encuentra una tarea con ese titulo");
				}
			}

		}
	}
}
