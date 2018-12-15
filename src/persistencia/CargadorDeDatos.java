package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;
import modelo.Requisito;
import modelo.SprintBacklog;
import modelo.Tarea;
import modelo.Tarea.Estado;

public class CargadorDeDatos {
	private static final String separator = ";";

	public static void loadMiembros(ArrayList<MiembroDeEquipo> miembros){
	
	BufferedReader br = null;
	
	try{
		File archivo = new File("miembros.csv");
		FileReader fr = new FileReader(archivo);
		br =  new BufferedReader(fr);
		
		String filaLeida;
		
		String[] cadenaSeparada;
		
		while((filaLeida = br.readLine()) != null){
			cadenaSeparada = filaLeida.split(separator);
			String dni = cadenaSeparada[0];
			int edad = Integer.parseInt(cadenaSeparada[1]);
			String nombre = cadenaSeparada[2];
			
			miembros.add(new MiembroDeEquipo(nombre, edad, dni));
			
		}
		br.close();
		fr.close();
		System.out.println("Miembros cargados");
	}catch (Exception e) {
		// TODO: handle exception
		System.err.println(e.getMessage());
	
		System.err.println("Error en la carga de los datos");
	}
	}

	public static void loadSprints(ProductBacklog prBacklog, ArrayList<SprintBacklog> sprints, ArrayList<MiembroDeEquipo> miembros, ArrayList<Requisito> requisitos, String nombreArchivo ){
		
		BufferedReader br = null;
		try{
	
			File archivo = new File(nombreArchivo);
			FileReader fr = new FileReader(archivo);
			br =  new BufferedReader(fr);
			sprints.add(new SprintBacklog() );
			String filaLeida;
	
			String[] cadenaSeparada;
			
			//ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
			CargadorDeDatos.loadRequisitos(requisitos);
			
			
			
			
			
			while((filaLeida = br.readLine()) != null){
				cadenaSeparada = filaLeida.split(separator);
				String titulo = cadenaSeparada[0];
				String descripcion = cadenaSeparada[1];
				
	
				int coste = (int) Float.parseFloat(cadenaSeparada[2]);
				int beneficio = (int) Float.parseFloat(cadenaSeparada[3]);
	
				String dniMiembro = cadenaSeparada[4];
				String estado = cadenaSeparada[5];
				int id = Integer.parseInt(cadenaSeparada[6]);
				String texto = null;
				for (Requisito requisito: requisitos){
					if(id==requisito.getID()){
						texto=requisito.getTexto();
						break;
					}
				}
	
	
				MiembroDeEquipo miembro = null;
				for (MiembroDeEquipo m: miembros){
					if (m.getDni().equals(dniMiembro)){
						miembro = m;
					}
				}
				Tarea tarea = new Tarea(new Requisito(id, texto), miembro, titulo, descripcion, coste, beneficio);
				tarea.setEstado(Estado.valueOf(estado));
				if (nombreArchivo.equals("tareas.csv")){
					sprints.get(0).addTarea(tarea);
				}else if (nombreArchivo.equals("productBack.csv")){
					prBacklog.setTareaToDo(tarea);

				}
			}
			br.close();
			fr.close();
			System.out.println("Tareas cargadas");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			
			System.err.println("Error en la carga de los datos");
			
		}
	}

	public static void loadRequisitos(ArrayList<Requisito> requisitos){
			
			BufferedReader br = null;
			try{
	
				File archivo = new File("requisitos.csv");
				FileReader fr = new FileReader(archivo);
				br =  new BufferedReader(fr);
				String filaLeida;
	
				String[] cadenaSeparada;
				while((filaLeida = br.readLine()) != null){
					cadenaSeparada = filaLeida.split(separator);
					int id = Integer.parseInt(cadenaSeparada[0]);
					String texto = cadenaSeparada[1];
					requisitos.add(new Requisito(id,texto));
										
				}
				br.close();
				fr.close();
				System.out.println("Requisitos cargados");
			}catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
				
				System.err.println("Error en la carga de los datos[Requisitos]");
				
			}
	}
	
	
	
	

}
