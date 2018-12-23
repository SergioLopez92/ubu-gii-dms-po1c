package controlador;

import java.util.ArrayList;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import modelo.Tarea;

public class EjecutorBacklogs extends Ejecutor {

	int flag = 0;

	public EjecutorBacklogs(int flag) {
		this.flag = flag;
	}

	@Override
	public void hacer(ArrayList<MiembroDeEquipo> miembros,ArrayList<SprintBacklog> sprints,ArrayList<Requisito> requisitos,ProductBacklog prBacklog) {
		if (flag == 0) {
			boolean success = sprints.add(new SprintBacklog());
			if (success == true) {
				System.out.println("Sprint añadido correctamente");
			}

		} else if (flag == 1) {
			System.out.println("Tareas en el ProductBacklog");

			for (Tarea tarea : prBacklog.getToDo()) {
				System.out.println(tarea.toStringCompleto());
			}
			for (int i = 0; i < sprints.size(); i++) {
				System.out.println("Tareas del sprint: " + i);
				System.out.println(sprints.get(i).getFechaInicio());

				for (Tarea t2 : sprints.get(i).getLista()) {
					if(t2!=null)
					System.out.println(t2.toStringCompleto());
				}

			}

		}

	}

}
