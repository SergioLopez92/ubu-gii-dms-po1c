package controlador;

import java.util.ArrayList;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import persistencia.CargadorDeDatos;
import persistencia.Guardado;

public class EjecutorDatos extends Ejecutor {
	int flag = 0;

	public EjecutorDatos(int flag) {
		this.flag = flag;
	}

	@Override
	public void hacer(ArrayList<MiembroDeEquipo> miembros,ArrayList<SprintBacklog> sprints,ArrayList<Requisito> requisitos,ProductBacklog prBacklog) {
		if (flag == 0) {
			CargadorDeDatos.loadMiembros(miembros);
			int count0 = 0;
			for (MiembroDeEquipo miembro : miembros) {
				count0++;
				System.out.println(count0 + ":" + miembro.getNombre());

			}
			CargadorDeDatos.loadSprints(prBacklog, sprints, miembros, requisitos, "tareas.csv");
			CargadorDeDatos.loadSprints(prBacklog, sprints, miembros, requisitos, "productBack.csv");

		} else if (flag == 1)

		{
			Guardado guardarDatos = new Guardado(1);
			guardarDatos.saveToCSV(miembros, prBacklog);

			guardarDatos.changeEstrategia(2);
			// MiembroCSV.saveToCSV(miembros);
			// NECESARIO GUARDAR DONDE ESTABA CADA TAREA (SPRINT)
			for (SprintBacklog sp : sprints) {
				guardarDatos.saveToCSV(sp.getLista(), prBacklog);
				// TareaReqCSV.saveToCSV(sp.getLista());
			}

		}else if(flag==2){
			miembros = new ArrayList<MiembroDeEquipo>();
			sprints = new ArrayList<SprintBacklog>();
			requisitos = new ArrayList<Requisito>();
			prBacklog = new ProductBacklog();

			System.out.println("Datos borrados.");
		}

	}
}
