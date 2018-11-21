package modelo;

import java.util.ArrayList;

public class SprintBacklog extends Backlog{
	
	

	private ArrayList<Tarea> toDo;
	private ArrayList<Tarea> doing;
	private ArrayList<Tarea> test;
	private ArrayList<Tarea> finished;
	
	
	public SprintBacklog() {
		toDo = new ArrayList<Tarea>();
		doing = new ArrayList<Tarea>();
		test = new ArrayList<Tarea>();
		finished = new ArrayList<Tarea>();

		
	}
	
	//getter y setter toDo
	public void addTareaToDo(Tarea tarea){
		toDo.add(tarea);
	}

	public Tarea getTareaToDo(Tarea tarea) {
		return toDo.get(toDo.indexOf(tarea));
	}

	//getter y setter doing
	public Tarea getTareaDoing(Tarea tarea) {
		return doing.get(doing.indexOf(tarea));
	}

	public void addTareaDoing(Tarea tarea) {
		doing.add(tarea);
	}

	//getter y setter test
	public Tarea getTareaTest(Tarea tarea) {
		return test.get(test.indexOf(tarea));
	}

	public void addTareaTest(Tarea tarea) {
		test.add(tarea);
	}

	//getter y setter finished
	public Tarea getTareaFinished(Tarea tarea) {
		return finished.get(finished.indexOf(tarea));
	}

	public void addTareaFinished(Tarea tarea) {
		finished.add(tarea);
	}
	
	
	
	

}
