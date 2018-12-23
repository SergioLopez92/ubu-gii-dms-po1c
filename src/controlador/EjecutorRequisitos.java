package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;

public class EjecutorRequisitos extends Ejecutor {
	
	Scanner reader = new Scanner(System.in);

	@Override
	public void hacer(ArrayList<MiembroDeEquipo> miembros,ArrayList<SprintBacklog> sprints,ArrayList<Requisito> requisitos,ProductBacklog prBacklog) {
		int count = 0;
		// editar requisito7
		System.out.println("Elige el requisito a editar: ");

		for (Requisito req : requisitos) {
			count++;
			System.out.println(count + ": ID " + req.getID() + " " + req.getTexto());
		}
		int choiceReq = reader.nextInt();
		Requisito newReq = null;
		if (choiceReq > 0) {
			newReq = requisitos.get(choiceReq - 1);
		}
		System.out.println(newReq.getTexto());
		System.out.println("Escribe el nuevo texto para el requisito");
		reader.nextLine();
		String texto = reader.nextLine();
		newReq.setTexto(texto);
	}

}
