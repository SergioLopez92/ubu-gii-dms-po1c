package persistencia;

import java.util.ArrayList;

import modelo.ProductBacklog;

public abstract class TipoDatoGuardado {

	protected static final String separator = ";";
	
	public abstract <E> void saveToCSV(ArrayList<E> dato, ProductBacklog prdBack);
	

}
