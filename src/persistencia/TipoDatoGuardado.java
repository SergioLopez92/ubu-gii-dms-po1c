package persistencia;

import java.util.ArrayList;

public abstract class TipoDatoGuardado {

	protected static final String separator = ";";
	
	public abstract <E> void saveToCSV(ArrayList<E> dato);
	

}
