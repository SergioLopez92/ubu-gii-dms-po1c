package persistencia;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import modelo.Tarea;

public class TareaReqCSV extends TipoDatoGuardado {

	@SuppressWarnings("unchecked")
	public <E> void saveToCSV(ArrayList<E> tareas) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tareas.csv"), "UTF-8"));
			BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("requisitos.csv"), "UTF-8"));
	
			for (Tarea tarea : (ArrayList<Tarea>)tareas) {
				StringBuffer line = new StringBuffer();
				line.append(tarea.getTitulo());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getDescripcion());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getCoste());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getBeneficio());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getAsignadoA().getDni());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getEstado());
				line.append(TipoDatoGuardado.separator);
				line.append(tarea.getRequisito().getID());
	
				bw.write(line.toString());
				bw.newLine();
				
				StringBuffer line2 = new StringBuffer();
				line2.append(tarea.getRequisito().getID());
				line2.append(TipoDatoGuardado.separator);
				line2.append(tarea.getRequisito().getTexto());
				bw2.write(line2.toString());
				bw2.newLine();
	
			}
			bw.flush();
			bw.close();
			bw2.flush();
			bw2.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	
	}

}
