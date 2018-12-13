package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import modelo.Tarea;
import modelo.Tarea.Estado;
import persistencia.CargadorDeDatos;
import persistencia.Guardado;
import vista.Vista;

public class Gestor {

	public static void main(String[] args) {
	
		ArrayList<MiembroDeEquipo> miembros = new ArrayList<MiembroDeEquipo>();
		ArrayList<SprintBacklog> sprints = new ArrayList<SprintBacklog>();
		ProductBacklog prBacklog = new ProductBacklog();
	
	
		// bucle para ejecucion principal
	
		boolean flag = true;
		int option;
	
		while (flag) {
			Vista.presentarOpciones();
	
			Scanner reader = new Scanner(System.in);
			option = reader.nextInt();
			
	
			switch (option) {
			case 0:
				CargadorDeDatos.loadMiembros(miembros);
				int count0 = 0;
				for (MiembroDeEquipo miembro : miembros) {
					count0++;
					System.out.println(count0 + ":" + miembro.getNombre());
	
				}
				CargadorDeDatos.loadSprints(prBacklog, sprints, miembros);
				break;
			case 1:
				System.out.println("Introduce el nombre del miembro a añadir");
				reader.nextLine();
				String nombre = reader.nextLine();
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
				reader.nextLine();
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
				reader.nextLine();
				tar = reader.nextLine();
				 
				 for (Tarea tarea : sprints.get(numSprint2).getLista()) {
						if (tar.equals(tarea.getTitulo())) {
							t = tarea;
							break;
						}
					}
	
				System.out.println("Introduce el nuevo titulo de la tarea");
				//reader.nextLine();
				String titulo2 = reader.nextLine();
				System.out.println("Introduce la descripcion de la tarea");
				//reader.nextLine();
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
				System.out.println("Tareas en el ProductBacklog");
	
				for (Tarea tarea:prBacklog.getToDo()){
					System.out.println(tarea.toStringCompleto());
				}
				for(int i=0;i<sprints.size();i++){
					System.out.println("Tareas del sprint: "+i);
					System.out.println(sprints.get(i).getFechaInicio());
	
					for (Tarea t2:sprints.get(i).getLista()){
						System.out.println(t2.toStringCompleto());
					}
	
				}
				
	
				
				break;
			case 8:
				Guardado guardarDatos = new Guardado(1);
				guardarDatos.saveToCSV(miembros);
				
				guardarDatos.changeEstrategia(2);
				//MiembroCSV.saveToCSV(miembros);
				// NECESARIO GUARDAR DONDE ESTABA CADA TAREA (SPRINT)
				for (SprintBacklog sp:sprints){
					guardarDatos.saveToCSV(sp.getLista());
					//TareaReqCSV.saveToCSV(sp.getLista());
				}
				reader.close();
	
				flag = false;
				break;
	
			case 9:
				flag = false;
				reader.close();
				break;
			}
	
		}
	}

}
