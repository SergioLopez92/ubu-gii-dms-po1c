package persistencia;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import modelo.MiembroDeEquipo;
import modelo.ProductBacklog;

public class MiembroCSV extends TipoDatoGuardado {
	
	@SuppressWarnings("unchecked")
	public <E> void saveToCSV(ArrayList<E> miembros) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("miembros.csv"), "UTF-8"));
		
			for (MiembroDeEquipo miembro : (ArrayList<MiembroDeEquipo>)miembros) {
				StringBuffer line = new StringBuffer();
				line.append(miembro.getDni());
				line.append(TipoDatoGuardado.separator);
				line.append(miembro.getEdad());
				line.append(TipoDatoGuardado.separator);
				line.append(miembro.getNombre());
				line.append(TipoDatoGuardado.separator);
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

	@Override
	public <E> void saveToCSV(ArrayList<E> dato, ProductBacklog prdBack) {
		this.saveToCSV(dato);
	}

}
