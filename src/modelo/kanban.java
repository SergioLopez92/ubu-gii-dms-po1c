package modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Tarea.Estado;

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
			System.out.println("Opcion 7: Salir de la aplicacion guardando los cambios");
			System.out.println("Opcion 8: Salir de la aplicacion sin guardar");

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
				// PROBLEMA! Espacio en blanco lo casca, con nextLine saca lo
				// siguiente sin esperar a recibir entrada
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
				sprints.get(choice - 1).addTarea(tareaElegida);
				break;

			case 5:
				System.out.print("Elige el srpint en el que está la tarea que quieres mover: ");
				System.out.println("[1" + "-" + sprints.size() + "]");
				int numSprint;
				numSprint = reader.nextInt();
				sprints.get(numSprint - 1).printear();

				System.out.println("Elige el titulo de la tarea a mover");

				
				String tituloTarea = "";
				tituloTarea = reader.next();

				System.out.println(
						"Escribe el numero de la lista donde quieras mover la tarea(1-Todo, 2-Doing, 3-Test, 4-Finished)");
				int numList;
				numList = reader.nextInt();

				Tarea t = null;
				SprintBacklog sprChoice = sprints.get(numSprint - 1);
				for (Tarea tarea : sprChoice.getLista()) {
					if (tituloTarea.equals(tarea.getTitulo())) {
						t = tarea;
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
				break;

			case 6:
				t = null;
				System.out.print("Elige el sprint en el que está la tarea que quieres mover: ");
				System.out.println("[1" + "-" + sprints.size() + "]");
				int numSprint2 = reader.nextInt() - 1;
				

				System.out.println("Escribe el titulo de la tarea a editar");
				for (Tarea tarea : sprints.get(numSprint2).getLista()) {
					System.out.println(tarea.getTitulo());
				}
				
				String tar;
				tar = reader.next();
				 
				 for (Tarea tarea : sprints.get(numSprint2).getLista()) {
						if (tar.equals(tarea.getTitulo())) {
							t = tarea;
							break;
						}
					}
				// Tarea tareaEditar = null;
				//
				// for (Tarea e : prBacklog.getToDo()) {
				// if (e.getTitulo().equals(tar)) {
				// tareaEditar = e;
				// }
				// }
				// if (tareaEditar == null) {
				// for (SprintBacklog spr : sprints) {
				// for (int i = 0; i < spr.getListas().size(); i++) {
				// for (Tarea tare : spr.getListas().get(i)) {
				// if (tare.getTitulo().equals(tar)) {
				// tareaEditar = tare;
				// }
				// }
				// }
				// }
				// }

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

				System.out.println("Se va a añadir la tarea con los siguientes datos:" + "Titulo: " + titulo2
						+ "Asignada a: " + miembroElegido2.getNombre());
				System.out.println("¿Es correcto? s/n");
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
					break;

				}
			case 7:
				saveMiembroToCSV(miembros);
				// NECESARIO GUARDAR DONDE ESTABA CADA TAREA (SPRINT)
				for (SprintBacklog sp:sprints){
					saveTareaToCSV(sp.getLista());
				}


				flag = false;
				break;

			case 8:
				flag = false;
				break;
			}

		}
	}

	// Metodos para guardar las entidades en un archivo csv, cada metodo se
	// encarga de guardar una entidad
	private static final String separator = ";";

	private static void saveMiembroToCSV(ArrayList<MiembroDeEquipo> miembros) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("miembros.csv"), "UTF-8"));

			for (MiembroDeEquipo miembro : miembros) {
				StringBuffer line = new StringBuffer();
				line.append(miembro.getDni());
				line.append(separator);
				line.append(miembro.getEdad());
				line.append(separator);
				line.append(miembro.getNombre());
				line.append(separator);
				bw.write(line.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

	private static void saveTareaToCSV(ArrayList<Tarea> tareas) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tareas.csv"), "UTF-8"));

			for (Tarea tarea : tareas) {
				StringBuffer line = new StringBuffer();
				line.append(tarea.getTitulo());
				line.append(separator);
				line.append(tarea.getDescripcion());
				line.append(separator);
				line.append(tarea.getCoste());
				line.append(separator);
				line.append(tarea.getBeneficio());
				line.append(separator);
				line.append(tarea.getAsignadoA().getDni());
				line.append(separator);
				line.append(tarea.getRequisito().toString());

				bw.write(line.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}
}