package modelo;

import java.util.ArrayList;

public class ProductBacklog extends Backlog {

	private ArrayList<Tarea> toDo;

	public ProductBacklog() {
		toDo = new ArrayList<Tarea>();

	}
	
	//getter y setter toDo
	public Tarea getTareaToDo(Tarea tarea) {
		return toDo.get(toDo.indexOf(tarea));
	}

	public ArrayList<Tarea> getToDo() {
		return toDo;
	}

	public void setTareaToDo(Tarea tarea) {
		toDo.add(tarea);
	}

}
