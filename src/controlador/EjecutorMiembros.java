package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import controlador.Choice;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;

public class EjecutorMiembros extends Ejecutor {
	
	private Scanner reader = new Scanner(System.in);
	
	
	@Override
	public void hacer(ArrayList<MiembroDeEquipo> miembros,ArrayList<SprintBacklog> sprints,ArrayList<Requisito> requisitos,ProductBacklog prBacklog) {
		System.out.println("Introduce el nombre del miembro a añadir");
		//reader.nextLine();
		String nombre = reader.nextLine();
		System.out.println("Introduce la edad de " + nombre);
		int edad = reader.nextInt();
		System.out.println("Introduce el dni de " + nombre);
		String dni = reader.next();
		System.out.println("Se va a añadir el usuario con los siguientes datos:" + "Nombre: " + nombre + "Edad: "
				+ edad + "DNI: " + dni);
		System.out.println("¿Es correcto? s/n");
		String valid = reader.next();

		if (valid.equals("s")) {

			miembros.add(new MiembroDeEquipo(nombre, edad, dni));

		}
		

	}

}
