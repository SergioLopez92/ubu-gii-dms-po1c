package persistencia;

import java.util.ArrayList;

import modelo.ProductBacklog;

public class Guardado {
	private TipoDatoGuardado dato;
	private int estrategia;
	
	public Guardado(int estrategia) {
		this.estrategia = estrategia;
		this.createTipoDato();
	}
	
	public void changeEstrategia (int estrategia){
		this.estrategia = estrategia;
		this.createTipoDato();
	}
	
	public void createTipoDato (){
		switch (this.estrategia) {
		 case 1: 
			 this.dato = new MiembroCSV();
			 break;
		 case 2:
			 this.dato = new TareaReqCSV();
			 break;
		 }
	}
	
	public <E> void saveToCSV(ArrayList<E> miem_tar, ProductBacklog prdBack){
		dato.saveToCSV(miem_tar, prdBack);
	}

}
