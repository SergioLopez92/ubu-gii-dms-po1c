package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import persistencia.CargadorDeDatos;
import vista.Vista;

public class Choice {

	boolean flag = true;
	int option;
	protected ArrayList<MiembroDeEquipo> miembros = new ArrayList<MiembroDeEquipo>();
	protected ArrayList<SprintBacklog> sprints = new ArrayList<SprintBacklog>();
	protected ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
	protected ProductBacklog prBacklog = new ProductBacklog();

	public void cargarDatos() {
		System.out.println("Cargando datos");
		CargadorDeDatos.loadMiembros(miembros);
		int count0 = 0;
		for (MiembroDeEquipo miembro : miembros) {
			count0++;
			System.out.println(count0 + ":" + miembro.getNombre());

		}
		CargadorDeDatos.loadSprints(prBacklog, sprints, miembros, requisitos, "tareas.csv");
		CargadorDeDatos.loadSprints(prBacklog, sprints, miembros, requisitos, "productBack.csv");
	}


	public void empezar() {
		
		Ejecutor e = null;

		while (flag) {
			Vista.presentarOpciones();

			Scanner reader = new Scanner(System.in);
			option = reader.nextInt();
			

			switch (option) {
			case 0:
				e = new EjecutorDatos(0);
				break;
			case 1:
				e = new EjecutorMiembros();
				break;
			case 2:
				e = new EjecutorBacklogs(0);
				break;
			case 3:
				e = new EjecutorTareas(0);

				break;

			case 4:
				e = new EjecutorTareas(1);

				break;

			case 5:
				e = new EjecutorTareas(2);
				break;

			case 6:
				e = new EjecutorTareas(3);

				break;

			case 7:
				e = new EjecutorBacklogs(1);
				break;

			case 8:
				e = new EjecutorRequisitos();

				break;

			case 9:
				e = new EjecutorDatos(1);

			case 10:
				flag = false;
				reader.close();
				break;
			case 11:
				e = new EjecutorDatos(2);
			}
			if (e != null) {
				e.hacer(miembros,sprints,requisitos,prBacklog);
			}
			
		}
	}
}
